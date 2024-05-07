package model;

import contraints.Constraint;
import exceptions.DataTypeException;
import lombok.AllArgsConstructor;
import lombok.Data;
import validator.DataValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
public class Table {

    private String name;
    private List<Column> cols;
    private List<Row> rows;

    public Table(String name, List<Column> cols) {
        this.name = name;
        this.cols = cols;
        this.rows = new ArrayList<>();
    }

    public void add(List<Object> data) throws DataTypeException {
        if(data.size() != cols.size()) {
            throw new RuntimeException("Invalid input");
        }
        List<ColumnData> columnData = new ArrayList<>();
        for (int i = 0; i < cols.size(); i++) {
            Column col = cols.get(i);
            Object o = data.get(i);
            for (DataValidator dataValidator : col.getDataValidators()) {
                dataValidator.validate(o);
            }
            for (Constraint constraint : col.getConstraints()) {
                constraint.validate(o, col, rows);
            }
            columnData.add(new ColumnData(col, o));
        }
        rows.add(new Row(rows.size()+1, columnData));
    }
}
