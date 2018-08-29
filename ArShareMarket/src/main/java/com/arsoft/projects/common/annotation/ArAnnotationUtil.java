package com.arsoft.projects.common.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.arsoft.projects.common.exception.ArException;
import com.arsoft.projects.common.string.ArStringUtil;

public class ArAnnotationUtil {
	
	public static final Logger logger = LogManager.getLogger(new Object().getClass().getEnclosingClass());

	public static List<Annotation> getClassAnnotations(Class<?> clazz){
		List<Annotation> annotations = null;
		if (clazz == null){
			logger.error("Class is required");
			return annotations;
		}
		for (Annotation annotation : clazz.getDeclaredAnnotations()) {
			if (annotations == null){
				annotations = new ArrayList<>();
			}
			annotations.add(annotation);
		}
		logger.debug("Class Level Annotations are: "+annotations);
		return annotations;
	}
	
	public static Map<String, String> getAnnotationAttributes(Annotation annotation) throws ArException{
		Map<String, String> annotationAttributes = null;
		if (annotation == null){
			logger.error("Annotation is required");
			return annotationAttributes;
		}
		for (Method method : annotation.annotationType().getDeclaredMethods()){
			if (annotationAttributes == null){
				annotationAttributes = new HashMap<>();
			}
            Object value;
			try {
				value = method.invoke(annotation, (Object[])null);
				annotationAttributes.put(method.getName(), value.toString());
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new ArException("Exception thrown inside getAnnotationAttributes "+e.getLocalizedMessage());
			}
        }
		logger.debug("Attributes of annotation: "+annotation.annotationType().getSimpleName()+" are: "+annotationAttributes);
		return annotationAttributes;
	}
	
	public static String getAttributeValue(Annotation annotation, String attributeName) throws ArException{
		String attributeValue = null;
		if (ArStringUtil.isNullOrEmptyString(attributeName)){
			logger.error("Attribute name is required");
			return attributeValue;
		}
		if (annotation == null){
			logger.error("Annotation is required");
			return attributeValue;
		} 
		for (Method method : annotation.annotationType().getDeclaredMethods()){
			try {
				if (method.getName().equals(attributeName)){
					attributeValue =  method.invoke(annotation, (Object[])null).toString();
					break;
				}
			} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				throw new ArException("Exception thrown inside getAttributeValue "+e.getLocalizedMessage());
			}
        }
		return attributeValue;
	}
}
