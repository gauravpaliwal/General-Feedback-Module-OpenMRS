<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addResponse.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<br/>

<form method="post">

	<spring:message code="feedback.addSeverity"/>: 
	<input type="text" name="response" value="" />
	
	<br/><br/>
	
	<input type="submit" value="<spring:message code="general.save" />" />

</form>

<h3><spring:message code="feedback.severities"/></h3>
 <table border="0">

<c:forEach items="${severities}" var="severityObj">
    <tr>
        <td>${severityObj.severity} </td>
    </tr>

</c:forEach>
</table> 
<br/>

<%@ include file="/WEB-INF/template/footer.jsp" %>