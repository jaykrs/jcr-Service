package com.teqto.jcr.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teqto.jcr.constants.JCRConstants;
import com.teqto.jcr.dto.model.Article;
import com.teqto.jcr.service.IContentArticleService;

/**
 * @author jayant
 *
 */
@RestController
@RequestMapping("/jcr/content")
public class JcrContentController {
	
	@Autowired
	IContentArticleService contentArticleService;

	@GetMapping("getallcontentarticle/{courseId}/{syllabusId}")
	public ResponseEntity<List<Article>> findAllContentArticle(@PathVariable("courseId") String courseId, @PathVariable("syllabusId") String syllabusId) {
		List<Article> listArticle = contentArticleService.listAllContentArticleByPath(courseId, syllabusId);
		return new ResponseEntity<List<Article>>(listArticle, HttpStatus.OK);
	}
	
	@PostMapping("addcontentarticle/{courseId}/{syllabusId}")
	public ResponseEntity<Map<String, String>> addContentArticle(@PathVariable("courseId") String courseId, @PathVariable("syllabusId") String syllabusId, @Valid @RequestBody Map<String, String> json) {
		Map<String, String> response = new HashMap<String, String>();
		Article article = new Article();
		
		if (Strings.isNotEmpty(json.get(JCRConstants.JCR_TITLE)))
			article.setTitle(json.get(JCRConstants.JCR_TITLE));
		else
			article.setTitle(Strings.EMPTY);
		
		if (Strings.isNotEmpty(json.get(JCRConstants.JCR_TEASER)))
			article.setTeaser(json.get(JCRConstants.JCR_TEASER));
		else
			article.setTeaser(Strings.EMPTY);
		
		if (Strings.isNotEmpty(json.get(JCRConstants.JCR_ARTICLE_TYPE)))
			article.setArticleType(Integer.parseInt(json.get(JCRConstants.JCR_ARTICLE_TYPE)));
		else
			article.setArticleType(0);
		
		if (Strings.isNotEmpty(json.get(JCRConstants.JCR_ORDER)))
			article.setOrder(Integer.parseInt(json.get(JCRConstants.JCR_ORDER)));
		else
			article.setOrder(0);
		
		if (Strings.isNotEmpty(json.get(JCRConstants.JCR_AUTHOR_ID)))
			article.setAuthorId(Integer.parseInt(json.get(JCRConstants.JCR_AUTHOR_ID)));
		else
			article.setAuthorId(0);
		
		if (Strings.isNotEmpty(json.get(JCRConstants.JCR_SYLLABUS_ID)))
			article.setSyllabusId(Integer.parseInt(json.get(JCRConstants.JCR_SYLLABUS_ID)));
		else
			article.setSyllabusId(0);
		
		if (Strings.isNotEmpty(json.get(JCRConstants.JCR_BODY)))
			article.setBody(json.get(JCRConstants.JCR_BODY));
		else
			article.setBody(Strings.EMPTY);
		
		if (Strings.isNotEmpty(json.get(JCRConstants.JCR_CONTENT_TYPE)))
			article.setContentType(json.get(JCRConstants.JCR_CONTENT_TYPE));
		else
			article.setContentType(Strings.EMPTY);
		
		if (Strings.isNotEmpty(json.get(JCRConstants.JCR_IS_PUBLISHED)))
			article.setIsPublished(Boolean.parseBoolean(json.get(JCRConstants.JCR_IS_PUBLISHED)));
		else
			article.setIsPublished(Boolean.FALSE);
		
		boolean result = contentArticleService.addContentArticleByPath(courseId, syllabusId,article);
		response.put("result", Boolean.toString(result));
		return ResponseEntity.ok().body(response);
	}
}
