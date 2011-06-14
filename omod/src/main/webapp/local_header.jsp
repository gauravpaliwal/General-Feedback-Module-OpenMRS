<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Feedback Criteria" otherwise="/login.htm" redirect="/module/feedback/addResponse.form" />

<%@ include file="/WEB-INF/template/header.jsp" %>

<!-- Include taglibs from core -->
<%@ taglib prefix="fn" uri="/WEB-INF/taglibs/fn.tld" %>

<openmrs:extensionPoint pointId="org.openmrs.admin.concepts.conceptDatatypeList.afterTitle" type="html" />

<c:if test="${!empty status}"> 
    
    <div id="openmrs_msg"><c:out value="${status}"/></div>
    
</c:if>
    
<ul id="menu">

        <li class="first">
                <a href="${pageContext.request.contextPath}/admin"><spring:message code="admin.title.short"/></a>
        </li>
        <li 
            <c:if test='<%= request.getRequestURI().contains("addPredefinedSubject") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/addPredefinedSubject.form"><spring:message code="feedback.addPredefinedSubject"/></a>

        </li>
        <li 
            <c:if test='<%= request.getRequestURI().contains("addSeverity") %>'>class="active"</c:if>>
                        			<a href="<openmrs:contextPath/>/module/feedback/addSeverity.form"><spring:message code="feedback.addSeverity"/></a>


        </li>
                <li 
            <c:if test='<%= request.getRequestURI().contains("addStatus") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/addStatus.form"><spring:message code="feedback.addStatus"/></a>

        </li>
                <li 
            <c:if test='<%= request.getRequestURI().contains("addFeedback") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/addFeedback.form"><spring:message code="feedback.addFeedback"/></a>

        </li>
                <li 
            <c:if test='<%= request.getRequestURI().contains("feedback/feedback") %>'>class="active"</c:if>>
                        <a href="<openmrs:contextPath/>/module/feedback/feedback.list"><spring:message code="feedback.manageFeedback"/></a>

        </li>
        <openmrs:extensionPoint pointId="org.openmrs.admin.concepts.localHeader" type="html">
                        <c:forEach items="${extension.links}" var="link">
                                <li <c:if test="${fn:endsWith(pageContext.request.requestURI, link.key)}">class="active"</c:if> >
                                        <a href="${pageContext.request.contextPath}/${link.key}"><spring:message code="${link.value}"/></a>
                                </li>
                        </c:forEach>
        </openmrs:extensionPoint>

</ul>


    