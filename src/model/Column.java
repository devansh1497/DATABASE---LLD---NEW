package model;

import contraints.Constraint;
import enums.ColumnType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import validator.DataValidator;
import validator.NotNullValidator;
import validator.ValidatorFactory;

import java.util.ArrayList;
import java.util.List;


@Data
@Getter
public class Column {
    private String name;
    private ColumnType type;
    private List<DataValidator> dataValidators;
    private List<Constraint> constraints;
    private boolean isNull;

    public Column(String name, ColumnType type, boolean isNull, List<Constraint> constraints) {
        this.name = name;
        this.type = type;
        this.isNull = isNull;
        dataValidators = new ArrayList<>();
        dataValidators.add(ValidatorFactory.get(type));
        if (!isNull) {
            this.dataValidators.add(new NotNullValidator());
        }
        this.constraints = constraints;
    }
}
