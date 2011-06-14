<%@ include file="local_header.jsp"%>

    
<h2><spring:message code="feedback.editPredefinedSubject"/></h2>

<b class="boxHeader"><spring:message code="feedback.predefinedsubjects"/></b>

<div class="box" >
    
    <table>
        <tr>
            <th width="100"><spring:message code="feedback.index"/></th>
            <th width="200"><spring:message code="feedback.predefinedSubject"/></th>
        </tr>
        <tr class="evenRow">
            <td><c:out value="${predefinedsubjects.feedbackPredefinedSubjectId}"/> </td>
            <td><c:out value="${predefinedsubjects.subject}"/> </td>
        </tr>
    </table> 
    
    <br/>
    
    <form method="get">
        <input TYPE=hidden name=predefinedsubjectid value= <c:out value="${predefinedsubjects.feedbackPredefinedSubjectId}"/> >
        <input TYPE=hidden name=delete value="1">
        <input type="submit" value="Delete" />
    </form>

</div>


<%@ include file="/WEB-INF/template/footer.jsp" %>