package com.teqto.jcr.nodeUtil;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;

/**
 * @author jayant
 *
 */
public class NodeUtils {

	public static Node createNode(Session session, String path, String nodeName) {
		Node node = null;
		try {
			Node _node = session.getNode(path);
			if (!_node.hasNode(nodeName))
				node = _node.addNode(nodeName);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return node;
	}
	
	public static boolean createPropeties(Node node, String property, String value) {
		try {
			if (!node.hasProperty(property)) {
				node.setProperty(property, value);
				return true;
			}
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public static Node getNode(Session session, String path) {
		Node node = null;
		try {
			node = session.getNode(path);
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
		return node;
	}
	
	public static void removeNode(Session session, String path) {
		Node node = null;
		try {
			node = session.getNode(path);
			node.remove();
		} catch (RepositoryException e) {
			e.printStackTrace();
		}
	}
}
