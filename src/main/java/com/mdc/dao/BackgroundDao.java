package com.mdc.dao;

import com.mdc.domain.Background;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mengdacheng on 2017/4/7.
 */
@Repository
public class BackgroundDao extends BaseDao<Background> {

    public List<Background> getBackgroundByKeyword(String keyword, int group){
        String hql = "FROM com.mdc.domain.Background b WHERE b.keyword LIKE ?";
        Query query = getSession().createQuery(hql);
        query.setParameter(0, "%"+ keyword +"%");
        query.setFirstResult(group * 10);
        query.setMaxResults(10);
        List<Background> result = query.list();
        return result;
    }
}
