<%@ include file="local_header.jsp"%>
    
<h2><spring:message code="feedback.editStatus"/></h2>

<b class="boxHeader"><spring:message code="feedback.statuses"/></b>
<div class="box" >
<table cellpadding="2" cellspacing="0">
    <tr>
        <th width="100"><spring:message code="feedback.index"/></th>
        <th width="200"><spring:message code="feedback.status"/></th>
    </tr>
    <tr  class="evenRow">
        <td><c:out value="${statuses.feedbackStatusId}"/> </td>
        <td> <c:out value="${statuses.status}"/> </td>
    </tr>    
</table> 
    
    <br/>
    <form method="get">
        <input type=hidden name=feedbackStatusId value=<c:out value="${statuses.feedbackStatusId}"/>>
        <input type=hidden name=delete value="1">
        <input type="submit" value="Delete" />
    </form>    


</div>


<%@ include file="/WEB-INF/template/footer.jsp" %>