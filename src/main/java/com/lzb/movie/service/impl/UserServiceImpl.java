package com.lzb.movie.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lzb.movie.common.constant.UserConstant;
import com.lzb.movie.common.enums.BussinessEnum;
import com.lzb.movie.common.result.ReturnResult;
import com.lzb.movie.entity.User;
import com.lzb.movie.mapper.UserMapper;
import com.lzb.movie.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.lzb.movie.util.EmptyUtil;
import com.lzb.movie.util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
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

    @Autowired
    private RedisTemplate redisTemplate;


    /*
    * @param userName
    * @param password
    * @desc  判断用户登陆的用户名和密码是否正确并且生成token保存。
    * */
    @Override
    public ReturnResult validateToken(String userName, String password) throws Exception{
        boolean flag = UserConstant.NOLOGIN;
        User user = null;

            user = super.selectOne(new EntityWrapper<User>().eq("username",userName)
                    .eq("password",password));//根据用户名和密码查询是否有该用户.
            if(user!=null) {//如果用户存在,则生成token
                String oldToken = (String)redisTemplate.opsForValue().get(user.getId());
                if(EmptyUtil.isNotEmpty(oldToken)){//如果token登陆前存在，则先删除旧的token
                    redisTemplate.delete(oldToken);
                    redisTemplate.delete(user.getId());
                }

                flag = UserConstant.LOGIN;
                String token = UserConstant.userPrefix+TokenUtil.createToken(user);
                redisTemplate.opsForValue().set(token, JSONObject.toJSONString(user),UserConstant.loginExpire);
                redisTemplate.opsForValue().set(UserConstant.userPrefix+user.getId(), token,UserConstant.loginExpire);
                return new ReturnResult(200,"登陆成功",token);
            }else{
                return new ReturnResult(403,"用户名或密码错误");
            }


    }

    /*
     *
     * @param user
     * @desc  用户激活账号操作。
     * */
     public String userActive(int id){
         User user = super.selectById(id);
         //如果激活时间在一分钟之内则激活成功,将用户的激活状态置为1并且更新数据库，否则删除数据
         if(System.currentTimeMillis() - user.getCreateDate().getTime() < 6000) {
             if(user.getActiveFlag()==UserConstant.NOACTIVE) {
                 user.setActiveFlag(UserConstant.ACTIVE);
                 super.updateById(user);
                 return UserConstant.ACTIVE_SUCCESS;
             }else {
                 return UserConstant.ACTIVE_FAIL;
             }
         }else {
             super.deleteById(id);
             return UserConstant.ACTIVE_MISS;
         }

     }

    @Override
    public ReturnResult removeToken(String token) throws Exception {
         ReturnResult returnResult = null;
        String tokenJson = (String)redisTemplate.opsForValue().get(token);
        if(EmptyUtil.isNotEmpty(tokenJson)){//判断token是否有效，token有效师删除对应的token和key
            User user = JSONObject.parseObject(tokenJson,User.class);
            redisTemplate.delete(token);
            redisTemplate.delete(user.getId());
            returnResult = new ReturnResult(BussinessEnum.EXIT_SUCCESS.getCode(),BussinessEnum.EXIT_SUCCESS.getMessage());
        }else{
            returnResult = new ReturnResult(BussinessEnum.EXIT_FAIL.getCode(),BussinessEnum.EXIT_FAIL.getMessage());
        }
        return returnResult;
    }

}
