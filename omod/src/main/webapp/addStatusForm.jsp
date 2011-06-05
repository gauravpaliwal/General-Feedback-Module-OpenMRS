<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addStatus.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<b class="boxHeader"><spring:message code="feedback.statuses"/></b>
<div class="box" >
<table cellpadding="2" cellspacing="0">
    <tr  class='evenRow'>
        <td width="100" ><h4>Index</h4></td>
        <td width="400"><h4>Status</h4></td>
    </tr>
<c:forEach items="${statuses}" var="statusObj">
    <tr>
        <td>${statusObj.feedbackStatusId} </td>
        <td><a href="/openmrs/module/feedback/status.form?feedbackStatusId=${statusObj.feedbackStatusId}">${statusObj.status}</a></td>   
    </tr>

</c:forEach>
</table> 
</div>
<br/>

<form method="post">

	<spring:message code="feedback.addStatus"/>: 
	<input type="text" name="status" value="" />
	
	<br/><br/>
	
	<input type="submit" value="<spring:message code="feedback.addStatus" />" />

</form>

<%@ include file="/WEB-INF/template/footer.jsp" %>