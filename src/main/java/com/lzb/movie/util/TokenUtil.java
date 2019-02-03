package com.lzb.movie.util;

import com.lzb.movie.entity.User;
import org.apache.commons.lang.time.DateFormatUtils;

import java.util.Date;

public class TokenUtil {

    public static String createToken(User user){
        String token = null;
        try{
            String timestemp = DateFormatUtils.format(new Date(),"yyyy-mm-dd");
            String source = user.getId()+user.getUsername()+timestemp;
            token= MD5Util.encrypt(source);
        }catch (Exception e){
            e.printStackTrace();;
        }
        return token;
    }
}
