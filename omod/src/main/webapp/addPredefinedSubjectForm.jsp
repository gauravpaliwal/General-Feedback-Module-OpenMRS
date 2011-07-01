<%@ include file="local_header.jsp"%>

<h2><spring:message code="feedback.addPredefinedSubject"/></h2>

<openmrs:portlet url="newjsp" id="SubmitFeedbackController" moduleId="feedback" />
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
            <th width="60"><spring:message code="feedback.index"/></th>
            <th width="320"><spring:message code="feedback.predefinedSubject"/></th>
        </tr>
        <c:forEach items="${predefinedsubjects}" var="predefinedsubjectObj"  varStatus="loopStatus">
            <tr class="${loopStatus.index % 2 == 0 ? 'evenRow' : 'oddRow'}">
                <td><c:out value="${predefinedsubjectObj.feedbackPredefinedSubjectId}"/></td>
                <td><a href ="<openmrs:contextPath/>/module/feedback/predefinedSubject.form?predefinedsubjectid=<c:out value="${predefinedsubjectObj.feedbackPredefinedSubjectId} "/>"><c:out value="${predefinedsubjectObj.subject} "/></a></td>
            </tr>
    
        </c:forEach>
    </table> 
</div>



<%@ include file="/WEB-INF/template/footer.jsp" %>