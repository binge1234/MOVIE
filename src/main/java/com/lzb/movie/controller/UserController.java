package com.lzb.movie.controller;

import com.lzb.movie.common.base.BaseController;
import com.lzb.movie.common.enums.CommonEnum;
import com.lzb.movie.common.result.ReturnResult;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.lzb.movie.common.constant.UserConstant;
import com.lzb.movie.entity.User;
import com.lzb.movie.service.UserService;
import com.lzb.movie.util.MapTool;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.lzb.movie.util.TokenUtil;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bingo
 * @since 2018-10-13
 * @desc 发送邮件采用消息中间件进行优化
 */
@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

   @Autowired
   UserService userService;

   @Autowired
   RabbitTemplate rabbitTemplate;

   @Autowired
    RedisTemplate redisTemplate;
   
//   @Autowired
//   MailUtil mailUtil;
   @RequestMapping("/checkExistUser")
   @ResponseBody
   public Map<String,Object>  checkExistUser(String username){
	   Map<String,Object> result = new HashMap<>();
	   
	  boolean isVaild = userService.selectCount(new EntityWrapper<User>()
			  .eq("username", username).eq("active_flag",true))==0;
           
	  result.put("valid",isVaild);
	  return result;
   }
   
   @RequestMapping("/checkExistEmail")
   @ResponseBody
   public Map<String,Object> checkExistEmail(String email){
	   Map<String,Object> result = new HashMap<>();

	   boolean isVaild = userService.selectCount(new EntityWrapper<User>()
			   .eq("email",email).eq("active_flag",true)) == 0;
	   result.put("valid",isVaild);
	   return result;
   }
   
   @RequestMapping(value="/toRegister", method = RequestMethod.POST)
   public void toRegister(User user) throws IllegalAccessException, InvocationTargetException, IntrospectionException {
	   user.setClent(UserConstant.CLIENT);
	   user.setActiveFlag(UserConstant.NOACTIVE);
	   user.setLoginFlag(UserConstant.NOLOGIN);
	   userService.insert(user);
	   Map<String,Object> map = MapTool.convertBean(user);

	   //mailUtil.sendTemplateMail(map);
       rabbitTemplate.convertAndSend(map);
	   //return null;
	   
   }
   
   @RequestMapping("/activeUser")
   @ResponseBody
   public String activeUser(int id) {
       try{
           return userService.userActive(id);
       }catch(Exception e){
           return UserConstant.ACTIVE_FAIL;
       }

   }

   @RequestMapping("/doLogin")
   @ResponseBody
   public ReturnResult doLogin(String userName, String password){
       try{
           return userService.validateToken(userName,password);
       }catch (Exception e){
          e.printStackTrace();
          return new ReturnResult(CommonEnum.SYSTEM_EXCEPTION.getCode(),CommonEnum.SYSTEM_EXCEPTION.getMessage());
       }


   }

   @RequestMapping("/doLogout")
    public ReturnResult doLogout(String token) throws Exception{
          return userService.removeToken(token);

   }

   
   
   
   
   
   
   
 
   
}


