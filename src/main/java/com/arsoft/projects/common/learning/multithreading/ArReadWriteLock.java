package com.arsoft.projects.common.learning.multithreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public class ArReadWriteLock implements ReadWriteLock{

	@Override
	public Lock readLock() {
		return null;
	}

	@Override
	public Lock writeLock() {
		return null;
	}

}
