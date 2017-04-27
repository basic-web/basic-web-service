package com.github.ququzone.basicweb.messages;

import com.github.ququzone.basicweb.common.GsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
        return ResponseEntity.ok(GsonHelper.string(service.add(source, dest, title, content)));
    }
}
