package com.arsoft.projects.artutorial.learning.vertxapp;

import io.vertx.core.*;
public class MyVertex {
	public static void main(String[] args) {
		Vertx vertx = Vertx.vertx();
		String message = "Anshul is living here";
		String address = "Sector 137 Noida";
		vertx.deployVerticle(new MySenderVerticle(message, address, vertx));
		vertx.deployVerticle(new MyReceiverVerticle(message, address, vertx));
	}
}
