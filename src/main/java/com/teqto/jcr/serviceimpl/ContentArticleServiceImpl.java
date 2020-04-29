package com.teqto.jcr.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.jcr.Node;
import javax.jcr.NodeIterator;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.nodetype.NodeType;
import javax.jcr.nodetype.NodeTypeIterator;
import javax.jcr.nodetype.NodeTypeManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.teqto.jcr.Itransformer.IArticleContentTransfromer;
import com.teqto.jcr.authentication.AuthenticationUtil;
import com.teqto.jcr.constants.JCRConstants;
import com.teqto.jcr.dto.model.Article;
import com.teqto.jcr.service.IContentArticleService;

/**
 * @author jayant
 *
 */
@Repository
public class ContentArticleServiceImpl implements IContentArticleService{

	
	
	@Autowired
	IArticleContentTransfromer articleContentTransformer;
	@Override
	public List<Article> listAllContentArticleByPath(String courseId, String syllabusId) {
		Session session = new AuthenticationUtil().getSession();
		List<Article> listContentArticle = new ArrayList<Article>();
		String nodePath = "/"+courseId+"/"+syllabusId;
		try {
			Node node = session.getNode(nodePath);
			NodeIterator nodeIterator = node.getNodes();
			while(nodeIterator.hasNext()) {
				Node _node = nodeIterator.nextNode();
				Article article = articleContentTransformer.transformContentNode(_node);
				listContentArticle.add(article);
			}
		} catch (RepositoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listContentArticle;
	}

	@SuppressWarnings("deprecation")
	@Override
	public boolean addContentArticleByPath(String courseId, String syllabusId, Article article) {
		Session session = new AuthenticationUtil().getSession();
		try {
		if(!session.getRootNode().hasNode(courseId))
			session.getRootNode().addNode(courseId, "nt:folder");
		session.save();
		if(!session.getRootNode().getNode(courseId).hasNode(syllabusId))
			session.getRootNode().getNode(courseId).addNode(syllabusId,"nt:folder");
		session.save();
		Node _node = session.getNode("/"+courseId+"/"+syllabusId);
		NodeTypeManager manager = session.getWorkspace().getNodeTypeManager();
		NodeTypeIterator nodeTypeIterator = manager.getAllNodeTypes();
		while(nodeTypeIterator.hasNext()) {
			NodeType nodeType = nodeTypeIterator.nextNodeType();
			System.out.println(nodeType.getName());
		}
		if(!session.getRootNode().hasNode(courseId+"-"+syllabusId+"-"+article.getTitle())) {
		Node articleNode = session.getRootNode().addNode(courseId+"-"+syllabusId+"-"+article.getTitle(), "teqto:article");
		session.save();
		articleNode.setProperty("teqto:"+JCRConstants.JCR_TITLE, article.getTitle());
		articleNode.setProperty("teqto:"+JCRConstants.JCR_TEASER, article.getTeaser());
		articleNode.setProperty("teqto:"+JCRConstants.JCR_ARTICLE_TYPE, Integer.toString(article.getArticleType()));
		articleNode.setProperty("teqto:"+JCRConstants.JCR_MO_ID, articleNode.getUUID());
		articleNode.setProperty("teqto:"+JCRConstants.JCR_ORDER, Integer.toString(article.getOrder()));
		articleNode.setProperty("teqto:"+JCRConstants.JCR_AUTHOR_ID, Integer.toString(article.getAuthorId()));
		articleNode.setProperty("teqto:"+JCRConstants.JCR_SYLLABUS_ID, Integer.toString(article.getSyllabusId()));
		articleNode.setProperty("teqto:"+JCRConstants.JCR_BODY, article.getTitle());
		articleNode.setProperty("teqto:"+JCRConstants.JCR_CONTENT_TYPE, article.getContentType());
		articleNode.setProperty("teqto:"+JCRConstants.JCR_IS_PUBLISHED, ""+Boolean.FALSE);
		session.save();
		}
		} catch(RepositoryException rexp) {}
		return false;
	}

}
