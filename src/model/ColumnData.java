package model;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class ColumnData {

    private Column column;
    private Object data;

    public Column getColumn() {
        return column;
    }

    public Object getData() {
        return data;
    }

    @Override
    public String toString() {
        return "ColumnData{" +
                "data=" + data +
                '}';
    }
}
