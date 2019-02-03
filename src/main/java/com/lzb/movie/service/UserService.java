package com.lzb.movie.service;

import com.lzb.movie.common.result.ReturnResult;
import com.lzb.movie.entity.User;
import com.baomidou.mybatisplus.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bingo
 * @since 2018-10-13
 */
public interface UserService extends IService<User> {

    public ReturnResult validateToken(String userName, String password) throws Exception;

    public String userActive(int id);

    public ReturnResult removeToken(String token) throws Exception;

}
