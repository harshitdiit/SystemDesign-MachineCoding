package entities;

import lombok.*;

import java.util.ArrayList;
import java.util.HashMap;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor @ToString
public class Table {

    private String tableName;
    private ArrayList<Column> columns;
    private HashMap<String, Row> rows;
    private HashMap<Integer, HashMap<Object, Integer>> index;
}
