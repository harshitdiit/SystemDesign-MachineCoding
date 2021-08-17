package entities;

import lombok.*;

import java.util.HashMap;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor @ToString
public class Database {

    String name;
    HashMap<String, Table> tables;

}
