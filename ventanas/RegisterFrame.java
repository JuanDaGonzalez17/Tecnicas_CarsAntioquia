/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.loginapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class RegisterFrame extends JFrame {
    public RegisterFrame() {
        System.out.println("Creando la ventana de registro...");

        // Configuración de la ventana
        setTitle("Registro");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crea el panel de fondo y establece la imagen
        BackgroundPanel backgroundPanel = new BackgroundPanel("/Images/background.jpg");
        backgroundPanel.setLayout(new BorderLayout());

        // Crea un panel para los componentes de registro
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS)); // Coloca componentes en vertical
        registerPanel.setOpaque(false); // Permite ver el fondo a través del panel

        // Crea los campos de texto y etiquetas
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setForeground(Color.WHITE); // Cambia el color a blanco
        JTextField userField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setForeground(Color.WHITE); // Cambia el color a blanco
        JPasswordField passwordField = new JPasswordField(15);
        JLabel confirmPasswordLabel = new JLabel("Confirmar Contraseña:");
        confirmPasswordLabel.setForeground(Color.WHITE); // Cambia el color a blanco
        JPasswordField confirmPasswordField = new JPasswordField(15);
        
        // Añadir los componentes al panel
        registerPanel.add(userLabel);
        registerPanel.add(userField);
        registerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre campos
        registerPanel.add(passwordLabel);
        registerPanel.add(passwordField);
        registerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre campos
        registerPanel.add(confirmPasswordLabel);
        registerPanel.add(confirmPasswordField);
        
        // Crear el botón de registro
        JButton registerButton = new JButton("Registrarse");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());

                // Validar que las contraseñas coincidan
                if (!password.equals(confirmPassword)) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Agregar usuario al archivo CSV
                if (registerUser(username, password)) {
                    JOptionPane.showMessageDialog(RegisterFrame.this, "Registro exitoso. Ahora puedes iniciar sesión.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    new LoginFrame().setVisible(true); // Abrir ventana de login
                    dispose(); // Cerrar ventana de registro
                }
            }
        });
        registerPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio adicional antes del botón
        registerPanel.add(registerButton);

        // Añadir el panel de registro al panel de fondo
        backgroundPanel.add(registerPanel, BorderLayout.EAST);

        // Añadir el panel de fondo al frame
        add(backgroundPanel);

        System.out.println("Ventana de registro creada con éxito.");
    }

    private boolean registerUser(String username, String password) {
        String csvFile = "users.csv"; // Ruta del archivo CSV
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile, true))) {
            bw.write(username + "," + password);
            bw.newLine();
            return true; // Registro exitoso
        } catch (IOException e) {
            e.printStackTrace();
            return false; // Fallo en el registro
        }
    }

    public static void main(String[] args) {
        System.out.println("Iniciando la aplicación de registro...");
        SwingUtilities.invokeLater(() -> {
            RegisterFrame registerFrame = new RegisterFrame();
            registerFrame.setVisible(true); // Muestra la ventana
            System.out.println("La ventana de registro se ha mostrado.");
        });
    }
}
