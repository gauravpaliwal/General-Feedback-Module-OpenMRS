<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addResponse.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<b class="boxHeader"><spring:message code="feedback.predefinedsubjects"/></b>
<div class="box" >
<table cellpadding="2" cellspacing="0">
    <tr  class='evenRow'>
        <th width="100" ><h4>Index</h4></th>
        <th width="200"><h4>Predefined Subject</h4></th>
    </tr>
<c:forEach items="${predefinedsubjects}" var="predefinedsubjectObj">
    <tr>
        <td>${predefinedsubjectObj.feedbackPredefinedSubjectId} </td>
        <td><a href="/openmrs/module/feedback/predefinedSubject.form?predefinedsubjectid=${predefinedsubjectObj.feedbackPredefinedSubjectId}">${predefinedsubjectObj.subject}</a></td>
    </tr>

</c:forEach>
</table> 
</div>
<br/>


<form method="post">

	<spring:message code="feedback.addPredefinedSubject"/>: 
	<input type="text" name="predefinedsubject" value="" />
	
	<br/><br/>
	
	<input type="submit" value="<spring:message code="feedback.addPredefinedSubject" />" />

</form>

<%@ include file="/WEB-INF/template/footer.jsp" %>