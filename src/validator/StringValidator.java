package validator;

import exceptions.DataTypeException;

public class StringValidator implements DataValidator {
    @Override
    public void validate(Object target) throws DataTypeException {
        if(!(target instanceof String val)) {
            throw new DataTypeException();
        }
        if(val.length() > 20) {
            throw new DataTypeException();
        }
    }
}
