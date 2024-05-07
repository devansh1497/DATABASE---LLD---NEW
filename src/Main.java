import enums.FilterOperator;
import contraints.UniqueConstraint;
import enums.ColumnType;
import exceptions.DataTypeException;
import model.Column;
import model.Table;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws DataTypeException {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        DatabaseManager databaseManager = DatabaseManager.get();
        Database database = databaseManager.create("db");
        List<Column> cols = new ArrayList<>();
        Column c1 = new Column("id", ColumnType.INT, false, Arrays.asList(new UniqueConstraint()));
        Column c2 = new Column("name", ColumnType.STRING, false, Arrays.asList(new UniqueConstraint()));
        cols.add(c1);
        cols.add(c2);
        Table student = databaseManager.createTable(database, "student", cols);
        List<Object> l1 = new ArrayList<>();
        l1.add(1);
        l1.add("Devansh");
        List<Object> l2 = new ArrayList<>();
        l2.add(1);
        l2.add("bunny");

        databaseManager.insert(student, l1);
        databaseManager.insert(student, l2);


        databaseManager.printTable(student, c1, 3, FilterOperator.NOT_EQUAL);
    }
}