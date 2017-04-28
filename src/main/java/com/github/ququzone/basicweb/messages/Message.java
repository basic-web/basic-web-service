package com.github.ququzone.basicweb.messages;

import com.github.ququzone.basicweb.common.AbstractModel;
import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.Date;

/**
 * message model.
 *
 * @author Yang XuePing
 */
public class Message extends AbstractModel implements Serializable {
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
}
