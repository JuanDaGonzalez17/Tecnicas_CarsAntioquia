/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.loginapp;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Ejecutar la creación de la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {
            // Crear la ventana de inicio de sesión
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true); // Mostrar la ventana de login
        });
    }
}