package com.lzb.movie.entity;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.lzb.movie.common.base.BaseModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author 
 * @since 2018-10-13
 */
public class User extends BaseModel<User> {

    private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String email;
	@TableField("login_flag")
	private Integer loginFlag;
	@TableField("active_flag")
	private Integer activeFlag;
	private Date createdate;
	private Date updatedate;


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(Integer loginFlag) {
		this.loginFlag = loginFlag;
	}

	public Integer getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Integer activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "User{" +
			"username=" + username +
			", password=" + password +
			", email=" + email +
			", loginFlag=" + loginFlag +
			", activeFlag=" + activeFlag +
			", createdate=" + createdate +
			", updatedate=" + updatedate +
			"}";
	}
}
