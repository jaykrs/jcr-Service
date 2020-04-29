package com.teqto.jcr.dto.model;


/**
 * @author jayant
 *
 */
public class Article {

	
	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	private String title;

	private String teaser;

	private int articleType;

	private String moId;
	
	private int order;
	
	private int authorId;

	private int syllabusId;
	
	private String body;

	private Boolean isPublished;

	private String contentType;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTeaser() {
		return teaser;
	}

	public void setTeaser(String teaser) {
		this.teaser = teaser;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	/**
	 * @return the articleType
	 */
	public int getArticleType() {
		return articleType;
	}

	/**
	 * @param articleType the articleType to set
	 */
	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}

	/**
	 * @return the moId
	 */
	public String getMoId() {
		return moId;
	}

	/**
	 * @param moId the moId to set
	 */
	public void setMoId(String moId) {
		this.moId = moId;
	}

	public Article(String title, int articleType, int moId) {
		super();
		this.title = title;
		this.articleType = articleType;
	}

	/**
	 * @return the isPublished
	 */
	public Boolean getIsPublished() {
		return isPublished;
	}

	/**
	 * @param isPublished the isPublished to set
	 */
	public void setIsPublished(Boolean isPublished) {
		this.isPublished = isPublished;
	}

	/**
	 * @return the syllabusId
	 */
	public int getSyllabusId() {
		return syllabusId;
	}

	/**
	 * @param syllabusId the syllabusId to set
	 */
	public void setSyllabusId(int syllabusId) {
		this.syllabusId = syllabusId;
	}

	/**
	 * @return the authorId
	 */
	public int getAuthorId() {
		return authorId;
	}

	/**
	 * @param authorId the authorId to set
	 */
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}

	/**
	 * @return the order
	 */
	public int getOrder() {
		return order;
	}

	/**
	 * @param order the order to set
	 */
	public void setOrder(int order) {
		this.order = order;
	}

	/**
	 * @return the contentType
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * @param contentType the contentType to set
	 */
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	
	
}