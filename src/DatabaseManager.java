import enums.FilterOperator;
import exceptions.DataTypeException;
import filters.Filter;
import filters.FilterFactory;
import model.Column;
import model.Row;
import model.Table;

import java.util.*;

public class DatabaseManager {

    private static DatabaseManager INSTANCE;
    private Map<String, Database> databaseMap = new HashMap<>();

    public static DatabaseManager get() {
        if(INSTANCE == null) {
            INSTANCE = new DatabaseManager();
        }
        return INSTANCE;
    }

    private DatabaseManager(){}

    public Database create(String name) {
        databaseMap.put(name, new Database(new ArrayList<>()));
        return databaseMap.get(name);
    }

    public Table createTable(Database database, String name, List<Column> columns) {
        return database.addTable(name, columns);
    }

    public void insert(Table table, List<Object> data) throws DataTypeException {
        table.add(data);
    }

    public void printData(Table table) {
        for (Row row : table.getRows()) {
            row.getColumnData().forEach(System.out::print);
            System.out.println();
        }
    }

    public void printTable(Table table, Column column, Object target, FilterOperator operator) {
        List<Row> rows = table.getRows();
        Filter filter = new Filter(column, target);
        filter.filter(rows, FilterFactory.get(operator)).forEach(System.out::println);
    }
}
