package com.github.ququzone.basicweb.messages;

import com.github.ququzone.basicweb.common.GsonHelper;
import com.github.ququzone.basicweb.common.KafkaProducerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * message service.
 *
 * @author Yang XuePing
 */
@Service
@Transactional
public class MessageService {
    @Autowired
    private MessageMapper mapper;

    @Autowired
    private KafkaProducerHelper kafkaProducerHelper;

    public Message add(String source, String dest, String title, String content) {
        Message message = new Message();
        message.setId(UUID.randomUUID().toString());
        message.setSource(source);
        message.setDest(dest);
        message.setTitle(title);
        message.setContent(content);
        message.setReaded(Boolean.FALSE);
        message.setCreatedTime(new Date());
        mapper.insert(message);
        kafkaProducerHelper.send("messages", message.toGson());
        return message;
    }
}
