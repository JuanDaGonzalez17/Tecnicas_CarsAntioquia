/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.loginapp;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginFrame extends JFrame {
    public LoginFrame() {
        System.out.println("Creando la ventana de login...");

        // Configuración de la ventana
        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Crea el panel de fondo y establece la imagen
        BackgroundPanel backgroundPanel = new BackgroundPanel("/Images/background.jpg");
        backgroundPanel.setLayout(new BorderLayout());

        // Crea un panel para los componentes de login
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS)); // Coloca componentes en vertical
        loginPanel.setOpaque(false); // Permite ver el fondo a través del panel
        
        // Crea los campos de texto y etiquetas
        JLabel userLabel = new JLabel("Usuario:");
        userLabel.setForeground(Color.WHITE); // Cambia el color a blanco
        JTextField userField = new JTextField(15);
        JLabel passwordLabel = new JLabel("Contraseña:");
        passwordLabel.setForeground(Color.WHITE); // Cambia el color a blanco
        JPasswordField passwordField = new JPasswordField(15);
        
        // Añadir los componentes al panel
        loginPanel.add(userLabel);
        loginPanel.add(userField);
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio entre campos
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        
        // Crear el botón de login
        JButton loginButton = new JButton("Ingresar");
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = userField.getText();
                String password = new String(passwordField.getPassword());
                if (authenticateUser(username, password)) {
                    new Index().setVisible(true); // Abrir ventana de índice
                    dispose(); // Cerrar ventana actual
                } else {
                    JOptionPane.showMessageDialog(LoginFrame.this, "Usuario o contraseña incorrectos.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio adicional antes del botón
        loginPanel.add(loginButton);

        // Botón para ir a la página de registro
        JButton registerButton = new JButton("Registrarse");
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RegisterFrame().setVisible(true); // Abrir ventana de registro
                dispose(); // Cerrar ventana de login
            }
        });
        loginPanel.add(Box.createRigidArea(new Dimension(0, 10))); // Espacio adicional antes del botón
        loginPanel.add(registerButton);

        // Añadir el panel de login al panel de fondo
        backgroundPanel.add(loginPanel, BorderLayout.EAST);

        // Añadir el panel de fondo al frame
        add(backgroundPanel);
        
        System.out.println("Ventana de login creada con éxito.");
    }

    private boolean authenticateUser(String username, String password) {
        // Método para autenticar al usuario a partir de un archivo CSV
        String csvFile = "users.csv"; // Ruta del archivo CSV
        String line;
        String[] credentials;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                credentials = line.split(","); // Divide la línea por la coma
                if (credentials.length == 2) {
                    if (credentials[0].equals(username) && credentials[1].equals(password)) {
                        return true; // Autenticación exitosa
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return false; // Autenticación fallida
    }

    public static void main(String[] args) {
        System.out.println("Iniciando la aplicación...");
        SwingUtilities.invokeLater(() -> {
            LoginFrame loginFrame = new LoginFrame();
            loginFrame.setVisible(true); // Muestra la ventana
            System.out.println("La ventana de login se ha mostrado.");
        });
    }
}
