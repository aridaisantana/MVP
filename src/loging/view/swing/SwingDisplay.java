/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loging.view.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import static java.awt.SystemColor.text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import loging.presenter.Presenter;
import loging.view.Display;

/**
 *
 * @author usuario
 */
public class SwingDisplay extends JFrame implements Display {
    
    private Presenter presenter;

    private JLabel  statusLabel;
    
    private JLabel user;
    private JLabel pass;
    
    private JTextField userName;
    private JTextField password;

    
    public SwingDisplay() {
        createUI();
    }
    
    
    public void updateStatusLabel(String text) {
        statusLabel.setText(text);

    }

    @Override
    public void display() {
        setVisible(true);
    }

    private void createUI() {
        this.setTitle("Loging");
        JFrame frame = new JFrame();
        Container panel = getContentPane();
	panel.setLayout(new GridLayout(3,2));
        
        
        
        statusLabel = new JLabel("This updates in reponse to input: ");
        
        user = new JLabel("User name:");
        userName = new JTextField(20);
        
        pass = new JLabel("Password");
        password = new JTextField(20);

        JButton loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                 presenter.login(userName.getText(),password.getText());
            }
            }); 

 
        panel.add(user);
        panel.add(userName);
        panel.add(pass);
        panel.add(password);
        panel.add(loginButton);
        panel.add(statusLabel);
      
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);

    }
    
   
    public void setPresenter(Presenter presenter) {

        this.presenter = presenter;

    }

    
}
