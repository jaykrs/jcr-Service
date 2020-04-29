package com.teqto.jcr.Itransformer;

import javax.jcr.Node;

import com.teqto.jcr.dto.model.Article;

/**
 * @author jayant
 *
 */
public interface IArticleContentTransfromer {

	public Article transformContentNode(Node node);
	public Node transformContentArticle(Article article, Node node);
	
}
