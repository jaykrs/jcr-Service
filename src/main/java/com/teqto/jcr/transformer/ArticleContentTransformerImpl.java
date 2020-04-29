package com.teqto.jcr.transformer;

import javax.jcr.Node;
import javax.jcr.PathNotFoundException;
import javax.jcr.RepositoryException;
import javax.jcr.ValueFormatException;

import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Repository;

import com.teqto.jcr.Itransformer.IArticleContentTransfromer;
import com.teqto.jcr.constants.JCRConstants;
import com.teqto.jcr.dto.model.Article;

/**
 * @author jayant
 *
 */
@Repository
public class ArticleContentTransformerImpl implements IArticleContentTransfromer{

	
	@Override
	public Article transformContentNode(Node node) {
		Article article = new Article();
		try {
			if (node.hasProperty(JCRConstants.JCR_TITLE))
				article.setTitle(node.getProperty(JCRConstants.JCR_TITLE).getString());
			else
				article.setTitle(Strings.EMPTY);
			if (node.hasProperty(JCRConstants.JCR_TEASER))
				article.setTeaser(node.getProperty(JCRConstants.JCR_TEASER).getString());
			else
				article.setTeaser(Strings.EMPTY);
			if (node.hasProperty(JCRConstants.JCR_ARTICLE_TYPE))
				article.setArticleType(Integer.parseInt(node.getProperty(JCRConstants.JCR_ARTICLE_TYPE).getString()));
			else
				article.setArticleType(0);
			if (node.hasProperty(JCRConstants.JCR_MO_ID))
				article.setMoId(node.getProperty(JCRConstants.JCR_MO_ID).getString());
			else
				article.setMoId(Strings.EMPTY);
			if (node.hasProperty(JCRConstants.JCR_ORDER))
				article.setOrder(Integer.parseInt(node.getProperty(JCRConstants.JCR_ORDER).getString()));
			else
				article.setOrder(0);
			if (node.hasProperty(JCRConstants.JCR_AUTHOR_ID))
				article.setAuthorId(Integer.parseInt(node.getProperty(JCRConstants.JCR_AUTHOR_ID).getString()));
			else
				article.setAuthorId(0);
			if (node.hasProperty(JCRConstants.JCR_SYLLABUS_ID))
				article.setSyllabusId(Integer.parseInt(node.getProperty(JCRConstants.JCR_SYLLABUS_ID).getString()));
			else
				article.setSyllabusId(0);
			if (node.hasProperty(JCRConstants.JCR_BODY))
				article.setBody(node.getProperty(JCRConstants.JCR_BODY).getString());
			else
				article.setBody(Strings.EMPTY);
			if (node.hasProperty(JCRConstants.JCR_IS_PUBLISHED))
				article.setIsPublished(
						Boolean.parseBoolean(node.getProperty(JCRConstants.JCR_IS_PUBLISHED).getString()));
			else
				article.setIsPublished(Boolean.FALSE);
			if (node.hasProperty(JCRConstants.JCR_CONTENT_TYPE))
				article.setContentType(node.getProperty(JCRConstants.JCR_CONTENT_TYPE).getString());
			else
				article.setContentType(Strings.EMPTY);

		} catch (ValueFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PathNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return article;
	}
	@Override
	public Node transformContentArticle(Article article, Node node) {
		
		try {
			if (null != article.getTitle())
				node.setProperty(JCRConstants.JCR_TITLE, article.getTitle());
			else
				article.setTitle(Strings.EMPTY);
			if (node.hasProperty(JCRConstants.JCR_TEASER))
				article.setTeaser(node.getProperty(JCRConstants.JCR_TEASER).getString());
			else
				article.setTeaser(Strings.EMPTY);
			if (node.hasProperty(JCRConstants.JCR_ARTICLE_TYPE))
				article.setArticleType(Integer.parseInt(node.getProperty(JCRConstants.JCR_ARTICLE_TYPE).getString()));
			else
				article.setArticleType(0);
			if (node.hasProperty(JCRConstants.JCR_MO_ID))
				article.setMoId(node.getProperty(JCRConstants.JCR_MO_ID).getString());
			else
				article.setMoId(Strings.EMPTY);
			if (node.hasProperty(JCRConstants.JCR_ORDER))
				article.setOrder(Integer.parseInt(node.getProperty(JCRConstants.JCR_ORDER).getString()));
			else
				article.setOrder(0);
			if (node.hasProperty(JCRConstants.JCR_AUTHOR_ID))
				article.setAuthorId(Integer.parseInt(node.getProperty(JCRConstants.JCR_AUTHOR_ID).getString()));
			else
				article.setAuthorId(0);
			if (node.hasProperty(JCRConstants.JCR_SYLLABUS_ID))
				article.setSyllabusId(Integer.parseInt(node.getProperty(JCRConstants.JCR_SYLLABUS_ID).getString()));
			else
				article.setSyllabusId(0);
			if (node.hasProperty(JCRConstants.JCR_BODY))
				article.setBody(node.getProperty(JCRConstants.JCR_BODY).getString());
			else
				article.setBody(Strings.EMPTY);
			if (node.hasProperty(JCRConstants.JCR_IS_PUBLISHED))
				article.setIsPublished(
						Boolean.parseBoolean(node.getProperty(JCRConstants.JCR_IS_PUBLISHED).getString()));
			else
				article.setIsPublished(Boolean.FALSE);
			if (node.hasProperty(JCRConstants.JCR_CONTENT_TYPE))
				article.setContentType(node.getProperty(JCRConstants.JCR_CONTENT_TYPE).getString());
			else
				article.setContentType(Strings.EMPTY);

		} catch (ValueFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PathNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return node;
	}

}
