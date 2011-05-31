<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addStatus.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<br/>

<form method="post">

	<spring:message code="feedback.addStatus"/>: 
	<input type="text" name="status" value="" />
	
	<br/><br/>
	
	<input type="submit" value="<spring:message code="general.save" />" />

</form>

<h3><spring:message code="feedback.statuses"/></h3>
<table border="0">
    <tr>
        <td width="100" ><h4>Index</h4></td>
        <td width="100"><h4>Status</h4></td>
    </tr>
<c:forEach items="${statuses}" var="statusObj">
    <tr>
        <td>${statusObj.feedbackStatusId} </td>
        <td>${statusObj.status} </td>
    </tr>

</c:forEach>
</table> 
<br/>

<%@ include file="/WEB-INF/template/footer.jsp" %>