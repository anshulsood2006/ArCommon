package com.arsoft.projects.artutorial.learning.vertxapp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class MyVerticle extends AbstractVerticle {
	@Override
	public void start(Future<Void> startFuture) {
		vertx.eventBus().consumer("address", message -> System.out.println("Message consumed."));
		System.out.println("MyVerticle started!");
	}
}
