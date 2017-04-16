package com.mdc.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by mengdacheng on 2017/1/7.
 */
@Entity(name="t_login_log")
public class LoginLog implements Serializable {
    private int loginLogId;
    private int userId;
    private String ip;
    private Date loginDate;

    public LoginLog(int userId, String ip, Date loginDate) {
        this.userId = userId;
        this.ip = ip;
        this.loginDate = loginDate;
    }

    public void setLoginLogId(int loginLogId) {
        this.loginLogId = loginLogId;
    }

    @Id
    @Column(name="log_id", unique = true, nullable = false)
    public int getLoginLogId() {
        return loginLogId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Column(name = "user_id")
    public int getUserId() {
        return userId;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    @Column(name = "ip")
    public String getIp() {
        return ip;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    @Column(name = "login_datetime")
    public Date getLoginDate() {
        return loginDate;
    }
}
