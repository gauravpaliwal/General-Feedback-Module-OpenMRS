<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addStatus.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<ul id="menu">
                <li class="first">
                        <a href="../../admin/index.htm"><spring:message code="feedback.admin"/></a>
                </li>
                
                <li>
                        <a href="../../module/feedback/addPredefinedSubject.form"><spring:message code="feedback.addPredefinedSubject"/></a>
                </li>
	
		<li >
			<a href="../../module/feedback/addSeverity.form"><spring:message code="feedback.addSeverity"/></a>
		</li>

		<li>
			<a href="../../module/feedback/addStatus.form"><spring:message code="feedback.addStatus"/></a>
		</li>	
                <li>
			<a href="../../module/feedback/addFeedback.form"><spring:message code="feedback.addFeedback"/></a>
		</li>
                <li class ="active">
			<a href="../../module/feedback/feedback.list"><spring:message code="feedback.manageFeedback"/></a>
		</li>
</ul>

<h2><spring:message code="feedback.manageFeedback"/></h2>

<form method="get">
    <b class="boxHeader"><spring:message code="feedback.submit"/></b>
    <div class="box" >
        <table>

            <tr>
                <th width="100"><spring:message code="feedback.feedbackId"/></th>
                <th width="300"><spring:message code="feedback.creator"/></th>
                <th width="400"><spring:message code="feedback.subject"/></th>
                <th width="300"><spring:message code="feedback.severity"/></th>
                <th width="400"><spring:message code="feedback.status"/></th>
                <th width="400"><spring:message code="feedback.dateCreated"/></th>
            </tr>
            <c:forEach items="${feedbacks}" var="feedbackObj" varStatus="loopStatus">
                <tr class="${loopStatus.index % 2 == 0 ? 'evenRow' : 'oddRow'}">
                    <td><c:out value="${feedbackObj.feedbackId} "/> </td>
                    <td><c:out value="${feedbackObj.creator} "/> </td>
                    <td><c:out value="${feedbackObj.subject} "/> </td>
                    <td><c:out value="${feedbackObj.severity} "/> </td>
                    <td><c:out value="${feedbackObj.status} "/> </td>
                    <td><c:out value="${feedbackObj.dateCreated} "/> </td>
                </tr>    
            </c:forEach>    
        </table>
   </div>
</form>

<%@ include file="/WEB-INF/template/footer.jsp" %>