package validator;

import exceptions.DataTypeException;

public class NotNullValidator implements DataValidator {
    @Override
    public void validate(Object target) throws DataTypeException {
        if(target == null) {
            throw new DataTypeException();
        }
    }
}
