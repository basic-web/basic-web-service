package com.github.ququzone.basicweb.messages;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Date;

/**
 * message model.
 *
 * @author Yang XuePing
 */
public class Message implements Serializable {
    @Expose
    private String id;

    @Expose
    private String source;

    @Expose
    private String dest;

    @Expose
    private String title;

    @Expose
    private String content;

    @Expose
    private Boolean readed;

    @Expose
    private Date createdTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Boolean getReaded() {
        return readed;
    }

    public void setReaded(Boolean readed) {
        this.readed = readed;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }
}
