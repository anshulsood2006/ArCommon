package com.arsoft.projects.common.socket;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class PSIRequestSimulator {
	
	private final static String psiApplyTariffRequest = "008701040000000f333830363738343530323236202020202020202020202020202020202020333830363732303534343735202020202020202020202020202020202020013338303637373637303932352020202020202020202020202020202020203030303030303030303030303030303030303030303030303030303030303030303230303030";

	public static void main(String[] args) throws IOException {
		while (true) {
			Socket s = new Socket("localhost", 6200);
			DataOutputStream dout=new DataOutputStream(s.getOutputStream()); 
			dout.writeUTF(psiApplyTariffRequest);  
			dout.flush();  
			dout.close();
			s.close();
		}
	}

}
