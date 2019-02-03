package com.lzb.movie.util;

/*
*
* @desc 该工具类用来判断对象或者字符串是否为空
* */
public class EmptyUtil{

   public static boolean isNotEmpty(Object o){
      boolean flag = false;

      if(o != null&&!o.equals("")){
          return true;
      }
      return flag;

   }
}
