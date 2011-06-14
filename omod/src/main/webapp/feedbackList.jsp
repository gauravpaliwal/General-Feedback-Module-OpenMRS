<%@ include file="local_header.jsp"%>

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