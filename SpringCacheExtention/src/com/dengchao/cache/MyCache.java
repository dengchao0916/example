package com.dengchao.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Callable;

import org.springframework.cache.Cache;
import org.springframework.cache.support.SimpleValueWrapper;

import com.dengchao.entity.Account;

public class MyCache implements Cache {
    private String name;
    private Map<String, Account> store = new HashMap<String, Account>();;

    public MyCache() {
    }

    public MyCache(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public Object getNativeCache() {
        return store;
    }

    // 从缓存查询返回的对象都将其 password 字段设置为一个特殊的值
    @Override
    public ValueWrapper get(Object key) {
        ValueWrapper result = null;
        Account thevalue = store.get(key);
        if (thevalue != null) {
            System.out.println("key : " + key);
            System.out.println("cache name : " + this.getName());
            System.out.println("the cache : " + this.getNativeCache());
            thevalue.setPassword("from mycache:" + name);
            result = new SimpleValueWrapper(thevalue);
        }
        return result;
    }

    @Override
    public void put(Object key, Object value) {
        System.out.println("put---->" + "key:" + key + " ,value:" + value);
        Account thevalue = (Account) value;
        store.put((String) key, thevalue);
    }

    @Override
    public void evict(Object key) {
    }

    @Override
    public void clear() {
    }

    @Override
    public <T> T get(Object arg0, Class<T> arg1) {
        return null;
    }

    @Override
    public <T> T get(Object arg0, Callable<T> arg1) {
        return null;
    }

    @Override
    public ValueWrapper putIfAbsent(Object arg0, Object arg1) {
        return null;
    }
}
