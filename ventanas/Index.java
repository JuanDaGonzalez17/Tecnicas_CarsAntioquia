/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.loginapp;

import javax.swing.*;
import java.awt.*;

public class Index extends JFrame {
    public Index() {
        System.out.println("Creando la ventana de índice...");

        // Configuración de la ventana
        setTitle("Índice");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crea el panel de fondo y establece la imagen
        BackgroundPanel backgroundPanel = new BackgroundPanel("/Images/background.jpg");
        backgroundPanel.setLayout(new BorderLayout());

        // Crea un panel de contenido
        JPanel contentPanel = new JPanel();
        contentPanel.setOpaque(false); // Permite ver el fondo a través del panel
        contentPanel.setLayout(new FlowLayout());

        JLabel welcomeLabel = new JLabel("Bienvenido al Índice");
        welcomeLabel.setForeground(Color.WHITE); // Cambia el color a blanco

        contentPanel.add(welcomeLabel);
        backgroundPanel.add(contentPanel, BorderLayout.CENTER);

        // Añadir el panel de fondo al frame
        add(backgroundPanel);

        System.out.println("Ventana de índice creada con éxito.");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Index indexFrame = new Index();
            indexFrame.setVisible(true); // Muestra la ventana
            System.out.println("La ventana de índice se ha mostrado.");
        });
    }
}
