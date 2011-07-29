<%@ include file="local_header.jsp"%>    


<h2><spring:message code="feedback.editSeverity"/></h2>

<b class="boxHeader"><spring:message code="feedback.severities"/></b>

<div class="box" >
<c:if test="${empty feedbackPageMessage}"> 

    <form method="post">
        <input type=hidden name=feedbackSeverityId value= <c:out value="${severity.feedbackSeverityId}"/> >
    <table>
        <tr>
            <th width="200"><spring:message code="feedback.severity"/></th>
        </tr>
        <tr  class="evenRow">
            <td><input type="text" name="severity" value="${severity.severity}"  size="50" /></td>
        </tr>
        <tr>    
            <td>
                <input type=hidden name=save value="1">
                <input type="submit" value="Save" />
            </td>
    </form>
            <td>
                <form method="post">
                    <input type=hidden name=feedbackSeverityId value= <c:out value="${severity.feedbackSeverityId}"/> >
                    <input type=hidden name=delete value="1">
                    <input type="submit" value="Delete" />
                </form>
            </td>        
        </tr>
    </table> 
</c:if>

</div>
        
        
<%@ include file="/WEB-INF/template/footer.jsp" %>