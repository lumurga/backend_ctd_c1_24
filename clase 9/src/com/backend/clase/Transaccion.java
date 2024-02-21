package com.backend.clase;

import com.backend.clase.dbconnection.H2Connection;
import com.backend.clase.entity.Cuenta;
import org.apache.log4j.Logger;

import java.sql.*;

public class Transaccion {

    private static final Logger LOGGER = Logger.getLogger(Transaccion.class);

    private static final String CREATE = "DROP TABLE IF EXISTS CUENTAS; CREATE TABLE CUENTAS (ID INT PRIMARY KEY AUTO_INCREMENT, NOMBRE VARCHAR(100) NOT NULL, NUMERO_CUENTA INT NOT NULL, SALDO NUMERIC(10, 2) NOT NULL)";
    private static final String INSERT = "INSERT INTO CUENTAS (NOMBRE, NUMERO_CUENTA, SALDO) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE CUENTAS SET SALDO = ? WHERE NUMERO_CUENTA = ?";
    private static final String SELECT = "SELECT * FROM CUENTAS WHERE NUMERO_CUENTA = ?";


    public static void main(String[] args) {

        Connection connection = null;
        Cuenta cuenta = new Cuenta("Lu", 1234567, 50000);
        Cuenta cuentaObtenida = null;

        try {

            connection = H2Connection.getConnection();
            connection.setAutoCommit(false);

            //crear la tabla
            Statement statement = connection.createStatement();
            statement.execute(CREATE);

            //Insertar los datos
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT);
            preparedStatement.setDouble(3, cuenta.getSaldo());
            preparedStatement.setString(1, cuenta.getNombre());
            preparedStatement.setInt(2, cuenta.getNumeroCuenta());
            preparedStatement.execute();


            //agregar 10 al saldo
            PreparedStatement preparedStatementUpdate = connection.prepareStatement(UPDATE);
            cuenta.setSaldo(cuenta.getSaldo() + 10);
            preparedStatementUpdate.setDouble(1, cuenta.getSaldo());
            preparedStatementUpdate.setInt(2, cuenta.getNumeroCuenta());
            preparedStatementUpdate.execute();
            PreparedStatement preparedStatementSelect = connection.prepareStatement(SELECT);
            preparedStatementSelect.setInt(1, cuenta.getNumeroCuenta());
            ResultSet resultSet = preparedStatementSelect.executeQuery();

            //int aux = 1/0;

            //agregar 15 al saldo
            PreparedStatement preparedStatementUpdate2 = connection.prepareStatement(UPDATE);
            preparedStatementUpdate2.setDouble(1, cuenta.getSaldo() + 15);
            preparedStatementUpdate2.setInt(2, cuenta.getNumeroCuenta());
            cuenta.setSaldo(cuenta.getSaldo() + 15);
            preparedStatementUpdate2.execute();


            connection.commit();

            //obtener datos y mostrarlos
            preparedStatementSelect = connection.prepareStatement(SELECT);
            preparedStatementSelect.setInt(1, cuenta.getNumeroCuenta());
            resultSet = preparedStatementSelect.executeQuery();
            while (resultSet.next()){
                cuentaObtenida = new Cuenta(resultSet.getInt(1), resultSet.getString("nombre"), resultSet.getInt(3), resultSet.getDouble("saldo"));
                LOGGER.info("Cuenta obtenida: " + cuentaObtenida);
            }

            //connection.setAutoCommit(true);


        } catch (Exception exception){
            LOGGER.error(exception.getMessage());
            if(connection != null){
                try{
                  connection.rollback();
                  exception.printStackTrace();
                  LOGGER.error(exception.getMessage());

                } catch (SQLException ex){
                    LOGGER.error(exception.getMessage());
                }
            }


        } finally {
            try {
                connection.close();
            } catch (Exception exception) {
                LOGGER.error(exception.getMessage());
            }
        }


    }
}
