<%@ include file="local_header.jsp"%>

<openmrs:hasPrivilege privilege="Admin Feedback">    
<h2><spring:message code="feedback.editPredefinedSubject"/></h2>

<b class="boxHeader"><spring:message code="feedback.predefinedsubjects"/></b>

<div class="box" >
<c:if test="${empty feedbackPageMessage}"> 
    <table>
        
        <form method="post">

            <tr class="evenRow">
            	<td width="200"><spring:message code="feedback.predefinedSubject"/></td>
                <td><input type="text" name="predefinedsubject"  size="50"  value="${predefinedsubjects.subject}"/></td>
            </tr>
            <tr class="oddRow">
            	<td width="200"><spring:message code="feedback.sortWeight"/></td>
                <td><input type="text" name="sortWeight"  size="50"  value="${predefinedsubjects.sortWeight}"/></td>
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

</br>
<b class="boxHeader"><spring:message code="feedback.predefinedsubject.help.heading"/></b>
<div class="box">
    	<ul>
		<li><i><spring:message code="feedback.predefinedsubject.help.l1"/></i></li>
		<li><i><spring:message code="feedback.predefinedsubject.help.l2"/></i></li>
                <li><i><spring:message code="feedback.predefinedsubject.help.l3"/></i></li>
                <li><i><spring:message code="feedback.predefinedsubject.help.l4"/></i></li>
                <li><i><spring:message code="feedback.predefinedsubject.help.l5"/></i></li>
                <li><i><spring:message code="feedback.predefinedsubject.help.l6"/></i></li>

        </ul>
</div>
</openmrs:hasPrivilege>


<%@ include file="/WEB-INF/template/footer.jsp" %>