import entities.Cache;
import entities.CacheEntry;
import service.CacheService;
import service.impl.LRUCacheService;

import java.util.HashMap;

public class Application {

    public static void main(String[] args){

        Cache<String> cache = new Cache<String>();
        cache.setStore(new HashMap<String, CacheEntry<String>>());
        cache.setCacheSize(4);

        CacheService<String> service = new LRUCacheService<String>();

        System.out.println("\nPutting keys\n");
        for(int i=0; i<4; i++){
            service.putEntry(cache, Integer.toString(i), Integer.toBinaryString(i));
        }

        cache.printCache();

        System.out.println("\nGetting key 2\n");
        CacheEntry<String> getResult = service.getEntry(cache, Integer.toString(2));
        getResult.printCacheEntry();

        cache.printCache();

        System.out.println("\nPutting new key\n");
        service.putEntry(cache, Integer.toString(5), Integer.toBinaryString(5));

        cache.printCache();

        System.out.println("\nDeleting key 1\n");
        service.deleteEntry(cache, Integer.toString(1));

        cache.printCache();
    }
}
