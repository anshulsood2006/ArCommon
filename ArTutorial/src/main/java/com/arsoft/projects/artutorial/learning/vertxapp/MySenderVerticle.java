package com.arsoft.projects.artutorial.learning.vertxapp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

public class MySenderVerticle extends AbstractVerticle{
	
	private String message;
	private String address;
	private Vertx vertx;
	
	MySenderVerticle(String message, String address, Vertx vertx){
		this.message = message;
		this.address = address;
		this.vertx = vertx;
	}
	
	@Override
	public void start(Future<Void> startFuture) {
		System.out.println("Start called inside MySenderVerticle");
		vertx.eventBus().send(address, "This is message sent to "+address+" : "+message);
	}
}
