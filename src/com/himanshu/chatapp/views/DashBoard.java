package com.himanshu.chatapp.views;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DashBoard extends JFrame {

	//private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashBoard frame = new DashBoard("");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public DashBoard(String message) {
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle(message);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu chatMenu = new JMenu("Chat");
		menuBar.add(chatMenu);
		
		JMenuItem startChat = new JMenuItem("StartChat");
		startChat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ClientChatScreen();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		chatMenu.add(startChat);
		setContentPane(contentPane);
		//contentPane.setLayout(null);
		
		JLabel imageLabel = new JLabel("");
		imageLabel.setIcon(new ImageIcon(DashBoard.class.getResource("/image/chatPic.jpg")));
		//Image image = imageIcon.getImage().getScaledInstance(690, 500, Image.SCALE_DEFAULT);
		//imageIcon = new ImageIcon(image);
		
        imageLabel.setBounds(0, 0, 700, 500);
		contentPane.add(imageLabel);
	
	}
}
