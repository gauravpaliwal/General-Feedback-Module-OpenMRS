<%@ include file="local_header.jsp"%>

<openmrs:hasPrivilege privilege="Admin Feedback">
    
<script>
$j(document).ready(function() {
		$j('.toggleAddTag').click(function(event) {
			$j('#addTag').slideToggle('fast');
			event.preventDefault();
		});
	});
</script>

<h2><spring:message code="feedback.statuses"/></h2>
<a class="toggleAddTag" href="#"><spring:message code="feedback.addStatus"/></a>
<div id="addTag" style="border: 1px black solid; background-color: #e0e0e0; display: none">
<form method="post">
<table>
            <tr>
                <td>
                    <spring:message code="feedback.addStatus"/>: 
                </td>
                <td>
                    <input type="text" name="status" value=""  size="50" />
	
	         </td>
            </tr>
            <tr>
                
            </tr>
            <tr>
                <td></td>
                <td>
                    <input type="submit" value="<spring:message code="general.save"/>" /> <input type="button" value="Cancel" class="toggleAddTag" />
                </td>
            </tr>
</table>
</form>
</div>   
<br/>
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
<br/>
<b class="boxHeader"><spring:message code="feedback.status.help.heading"/></b>
<div class="box">
    	<ul>
		<li><i><spring:message code="feedback.status.help.l1"/></i></li>
		<li><i><spring:message code="feedback.status.help.l2"/></i></li>
                <li><i><spring:message code="feedback.status.help.l3"/></i></li>
                <li><i><spring:message code="feedback.status.help.l4"/></i></li>
                <li><i><spring:message code="feedback.status.help.l5"/></i></li>
        </ul>
</div>
        </openmrs:hasPrivilege>
        
<%@ include file="/WEB-INF/template/footer.jsp" %>