<%@ include file="local_header.jsp"%>
<%@ taglib prefix="kc" tagdir="/WEB-INF/tags/module/feedback/"%>
<script>
	$j(document).ready(function() 
	{
		$j('.toggleAddTag').click(function(event) 
		{
			$j('#addTag').slideToggle('fast');
			event.preventDefault();
		});
        		colorVisibleTableRows("table", "white", "whitesmoke");
	});
</script>

<style>
	form {display: inline; }
</style>

<openmrs:hasPrivilege privilege="Add Feedback,Admin Feedback">
<h2>
	<spring:message code="feedback.manageFeedback"/>
</h2>
<div id="feedbackPhotoDialog">
	<img src="<openmrs:contextPath/>/moduleServlet/feedback/fileDownloadServlet?feedbackId=<c:out value="${feedback.feedbackId}"/>" >
</div>

<form method="post"   enctype="multipart/form-data">
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
                <th width="400"><spring:message code="feedback.status"/></th>
                <td> 
		<c:out value="${feedback.status}"/>
		</td>
            </tr>             
            <tr>
                <th width="400"><spring:message code="feedback.dateCreated"/></th>
                <td><openmrs:formatDate date="${feedback.dateCreated}" type="long" /></td>    
            </tr>          
            <tr>
                <th width="400"><spring:message code="feedback.content"/></th>
                <td>
			<a class="toggleAddTag" href="#"><spring:message code="feedback.content.view"/></a>
			<div id="addTag" style="border: 1px black solid; background-color: #e0e0e0; display: none">
				<c:out value="${feedback.content}"/> 
			</div>           
		</td>   
            </tr>
            <tr>
                <th width="400"><spring:message code="feedback.message"/></th>
                <td>
			<a href="javascript:fdbkPhotoPopUp()" > 
			<img src="<openmrs:contextPath/>/moduleServlet/feedback/fileDownloadServlet?feedbackId=<c:out value="${feedback.feedbackId}"/>" height="100" width="100">
			</img> 
			</a>
		</td>
            </tr>
	    <c:forEach items="${comments}" var="commentObj" >
	    <tr>
		<td colspan="2">
             		<c:out value="${commentObj.comment}"/>  
			<div class="description"> 
				<c:if test="${not empty commentObj.attachment}"> 
					<a href="<openmrs:contextPath/>/moduleServlet/feedback/fileDownloadServlet?feedbackCommentId=<c:out value="${commentObj.feedbackCommentId}"/> "> 			
					Attachment
					</a>
				</c:if >
		
				<c:out value="${commentObj.creator.personName}"/>
				<kc:prettyTime date="${commentObj.dateCreated}"></kc:prettyTime>                    
			</div>
		</td>
	    </tr>
            </c:forEach>
          <openmrs:hasPrivilege privilege="Admin Feedback">
            <tr>
                <th width="400"><spring:message code="feedback.status"/></th>
                <td>           
		<form method="post">
		<input type=hidden name=feedbackId value=<c:out value="${feedback.feedbackId}"/> >
                    <select name="status">
                        <c:forEach items="${statuses}" var="statusObj" >
                            <option value="<c:out value="${statusObj.status}"/>"> <c:out value="${statusObj.status}"/> </option>      
                        </c:forEach>
                    </select> 
            	<input type="submit" value="<spring:message code="feedback.status.change" />" />  
		</form>              
                </td>

            </tr>
          </openmrs:hasPrivilege>
           <tr>
            	<th><spring:message code="feedback.attachment"/> </th>
            	<td><input type="file" accept="image" name="file" size="40" > </input> 
		<div class="description"> 
			<spring:message code="feedback.attachment.comment.mandatory"/>
		</div>

		</td>   
            </tr>
            <tr>
                <th valign="top"><spring:message code="feedback.comment"/> </th>
                <td><textarea name="comment" rows="10" cols="120" type="_moz" size="35"></textarea> </td>
            </tr>
          
        <td>
	</td>
	<td>
            <input type=hidden name=feedbackId value=<c:out value="${feedback.feedbackId}"/> >
            <input type="submit" value="<spring:message code="feedback.comment" />" />                
            </form>

          <openmrs:hasPrivilege privilege="Admin Feedback">
	    <form method="post"> 
                <input type=hidden name=delete value= "1"/> 
                <input type=hidden name=feedbackId value="${feedback.feedbackId}"/> 
                <input type="submit" value="<spring:message code="general.delete"/>" />   
            </form>   
	    <form method="post" action="<openmrs:contextPath/>/module/feedback/forwardFeedback.form"> 
                <input type=hidden name=feedbackId value="${feedback.feedbackId}"/> 
                <input type="submit" value="<spring:message code="feedback.forward"/>" />            
            </form>
	</td>
          </openmrs:hasPrivilege> 
	</div>
	</td>
  	</tr>              
        </table>

   </div>
                
</openmrs:hasPrivilege>

<%@ include file="/WEB-INF/template/footer.jsp" %>