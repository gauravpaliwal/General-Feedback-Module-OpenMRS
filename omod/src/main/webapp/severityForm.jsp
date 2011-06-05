<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addResponse.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<br/>

<h3><spring:message code="feedback.predefinedsubjects"/></h3>
<table border="0">
    <tr>
        <td width="100" ><h4>Index</h4></td>
        <td width="200"><h4>Severity</h4></td>
    </tr>

    <tr>
        <td>${severity.feedbackSeverityId} </td>
        <td>${severity.severity} </td>
    </tr>
</table> 
<br/>
${status}
<br/>
<form method="get">
<INPUT TYPE=hidden NAME=feedbackSeverityId VALUE= ${severity.feedbackSeverityId} >
<INPUT TYPE=hidden NAME=delete VALUE="1">
<input type="submit" value="Delete" />
</form>

<%@ include file="/WEB-INF/template/footer.jsp" %>