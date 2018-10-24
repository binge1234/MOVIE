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

	private String postUrl;
	private String imgUrl;
	private String downpath;
	private String chinesetitle;
	private String englishtitle;
	private String time;
	private String place;
	private String category;
	private String director;
	private String star;
	private String description;


	public String getPostUrl() {
		return postUrl;
	}

	public void setPostUrl(String postUrl) {
		this.postUrl = postUrl;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
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
			"postUrl=" + postUrl +
			", imgUrl=" + imgUrl +
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
