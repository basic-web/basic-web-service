package com.github.ququzone.basicweb.messages;

import com.github.ququzone.basicweb.common.GsonHelper;
import com.google.gson.annotations.Expose;

/**
 * readed message.
 *
 * @author Yang XuePing
 */
public class ReadedMessage {
    @Expose
    public Long total;

    @Expose
    public Message message;

    public String toGson() {
        return GsonHelper.string(this);
    }
}
