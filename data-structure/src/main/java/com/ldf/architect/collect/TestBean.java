package com.ldf.architect.collect;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;
import java.util.Map;
/**
 * @author lidefu
 * @date 2019/1/7 8:54
 */
public class TestBean<K, V> implements Map<K, V>, Cloneable, Serializable {

    transient String[] table;

    /**
     * Holds cached entrySet(). Note that AbstractMap fields are used
     * for keySet() and values().
     */
    transient Set<String> entrySet;

    /**
     * The number of key-value mappings contained in this map.
     */
    transient int size;

    public String[] getTable() {
        return table;
    }


    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V put(K key, V value) {
        return null;
    }

    @Override
    public V remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        return null;
    }
}
