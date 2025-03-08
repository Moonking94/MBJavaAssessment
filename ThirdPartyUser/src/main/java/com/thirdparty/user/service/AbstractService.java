package com.thirdparty.user.service;

import java.lang.reflect.Field;

public class AbstractService {

	protected static <T> void setField(T entity, String key, Object value) {
        try {
            Field field = entity.getClass().getDeclaredField(key);
            field.setAccessible(true); // Allow modifying private fields

            Class<?> fieldType = field.getType();

            if (fieldType.equals(Character.class) || fieldType.equals(char.class)) {
                // Convert String to Character safely
                if (value instanceof String && !((String) value).isEmpty()) {
                    field.set(entity, ((String) value).charAt(0));
                } else {
                    field.set(entity, null);
                }
            } else if (fieldType.equals(Integer.class) || fieldType.equals(int.class)) {
                field.set(entity, Integer.parseInt(value.toString()));
            } else if (fieldType.equals(Long.class) || fieldType.equals(long.class)) {
                field.set(entity, Long.parseLong(value.toString()));
            } else if (fieldType.equals(Double.class) || fieldType.equals(double.class)) {
                field.set(entity, Double.parseDouble(value.toString()));
            } else if (fieldType.equals(Boolean.class) || fieldType.equals(boolean.class)) {
                field.set(entity, Boolean.parseBoolean(value.toString()));
            } else {
                // Default case: Direct assignment
                field.set(entity, value);
            }
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace(); // Handle properly in production
        }
    }
	
}
