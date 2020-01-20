package com.arsoft.projects.common.socket;

import java.io.DataOutputStream;
import java.net.Socket;

public class Provider {
	public static void main(String[] args) {
		try {
			Socket s = new Socket("arjboss", 6666);
			DataOutputStream dout = new DataOutputStream(s.getOutputStream());
			dout.writeUTF("Hello Server");
			dout.flush();
			dout.close();
			s.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
