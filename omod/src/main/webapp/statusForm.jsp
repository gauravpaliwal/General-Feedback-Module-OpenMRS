<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addResponse.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<c:if test="${!empty status}"> 
    
    <div id="openmrs_msg"><c:out value="${status}"/></div>
    
</c:if>
    
<ul id="menu">
                <li class="first">
                        <a href="../../admin/index.htm"><spring:message code="feedback.admin"/></a>
                </li>
                
                <li>
                        <a href="../../module/feedback/addPredefinedSubject.form"><spring:message code="feedback.addPredefinedSubject"/></a>
                </li>
	
		<li >
			<a href="../../module/feedback/addSeverity.form"><spring:message code="feedback.addSeverity"/></a>
		</li>

		<li>
			<a href="../../module/feedback/addStatus.form"><spring:message code="feedback.addStatus"/></a>
		</li>	
                <li>
			<a href="../../module/feedback/addFeedback.form"><spring:message code="feedback.addFeedback"/></a>
		</li>
                <li>
			<a href="../../module/feedback/feedback.list"><spring:message code="feedback.manageFeedback"/></a>
		</li>
</ul>
    
<h2><spring:message code="feedback.editStatus"/></h2>

<b class="boxHeader"><spring:message code="feedback.statuses"/></b>
<div class="box" >
<table cellpadding="2" cellspacing="0">
    <tr>
        <th width="100"><spring:message code="feedback.index"/></th>
        <th width="200"><spring:message code="feedback.status"/></th>
    </tr>
    <tr  class="evenRow">
        <td><c:out value="${statuses.feedbackStatusId}"/> </td>
        <td> <c:out value="${statuses.status}"/> </td>
    </tr>    
</table> 
    
    <br/>
    <form method="get">
        <INPUT TYPE=hidden NAME=feedbackStatusId VALUE=<c:out value="${statuses.feedbackStatusId}"/>>
        <INPUT TYPE=hidden NAME=delete VALUE="1">
        <input type="submit" value="Delete" />
    </form>    


</div>


<%@ include file="/WEB-INF/template/footer.jsp" %>