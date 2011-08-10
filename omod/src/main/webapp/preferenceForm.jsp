<%@ include file="local_header.jsp"%>

<openmrs:hasPrivilege privilege="Add Feedback,Admin Feedback">

<h2><spring:message code="feedback.userPreference"/></h2>

<form method="post">
    <div class="box" >
        <table>
        <tr>
            <td><spring:message code="feedback.userPreference.email"/></td>
            <td>
                    <input type="text" name="email" size="50" value="${feedback_email}"/>
            </td>
        </tr>
        <tr>
            <td><spring:message code="feedback.userPreference.notification.receipt"/></td>
            <td>
                <input type="radio" name="notificationReceipt" value="Yes" <c:if test="${feedback_notificationReceipt == 'Yes'}">checked</c:if>> Yes
                <input type="radio" name="notificationReceipt" value="No"  <c:if test="${feedback_notificationReceipt == 'No'}">checked</c:if>> No
            </td>
        </tr>
        <tr>
            <td><spring:message code="feedback.userPreference.notification.followup"/></td>
            <td>
                <input type="radio" name="notificationFollowup" value="Yes"  <c:if test="${feedback_notificationFollowup == 'Yes'}">checked</c:if>> Yes
                <input type="radio" name="notificationFollowup" value="No"  <c:if test="${feedback_notificationFollowup == 'No'}">checked</c:if>> No
            </td>
        </tr>
        <tr>
            <td>
                    <input type="submit" value="Save" />
            </td>
        </tr>
        </table>
    </div>
</form>
</openmrs:hasPrivilege>


<%@ include file="/WEB-INF/template/footer.jsp" %>