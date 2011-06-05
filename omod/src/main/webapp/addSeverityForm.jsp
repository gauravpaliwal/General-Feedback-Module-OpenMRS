<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addResponse.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<b class="boxHeader"><spring:message code="feedback.severities"/></b>
<div class="box" >
<table cellpadding="2" cellspacing="0">
    <tr  class='evenRow'>
        <td width="100" ><h4>Index</h4></td>
        <td width="100"><h4>Severity Level</h4></td>
    </tr>
<c:forEach items="${severities}" var="severityObj">
    <tr>
        <td>${severityObj.feedbackSeverityId} </td>
        <td><a href="/openmrs/module/feedback/severity.form?feedbackSeverityId=${severityObj.feedbackSeverityId}">${severityObj.severity}</a></td>   
    
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