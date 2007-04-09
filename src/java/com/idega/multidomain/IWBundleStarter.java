/*
 * $Id: IWBundleStarter.java,v 1.1 2007/04/09 22:11:06 tryggvil Exp $
 * Created on 2.11.2004
 *
 * Copyright (C) 2004 Idega Software hf. All Rights Reserved.
 *
 * This software is the proprietary information of Idega hf.
 * Use is subject to license terms.
 */
package com.idega.multidomain;

import java.util.ArrayList;
import java.util.Collection;

import com.idega.core.view.DefaultViewNode;
import com.idega.core.view.ViewNode;
import com.idega.idegaweb.IWBundle;
import com.idega.idegaweb.IWBundleStartable;
import com.idega.manager.view.ManagerViewManager;


/**
 * 
 *  Last modified: $Date: 2007/04/09 22:11:06 $ by $Author: tryggvil $
 * 
 * @author <a href="mailto:tryggvil@idega.com">Tryggvi Larusson</a>
 * @version $Revision: 1.1 $
 */
public class IWBundleStarter implements IWBundleStartable {
	private static final String BUNDLE_IDENTIFIER="com.idega.multidomain";

	/**
	 * 
	 */
	public IWBundleStarter() {
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see com.idega.idegaweb.IWBundleStartable#start(com.idega.idegaweb.IWBundle)
	 */
	public void start(IWBundle starterBundle) {
		addManagerViews(starterBundle);
		//Add the stylesheet:
		//GlobalIncludeManager.getInstance().addBundleStyleSheet(BUNDLE_IDENTIFIER,STYLE_SHEET_URL);
	}

	/* (non-Javadoc)
	 * @see com.idega.idegaweb.IWBundleStartable#stop(com.idega.idegaweb.IWBundle)
	 */
	public void stop(IWBundle starterBundle) {
		// TODO Auto-generated method stub	
	}
	
	public void addManagerViews(IWBundle bundle){

		String multiDomainRole = "multidomain_admin";
		Collection<String> roles = new ArrayList<String>();
		roles.add(multiDomainRole);
		
		ManagerViewManager managerViewManager = ManagerViewManager.getInstance(bundle.getApplication());
		
		ViewNode managerNode = managerViewManager.getManagerNode();
		
		DefaultViewNode domainsNode = new DefaultViewNode("domains",managerNode);
		domainsNode.setJspUri(bundle.getJSPURI("domainManager.jsp"));
		domainsNode.setAuthorizedRoles(roles);
		domainsNode.setName("#{localizedStrings['com.idega.multidomain']['domains']}");
		

	}
}
