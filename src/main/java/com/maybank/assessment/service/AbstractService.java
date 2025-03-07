package com.maybank.assessment.service;

import java.lang.reflect.Field;

public class AbstractService {

	protected void setField(Object entity, String fieldName, Object value) {
        try {
            Field field = entity.getClass().getDeclaredField(fieldName); // Get field dynamically
            field.setAccessible(true); // Allow modifying private fields
            field.set(entity, value); // Set value (including null)
        } catch (NoSuchFieldException e) {
            throw new IllegalArgumentException("Field " + fieldName + " does not exist on entity " + entity.getClass().getSimpleName());
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Unable to update field " + fieldName, e);
        }
    }
	
}
