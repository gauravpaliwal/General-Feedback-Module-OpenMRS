<%@ include file="local_header.jsp"%>

<openmrs:hasPrivilege privilege="Admin Feedback">    
    
<h2><spring:message code="feedback.editStatus"/></h2>

<b class="boxHeader"><spring:message code="feedback.statuses"/></b>
<div class="box" >

<c:if test="${not empty statuses.status}"> 
    
<form method="post">

    <table cellpadding="2" cellspacing="0">
        <tr>
            <th width="200"><spring:message code="feedback.status"/></th>
        </tr>
        <tr  class="evenRow">
            <td> <input type="text" name="status" value="${statuses.status}" size="50"  /> </td>
        </tr>    
        <tr>
            <td>
                <input type=hidden name=feedbackStatusId value=<c:out value="${statuses.feedbackStatusId}"/>>
                <input type=hidden name=save value="1">
                <input type="submit" value="<spring:message code="general.save"/>" />
</form>    
            </td>
            <td>
                <form method="post">
                    <input type=hidden name=feedbackStatusId value=<c:out value="${statuses.feedbackStatusId}"/>>
                    <input type=hidden name=delete value="1">
                    <input type="submit" value="Delete" />
                </form> 
            </td>
        </tr>    
    </table> 

</c:if>
</div>

<br/>
</openmrs:hasPrivilege>


<%@ include file="/WEB-INF/template/footer.jsp" %>