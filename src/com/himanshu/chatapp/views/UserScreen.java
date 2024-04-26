package com.himanshu.chatapp.views;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.himanshu.chatapp.dao.UserDAO;
import com.himanshu.chatapp.dto.UserDTO;
import com.himanshu.chatapp.utils.UserInfo;

import java.lang.*;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JPasswordField;

public class UserScreen extends JFrame {

	
	private JPanel contentPane;
	private JTextField userId;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	    EventQueue.invokeLater(new Runnable() {
	        public void run() {
	            try {
	                UserScreen frame = new UserScreen();
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    });
	}
	
	UserDAO userDAO = new UserDAO();
	
	private void doLogin() {
	    String userid = userId.getText();
	    char[] password = passwordField.getPassword();
	    
	    UserDTO userDTO = new UserDTO(userid, password);
	    try {
	    	String message="";
			if(userDAO.isLogin(userDTO)) {
				message="Welcome "+userid;
				UserInfo.USER_NAME = userid;
				JOptionPane.showMessageDialog(this,message);
				setVisible(false);
				dispose();
				DashBoard dashBoard=new DashBoard(message);
				dashBoard.setVisible(true);
				//server s1=new server(message,userid);
				//s1.setVisible(true);
			}else {
				message="Invalid userid or password";
				JOptionPane.showMessageDialog(this,message);
			}
			//JOptionPane.showMessageDialog(this,message);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void register() {
	    String userid = userId.getText();
	    char[] password = passwordField.getPassword();
	    //UserDAO userDAO = new UserDAO();
	    UserDTO userDTO = new UserDTO(userid, password);
	    try {
	        int result = userDAO.add(userDTO);
	        if (result > 0) {
	        	JOptionPane.showMessageDialog(this,"Register Successfully");
	           //System.out.println("Record Added....");
	        } else {
	        	JOptionPane.showMessageDialog(this,"Register Failed");
	            //System.out.println("Record not Added....");
	        }
	    } 
	    catch (ClassNotFoundException ex) {
	        System.out.println("DB issue ..." );
	        ex.printStackTrace();
	    } 
	    catch (SQLException ex) {
	        System.out.println("DB issue ...");
	        ex.printStackTrace();
	    } 
	    catch (Exception ex) {
	        System.out.println("Some Generic exception raised...");
	        ex.printStackTrace();
	    }
	    System.out.println("userid " + userid + " password " + password+" "+password.toString());
	}

	/**
	 * Create the frame.
	 */
	public UserScreen() {
		setResizable(false);
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 550, 465);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel userName = new JLabel("User Name");
		userName.setFont(new Font("Arial", Font.PLAIN, 15));
		userName.setHorizontalAlignment(SwingConstants.LEFT);
		userName.setBounds(159, 153, 156, 14);
		contentPane.add(userName);
		
		userId = new JTextField();
		userId.setFont(new Font("Arial", Font.PLAIN, 13));
		userId.setBounds(159, 180, 236, 27);
		contentPane.add(userId);
		userId.setColumns(10);
		
		JLabel password = new JLabel("Password");
		password.setHorizontalAlignment(SwingConstants.LEFT);
		password.setFont(new Font("Arial", Font.PLAIN, 15));
		password.setBounds(159, 218, 156, 14);
		contentPane.add(password);
		
		JButton loginBt = new JButton("LogIn");
		loginBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doLogin();
				
				userId.setText("");
				passwordField.setText("");
			}
		});
		loginBt.setFont(new Font("Arial", Font.PLAIN, 15));
		loginBt.setBounds(159, 295, 236, 27);
		contentPane.add(loginBt);
		
		JButton registerBt = new JButton("Register");
		registerBt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					register();
					
					userId.setText("");
					passwordField.setText("");
					
			}	
		});
		registerBt.setFont(new Font("Arial", Font.PLAIN, 15));
		registerBt.setBounds(159, 333, 236, 27);
		contentPane.add(registerBt);
		
		
		// Adding image to the right side
        JLabel imageLabel = new JLabel();
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        //ImageIcon imageIcon = new ImageIcon("src/image/bgpic.png"); // Replace "image.jpg" with the actual path to your image
       // Image image = imageIcon.getImage().getScaledInstance(110, 110, Image.SCALE_DEFAULT); // Adjust size as needed
        //imageIcon = new ImageIcon(image);
        imageLabel.setIcon(new ImageIcon(UserScreen.class.getResource("/image/bgpic.png")));
        imageLabel.setBounds(159, 0, 241, 144); // Adjust position and size as needed
        contentPane.add(imageLabel);
        
        passwordField = new JPasswordField();
        passwordField.setBounds(159, 243, 236, 27);
        contentPane.add(passwordField);

	}
}
