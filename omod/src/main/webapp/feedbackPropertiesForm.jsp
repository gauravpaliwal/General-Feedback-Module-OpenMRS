<%@ include file="local_header.jsp"%>
<openmrs:hasPrivilege privilege="Admin Feedback">
<h2><spring:message code="feedback.admin.properties"/></h2>

<form method="post" >
<b class="boxHeader"><spring:message code="feedback.admin.properties.edit"/></b>
    <div class="box" >
        <table>
	<tr>
            <td valign="top"><spring:message code="feedback.admin.properties.notification.email"/> </td>
            <td><input type="text" name="feedbackNotificationEmail" size="80" value="<openmrs:globalProperty key="feedback.notification.email"/>"></td>
        </tr>
        <tr>
            <td valign="top"><spring:message code="feedback.admin.properties.notification"/> </td>
            <td><textarea name="feedbackNotification" rows="10" cols="120" type="_moz" size="35" ><openmrs:globalProperty key="feedback.notification"/></textarea> </td>
        </tr>  
	<tr>
            <td valign="top"><spring:message code="feedback.admin.properties.admin.notification.email"/> </td>
            <td><input type="text" name="feedbackAdminNotificationEmail" size="80" value="<openmrs:globalProperty key="feedback.admin.notification.email"/>"></td>
        </tr>
	<tr>
            <td valign="top"><spring:message code="feedback.admin.properties.admin.notification"/> </td>
            <td><textarea name="feedbackAdminNotification" rows="10" cols="120" type="_moz" size="35" ><openmrs:globalProperty key="feedback.admin.notification"/></textarea> </td>
        </tr> 
	<tr>
            <td valign="top"><spring:message code="feedback.admin.properties.ui.notification"/> </td>
            <td><textarea name="feedbackUiNotification" rows="10" cols="120" type="_moz" size="35" ><openmrs:globalProperty key="feedback.ui.notification"/></textarea> </td>
        </tr> 

        <tr>
            <td> </td>            
            <td> 
                <input type="submit" value="<spring:message code="general.save"/>" />
            </td>            
        </tr>
        </table>
    </div>
    
</openmrs:hasPrivilege>


<%@ include file="/WEB-INF/template/footer.jsp" %>    