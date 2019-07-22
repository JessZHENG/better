package com.example.repository;

import com.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    //根据用户名分页查询用户列表
    Page<User> findByNameLike(String userName, Pageable pageable);
    //根据用户邮箱查找用户
    User findByEmail(String email);
}
