package com.lzb.movie.mybatisplus;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

/**
 * Created by Mankind on 2018/2/3.
 */
@Component
public class MyMetaObjectHandler extends MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        metaObject.setValue("create_date",new Timestamp(System.currentTimeMillis()));
        metaObject.setValue("update_date",new Timestamp(System.currentTimeMillis()));
    }
    @Override
    public void updateFill(MetaObject metaObject) {
        metaObject.setValue("update_date",new Timestamp(System.currentTimeMillis()));
    }
    
    
    
        
}
