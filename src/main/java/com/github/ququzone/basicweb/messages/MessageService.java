package com.github.ququzone.basicweb.messages;

import com.github.ququzone.basicweb.common.KafkaProducerHelper;
import com.github.ququzone.basicweb.common.Page;
import com.github.ququzone.basicweb.common.ServiceException;
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

    public LatestMessage latestByDest(String dest, Integer size) {
        LatestMessage result = new LatestMessage();
        result.total = mapper.countUnread(dest);
        result.messages = mapper.unreadByDest(dest, size);
        return result;
    }

    public ReadedMessage read(String userID, String messageID) {
        Message message = mapper.find(messageID);
        if (message == null || !message.getDest().equals(userID)) {
            throw new ServiceException("消息不存在", 404);
        }
        mapper.updateReaded(messageID, Boolean.TRUE);
        message.setReaded(Boolean.TRUE);
        ReadedMessage result = new ReadedMessage();
        result.total = mapper.countUnread(userID);
        result.message = message;
        return result;
    }

    public Page<Message> page(String dest, int page, String q) {
        long total = mapper.countByDestAndQ(dest, q);
        Page<Message> result = new Page<>(total, Page.DEFAULT_PAGE_SIZE, page);
        if (total > 0) {
            result.setData(mapper.pageByDestAndQ(dest, q, Page.DEFAULT_PAGE_SIZE, (page - 1) * Page.DEFAULT_PAGE_SIZE));
        }
        return result;
    }
}
