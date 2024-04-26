package com.himanshu.chatapp.views;

import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class UserView extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserView(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500,600);
        setResizable(false);
        setTitle("Login");
        setLocationRelativeTo(null);
        //setLocation(100,50);
        
        JLabel welcome = new JLabel("Login");
        welcome.setFont(new Font("Arial", Font.BOLD, 40));
        Container container =this.getContentPane();
        container.setLayout(null);
        welcome.setBounds(200,100,200,60);
        container.add(welcome);
        
        JButton button = new JButton("submit");
        button.setBounds(150,200,100,60);
        container.add(button);
        
        setVisible(true);
    }
	
	public static void main(String args[]) {
		
	}
}
