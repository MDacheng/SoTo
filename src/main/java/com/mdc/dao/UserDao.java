package com.mdc.dao;

import com.mdc.domain.User;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by mengdacheng on 2017/1/7.
 */
@Repository                     //通过Spring注解定义一个Dao
public class UserDao extends BaseDao<User> {

    public int getMatchCount(String userName, String password){
        String hql = "FROM com.mdc.domain.User u WHERE u.userName = ? AND u.password = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, userName);
        query.setParameter(1, password);
        return query.list().size();
    }

    public User findUserByName(final String userName){
        String hql = "FROM com.mdc.domain.User u WHERE u.userName = ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, userName);
        List<User> result = query.list();
        return result.size() > 0 ? result.get(0) : null;
    }
}
