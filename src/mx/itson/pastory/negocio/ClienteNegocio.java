/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastory.negocio;

import mx.itson.pastory.persistencia.ClienteDAO;

/**
 *
 * @author julio
 */
public class ClienteNegocio {

    public static boolean guardar(String nombre, String direccion, String telefono, String email) {
        boolean resultado = false;
        try {
            if (!ClienteDAO.comprobarEmail(email)) {
                resultado = ClienteDAO.guardar(nombre, direccion, telefono, email);
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return resultado;
    }
}
