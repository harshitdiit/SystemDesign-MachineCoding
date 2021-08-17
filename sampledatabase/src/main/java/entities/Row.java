package entities;

import lombok.*;

import java.util.HashMap;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor @ToString
public class Row {
    private Integer rowId;
    private HashMap<Integer, Object> valueset;
}
