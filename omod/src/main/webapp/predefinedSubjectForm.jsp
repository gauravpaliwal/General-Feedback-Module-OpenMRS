<%@ include file="local_header.jsp"%>

    
<h2><spring:message code="feedback.editPredefinedSubject"/></h2>

<b class="boxHeader"><spring:message code="feedback.predefinedsubjects"/></b>

<div class="box" >
<c:if test="${empty feedbackPageMessage}"> 
    <table>
        <tr>
            <th width="200"><spring:message code="feedback.predefinedSubject"/></th>
        </tr>
        <form method="post">
            <tr class="evenRow">
                <td><input type="text" name="predefinedsubject"  size="50"  value="${predefinedsubjects.subject}"/></td>
            </tr>
            <tr>
                <input TYPE=hidden name=predefinedsubjectid value= <c:out value="${predefinedsubjects.feedbackPredefinedSubjectId}"/> >
                <input TYPE=hidden name=save value="1">
                <td>
                    <input type="submit" value="Save" />
                </td>
        </form>
   
        <form method="post">
        <input TYPE=hidden name=predefinedsubjectid value= <c:out value="${predefinedsubjects.feedbackPredefinedSubjectId}"/> >
        <input TYPE=hidden name=delete value="1">
                <td>
                    <input type="submit" value="Delete" />
                </td>
    </form>
             </tr>

    </table> 
</c:if>

</div>


<%@ include file="/WEB-INF/template/footer.jsp" %>