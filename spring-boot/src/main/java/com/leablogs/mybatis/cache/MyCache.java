package com.leablogs.mybatis.cache;

import org.apache.ibatis.cache.Cache;

public class MyCache implements Cache {
    /**
     * 获取缓存id，通常为mapper命名空间名称
     * @return
     */
    @Override
    public String getId() {
        return null;
    }

    /**
     * 将一个java对象添加到缓存，
     * @param o 缓存的key
     * @param o1 需要缓存对象
     */
    @Override
    public void putObject(Object o, Object o1) {

    }

    /**
     * 获取缓存key对应的缓存对象
     * @param o
     * @return
     */
    @Override
    public Object getObject(Object o) {
        return null;
    }

    /**
     * 将一个对象琮缓存中移除
     * @param o
     * @return
     */
    @Override
    public Object removeObject(Object o) {
        return null;
    }

    /**
     * 清空缓存
     */
    @Override
    public void clear() {

    }

    /**
     * 获取缓存大小
     * @return
     */
    @Override
    public int getSize() {
        return 0;
    }
}
