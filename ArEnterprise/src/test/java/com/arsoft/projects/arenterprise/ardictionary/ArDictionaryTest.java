package com.arsoft.projects.arenterprise.ardictionary;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.arsoft.projects.arenterprise.ardictionary.contract.IArDictionary;

@RunWith(MockitoJUnitRunner.class)
public class ArDictionaryTest {
	@Mock
	IArDictionary arDictionary;
	
	@Test
	public void addTest(){
		boolean added = arDictionary.add("Anshul", "Sun");
		assertEquals(added, false);
	}
	
	@Test
	public void findTest(){
		Map<String, List<String>> wordPresent = arDictionary.find("Anshul");
	}
}

