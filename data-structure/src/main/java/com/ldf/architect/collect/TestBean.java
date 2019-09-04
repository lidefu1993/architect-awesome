package com.ldf.architect.collect;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author lidefu
 * @date 2019/1/7 8:54
 */
public class TestBean<K,V> extends AbstractMap<K,V> {

    private int size;

    public String name;

    @Override
    public Set<Entry<K, V>> entrySet() {
        return new HashSet<>();
    }

}
