package filters;

import enums.FilterOperator;

import java.util.Objects;
import java.util.function.BiFunction;

public class FilterFactory {

    public static BiFunction<Object, Object, Boolean> get(FilterOperator operator ) {
        if(operator == FilterOperator.EQUAL) {
            return Object::equals;
        } else if(operator == FilterOperator.NOT_EQUAL) {
            return (x,y) -> !Objects.equals(x, y);
        }
        //throw exception
        return null;
    }
}
