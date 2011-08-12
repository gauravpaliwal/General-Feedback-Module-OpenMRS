<%@ include file="/WEB-INF/template/include.jsp" %>

<%@ include file="/WEB-INF/template/header.jsp" %>

<!-- Include taglibs from core -->
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>

<openmrs:hasPrivilege privilege="Add Feedback">

<c:if test="${!empty feedbackPageMessage}"> 
            <div id="openmrs_msg"><spring:message code="${feedbackPageMessage}"/></div>
</c:if>
    
<ul id="menu">
	<openmrs:hasPrivilege privilege="Admin Feedback,Add Feedback">
        <li class="first">
                <a href="${pageContext.request.contextPath}/admin"><spring:message code="admin.title.short"/></a>
        </li>
	</openmrs:hasPrivilege>

	<openmrs:hasPrivilege privilege="Admin Feedback">
        <li 
            <c:if test='<%= request.getRequestURI().contains("addPredefinedSubject") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/addPredefinedSubject.form"><spring:message code="feedback.predefinedsubjects"/></a>

        </li>
	</openmrs:hasPrivilege>
	<openmrs:hasPrivilege privilege="Admin Feedback">
        <li 
            <c:if test='<%= request.getRequestURI().contains("addSeverity") %>'>class="active"</c:if>>
                        			<a href="<openmrs:contextPath/>/module/feedback/addSeverity.form"><spring:message code="feedback.severities"/></a>


        </li>
	</openmrs:hasPrivilege>
	<openmrs:hasPrivilege privilege="Admin Feedback">
        <li 
            <c:if test='<%= request.getRequestURI().contains("addStatus") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/addStatus.form"><spring:message code="feedback.statuses"/></a>

        </li>
	</openmrs:hasPrivilege>
	<openmrs:hasPrivilege privilege="Admin Feedback">
        <li 
            <c:if test='<%= request.getRequestURI().contains("feedback/feedbackAdmin") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/feedbackAdmin.list"><spring:message code="feedback.manageFeedback"/></a>

        </li>
	</openmrs:hasPrivilege>
	<openmrs:hasPrivilege privilege="Admin Feedback">
        <li 
            <c:if test='<%= request.getRequestURI().contains("feedbackProperties") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/feedbackProperties.form"><spring:message code="feedback.admin.properties"/></a>
        </li>
	</openmrs:hasPrivilege>
	<openmrs:hasPrivilege privilege="Add Feedback,Admin Feedback">
        <li 
            <c:if test='<%= request.getRequestURI().contains("addFeedback") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/addFeedback.form"><spring:message code="feedback.addFeedback"/></a>

        </li>
	</openmrs:hasPrivilege>
	<openmrs:hasPrivilege privilege="Add Feedback,Admin Feedback">
        <li 
            <c:if test='<%= request.getRequestURI().contains("feedback/feedbackUser") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/feedbackUser.list"><spring:message code="feedback.user.manageFeedback"/></a>

        </li>
	</openmrs:hasPrivilege>
	<openmrs:hasPrivilege privilege="Add Feedback,Admin Feedback">
        <li 
            <c:if test='<%= request.getRequestURI().contains("preference") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/preference.form"><spring:message code="feedback.user.preference"/></a>
        </li>
	</openmrs:hasPrivilege>
        <openmrs:extensionPoint pointId="org.openmrs.module.feedback.localHeader" type="html">
            <openmrs:hasPrivilege privilege="${extension.requiredPrivilege}">
                <c:if test="${extension.portletUrl != null}">
                    <openmrs:portlet url="${extension.portletUrl}" moduleId="${extension.moduleId}" id="${extension.portletUrl}" />
                </c:if>
            </openmrs:hasPrivilege>
        </openmrs:extensionPoint> 

</ul>
       </openmrs:hasPrivilege>
                 
                        
                                             