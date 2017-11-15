package com.arsoft.projects.common.socket;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class PSIRequestListener implements Runnable {

	public PSIRequestListener() {
		Thread thread = new Thread(this);
		thread.start();
	}

	@Override
	public void run() {
		ServerSocket listener = null;
		try {
			listener = new ServerSocket(6200);
			if (listener != null)
			{
				System.out.println("PSIRequestConsumer is listening");
				Socket socket = listener.accept();
				DataInputStream dis = new DataInputStream(socket.getInputStream());
				String str = (String) dis.readUTF();
				System.out.println("message= " + str);
				socket.close();
			}
		} catch (IOException e) {
			
		} finally {
			try {
				if(listener != null) {
					listener.close();
				}
			} catch (IOException e) {
				
			}
		}
	}

}
