package com.arsoft.projects.common.socket;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PSIRequestConsumer {
	public static void main(String[] args) throws IOException {
		System.out.println("This is currently running on the main thread, " +  
	            "the id is: " + Thread.currentThread().getId()); 
		List<PSIRequestListener> psiRequestListeners = new ArrayList<PSIRequestListener>();
		for (int i=0; i < 5; i++)  {
			psiRequestListeners.add(new PSIRequestListener());
		}
	}
}
