<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addResponse.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>


<b class="boxHeader"><spring:message code="feedback.predefinedsubjects"/></b>
<div class="box" >
<table cellpadding="2" cellspacing="0">
    <tr  class='evenRow'>
        <td width="100" ><h4>Index</h4></td>
        <td width="200"><h4>Status</h4></td>
    </tr>
    <tr>
        <td>${statuses.feedbackStatusId} </td>
        <td>${statuses.status} </td>
    </tr>
    ${status}
</table> 

<form method="get">
<INPUT TYPE=hidden NAME=feedbackStatusId VALUE=${statuses.feedbackStatusId} >
<INPUT TYPE=hidden NAME=delete VALUE="1">
<input type="submit" value="Delete" />
</form>

</div>


<%@ include file="/WEB-INF/template/footer.jsp" %>