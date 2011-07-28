<%@ include file="local_header.jsp"%>

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
            <th width="320"><spring:message code="feedback.predefinedSubject"/></th>
        </tr>
        <c:forEach items="${predefinedsubjects}" var="predefinedsubjectObj"  varStatus="loopStatus">
            <tr class="${loopStatus.index % 2 == 0 ? 'evenRow' : 'oddRow'}">
                <td><a href ="<openmrs:contextPath/>/module/feedback/predefinedSubject.form?predefinedsubjectid=<c:out value="${predefinedsubjectObj.feedbackPredefinedSubjectId} "/>"><c:out value="${predefinedsubjectObj.subject} "/></a></td>
            </tr>
    
        </c:forEach>
    </table> 
</div>

</br>
<b class="boxHeader"><spring:message code="feedback.predefinedsubject.help.heading"/></b>
<div class="box">
    	<ul>
		<li><i><spring:message code="feedback.predefinedsubject.help.l1"/></i></li>
		<li><i><spring:message code="feedback.predefinedsubject.help.l2"/></i></li>
                <li><i><spring:message code="feedback.predefinedsubject.help.l3"/></i></li>
                <li><i><spring:message code="feedback.predefinedsubject.help.l4"/></i></li>
        </ul>
</div>

<%@ include file="/WEB-INF/template/footer.jsp" %>