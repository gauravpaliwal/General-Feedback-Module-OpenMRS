<%@ include file="local_header.jsp"%>
    <script type="text/javascript">
	$j(document).ready(function() {
        colorVisibleTableRows("table", "white", "whitesmoke");              
	});
    </script>

<openmrs:hasPrivilege privilege="Add Feedback">

<h2><spring:message code="feedback.manageFeedback"/></h2>

<div id="feedbackPhotoDialog">
<img src="<openmrs:contextPath/>/moduleServlet/feedback/fileDownloadServlet?feedbackId=<c:out value="${feedback.feedbackId}"/>" >
</div>


<form method="post">
    <b class="boxHeader"><spring:message code="feedback.submit"/></b>
    <div class="box" >
        <table id="table">
	    <tr>
	    </tr>
            <tr>
                <th width="100"><spring:message code="feedback.feedbackId"/></th>
                <td><c:out value="${feedback.feedbackId} "/> </td>
            </tr>

            <tr>
                <th width="300"><spring:message code="feedback.creator"/></th>
                <td><c:out value="${feedback.creator} "/> </td>
            </tr>

            <tr>
                <th width="400"><spring:message code="feedback.subject"/></th>
                <td><c:out value="${feedback.subject} "/> </td>
            </tr>

            <tr>    
            <th width="300"><spring:message code="feedback.severity"/></th>
            <td><c:out value="${feedback.severity} "/> </td>
            </tr>
           
            <tr>
                <th width="400"><spring:message code="feedback.dateCreated"/></th>
                <td><openmrs:formatDate date="${feedback.dateCreated}" type="long" /></td>    
            </tr> 
         
            <tr>
                <th width="400"><spring:message code="feedback.content"/></th>
                <td><c:out value="${feedback.content}"/> </td>              
            </tr>

            <tr>
                <th width="400"><spring:message code="feedback.message"/></th>
                <td><a href="javascript:fdbkPhotoPopUp()" > <img src="<openmrs:contextPath/>/moduleServlet/feedback/fileDownloadServlet?feedbackId=<c:out value="${feedback.feedbackId}"/>" height="100" width="100"></img> </a></td>
            </tr>
            
            <c:if test="${empty feedback.status}">
            <tr >
                <th width="400"><spring:message code="feedback.status"/></th>
                <td>            
                    <select name="status">
                        <c:forEach items="${statuses}" var="statusObj" >
                            <option value="<c:out value="${statusObj.status}"/>"> <c:out value="${statusObj.status}"/> </option>      
                        </c:forEach>
                    </select> 
                </td>
            </tr>
            
            <tr>
                <th valign="top"><spring:message code="feedback.comment"/> </th>
                <td><textarea name="comment" rows="10" cols="120" type="_moz" size="35"></textarea> </td>
            </tr>
            
            </c:if>
            
            <c:if test="${!empty feedback.status}">
            <tr >
                <th width="400"><spring:message code="feedback.status"/></th>
                <td>            
                    <c:out value="${feedback.status}"/>      
                </td>
            </tr>            
            <tr>
                <th valign="top"><spring:message code="feedback.comment"/> </th>
                <td><c:out value="${feedback.comment}"/></td>
            </tr>
            </c:if>
 
	<tr>            
        <td>
	</td>
	<td>
	    <c:if test="${empty feedback.status}">          
            <input type=hidden name=feedbackId value= <c:out value="${feedback.feedbackId}"/> >
            <input type="submit" value="<spring:message code="feedback.comment" />" />                
            </c:if>
          <openmrs:hasPrivilege privilege="Admin Feedback">
	    <form method="post"> 
                <input type=hidden name=delete value= "1"/> 
                <input type=hidden name=feedbackId value="${feedback.feedbackId}"/> 
                <input type="submit" value="Delete" />            
            </form>
          </openmrs:hasPrivilege> 
	</td>

  	</tr>              
        </table>
            	</form>
   </div>
                
</openmrs:hasPrivilege>

<%@ include file="/WEB-INF/template/footer.jsp" %>