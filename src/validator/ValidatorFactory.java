package validator;

import enums.ColumnType;

public class ValidatorFactory {

    public static DataValidator get(ColumnType type) {
        if(type == ColumnType.INT ) {
            return new IntValidator();
        } else if(type == ColumnType.STRING) {
            return new StringValidator();
        } else{
//            throw exeception
        }
        return null;
    }
}
