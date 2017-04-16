package com.mdc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by mengdacheng on 2017/4/12.
 */
public class BaseDao<T> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class entityClass;              //dao的泛型类，也就是T的类型

    public BaseDao(){
        Type genType = this.getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType)genType).getActualTypeArguments();
        entityClass = (Class)params[0];
    }

    public T get(Serializable id){
        return (T)sessionFactory.getCurrentSession().get(entityClass, id);
    }

    public void save(T entity){
        sessionFactory.getCurrentSession().save(entity);
    }

    public void update(T entity){
        sessionFactory.getCurrentSession().update(entity);
    }

    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }
}
