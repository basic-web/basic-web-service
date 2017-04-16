package com.github.ququzone.basicweb.users;

import com.github.ququzone.basicweb.GsonHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
        User user = userService.login(phone, password);
        return ResponseEntity.ok(GsonHelper.string(user));
    }
}
