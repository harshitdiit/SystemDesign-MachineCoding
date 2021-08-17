package service.impl;

import entities.Cache;
import entities.CacheEntry;
import lombok.NoArgsConstructor;
import service.CacheService;

import java.util.HashMap;

@NoArgsConstructor
public class LRUCacheService<T> implements CacheService<T> {

    public CacheEntry<T> getEntry(Cache<T> cache, String key) {

        HashMap<String, CacheEntry<T>> store = cache.getStore();

        if(!store.containsKey(key)){
            return null;
        }

        CacheEntry<T> entry = store.get(key);
        deleteEntry(cache, entry.getKey());
        putEntry(cache, entry.getKey(), entry.getValue());

        Integer i = new Integer(0);
        i = 6;
        i = i>6?i:4;

        return entry;

    }

    public CacheEntry<T> deleteEntry(Cache<T> cache, String key) {

        HashMap<String, CacheEntry<T>> store = cache.getStore();

        if(!store.containsKey(key))
            return null;

        CacheEntry<T> entry = store.get(key);

        if(entry.getPrevious() != null){
            entry.getPrevious().setNext(entry.getNext());
        }
        else{
            cache.setHead(entry.getNext());
        }

        if(entry.getNext() != null){
            entry.getNext().setPrevious(entry.getPrevious());
        }
        else{
            cache.setTail(entry.getPrevious());
        }

        store.remove(key);

        return entry;

    }

    public CacheEntry<T> putEntry(Cache<T> cache, String key, T value) {
        if(key==null || value==null){
            return null;
        }

        HashMap<String, CacheEntry<T>> store = cache.getStore();
        CacheEntry<T> response;

        // Updates old value
        if(store.containsKey(key)){
            CacheEntry<T> entry = store.get(key);
            entry.setValue(value);
            deleteEntry(cache, key);
            addToTop(cache, entry);

            response = entry;

        }

        // Adds new value
        else{
            CacheEntry<T> entry = new CacheEntry<T>();
            entry.setKey(key);
            entry.setValue(value);
            entry.setNext(null);
            entry.setPrevious(null);

            if(cache.getCacheSize().equals(store.size())) {
                evict(cache);
            }

            addToTop(cache, entry);
            response = entry;
        }
        store.put(key, response);
        return response;

    }

    private void addToTop(Cache<T> cache, CacheEntry<T> entry){
        if(entry != null){
            entry.setNext(cache.getHead());
            entry.setPrevious(null);
            if(cache.getHead() != null){
                cache.getHead().setPrevious(entry);
            }

            cache.setHead(entry);
            if(cache.getTail() == null){
                cache.setTail(entry);
            }
        }
    }

    private void evict(Cache<T> cache){

        HashMap<String, CacheEntry<T>> store = cache.getStore();

        if(store.isEmpty())
            return;

        CacheEntry<T> tail = cache.getTail();
        if(cache.getHead()!=cache.getTail()) {
            tail.getPrevious().setNext(null);
        }
        cache.setTail(tail.getPrevious());
        store.remove(tail.getKey());

    }
}
