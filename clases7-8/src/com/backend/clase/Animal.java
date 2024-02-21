package com.backend.clase;

import org.apache.log4j.Logger;

import java.sql.*;

public class Animal {
    public static void main(String[] args) {

        Logger LOGGER = Logger.getLogger(Animal.class);

        String create = "DROP TABLE IF EXISTS ANIMALES; CREATE TABLE ANIMALES(ID INT AUTO_INCREMENT PRIMARY KEY, NOMBRE VARCHAR(50) NOT NULL, TIPO VARCHAR(50) NOT NULL)";
        String insert = "INSERT INTO ANIMALES(NOMBRE, TIPO) VALUES ('Firulais', 'Perro'), ('Lola', 'Vaca'), ('Homero', 'Perro'), ('Pepe', 'Sapo'), ('Tuki', 'Loro')";

        Connection connection = null;
        try{
            connection = getConnection();

            //crear tabla
            Statement statement = connection.createStatement();
            statement.execute(create);

            //insertar registros en la tabla
            statement.execute(insert);

            //select all
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ANIMALES");


            //recorrer el result set
            while(resultSet.next()){
                LOGGER.info("Animal: " + resultSet.getInt(1) + " - " + resultSet.getString("nombre") + " - " + resultSet.getString("tipo"));
            }

            //eliminar un registro
            statement.execute("DELETE FROM ANIMALES WHERE ID = 1");
            LOGGER.info("----------------------------------------------------------------");

            //select all
            resultSet = statement.executeQuery("SELECT * FROM ANIMALES");

            //recorrer el result set
            while(resultSet.next()){
                LOGGER.info("Animal: " + resultSet.getInt(1) + " - " + resultSet.getString("nombre") + " - " + resultSet.getString("tipo"));
            }


        } catch (Exception exception){
            exception.printStackTrace();
            LOGGER.error(exception.getClass() + ": " + exception.getMessage());
        }


        finally {
            try{
                connection.close();
            } catch (Exception exception){
                LOGGER.error(exception.getMessage());
            }
        }
        LOGGER.info("Este es un mensaje para evidenciar que por mas que se genere una excepcion, si esta manejada dentro de bloques try/catch, no interrumpe el flujo de ejecucion de la aplicacion.");

    }

    //metodo para poder establecer una conexion cuando la necesite
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //indicar que driver vamos a usar
        Class.forName("org.h2.Driver");
        return DriverManager.getConnection("jdbc:h2:~/clase8c1", "sa", "sa");
        //jdbc:h2:mem:testdb en memoria
    }

}
