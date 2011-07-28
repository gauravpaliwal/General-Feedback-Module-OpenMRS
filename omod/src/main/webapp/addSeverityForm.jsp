<%@ include file="local_header.jsp"%>

<h2><spring:message code="feedback.addSeverity"/></h2>

<form method="post">
    
	<spring:message code="feedback.addSeverity"/>: 
	<input type="text" name="severity" value="" />
	
	<br/><br/>
	
	<input type="submit" value="<spring:message code="feedback.addSeverity" />" />
        
</form>
        
<br/>

<b class="boxHeader"><spring:message code="feedback.severities"/></b>
<div class="box" >
    <table>
        <tr>
            <th width="400"><spring:message code="feedback.severity"/></th>
        </tr>
        <c:forEach items="${severities}" var="severityObj"  varStatus="loopStatus">
            <tr class="${loopStatus.index % 2 == 0 ? 'evenRow' : 'oddRow'}">
                <td><a href="<openmrs:contextPath/>/module/feedback/severity.form?feedbackSeverityId=<c:out value="${severityObj.feedbackSeverityId} "/>"><c:out value="${severityObj.severity} "/></a></td>       
            </tr>    
        </c:forEach>
    </table> 
</div>
</br>
<b class="boxHeader"><spring:message code="feedback.severity.help.heading"/></b>
<div class="box">
    	<ul>
		<li><i><spring:message code="feedback.severity.help.l1"/></i></li>
		<li><i><spring:message code="feedback.severity.help.l2"/></i></li>
                <li><i><spring:message code="feedback.severity.help.l3"/></i></li>
                <li><i><spring:message code="feedback.severity.help.l4"/></i></li>
        </ul>
</div>


<%@ include file="/WEB-INF/template/footer.jsp" %>