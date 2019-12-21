package com.adu21.spring.boot.global.param.trace.cache;

/**
 * @author LukeDu
 * @date 2019/12/21
 */
public interface CacheService<K, V> {
    int EXPIRATION = 60 * 5; // 5min

    boolean exist(K key);

    V get(K key);

    void set(K key, V value);
    void set(K key, V value, int expiration);

    void delete(K key);
}
