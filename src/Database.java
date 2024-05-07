import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import model.Column;
import model.Table;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Database {

    private List<Table> tables;

    public Table addTable(String name, List<Column> cols) {
        tables.add(new Table(name, cols));
        return tables.get(tables.size()-1);
    }
}
