package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@AllArgsConstructor
@Setter
@Data
public class Row {

    private int no;
    private List<ColumnData> columnData;
}
