package com.lzb.movie.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.activerecord.Model;
import com.lzb.movie.common.base.BaseModel;

/**
 * <p>
 * 
 * </p>
 *
 * @author Bingo
 * @since 2018-10-24
 */
public class Movie extends BaseModel<Movie> {

    private static final long serialVersionUID = 1L;

	private String posturl;//电影url
	private String imgurl;//图片地址
	private String downpath;//电影下载地址
	private String chinesetitle;//中文译名
	private String englishtitle;//英文名
	private String time;//年代
	private String place;//产地
	private String category;//类别
	private String director;//导演
	private String star;//明星
	private String description;//电影简介


	public String getPosturl() {
		return posturl;
	}

	public void setPosturl(String postUrl) {
		this.posturl = postUrl;
	}

	public String getImgurl() {
		return imgurl;
	}

	public void setImgurl(String imgUrl) {
		this.imgurl = imgUrl;
	}

	public String getDownpath() {
		return downpath;
	}

	public void setDownpath(String downpath) {
		this.downpath = downpath;
	}

	public String getChinesetitle() {
		return chinesetitle;
	}

	public void setChinesetitle(String chinesetitle) {
		this.chinesetitle = chinesetitle;
	}

	public String getEnglishtitle() {
		return englishtitle;
	}

	public void setEnglishtitle(String englishtitle) {
		this.englishtitle = englishtitle;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getStar() {
		return star;
	}

	public void setStar(String star) {
		this.star = star;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

	@Override
	public String toString() {
		return "Movie{" +
			"postUrl=" + posturl +
			", imgUrl=" + imgurl +
			", downpath=" + downpath +
			", chinesetitle=" + chinesetitle +
			", englishtitle=" + englishtitle +
			", time=" + time +
			", place=" + place +
			", category=" + category +
			", director=" + director +
			", star=" + star +
			", description=" + description +
			"}";
	}
}
