package com.backend.clinicaodontologica.dao.impl;



import com.backend.clinicaodontologica.dao.IDao;
import com.backend.clinicaodontologica.dbconnection.H2Connection;
import com.backend.clinicaodontologica.entity.Domicilio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class DomicilioDaoH2 implements IDao<Domicilio> {

    private final Logger LOGGER = LoggerFactory.getLogger(DomicilioDaoH2.class);


    @Override
    public Domicilio registrar(Domicilio domicilio) {
        Connection connection = null;
        Domicilio domicilioRegistrado = null;

        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DOMICILIOS (CALLE, NUMERO, LOCALIDAD, PROVINCIA) VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, domicilio.getCalle());
            preparedStatement.setInt(2, domicilio.getNumero());
            preparedStatement.setString(3, domicilio.getLocalidad());
            preparedStatement.setString(4, domicilio.getProvincia());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            domicilioRegistrado = new Domicilio(domicilio.getCalle(), domicilio.getNumero(), domicilio.getLocalidad(), domicilio.getProvincia());

            while (resultSet.next()) {
                domicilioRegistrado.setId(resultSet.getInt("id"));
            }


            connection.commit();
            LOGGER.info("Se ha registrado el domicilio: " + domicilioRegistrado);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            if (connection != null) {
                try {
                    connection.rollback();
                    LOGGER.info("Tuvimos un problema");
                    LOGGER.error(e.getMessage());
                    e.printStackTrace();
                } catch (SQLException exception) {
                    LOGGER.error(exception.getMessage());
                    exception.printStackTrace();
                }
            }
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
            }
        }

        return domicilioRegistrado;
    }

    @Override
    public Domicilio buscarPorId(int id) {
        Domicilio domicilio = null;
        Connection connection = null;
        try {
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DOMICILIOS WHERE ID = ?");
            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                domicilio = crearObjetoDomicilio(resultSet);
            }

            if (domicilio == null) LOGGER.error("No se ha encontrado el domicilio con id: " + id);
            else LOGGER.info("Se ha encontrado el domicilio: " + domicilio);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return domicilio;
    }

    @Override
    public List<Domicilio> listarTodos() {
        Connection connection = null;
        List<Domicilio> domicilios = new ArrayList<>();

        try {
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM DOMICILIOS");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Domicilio domicilio = crearObjetoDomicilio(resultSet);
                domicilios.add(domicilio);
            }

            LOGGER.info("Listado de domicilios obtenido: " + domicilios);

        } catch (Exception e) {
            LOGGER.error(e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                connection.close();
            } catch (Exception ex) {
                LOGGER.error("Ha ocurrido un error al intentar cerrar la bdd. " + ex.getMessage());
                ex.printStackTrace();
            }
        }

        return domicilios;
    }


    private Domicilio crearObjetoDomicilio(ResultSet resultSet) throws SQLException {

        return new Domicilio(resultSet.getInt("id"), resultSet.getString("calle"), resultSet.getInt("numero"), resultSet.getString("localidad"), resultSet.getString("provincia"));

    }
}
