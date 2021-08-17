package service;

import entities.Cache;
import entities.CacheEntry;

public interface CacheService<T> {

    public CacheEntry<T> getEntry(Cache<T> cache, String key);
    public CacheEntry<T> putEntry(Cache<T> cache, String key, T value);
    public CacheEntry<T> deleteEntry(Cache<T> cache, String key);
}
