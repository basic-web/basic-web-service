package com.github.ququzone.basicweb.common;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * abstract model.
 *
 * @author Yang XuePing
 */
public class AbstractModel {
    @Expose
    private String id;

    @Expose
    private Date createdTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String toGson() {
        return GsonHelper.string(this);
    }
}
