package com.github.ququzone.basicweb.users;

import com.github.ququzone.basicweb.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * user service.
 *
 * @author Yang XuePing
 */
@Service
@Transactional
public class UserService {
    public User login(String phone, String password) {
        throw new ServiceException("用户名或者密码错误", 400);
    }
}
