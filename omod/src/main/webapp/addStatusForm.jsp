<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addStatus.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<ul id="menu">
                <li class="first">
                        <a href="../../admin/index.htm">Admin</a>
                </li>
                
                <li>
                        <a href="../../module/feedback/addPredefinedSubject.form">Add Predefined Subject</a>
                </li>
	
		<li>
			<a href="../../module/feedback/addSeverity.form">Add Severity Level</a>
		</li>

		<li class="active">
			<a href="../../module/feedback/addStatus.form">Add Status</a>
		</li>	
                <li>
			<a href="../../module/feedback/addFeedback.form">Submit Feedback</a>
		</li>
</ul>
<h2>Status Management</h2>


<b class="boxHeader"><spring:message code="feedback.statuses"/></b>
<div class="box" >
<table cellpadding="2" cellspacing="0">
    <tr  class='evenRow'>
        <td width="100" ><h4>Index</h4></td>
        <td width="400"><h4>Status</h4></td>
    </tr>
<c:forEach items="${statuses}" var="statusObj">
    <tr>
        <td><c:out value="${statusObj.feedbackStatusId} "/></td>
        <td><a href="/openmrs/module/feedback/status.form?feedbackStatusId=<c:out value="${statusObj.feedbackStatusId}"/>"><c:out value="${statusObj.status}"/></a></td>   
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