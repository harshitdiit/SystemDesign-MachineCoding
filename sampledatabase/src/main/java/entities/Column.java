package entities;

import constants.DataType;
import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor @ToString
public class Column {

    private Integer colIndex;
    private String name;
    private DataType dataType;
    private Boolean isIndexed;
    private Object defaultValue;

}
