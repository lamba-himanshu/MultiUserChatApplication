package com.himanshu.chatapp.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import com.himanshu.chatapp.utils.ConfigReader;

public class Server {

	ServerSocket serverSocket;
	ArrayList<ServerWorker> workers=new ArrayList<>();
	public Server() throws IOException {
		int port=Integer.parseInt(ConfigReader.getValue("PortNo"));
		serverSocket = new ServerSocket(port);
		System.out.println("Server Start and waiting for the clients to join");
		handleClientRequest();
	}
	public void handleClientRequest() throws IOException {
		while(true) {
			Socket clientSocket =serverSocket.accept();
			//per client per thread
			ServerWorker serverWorker = new ServerWorker(clientSocket,this);
			workers.add(serverWorker);
			serverWorker.start();
		}
	}
	
	/* single client
	public Server() throws IOException {
		int port=Integer.parseInt(ConfigReader.getValue("PortNo"));
		serverSocket = new ServerSocket(port);
		System.out.println("Server Started and waiting for the client connection..");
		Socket socket = serverSocket.accept(); //Handshaking
		System.out.println("Client joins the server");
		InputStream in=socket.getInputStream();
		byte arr[]=in.readAllBytes();
		String str=new String(arr);
		System.out.println("Message recieved from client "+str);
		in.close();
		socket.close();
	}
	*/
	public static void main(String args[]) throws IOException {
		Server server =new Server();
	}
}
