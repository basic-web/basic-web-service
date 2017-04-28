package com.github.ququzone.basicweb.messages;

import com.github.ququzone.basicweb.common.GsonHelper;
import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * latest message.
 *
 * @author Yang XuePing
 */
public class LatestMessage {
    @Expose
    public Long total;

    @Expose
    public List<Message> messages;

    public String toGson() {
        return GsonHelper.string(this);
    }
}
