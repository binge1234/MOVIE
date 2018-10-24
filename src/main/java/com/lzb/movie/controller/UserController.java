package com.lzb.movie.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.lzb.movie.common.constant.UserConstant;
import com.lzb.movie.entity.User;
import com.lzb.movie.service.UserService;
import com.lzb.movie.util.MailUtil;
import com.lzb.movie.util.MapTool;

import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author Bingo
 * @since 2018-10-13
 */
@Controller
@RequestMapping("/user")
public class UserController {
   @Autowired
   UserService userService;
   
   @Autowired
   MailUtil mailUtil;
      
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
   public String toRegister(User user) throws IllegalAccessException, InvocationTargetException, IntrospectionException {
	   user.setClent(UserConstant.CLIENT);
	   user.setActiveFlag(UserConstant.NOACTIVE);
	   user.setLoginFlag(UserConstant.NOLOGIN);
	   userService.insert(user);
	   Map<String,Object> map = MapTool.convertBean(user);
	   mailUtil.sendTemplateMail(map);
	   return null;
	   
   }
   
   @RequestMapping("/activeUser")
   @ResponseBody
   public String activeUser(int id) {
	   User user = userService.selectById(id);
	   //如果激活时间在一分钟之内则激活成功,将用户的激活状态置为1并且更新数据库，否则删除数据
	   if(System.currentTimeMillis() - user.getCreateDate().getTime() < 6000) {
		   if(user.getActiveFlag()==UserConstant.NOACTIVE) {
		   user.setActiveFlag(UserConstant.ACTIVE);
		   userService.updateById(user);
		   return UserConstant.ACTIVE_SUCCESS;
		   }else {
			   return UserConstant.ACTIVE_FAIL;
		   }
	   }else {
		   userService.deleteById(id);
		   return UserConstant.ACTIVE_MISS;
	   }
   }
   
   
   
   
   
   
   
   
 
   
}


