package com.backend.dao.impl;

import com.backend.dao.IDao;
import com.backend.dbconnection.H2Connection;
import com.backend.entity.Domicilio;
import com.backend.entity.Paciente;
import org.apache.log4j.Logger;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PacienteDaoH2 implements IDao<Paciente> {

    private Logger LOGGER = Logger.getLogger(PacienteDaoH2.class);
    private DomicilioDaoH2 domicilioDaoH2;


    @Override
    public Paciente registrar(Paciente paciente) {
        Connection connection = null;
        Paciente pacienteRegistrado = null;

        try {
            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            domicilioDaoH2 = new DomicilioDaoH2();
            Domicilio domicilioRegistrado = domicilioDaoH2.registrar(paciente.getDomicilio());

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PACIENTES (NOMBRE, APELLIDO, DNI, FECHA, DOMICILIO_ID) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, paciente.getNombre());
            preparedStatement.setString(2, paciente.getApellido());
            preparedStatement.setInt(3, paciente.getDni());
            preparedStatement.setDate(4, Date.valueOf(paciente.getFechaIngreso()));
            preparedStatement.setInt(5, domicilioRegistrado.getId());
            preparedStatement.execute();

            pacienteRegistrado = new Paciente(paciente.getNombre(), paciente.getApellido(), paciente.getDni(), paciente.getFechaIngreso(), domicilioRegistrado);

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while(resultSet.next()) {
                pacienteRegistrado.setId(resultSet.getInt("id"));
            }

            connection.commit();
            LOGGER.info("Se ha registrado el paciente: " + pacienteRegistrado);



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
            {
                try {
                    connection.close();
                } catch (Exception ex) {
                    LOGGER.error("No se pudo cerrar la conexion: " + ex.getMessage());
                }
            }


        }


        return pacienteRegistrado;
    }

    @Override
    public Paciente buscarPorId(int id) {
        return null;
    }

    @Override
    public List<Paciente> listarTodos() {
        Connection connection = null;
        List<Paciente> pacientes = new ArrayList<>();
        try{
            connection = H2Connection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PACIENTES");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                Paciente paciente = crearObjetoPaciente(resultSet);
                pacientes.add(paciente);
            }

            LOGGER.info("Listado de todos los pacientes: " + pacientes);



        }catch (Exception e) {
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

        return pacientes;
    }

    private Paciente crearObjetoPaciente(ResultSet resultSet) throws SQLException {

        Domicilio domicilio = new DomicilioDaoH2().buscarPorId(resultSet.getInt("domicilio_id"));

        return new Paciente(resultSet.getInt("id"), resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getInt("dni"), resultSet.getDate("fecha").toLocalDate(), domicilio);
    }
}
