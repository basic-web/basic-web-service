package com.github.ququzone.basicweb.users;

import com.github.ququzone.basicweb.common.DigestHelper;
import com.github.ququzone.basicweb.common.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

/**
 * user service.
 *
 * @author Yang XuePing
 */
@Service
@Transactional
public class UserService {
    @Value("${password.salt}")
    private String salt;

    @Autowired
    private UserMapper userMapper;

    public User login(String phone, String password) {
        User user = userMapper.findByPhone(phone);
        if (user == null) {
            throw new ServiceException("用户名或者密码错误", 402);
        }
        if (user.getStatus() == User.Status.DISABLE) {
            throw new ServiceException("用户名被锁定", 402);
        }
        if (!user.getPassword().equals(DigestHelper.digest("MD5", salt, password, user.getSalt()))) {
            throw new ServiceException("用户名或者密码错误", 402);
        }
        return user;
    }

    public User register(String phone, String password, String nickname) {
        if (userMapper.findByPhone(phone) != null) {
            throw new ServiceException("电话号码已经存在", 402);
        }
        User user = new User();
        Date now = new Date();
        user.setId(UUID.randomUUID().toString());
        user.setPhone(phone);
        user.setNickname(nickname);
        user.setSalt(DigestHelper.digest("SHA-1", now.toString()));
        user.setPassword(DigestHelper.digest("MD5", salt, password, user.getSalt()));
        user.setStatus(User.Status.NORMAL);
        user.setCreatedTime(now);
        userMapper.insert(user);
        return user;
    }

    public User get(String id) {
        User user = userMapper.find(id);
        if (user == null) {
            throw new ServiceException("用户不存在", 404);
        }
        return user;
    }

    public User update(String id, String phone, String originPassword, String password, String nickname, String head) {
        User user = userMapper.find(id);
        if (user == null) {
            throw new ServiceException("用户不存在", 404);
        }
        if (phone != null) {
            if (userMapper.findByPhone(phone) != null) {
                throw new ServiceException("电话号码已经存在", 402);
            }
            user.setPhone(phone);
        }
        if (password != null) {
            if (!DigestHelper.digest("MD5", salt, originPassword, user.getSalt()).equals(user.getPassword())) {
                throw new ServiceException("原密码错误", 402);
            }
            user.setPassword(DigestHelper.digest("MD5", salt, password, user.getSalt()));
        }
        if (nickname != null) {
            user.setNickname(nickname);
        }
        if (head != null) {
            user.setHead(head);
        }
        user.setUpdatedTime(new Date());
        userMapper.update(user);
        return user;
    }
}
