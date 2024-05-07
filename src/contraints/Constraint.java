package contraints;

import model.Column;
import model.Row;

import java.util.List;

public interface Constraint {

    void  validate(Object target, Column column, List<Row> rows);
}
