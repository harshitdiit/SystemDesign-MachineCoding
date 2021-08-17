package entities;

import lombok.*;

import java.util.HashMap;

@Getter @Setter @Builder
@NoArgsConstructor @AllArgsConstructor
public class Cache<T> {

    private Integer cacheSize;
    private CacheEntry<T> head;
    private CacheEntry<T> tail;
    private HashMap<String, CacheEntry<T>> store;

    public void printCache(){
        System.out.println("Current Cache State :");
        for (String entry: store.keySet()) {
            String key = entry;
            CacheEntry<T> value = store.get(key);
            System.out.println(key + " " + value.getValue());
        }

        System.out.println("Most Recently Used Key : " + this.head.getKey());
        System.out.println("Least Recently Used Key  : " + this.tail.getKey());
    }
}
