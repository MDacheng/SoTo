package com.mdc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mengdacheng on 2017/1/7.
 */
@Entity(name="t_user")
public class User implements Serializable{
    private int userId;
    private String userName;
    private String password;
    private int credits;
    private String lastIp;
    private Date lastVist;

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Id
    @Column(name = "user_id", unique = true, nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name="user_name")
    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name="password")
    public String getPassword() {
        return password;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    @Column(name="credits")
    public int getCredits() {
        return credits;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    @Column(name="last_ip")
    public String getLastIp() {
        return lastIp;
    }

    public void setLastVist(Date lastVist) {
        this.lastVist = lastVist;
    }

    @Column(name="last_visit")
    public Date getLastVist() {
        return lastVist;
    }
}
