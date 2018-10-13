package com.lzb.movie.service.impl;

import com.lzb.movie.entity.User;
import com.lzb.movie.mapper.UserMapper;
import com.lzb.movie.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Bingo
 * @since 2018-10-13
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
