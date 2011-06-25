<%@ include file="local_header.jsp"%>

<h2><spring:message code="feedback.manageFeedback"/></h2>

<form method="post">
    <b class="boxHeader"><spring:message code="feedback.submit"/></b>
    <div class="box" >
        <table>

            <tr class="oddRow">
                <th width="100"><spring:message code="feedback.feedbackId"/></th>
                <td><c:out value="${feedback.feedbackId} "/> </td>
            </tr>
            <tr class="evenRow">
                <th width="300"><spring:message code="feedback.creator"/></th>
                <td><c:out value="${feedback.creator} "/> </td>
            </tr>
            <tr class="oddRow">
                <th width="400"><spring:message code="feedback.subject"/></th>
                <td><c:out value="${feedback.subject} "/> </td>
            </tr>
            <tr class="evenRow">    
            <th width="300"><spring:message code="feedback.severity"/></th>
            <td><c:out value="${feedback.severity} "/> </td>
            </tr>
           
            <tr class="oddRow">
                <th width="400"><spring:message code="feedback.dateCreated"/></th>
                <td><c:out value="${feedback.dateCreated} "/> </td>    
            </tr>          
            <tr class="evenRow">
                <th width="400"><spring:message code="feedback.content"/></th>
                <td><c:out value="${feedback.content}"/> </td>              
            </tr>
            <c:if test="${empty feedback.status}">
            <tr class="oddRow">
                <th width="400"><spring:message code="feedback.status"/></th>
                <td>            
                    <select name="status">
                        <c:forEach items="${status}" var="statusObj" >
                            <option value="<c:out value="${statusObj.status}"/>"> <c:out value="${statusObj.status}"/> </option>      
                        </c:forEach>
                    </select> 
                </td>
            </tr>
            
            <tr class="evenRow">
                <th valign="top"><spring:message code="feedback.comment"/> </th>
                <td><textarea name="comment" rows="10" cols="120" type="_moz" size="35"></textarea> </td>
            </tr>
            
            </c:if>
            
            <c:if test="${!empty feedback.status}">
            <tr class="oddRow">
                <th width="400"><spring:message code="feedback.status"/></th>
                <td>            
                    <c:out value="${feedback.status}"/>      
                </td>
            </tr>            
            <tr class="evenRow">
                <th valign="top"><spring:message code="feedback.comment"/> </th>
                <td><c:out value="${feedback.comment}"/></td>
            </tr>
            </c:if>
 
        </table>
            
        <c:if test="${empty feedback.status}">          
            <input type=hidden name=feedbackId value= <c:out value="${feedback.feedbackId}"/> >
            <input type="submit" value="<spring:message code="feedback.comment" />" />                
        </c:if>
                
   </div>
</form>

<%@ include file="/WEB-INF/template/footer.jsp" %>