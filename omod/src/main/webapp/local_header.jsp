<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Feedback Criteria" otherwise="/login.htm" redirect="/module/feedback/addResponse.form" />

<%@ include file="/WEB-INF/template/header.jsp" %>

<!-- Include taglibs from core -->
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>

<openmrs:extensionPoint pointId="org.openmrs.admin.concepts.conceptDatatypeList.afterTitle" type="html" />
<!-- True/False can't be the value of the feedbackMessage -->

<c:if test="${!empty feedbackPageMessage}"> 
            <div id="openmrs_msg"><spring:message code="${feedbackPageMessage}"/></div>
</c:if>
    
<ul id="menu">

        <li class="first">
                <a href="${pageContext.request.contextPath}/admin"><spring:message code="admin.title.short"/></a>
        </li>
        <li 
            <c:if test='<%= request.getRequestURI().contains("addPredefinedSubject") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/addPredefinedSubject.form"><spring:message code="feedback.predefinedsubjects"/></a>

        </li>
        <li 
            <c:if test='<%= request.getRequestURI().contains("addSeverity") %>'>class="active"</c:if>>
                        			<a href="<openmrs:contextPath/>/module/feedback/addSeverity.form"><spring:message code="feedback.severities"/></a>


        </li>
        <li 
            <c:if test='<%= request.getRequestURI().contains("addStatus") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/addStatus.form"><spring:message code="feedback.statuses"/></a>

        </li>
        <li 
            <c:if test='<%= request.getRequestURI().contains("addFeedback") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/addFeedback.form"><spring:message code="feedback.addFeedback"/></a>

        </li>
        <li 
            <c:if test='<%= request.getRequestURI().contains("feedback/feedback") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/feedback.list"><spring:message code="feedback.manageFeedback"/></a>

        </li>
        <openmrs:extensionPoint pointId="org.openmrs.module.feedback.localHeader" type="html">
            <openmrs:hasPrivilege privilege="${extension.requiredPrivilege}">
                <c:if test="${extension.portletUrl != null}">
                    <openmrs:portlet url="${extension.portletUrl}" moduleId="${extension.moduleId}" id="${extension.portletUrl}" />
                </c:if>
            </openmrs:hasPrivilege>
        </openmrs:extensionPoint> 

</ul>
                        
                        
                                             