package com.lzb.movie.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class PrintUtil {

    static Logger logger = Logger.getLogger(PrintUtil.class);

//    public HttpServletResponse response;
//
//    public PrintUtil(HttpServletResponse response,String contentType){
//        this.response = response;
//        this.response.setContentType(contentType);
//    }
//
//    public PrintUtil(HttpServletResponse response){
//        this.response = response;
//    }

    public static void print(Object msg,HttpServletResponse response){
        PrintWriter writer = null;

        try{
            if(null!=response){
                //如果系统打开了outputStream 那么将其关闭
                writer = new PrintWriter(response.getOutputStream());
                String temp = new String(String.valueOf(msg));
                writer.write(temp);
                writer.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            writer.close();
        }

    }
}
