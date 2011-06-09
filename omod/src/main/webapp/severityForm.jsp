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
    
<h2><spring:message code="feedback.editSeverity"/></h2>

<b class="boxHeader"><spring:message code="feedback.severities"/></b>

<div class="box" >
    <table>
        <tr>
            <th width="100"><spring:message code="feedback.index"/></th>
            <th width="200"><spring:message code="feedback.severity"/></th>
        </tr>
        <tr  class="evenRow">
            <td><c:out value="${severity.feedbackSeverityId}"/> </td>
            <td><c:out value="${severity.severity}"/></td>
        </tr>
    </table> 
    <br/>
    <form method="get">
        <INPUT TYPE=hidden NAME=feedbackSeverityId VALUE= <c:out value="${severity.feedbackSeverityId}"/> >
        <INPUT TYPE=hidden NAME=delete VALUE="1">
        <input type="submit" value="Delete" />
    </form>
    
</div>


<%@ include file="/WEB-INF/template/footer.jsp" %>