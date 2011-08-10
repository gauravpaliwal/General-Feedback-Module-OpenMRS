<%@ include file="local_header.jsp"%>

<script type="text/javascript">
	$j(document).ready(function() {
        colorVisibleTableRows("table", "white", "whitesmoke");              
	});
</script>

<openmrs:hasPrivilege privilege="Add Feedback">

<h2><spring:message code="feedback.manageFeedback"/></h2>

<form method="get">
    <b class="boxHeader"><spring:message code="feedback.submit"/></b>
    <div class="box" >
        <table id="table">
	    <tr>
	    </tr>
            <tr>
                <th width="400"><spring:message code="feedback.subject"/></th>
                <td><input type="text" name="subject" value=<c:out value="${feedback.subject}"/> size="150"></td>
            </tr>        
            <tr>
                <th width="400"><spring:message code="feedback.content"/></th>
                <td> <textarea value="" rows="20" cols="140" name="comment"> <c:out value="${feedback.content}"/>  </textarea> </td>              
            </tr>
	</div> 
        </form>            
        </table>

   </div>
                
</openmrs:hasPrivilege>

<%@ include file="/WEB-INF/template/footer.jsp" %>