package com.arsoft.projects.artutorial.learning.vertxapp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class MyReceiverVerticle extends AbstractVerticle{
	
	private String message;
	private String address;
	private Vertx vertx;
	
	MyReceiverVerticle(String message, String address, Vertx vertx){
		this.message = message;
		this.address = address;
		this.vertx = vertx;
	}
	
	@Override
	public void start(Future<Void> startFuture) {
		System.out.println("Start called inside MyReceiverVerticle");
		vertx.eventBus().consumer(address, messageSent -> System.out.println("This is message sent to "+address+" : "+message));
	}
}

