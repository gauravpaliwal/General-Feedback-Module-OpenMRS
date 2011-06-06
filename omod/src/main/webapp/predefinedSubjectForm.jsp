<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addResponse.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<div id="openmrs_msg"><c:out value="${status}"/></div>

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

		<li >
			<a href="../../module/feedback/addStatus.form">Add Status</a>
		</li>	
                <li >
			<a href="../../module/feedback/addFeedback.form">Submit Feedback</a>
		</li>
</ul>
<h2>Edit Predefined Subject</h2>


<b class="boxHeader"><spring:message code="feedback.predefinedsubjects"/></b>
<div class="box" >
<table cellpadding="2" cellspacing="0">
    <tr  class='evenRow'>
        <td width="100" ><h4>Index</h4></td>
        <td width="200"><h4>Predefined Subject</h4></td>
    </tr>
    <tr>
        <td><c:out value="${predefinedsubjects.feedbackPredefinedSubjectId}"/> </td>
        <td><c:out value="${predefinedsubjects.subject}"/> </td>
    </tr>
<br/>


</table> 
    <br/>
    <form method="get">
<INPUT TYPE=hidden NAME=predefinedsubjectid VALUE= <c:out value="${predefinedsubjects.feedbackPredefinedSubjectId}"/> >
<INPUT TYPE=hidden NAME=delete VALUE="1">
<input type="submit" value="Delete" />
</form>

</div>


<%@ include file="/WEB-INF/template/footer.jsp" %>