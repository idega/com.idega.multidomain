<jsp:root version="1.2" 
	xmlns:f="http://java.sun.com/jsf/core" 
	xmlns:h="http://java.sun.com/jsf/html" 
	xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:ws="http://xmlns.idega.com/com.idega.workspace"
	xmlns:wf="http://xmlns.idega.com/com.idega.webface">
    <jsp:directive.page contentType="text/html;charset=ISO-8859-1" pageEncoding="UTF-8"/>
    <f:view>
		<ws:page>
            <h:form id="form1">
            <wf:wfblock title="#{localizedStrings['com.idega.multidomain']['domains']}">
            
	            <!--wf:container>
	            	<h:outputText  value="Domain Manager"/>
	            </wf:container-->
	            
	            <wf:container  style="padding: 10px 10px 10px 10px">
	                <h:messages 
	                	showSummary="false" 
	                	showDetail="true"
	            		style="color: red;" 
	            		id="errors1"/>
		            
					<h:dataTable id="domainsTable" value="#{DomainsManager.domains}" var="domain" >
						<h:column id="name">
							<f:facet name="header">
								<h:outputText value="#{localizedStrings['com.idega.multidomain']['domainName']}" id="nameHeaderText"></h:outputText>
							</f:facet>
							<h:outputText id="textName" value="#{domain.name}" >
							</h:outputText>
						</h:column>
						<h:column id="serverName">
							<f:facet name="header">
								<h:outputText value="#{localizedStrings['com.idega.multidomain']['serverName']}" id="text2"></h:outputText>
							</f:facet>
							<h:outputText id="textServerName" value="#{domain.serverName}">
							</h:outputText>
						</h:column>
					</h:dataTable>

	            </wf:container>
	            
	            <wf:container style="padding: 10px 10px 10px 10px">
		            
		            <h:inputText id="addDomainInput" value="#{DomainsManager.newDomainName}"/>
		            <h:commandButton id="addDomainButton"  
		                action="#{DomainsManager.addDomain}"
		               	value="#{localizedStrings['com.idega.multidomain']['add_domain']}"/>
		           	
	            </wf:container>

           	</wf:wfblock>
            </h:form>
		</ws:page>
    </f:view>
</jsp:root>
