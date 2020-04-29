package com.teqto.jcr.authentication;

import javax.jcr.Repository;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.SimpleCredentials;

import org.apache.jackrabbit.commons.JcrUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author jayant
 *
 */
@Component
public class AuthenticationUtil {

	public Session session;
	
	 @Value("${jcr.userId:admin}")
	 private String userId;
	 
	 @Value("${jcr.pwd:admin}")
	 private String pwd;
	 
	 @Value("${jcr.workspace:teqtosys}")
	 private String workspace;
	 
	public void login(String uid, String pwd, String workspaceName) {
		if (null == this.session) {
			try {
				Repository repository = JcrUtils.getRepository();
				setSession(repository.login(new SimpleCredentials(uid, pwd.toCharArray()), workspaceName));
			} catch (RepositoryException rException) {
				rException.printStackTrace();
			}
		}
	}

	/**
	 * @return the session
	 */
	public Session getSession() {
		if (null == this.session)
			login("admin", "admin", "teqtosys");
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public  void setSession(Session session) {
		this.session = session;
	}
	
	public void removeSession(Session session) {
		session.logout();
		this.session = null;
	}
}
