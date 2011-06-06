<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addResponse.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>
<ul id="menu">
                <li class="first">
                        <a href="../../admin/index.htm">Admin</a>
                </li>
                
                <li>
                        <a href="../../module/feedback/addPredefinedSubject.form">Add Predefined Subject</a>
                </li>
	
		<li  class="active">
			<a href="../../module/feedback/addSeverity.form">Add Severity Level</a>
		</li>

		<li >
			<a href="../../module/feedback/addStatus.form">Add Status</a>
		</li>	
                <li>
			<a href="../../module/feedback/addFeedback.form">Submit Feedback</a>
		</li>
</ul>
<h2>Severity Management</h2>

<b class="boxHeader"><spring:message code="feedback.severities"/></b>
<div class="box" >
<table cellpadding="2" cellspacing="0">
    <tr  class='evenRow'>
        <td width="100" ><h4>Index</h4></td>
        <td width="400"><h4>Severity Level</h4></td>
    </tr>
<c:forEach items="${severities}" var="severityObj">
    <tr>
        <td><c:out value="${severityObj.feedbackSeverityId} "/> </td>
        <td><a href="/openmrs/module/feedback/severity.form?feedbackSeverityId=<c:out value="${severityObj.feedbackSeverityId} "/>"><c:out value="${severityObj.severity} "/></a></td>   
    
    </tr>    
</c:forEach>
</table> 
</div>
<br/>
<form method="post">
    
	<spring:message code="feedback.addSeverity"/>: 
	<input type="text" name="severity" value="" />
	
	<br/><br/>
	
	<input type="submit" value="<spring:message code="feedback.addSeverity" />" />

</form>
<br/>

<%@ include file="/WEB-INF/template/footer.jsp" %>