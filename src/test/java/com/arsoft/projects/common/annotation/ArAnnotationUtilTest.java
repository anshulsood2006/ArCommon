package com.arsoft.projects.common.annotation;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Path;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.webservice.rest.environment.ArEnvironmentService;

public class ArAnnotationUtilTest {
	
	@Rule
	public ExpectedException expectedException = ExpectedException.none();
	
	@Test
	public void getClassAnnotations() throws ArException{
		List<Annotation> annotations = ArAnnotationUtil.getClassAnnotations(ArEnvironmentService.class);
		assertEquals(annotations.get(0).annotationType(),Path.class);
		assertEquals(annotations.get(0).annotationType().getSimpleName(),"Path");
		assertEquals(annotations.get(0).annotationType().getName(),"javax.ws.rs.Path");
	}
	
	@Test
	public void getClassAnnotationsNull(){
		List<Annotation> annotations = ArAnnotationUtil.getClassAnnotations(null);
		assertNull(annotations);
	}
	
	@Test
	public void getAnnotationAttributes() throws ArException{
		Map<String, String> expectedAttributes = new HashMap<String, String>();
		expectedAttributes.put("value", "/getEnvironmentDetail");
		List<Annotation> annotations = ArAnnotationUtil.getClassAnnotations(ArEnvironmentService.class);
		assertNotNull(annotations);
		Map<String, String> attributes = ArAnnotationUtil.getAnnotationAttributes(annotations.get(0));
		assertNotNull(attributes);
		assertEquals(expectedAttributes,attributes);	
	}
	
	@Test
	public void getAttributeValue() throws ArException{
		List<Annotation> annotations = ArAnnotationUtil.getClassAnnotations(ArEnvironmentService.class);
		String value = ArAnnotationUtil.getAttributeValue(annotations.get(0), null);
		assertNull(value);
		value = ArAnnotationUtil.getAttributeValue(null, "");
		assertNull(value);
		value = ArAnnotationUtil.getAttributeValue(null, null);
		assertNull(value);
		value = ArAnnotationUtil.getAttributeValue(annotations.get(0), "");
		assertNull(value);
		value = ArAnnotationUtil.getAttributeValue(annotations.get(0), "value");
		assertEquals(value, "/getEnvironmentDetail");
		value = ArAnnotationUtil.getAttributeValue(annotations.get(0), "invalid");
		assertEquals(value, null);
	}
	
}
