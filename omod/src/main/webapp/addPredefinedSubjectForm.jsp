<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addResponse.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<ul id="menu">
                <li class="first">
                        <a href="../../admin/index.htm"><spring:message code="feedback.admin"/></a>
                </li>
                
                <li  class="active">
                        <a href="../../module/feedback/addPredefinedSubject.form"><spring:message code="feedback.addPredefinedSubject"/></a>
                </li>
	
		<li>
			<a href="../../module/feedback/addSeverity.form"><spring:message code="feedback.addSeverity"/></a>
		</li>

		<li >
			<a href="../../module/feedback/addStatus.form"><spring:message code="feedback.addStatus"/></a>
		</li>	
                <li>
			<a href="../../module/feedback/addFeedback.form"><spring:message code="feedback.addFeedback"/></a>
		</li>
                <li>
			<a href="../../module/feedback/feedback.list"><spring:message code="feedback.manageFeedback"/></a>
		</li>
</ul>
<h2><spring:message code="feedback.addPredefinedSubject"/></h2>


<form method="post">

	<spring:message code="feedback.addPredefinedSubject"/>: 
	<input type="text" name="predefinedsubject" value="" />
	
	<br/><br/>
	
	<input type="submit" value="<spring:message code="feedback.addPredefinedSubject" />" />

</form>
        
        <br/>

<b class="boxHeader"><spring:message code="feedback.predefinedsubjects"/></b>

<div class="box" >
    
    <table>
        <tr>
            <th width="100"><spring:message code="feedback.index"/></th>
            <th width="200"><spring:message code="feedback.predefinedSubject"/></th>
        </tr>
        <c:forEach items="${predefinedsubjects}" var="predefinedsubjectObj"  varStatus="loopStatus">
            <tr class="${loopStatus.index % 2 == 0 ? 'evenRow' : 'oddRow'}">
                <td><c:out value="${predefinedsubjectObj.feedbackPredefinedSubjectId}"/></td>
                <td><a href="/openmrs/module/feedback/predefinedSubject.form?predefinedsubjectid=<c:out value="${predefinedsubjectObj.feedbackPredefinedSubjectId} "/>"><c:out value="${predefinedsubjectObj.subject} "/></a></td>
            </tr>
    
        </c:forEach>
    </table> 
</div>



<%@ include file="/WEB-INF/template/footer.jsp" %>