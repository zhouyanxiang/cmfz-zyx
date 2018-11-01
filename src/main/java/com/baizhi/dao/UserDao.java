package com.baizhi.dao;

import com.baizhi.entity.User;
import com.baizhi.entity.UserDTO;

import java.util.List;

/**
 * Created by admin on 2018/10/28.
 */
public interface UserDao {

    public List<User> selectAllUser();

    public int selectUserByTime(int day);

    public void insert(User user);

    public List<String> selectColumns();

    public List<UserDTO> selectAllUserDTO();

    public User selectOne(int id);




}
