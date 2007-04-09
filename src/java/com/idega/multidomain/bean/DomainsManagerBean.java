package com.idega.multidomain.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.ejb.CreateException;

import com.idega.core.builder.data.ICDomain;
import com.idega.core.builder.data.ICDomainHome;
import com.idega.data.IDOLookup;
import com.idega.data.IDOLookupException;

public class DomainsManagerBean {

	private String newDomainName;
	
	public List getDomains(){
		
		ArrayList<ICDomain> list = new ArrayList<ICDomain>();
	
		
		ICDomainHome domainHome = getDomainHome();
		
		Collection domains;
		try {
			domains = domainHome.findAllDomains();
			

			for (Iterator iter = domains.iterator(); iter.hasNext();) {
				ICDomain icdomain = (ICDomain) iter.next();
				Domain domain = new Domain(icdomain);
				list.add(domain);
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	private ICDomainHome getDomainHome() {
		try {
			return (ICDomainHome) IDOLookup.getHome(ICDomain.class);
		} catch (IDOLookupException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void addDomain(){
		
		
		ICDomain newDomain;
		try {
			newDomain = getDomainHome().create();
			
			newDomain.setName(getNewDomainName());
			newDomain.setServerName(getNewDomainName());
			newDomain.setType(ICDomain.TYPE_SUBDOMAIN);
			newDomain.store();
			
		} catch (CreateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @return Returns the newDomainName.
	 */
	public String getNewDomainName() {
		return newDomainName;
	}

	/**
	 * @param newDomainName The newDomainName to set.
	 */
	public void setNewDomainName(String newDomainName) {
		this.newDomainName = newDomainName;
	}
}
