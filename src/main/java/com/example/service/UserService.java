package com.example.service;

import com.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.jws.soap.SOAPBinding;
import java.util.Optional;

public interface UserService {
    /*
    新增、编辑、保存用户
    @param user
    @return
     */
    User saveOrUpdateUser(User user);

    /*
    注册用户
    @param user
    @return
     */
    User registerUser (User user);

    /*
    删除用户
    @param id
     */
    void removeUser(Long id);

    /*
    根据id获取用户
    @param id
    @return
     */
    Optional<User> getUserById(Long id);

    /*
    根据用户名分页模糊查询
    @param name
    @param pageable
    @return
     */
    Page<User> listUsersByNameLike(String userName, Pageable pageable);

}
