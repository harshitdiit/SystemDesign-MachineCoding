package constants;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor @NoArgsConstructor
public enum DataType {
    STRING("str", String.class),
    INTEGER("int", Inetger.class);

    private String name;
    private Class type;
}
