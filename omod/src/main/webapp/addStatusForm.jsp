<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="Add Hello World Response" otherwise="/login.htm" redirect="/module/feedback/addStatus.form" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<ul id="menu">
                <li class="first">
                        <a href="../../admin/index.htm"><spring:message code="feedback.admin"/></a>
                </li>
                
                <li>
                        <a href="../../module/feedback/addPredefinedSubject.form"><spring:message code="feedback.addPredefinedSubject"/></a>
                </li>
	
		<li >
			<a href="../../module/feedback/addSeverity.form"><spring:message code="feedback.addSeverity"/></a>
		</li>

		<li  class="active">
			<a href="../../module/feedback/addStatus.form"><spring:message code="feedback.addStatus"/></a>
		</li>	
                <li>
			<a href="../../module/feedback/addFeedback.form"><spring:message code="feedback.addFeedback"/></a>
		</li>
                <li>
			<a href="../../module/feedback/feedback.list"><spring:message code="feedback.manageFeedback"/></a>
		</li>
</ul>
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
            <th width="100" ><spring:message code="feedback.index"/></th>
            <th width="400"><spring:message code="feedback.status"/></th>
        </tr>
    <c:forEach items="${statuses}" var="statusObj"  varStatus="loopStatus">
        <tr  class="${loopStatus.index % 2 == 0 ? 'evenRow' : 'oddRow'}">
            <td><c:out value="${statusObj.feedbackStatusId} "/></td>
            <td><a href="/openmrs/module/feedback/status.form?feedbackStatusId=<c:out value="${statusObj.feedbackStatusId}"/>"><c:out value="${statusObj.status}"/></a></td>   
        </tr>
    </c:forEach>
        
    </table> 
</div>



<%@ include file="/WEB-INF/template/footer.jsp" %>