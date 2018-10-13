package com.lzb.movie.common.base;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.FieldStrategy;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by Mankind on 2018/1/30.
 */
public abstract class BaseModel<T extends Model> extends Model<T> implements Serializable {

    @TableId(type= IdType.AUTO)
    protected Long id;

    /**
     * 创建时间
     */
    @TableField(value = "create_date",fill = FieldFill.INSERT,strategy= FieldStrategy.IGNORED)
    protected Timestamp createDate;
    /**
     * 更新时间
     */
    @TableField(value = "update_date",fill = FieldFill.INSERT_UPDATE,strategy= FieldStrategy.IGNORED)
    protected Timestamp updateDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    public Timestamp getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    public static final String ID = "id";

    public static final String VERSION = "version";

    public static final String CREATETIME = "createDate";

    public static final String UPDATETIME = "updateDate";

    public static final String DELETETIME = "deleteDate";

    public static final String VALID = "valid";
}
