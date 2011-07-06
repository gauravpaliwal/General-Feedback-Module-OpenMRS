<%@ include file="local_header.jsp"%>

<h2><spring:message code="feedback.addStatus"/></h2>

<form method="post">

	<spring:message code="feedback.addStatus"/>: 
	<input type="text" name="status" value="" />
	
	<br/><br/>
	
	<input type="submit" value="<spring:message code="feedback.addStatus" />" />

</form>
        
<br/>

<b class="boxHeader"><spring:message code="feedback.statuses"/></b>
<div class="box" >
    <table cellpadding="2" cellspacing="0">
        <tr>
            <th width="400"><spring:message code="feedback.status"/></th>
        </tr>
    <c:forEach items="${statuses}" var="statusObj"  varStatus="loopStatus">
        <tr  class="${loopStatus.index % 2 == 0 ? 'evenRow' : 'oddRow'}">
            <td><a href="<openmrs:contextPath/>/module/feedback/status.form?feedbackStatusId=<c:out value="${statusObj.feedbackStatusId}"/>"><c:out value="${statusObj.status}"/></a></td>   
        </tr>
    </c:forEach>
        
    </table> 
</div>



<%@ include file="/WEB-INF/template/footer.jsp" %>