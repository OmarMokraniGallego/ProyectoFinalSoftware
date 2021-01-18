package es.upm.proyecto3.controllers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import es.upm.proyecto3.dao.ConnectionStackOverflow;
import es.upm.proyecto3.entities.Client;

public class AccountController {

    /* Método para insertar un cliente a la DB */
    public static void insertClient(String name, String lastname, double savings) {
        Connection connection = null;
        /* Intentamos conectarnos */
        try {
            connection = ConnectionStackOverflow.getConexion();

            /* Si no es nula que entre al método que nos facilita realizar la insercción */
            if (connection != null) {
                PreparedStatement ps;
                String sql = "INSERT INTO bank(name, lastname, savings) VALUES(?,?,?)";
                ps = connection.prepareStatement(sql);
                ps.setString(1, name);
                ps.setString(2, lastname);
                ps.setDouble(3, savings);
                ps.executeUpdate();
                ps.close();
                System.out.println("Query executed");
            } else {
                System.out.println("Connection appears to be null");
            }
        } catch (Exception error) {
            System.out.println("Cannot even connect");
            error.getMessage();
            error.printStackTrace();
        }
    }

    /*
     * Método para retornar un cliente por su id , este es que seguramente se usaría
     * en una app de Escritorio, llegando el id por un campo hidden
     */
    public static Client retriveClient(int id) {
        Connection connection = null;

        String name = null;
        double savings = 0;
        Client client = null;

        try {
            connection = ConnectionStackOverflow.getConexion();

            if (connection != null) {
                Statement st;
                String sql = "SELECT * FROM accounts WHERE id=" + id;
                st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql);

                /*
                 * Mientras haya un resultado en la tabla le decimos que nos lo traiga y que a
                 * su vez grabe las variables recuperadas en name y savings, y por último lo
                 * agregamos a un cliente nuevo
                 */
                while (rs.next()) {
                    name = rs.getString("name");
                    savings = rs.getDouble("savings");
                    client = new Client(id, name, savings);
                }
                /* Lo probamos por consola para ver si funcionó */
                System.out.println(client.getSavings());
                System.out.println("Query executed");
            } else {
                System.out.println("Connection appears to be null");
            }
        } catch (Exception error) {
            System.out.println("Cannot even connect");
            error.getMessage();
            error.printStackTrace();
        }
        return client;
    }

    /*
     * Esta consulta no es recomendada ya que lo ideal es realizar la consulta sobre
     * el id y en este caso lo estoy haciendo sobre el name y lastname, va a ser
     * untema tuyo como solucionarlo
     */
    public static double getPersistedSavings(String name, String lastname) {
        Connection connection = null;
        double savings = 0;
        Client client = null;
        try {
            connection = ConnectionStackOverflow.getConexion();
            /*  Si la conexión no es nula entonces que pase al métodos de averiguación de datos */
            if (connection != null) {
                Statement st;
                String sql = "SELECT savings FROM accounts WHERE name='" + name + "' AND lastname='" + lastname + "' ";
                st = connection.createStatement();
                ResultSet rs = st.executeQuery(sql);

                /*  Sólo queremos los savings o saldo, usamos el constructor vacío y le seteamos el valor recuperado    */
                while (rs.next()) {
                    savings = rs.getDouble("savings");
                    client = new Client();
                    client.setSavings(savings);
                }
                System.out.println(client.getSavings());
                System.out.println("Query executed");
            } else {
                System.out.println("Connection appears to be null");
            }
        } catch (Exception error) {
            System.out.println("Cannot even connect");
            error.getMessage();
            error.printStackTrace();
        }
        return savings;
    }

}
