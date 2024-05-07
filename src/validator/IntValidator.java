package validator;

import exceptions.DataTypeException;

public class IntValidator implements DataValidator {
    @Override
    public void validate(Object target) throws DataTypeException {
        if(!(target instanceof Integer)) {
            throw new DataTypeException();
        }
        int val = (Integer)target;
        if(val < -1024 || val > 1024) {
            throw new DataTypeException();
        }
    }
}
