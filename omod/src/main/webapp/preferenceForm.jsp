<%@ include file="local_header.jsp"%>

<openmrs:hasPrivilege privilege="Add Feedback,Admin Feedback">

<h2><spring:message code="feedback.userPreference"/></h2>

<form method="post">
    <div class="box" >
        <table>
        <tr>
            <td><spring:message code="feedback.userPreference.email"/></td>
            <td>
                    <input type="text" name="email" size="30" value="${feedback_email}"/>
            </td>
        </tr>
        <tr>
            <td><spring:message code="feedback.userPreference.notification.receipt"/></td>
            <td>
                <label for="radio1"><spring:message code="general.yes"/></label>
                <input id="radio1" type="radio" name="notificationReceipt" value="<spring:message code="general.yes"/>" <c:if test="${feedback_notificationReceipt == 'Yes'}">checked</c:if>>
                <label for="radio2"><spring:message code="general.no"/></label>
                <input id="radio2" type="radio" name="notificationReceipt" value="<spring:message code="general.no"/>" <c:if test="${feedback_notificationReceipt == 'No'}">checked</c:if>>
            </td>
        </tr>
        <tr>
            <td><spring:message code="feedback.userPreference.notification.followup"/></td>
            <td>
                <label for="radio3"><spring:message code="general.yes"/></label>
                <input type="radio" id="radio3" name="notificationFollowup" value="<spring:message code="general.yes"/>" <c:if test="${feedback_notificationFollowup == 'Yes'}">checked</c:if>>
                <label for="radio4"><spring:message code="general.no"/></label>
                <input type="radio" id="radio4" name="notificationFollowup" value="<spring:message code="general.no"/>" <c:if test="${feedback_notificationFollowup == 'No'}">checked</c:if>>
            </td>
        </tr>
        <tr>
            <td>
                    <input type="submit" value="<spring:message code="general.save"/>" />
            </td>
        </tr>
        </table>
    </div>
</form>
</openmrs:hasPrivilege>


<%@ include file="/WEB-INF/template/footer.jsp" %>