package com.teqto.jcr.service;

import java.util.List;

import com.teqto.jcr.dto.model.Article;

/**
 * @author jayant
 *
 */
public interface IContentArticleService {

	List<Article> listAllContentArticleByPath(String courseId, String syllabusId);
	boolean addContentArticleByPath(String courseId, String syllabusId, Article article);
}
