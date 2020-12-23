package com.arsoft.projects.artutorial.learning.vertxapp;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;

public class HelloVerticle extends AbstractVerticle {

	@Override
	public void start(Future<Void> future) {
		vertx = this.getVertx();
		System.out.println("Welcome to Vertx");
		vertx.deployVerticle(HelloVerticle.class.getName(), deployResult -> {
			if (deployResult.succeeded()) {
				String deployment = deployResult.result();
				System.out.println("success: " + deployment);
				vertx.deploymentIDs().add(deployment);
			} else {
				System.out.println("failed");
			}
		});
	}

	@Override
	public void stop() {
		System.out.println("Shutting down application");
	}
}
