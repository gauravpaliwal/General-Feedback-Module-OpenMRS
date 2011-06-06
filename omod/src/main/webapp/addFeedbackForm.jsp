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

		<li >
			<a href="../../module/feedback/addStatus.form">Add Status</a>
		</li>	
                <li class="active">
			<a href="../../module/feedback/addFeedback.form">Submit Feedback</a>
		</li>
</ul>
<h2>Feedback Management</h2>

<form method="get">
<b class="boxHeader"><spring:message code="feedback.submit"/></b>
<div class="box" >
<table cellpadding="2" cellspacing="0">
    <tr>
        <td><spring:message code="feedback.subject"/> </td>
	<td>
            <select name="subject">
                <c:forEach items="${predefinedsubjects}" var="predefinedsubjectObj">
                    <option value="<c:out value="${predefinedsubjectObj.subject}"/>"> <c:out value="${predefinedsubjectObj.subject}"/> </option>      
                </c:forEach>
            </select>
        </td>
        </tr>
        <tr>
        <td><spring:message code="feedback.severity"/>  </td>        
        <td>
            <select name="severities">
                <c:forEach items="${severities}" var="severityObj">
                    <option value="<c:out value="${severityObj.severity}"/>"> <c:out value="${severityObj.severity}"/> </option>      
                </c:forEach>
            </select>
        </td>
        </tr>
        <tr>
        <td valign="top"><spring:message code="feedback.feedback"/> </td>
        <td><textarea name="feedback" rows="10" cols="120" type="_moz" size="35"></textarea> </td>
        </tr>
        <tr>
       	<td><spring:message code="feedback.pageContext"/> </td>
        <td><input type="checkbox" NAME="pagecontext"> </input>        </td>   
        </tr>
        <tr>
       	<td><spring:message code="feedback.attachment"/> </td>
        <td><input type="file" name="attachment" size="40"> </input> </td>   
        </tr>
</table>
        <br/>
	<input type="submit" value="<spring:message code="feedback.addFeedback" />" />
</div>
</form>

<%@ include file="/WEB-INF/template/footer.jsp" %>