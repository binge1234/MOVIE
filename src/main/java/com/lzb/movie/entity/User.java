package com.lzb.movie.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.lzb.movie.common.base.BaseModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bingo
 * @since 2018-10-13
 */
public class User extends BaseModel<User> {

    private static final long serialVersionUID = 1L;

	private String username;
	private String password;
	private String email;
    /**
     * 0代表未登录，1代表已登录
     */
	@TableField("login_flag")
	private Boolean loginFlag;
    /**
     * 0代表未激活，1代表已激活
     */
	@TableField("active_flag")
	private Boolean activeFlag;
    /**
     * 0代表是客户，1代表是admin
     */
	@TableField("isClent")
	private Boolean clent;


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

	public Boolean getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(Boolean loginFlag) {
		this.loginFlag = loginFlag;
	}

	public Boolean getActiveFlag() {
		return activeFlag;
	}

	public void setActiveFlag(Boolean activeFlag) {
		this.activeFlag = activeFlag;
	}

	public Boolean getClent() {
		return clent;
	}

	public void setClent(Boolean clent) {
		this.clent = clent;
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
			", clent=" + clent +
			"}";
	}
}
