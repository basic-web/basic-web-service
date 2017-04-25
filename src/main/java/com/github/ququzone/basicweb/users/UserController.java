package com.github.ququzone.basicweb.users;

import com.github.ququzone.basicweb.common.GsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * user controller.
 *
 * @author Yang XuePing
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/users/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestParam("phone") String phone,
                                        @RequestParam("password") String password) {
        return ResponseEntity.ok(GsonHelper.string(userService.login(phone, password)));
    }

    @RequestMapping(value = "/users/register", method = RequestMethod.POST)
    public ResponseEntity<String> register(@RequestParam("phone") String phone,
                                           @RequestParam("password") String password,
                                           @RequestParam("nickname") String nickname) {
        return ResponseEntity.ok(GsonHelper.string(userService.register(phone, password, nickname)));
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity<String> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(GsonHelper.string((userService.get(id))));
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.PATCH)
    public ResponseEntity<String> update(@PathVariable("id") String id,
                                         @RequestParam(value = "phone", required = false) String phone,
                                         @RequestParam(value = "origin_password", required = false) String originPassword,
                                         @RequestParam(value = "password", required = false) String password,
                                         @RequestParam(value = "nickname", required = false) String nickname,
                                         @RequestParam(value = "head", required = false) String head) {
        return ResponseEntity.ok(GsonHelper.string((userService.update(id, phone, originPassword, password, nickname, head))));
    }
}
