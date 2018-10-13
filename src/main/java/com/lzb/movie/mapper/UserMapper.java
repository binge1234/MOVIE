package com.lzb.movie.mapper;

import com.lzb.movie.entity.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Mankind
 * @since 2018-10-13
 */
public interface UserMapper extends BaseMapper<User> {
     
	public Integer insert(User user);
}
