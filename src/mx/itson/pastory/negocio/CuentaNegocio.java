/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.pastory.negocio;

import mx.itson.pastory.persistencia.CuentaDAO;

/**
 *
 * @author julio
 */
public class CuentaNegocio {

    public static boolean guardar(String numero, int clId) {

        boolean resultado = false;

        try {

            resultado = CuentaDAO.guardar(numero, clId);

        } catch (Exception e) {
            System.out.println("A ocurrido un error al guardar " + e.getMessage());

        }
        return resultado;

    }
}
