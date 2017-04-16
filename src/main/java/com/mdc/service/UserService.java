package com.mdc.service;

import com.mdc.dao.LoginLogDao;
import com.mdc.dao.UserDao;

import com.mdc.domain.Background;
import com.mdc.domain.LoginLog;
import com.mdc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by mengdacheng on 2017/1/12.
 */
@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private LoginLogDao loginLogDao;

    public boolean hasMatchUser(String userName, String password){
        int matchCount = userDao.getMatchCount(userName, password);
        return matchCount > 0;
    }

    public User findUserByName(String userName){
        return userDao.findUserByName(userName);
    }

    public void loginSuccess(User user){
        Calendar curCalendar = Calendar.getInstance();
        Calendar lastCalendar = Calendar.getInstance();
        lastCalendar.setTime(user.getLastVist());
        if(curCalendar.get(Calendar.YEAR) >= lastCalendar.get(Calendar.YEAR) &&
                curCalendar.get(Calendar.MONTH) >= lastCalendar.get(Calendar.MONTH) &&
                curCalendar.get(Calendar.DAY_OF_MONTH) > lastCalendar.get(Calendar.DAY_OF_MONTH))
            user.setCredits(5 + user.getCredits());

        user.setLastVist(curCalendar.getTime());
        LoginLog loginLog = new LoginLog(user.getUserId(), user.getLastIp(), user.getLastVist());
        userDao.update(user);
        loginLogDao.save(loginLog);
    }

}
