/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastory.persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mx.itson.pastory.entidades.Cliente;
import mx.itson.pastory.entidades.Cuenta;

/**
 *
 * @author julio
 */
public class CuentaDAO {
    
    
    public static List<Cuenta> obtenerPorId(int id) {
        List<Cuenta> cuentas = new ArrayList<>();
        
        try {
            Connection conexion = Conexion.obtener();
            String query = "SELECT cu.id as cuentaid, cu.numero, cl.id as clienteid, cl.nombre, cl.email FROM cuenta cu INNER JOIN cliente cl ON cu.idCliente = cl.id where cl.id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            
            
            while (resultSet.next()) {     
                
                Cuenta c = new Cuenta();
                c.setId(resultSet.getInt(1));
                c.setNumero(resultSet.getString(2));
                
                Cliente cl = new Cliente();
                cl.setId(resultSet.getInt(3));
                cl.setNombre(resultSet.getString(4));
                cl.setEmail(resultSet.getString(5));
            
            }
                conexion.close();
        } catch (Exception e) {
            System.out.println("Ocurrio un error: " + e.getMessage());
        }
        return cuentas;
    }

    public static List<Cuenta> obtenerTodo() {

        List<Cuenta> cuentas = new ArrayList<>();
        try {
            Connection connection = Conexion.obtener();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT cu.id, cu.numero, cl.id, cl.nombre, cl.direccion, cl.telefono, cl.email FROM cuenta cu INNER JOIN cliente cl ON cu.idCliente = cl.id");

            while (resultSet.next()) {

                Cuenta cu = new Cuenta();
                cu.setId(resultSet.getInt(1));
                cu.setNumero(resultSet.getString(2));

                Cliente cl = new Cliente();
                cl.setId(resultSet.getInt(3));
                cl.setNombre(resultSet.getString(4));
                cl.setDireccion(resultSet.getString(5));
                cl.setTelefono(resultSet.getString(6));
                cl.setEmail(resultSet.getString(7));
                cu.setCliente(cl);

                cuentas.add(cu);

            }

        } catch (Exception e) {
            System.err.println("Ocurrio un error: " + e.getMessage());
        }
        return cuentas;
    }

    public static boolean guardar(String numero, int clId) {
        boolean resultado = false;

        try {

            Connection connection = Conexion.obtener();
            String consulta = "INSERT INTO cuenta (numero, idCliente) VALUES (?, ?)";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, numero);
            statement.setInt(2, clId);
            statement.execute();

            resultado = statement.getUpdateCount() == 1;

        } catch (Exception e) {
            System.out.println("Ocurrio un error " + e);
        }
        return resultado;

    }

    public static Cuenta validarCorreo(String email) {

        Cuenta c = new Cuenta();

        try {

            Connection coneccion = Conexion.obtener();
            String consulta = "SELECT cu.id, cu.numero, cl.id, cl.nombre, cl.direccion, cl.telefono, cl.email FROM cuenta cu INNER JOIN cliente cl ON cu.idCliente = cl.id where cl.email like ?";
            PreparedStatement statement = coneccion.prepareStatement(consulta);
            statement.setString(1, email);

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                c.setId(resultSet.getInt(1));
                c.setNumero(resultSet.getString(2));

                Cliente cl = new Cliente();
                cl.setId(resultSet.getInt(3));
                cl.setNombre(resultSet.getString(4));
                cl.setDireccion(resultSet.getString(5));
                cl.setTelefono(resultSet.getString(6));
                cl.setEmail(resultSet.getString(7));
                c.setCliente(cl);

            }

        } catch (Exception e) {
            System.out.println("Hubo un error al validar " + e.getMessage());

        }
        return c;

    }

    public static boolean Eliminar(int id) {
        boolean resultado = false;
        try {

            Connection coneccion = Conexion.obtener();

            String consulta = "DELETE FROM cuenta WHERE id = ?";
            PreparedStatement statement = coneccion.prepareStatement(consulta);
            statement.setInt(1, id);
            statement.execute();

            resultado = statement.getUpdateCount() == 1;
        } catch (Exception e) {
            System.out.println("Hubo un error al eliminar " + e.getMessage());
        }
        return resultado;
    }
}
