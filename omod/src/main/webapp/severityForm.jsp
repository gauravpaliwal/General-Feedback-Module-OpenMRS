<%@ include file="local_header.jsp"%>

    
<h2><spring:message code="feedback.editSeverity"/></h2>

<b class="boxHeader"><spring:message code="feedback.severities"/></b>

<div class="box" >
    <table>
        <tr>
            <th width="100"><spring:message code="feedback.index"/></th>
            <th width="200"><spring:message code="feedback.severity"/></th>
        </tr>
        <tr  class="evenRow">
            <td><c:out value="${severity.feedbackSeverityId}"/> </td>
            <td><c:out value="${severity.severity}"/></td>
        </tr>
    </table> 
    <br/>
    <form method="get">
        <input TYPE=hidden name=feedbackSeverityId value= <c:out value="${severity.feedbackSeverityId}"/> >
        <input TYPE=hidden name=delete value="1">
        <input type="submit" value="Delete" />
    </form>
    
</div>


<%@ include file="/WEB-INF/template/footer.jsp" %>