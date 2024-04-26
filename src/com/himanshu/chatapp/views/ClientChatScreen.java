package com.himanshu.chatapp.views;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.himanshu.chatapp.network.Client;
import com.himanshu.chatapp.utils.UserInfo;

import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.UnknownHostException;
import java.awt.event.ActionEvent;

public class ClientChatScreen extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextArea textArea ;
	private Client client;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

					try {
						ClientChatScreen frame = new ClientChatScreen();
					}catch(UnknownHostException ex) {
						ex.printStackTrace();
					}
					catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

	}
	
	private void sendIt() {
		String message = textField.getText();
		try {
			client.sendMessage(UserInfo.USER_NAME + " - " + message);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public ClientChatScreen() throws UnknownHostException, IOException {
		textArea =new JTextArea();
		client=new Client(textArea);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(ClientChatScreen.class.getResource("/image/icons8-chat-100.png")));
		setFont(new Font("Arial", Font.PLAIN, 14));
		setTitle("MultiTalk");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 69, 544, 440);
		contentPane.add(scrollPane);
		

		//textArea.setForeground(new Color(0, 128, 255));
		textArea.setFont(new Font("Arial", Font.PLAIN, 19));
		textArea.setBounds(5, 63, 5,540 );
		scrollPane.setViewportView(textArea);
		
		textField = new JTextField();
		textField.setBackground(new Color(255, 255, 255));
		textField.setBounds(10, 516, 402, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Send");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sendIt();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(0, 128, 255));
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 20));
		btnNewButton.setBounds(426, 516, 128, 33);
		contentPane.add(btnNewButton);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(1, 172, 254));
		panel.setBounds(0, 0, 574, 58);
		panel.setLayout(null);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ClientChatScreen.class.getResource("/image/bimage.png")));
		lblNewLabel.setBounds(10, 11, 59, 36);
		panel.add(lblNewLabel);

   
		//contentPane.add(textArea);
//		
//        ImageIcon i4=new ImageIcon(ClassLoader.getSystemResource("image/himanshu.png"));
//        Image i5 = i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
//        ImageIcon i6=new ImageIcon(i5);
        setVisible(true);

	}
}
