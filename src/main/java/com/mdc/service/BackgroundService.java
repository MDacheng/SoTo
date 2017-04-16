package com.mdc.service;

import com.mdc.dao.BackgroundDao;
import com.mdc.dao.UserDao;
import com.mdc.domain.Background;
import com.mdc.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;


import java.util.List;

/**
 * Created by mengdacheng on 2017/4/8.
 */
@Service
public class BackgroundService {

    @Autowired
    private BackgroundDao backgroundDao;

    @Autowired
    private UserDao userDao;
    
    public List<Background> getBackground(){
        return backgroundDao.getBackgroundByKeyword("", 0);
    }

    public List<Background> getBackgroundByKeyword(String keyword, int group){
        return backgroundDao.getBackgroundByKeyword(keyword, group);
    }
    public void download(User user){
        user.setCredits(user.getCredits() - 5);
        userDao.update(user);
    }
}
