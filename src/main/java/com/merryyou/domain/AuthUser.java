package com.merryyou.domain;

import com.merryyou.base.AuthInfo;
import com.merryyou.db.BaseEntity;
import com.merryyou.util.Status;
import org.joda.time.DateTime;


/**
 * Created on 2015/9/22 0022.
 *
 * @author zhenglongfei
 * @since 1.0
 */
public class AuthUser extends BaseEntity<String> implements AuthInfo{
    private static final long serialVersionUID = -3755092819615590453L;

    private String username;
    private String password;//经过md5加密
    private Integer role; //1表示管理员，2表示普通用户
    private Status status;//1表示正常，0表示不正常
    private DateTime createdTime;
    private DateTime lastModifiedTime;

    /**
     * Gets last modified time.
     *
     * @return the last modified time
     */
    public DateTime getLastModifiedTime() {
        return lastModifiedTime;
    }

    /**
     * Sets last modified time.
     *
     * @param lastModifiedTime the last modified time
     */
    public void setLastModifiedTime(DateTime lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    /**
     * Gets created time.
     *
     * @return the created time
     */
    public DateTime getCreatedTime() {
        return createdTime;
    }

    /**
     * Sets created time.
     *
     * @param createdTime the created time
     */
    public void setCreatedTime(DateTime createdTime) {
        this.createdTime = createdTime;
    }

    private DateTime editTime;

    /**
     * Instantiates a new Auth user.
     */
    public AuthUser() {
    }

    /**
     * Instantiates a new Auth user.
     *
     * @param s the s
     */
    public AuthUser(String s) {
        super(s);
    }

    /**
     * Gets username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets username.
     *
     * @param username the username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets password.
     *
     * @param password the password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets role.
     *
     * @return the role
     */
    public Integer getRole() {
        return role;
    }

    /**
     * Sets role.
     *
     * @param role the role
     */
    public void setRole(Integer role) {
        this.role = role;
    }

    /**
     * Gets status.
     *
     * @return the status
     */
    public Status getStatus() {
        return status;
    }

    /**
     * Sets status.
     *
     * @param status the status
     */
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * Gets edit time.
     *
     * @return the edit time
     */
    public DateTime getEditTime() {
        return editTime;
    }

    /**
     * Sets edit time.
     *
     * @param editTime the edit time
     */
    public void setEditTime(DateTime editTime) {
        this.editTime = editTime;
    }
}
