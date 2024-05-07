package filters;

import model.Column;
import model.ColumnData;
import model.Row;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

public class Filter {

    private Column column;
    private Object target;

    public Filter(Column column, Object target) {
        this.column = column;
        this.target = target;
    }

    public List<Row> filter(List<Row> rows, BiFunction<Object, Object, Boolean> logic) {
        List<Row> result = new ArrayList<>();

        for (Row innerRow : rows) {
            boolean include = false;
            for (ColumnData columnDatum : innerRow.getColumnData()) {
                if (columnDatum.getColumn().getName().equals(column.getName()) && logic.apply(columnDatum.getData(), target)) {
                    include = true;
                }
            }
            if (include) {
                result.add(innerRow);
            }
        }
        return result;
    }
}
