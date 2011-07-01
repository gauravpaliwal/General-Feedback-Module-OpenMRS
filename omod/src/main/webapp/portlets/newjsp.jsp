<%@ include file="/WEB-INF/template/include.jsp" %>

<div id="dialog" title="Submit Feedback Form">
    
<form action="<openmrs:contextPath/>/module/feedback/addFeedback.form" method="post"  enctype="multipart/form-data" >
<b class="boxHeader"><spring:message code="feedback.submit"/></b>
    <div class="box" >
    <table>
        <tr>
            <td><spring:message code="feedback.subject"/> </td>
            <td>
            <select name="subject">
                <c:forEach items="${model.predefinedsubjects}" var="predefinedsubjectObj" >
                    <option value="<c:out value="${predefinedsubjectObj.subject}"/>"> <c:out value="${predefinedsubjectObj.subject}"/> </option>      
                </c:forEach>
            </select>
            </td>
        </tr>
        <tr>
            <td><spring:message code="feedback.severity"/>  </td>        
            <td>
                <select name="severity">
                    <c:forEach items="${model.severities}" var="severityObj">
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
            <td><input type="checkbox" name="pagecontext"> </input>        </td>   
        </tr>
        <tr>
            <td><spring:message code="feedback.attachment"/> </td>
            <td><input type="file" name="file" size="40"> </input> </td>   
        </tr>
    </table>
        <br/>
	<input type="submit" value="<spring:message code="feedback.addFeedback" />" />
    </div>
</form>


</div>

