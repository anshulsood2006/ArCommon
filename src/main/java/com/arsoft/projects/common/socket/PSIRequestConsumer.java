package com.arsoft.projects.common.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PSIRequestConsumer {
	public static void main(String[] args) throws IOException {
		ServerSocket listener = new ServerSocket(6200);
		int noOfConnections = 1;
		int maxConnections = 20;
		try {
			while (noOfConnections <= maxConnections) {
				System.out.println("PSIRequestConsumer is listening");
				Socket socket = listener.accept();
				noOfConnections++; 
				DataInputStream dis=new DataInputStream(socket.getInputStream());  
				String  str=(String)dis.readUTF();  
				System.out.println("message= "+str); 
				socket.close();
			}
			System.out.println("PSIRequestConsumer is not listening");
		} finally {
			listener.close();
		}
	}
}
