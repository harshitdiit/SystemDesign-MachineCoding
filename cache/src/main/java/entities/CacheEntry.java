package entities;

import lombok.*;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class CacheEntry<T> {

    private String key;
    private T value;
    private CacheEntry<T> next;
    private CacheEntry<T> previous;

    public void printCacheEntry(){
        System.out.println(key + " " + value);
    }
}
