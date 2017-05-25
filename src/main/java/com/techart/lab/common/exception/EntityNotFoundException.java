package com.techart.lab.common.exception;

/**
 * @author by vitali.pak
 */
public class EntityNotFoundException extends RuntimeException {

    private static final String GET_BY_ID_MESSAGE = "Entity of type %s with %d id is not found";

    private long entityID;

    private Class entityClass;

    public EntityNotFoundException(long entityID, Class entityClass) {
        this.entityID = entityID;
        this.entityClass = entityClass;
    }

    @Override
    public String getMessage() {
        return String.format(GET_BY_ID_MESSAGE, entityClass.getName(), entityID);
    }
}
