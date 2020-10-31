package com.queenprime.api.domain;

import java.sql.Date;

import javax.persistence.*;


@Entity
@Table(name = "videos")
public class Video implements java.io.Serializable {

private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String title;
	private String description;
	private String filePath;
	private Integer isMovie;
	private Date uploadDate;
	private Date releaseDate;
	private Integer views;
	private String duration;
	private Integer season;
	private Integer episode;
	private Integer entityId;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public Integer getIsMovie() {
		return isMovie;
	}
	public void setIsMovie(Integer isMovie) {
		this.isMovie = isMovie;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	public Integer getViews() {
		return views;
	}
	public void setViews(Integer views) {
		this.views = views;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Integer getSeason() {
		return season;
	}
	public void setSeason(Integer season) {
		this.season = season;
	}
	public Integer getEpisode() {
		return episode;
	}
	public void setEpisode(Integer episode) {
		this.episode = episode;
	}
	public Integer getEntityId() {
		return entityId;
	}
	public void setEntityId(Integer entityId) {
		this.entityId = entityId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public String toString() {
		return "Video [id=" + id + ", title=" + title + ", description=" + description + ", filePath=" + filePath
				+ ", isMovie=" + isMovie + ", uploadDate=" + uploadDate + ", releaseDate=" + releaseDate + ", views="
				+ views + ", duration=" + duration + ", season=" + season + ", episode=" + episode + ", entityId="
				+ entityId + "]";
	}
	
}
