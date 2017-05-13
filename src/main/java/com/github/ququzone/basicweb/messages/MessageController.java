package com.github.ququzone.basicweb.messages;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * message controller.
 *
 * @author Yang XuePing
 */
@Controller
public class MessageController {
    @Autowired
    private MessageService service;

    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public ResponseEntity<String> add(@RequestParam(value = "source", required = false) String source,
                                      @RequestParam("dest") String dest,
                                      @RequestParam("title") String title, @RequestParam("content") String content) {
        return ResponseEntity.ok(service.add(source, dest, title, content).toGson());
    }

    @RequestMapping(value = "/messages/latest", method = RequestMethod.GET)
    public ResponseEntity<String> latest(@RequestParam("userID") String userID,
                                         @RequestParam(value = "size", defaultValue = "6", required = false) Integer size) {
        return ResponseEntity.ok(service.latestByDest(userID, size).toGson());
    }

    @RequestMapping(value = "/message/{messageID}/user/{userID}/read", method = RequestMethod.PUT)
    public ResponseEntity<String> read(@PathVariable("userID") String userID, @PathVariable("messageID") String messageID) {
        return ResponseEntity.ok(service.read(userID, messageID).toGson());
    }

    @RequestMapping(value = "/messages/user/{userID}", method = RequestMethod.GET)
    public ResponseEntity<String> page(@PathVariable("userID") String userID,
                                       @RequestParam(value = "page", defaultValue = "1") int page,
                                       @RequestParam(value = "q", required = false) String q) {
        return ResponseEntity.ok(service.page(userID, page, q).toGson());
    }
}
