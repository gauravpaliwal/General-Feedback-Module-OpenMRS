<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addResponse.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<br/>

<form method="get">

	<spring:message code="feedback.addPredefinedSubject"/>: 
	<input type="text" name="predefinedsubject" value="" />
	
	<br/><br/>
	
	<input type="submit" value="<spring:message code="general.save" />" />

</form>

<h3><spring:message code="feedback.predefinedsubjects"/></h3>
<table border="0">
    <tr>
        <td width="100" ><h4>Index</h4></td>
        <td width="200"><h4>Predefined Subject</h4></td>
    </tr>
<c:forEach items="${predefinedsubjects}" var="predefinedsubjectObj">
    <tr>
        <td>${predefinedsubjectObj.feedbackPredefinedSubjectId} </td>
        <td>${predefinedsubjectObj.subject} </td>
    </tr>

</c:forEach>
</table> 
<br/>

<%@ include file="/WEB-INF/template/footer.jsp" %>