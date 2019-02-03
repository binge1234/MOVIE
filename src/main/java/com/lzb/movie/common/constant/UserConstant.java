package com.lzb.movie.common.constant;

public class UserConstant {
     public static final boolean LOGIN = true;
     public static final boolean NOLOGIN = false;
     public static final boolean ACTIVE = true;
     public static final boolean NOACTIVE = false;
     public static final boolean CLIENT = true;
     public static final boolean NOCLIENT = false;
     public static final String ACTIVE_SUCCESS = "激活成功";
     public static final String ACTIVE_MISS = "激活链接已失效";
     public static final String ACTIVE_FAIL = "激活失败";
     public static final Long loginExpire =30L;//登陆超时时间
     public static final String tokenPrefix ="token";//存放在redis的token前缀
     public static final String userPrefix = "user";//存放在redis的userid前缀


}
