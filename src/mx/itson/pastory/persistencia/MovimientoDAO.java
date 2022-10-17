/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastory.persistencia;

import java.util.ArrayList;
import java.util.List;
import mx.itson.pastory.entidades.Movimiento;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Statement;
import mx.itson.pastory.entidades.Cuenta;

/**
 *
 * @author AbelEsquer
 */
public class MovimientoDAO {
    
    public static List<Movimiento>obtenerPorId(int cuenta){
    
        List<Movimiento> movimientos = new ArrayList<>();
        try {
           
            Connection connection = Conexion.obtener();
            String consulta = "SELECT id, concepto, fecha, importe, tipo, idcuenta FROM pastordb.movimiento where idCuenta = ?";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setInt(1, cuenta);
            
            statement.execute();
          
            ResultSet resultSet = statement.executeQuery();
            
            while (resultSet.next()) {
                
                 Movimiento m = new Movimiento();
                m.setId(resultSet.getInt(1));
                m.setConcepto(resultSet.getString(2));
                m.setFecha(resultSet.getDate(3));
                m.setImporte(resultSet.getInt(4));
                m.setTipo(resultSet.getInt(5));
                
                Cuenta cu = new Cuenta();
                cu.setId(resultSet.getInt(6));
                
                m.setCuenta(cu);
                
                movimientos.add(m);
                
            }
            
        } catch (Exception e) {
            System.err.println("Ocurrio un error: " + e.getMessage());
        }      
    return movimientos;
    }
    
    
    public static boolean guardar(String concepto, Double importe, int tipo, int cuId) {
        boolean resultado = false;

        try {

            Connection connection = Conexion.obtener();
            String consulta = "INSERT INTO pastordb.movimiento (concepto, importe, tipo, idCuenta) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(consulta);
            statement.setString(1, concepto);
            statement.setDouble(2, importe);
            statement.setDouble(3, tipo);
            statement.setDouble(4, cuId);
            statement.execute();

            resultado = statement.getUpdateCount() == 1;

        } catch (Exception e) {
            System.out.println("Ocurrio un error " + e);
        }
        return resultado;

    }
    
}


