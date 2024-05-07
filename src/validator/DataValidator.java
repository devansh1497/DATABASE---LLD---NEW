package validator;

import exceptions.DataTypeException;

public interface DataValidator {

    void validate(Object target) throws DataTypeException;
}
