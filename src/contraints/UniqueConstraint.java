package contraints;

import exceptions.ConstraintException;
import model.Column;
import model.ColumnData;
import model.Row;

import java.util.List;
import java.util.Objects;

public class UniqueConstraint implements Constraint {
    @Override
    public void validate(Object target, Column column, List<Row> rows) {
        for (Row row : rows) {
            for (ColumnData columnDatum : row.getColumnData()) {
                if(columnDatum.getColumn().getName().equals(column.getName()) && Objects.equals(target,
                        columnDatum.getData())) {
                    throw new ConstraintException();
                }
            }
        }
    }
}
