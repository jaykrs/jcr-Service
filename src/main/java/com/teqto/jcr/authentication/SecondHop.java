package com.teqto.jcr.authentication;

import javax.jcr.Repository; 
import javax.jcr.Session; 
import javax.jcr.SimpleCredentials;
import javax.jcr.Workspace;
import javax.jcr.Node; 
import org.apache.jackrabbit.commons.JcrUtils;

/** 
* Second hop example. Stores, retrieves, and removes example content. 
*/ 
public class SecondHop { 

    /** 
    * The main entry point of the example application. 
    * 
    * @param args command line arguments (ignored) 
    * @throws Exception if an error occurs 
    */ 

	public  void mainRun(String[] args) throws Exception { 
    Repository repository = JcrUtils.getRepository();
  //      Session session = repository.login( 
   //     new SimpleCredentials("admin", "admin".toCharArray()));
   Session session =    repository.login(new SimpleCredentials("admin", "admin".toCharArray()), "teqtosys");
        try { 
     //   	Workspace wsn = session.getWorkspace();
     //   			((org.apache.jackrabbit.core.WorkspaceImpl)wsn).createWorkspace("teqtosys");
        
        			Node root = session.getRootNode(); 

            // Store content 
            Node hello = root.addNode("hello"); 
            Node world = hello.addNode("world", "teqto:article"); 
            world.setProperty("teqto:title", "Hellotitle"); 
            world.setProperty("teqto:body", "Hellotitle"); 
            session.save(); 

            // Retrieve content 
            Node node = root.getNode("hello/world"); 
            System.out.println(node.getPath()); 
            System.out.println(node.getProperty("message").getString()); 

            // Remove content 
            root.getNode("hello").remove(); 
            session.save(); 
        } finally { 
            session.logout(); 
        } 
    } 

} 