<%@ include file="local_header.jsp"%>

<script type="text/javascript">
	$j(document).ready(function() {
        colorVisibleTableRows("table", "white", "whitesmoke");              
	});
</script>

<openmrs:hasPrivilege privilege="Add Feedback">

<h2><spring:message code="feedback.forward"/></h2>

<form method="post" action="https://tickets.openmrs.org/secure/CreateIssueDetails!init.jspa">
    <b class="boxHeader"><spring:message code="feedback"/></b>
    <div class="box" >
        <table id="table">
	    <tr>
	    </tr>
            <tr>
                <th width="400"><spring:message code="feedback.subject"/></th>
                <td><input type="text" name="summary" value=<c:out value="${feedback.subject}"/> /> </td>
            </tr>        
            <tr>
                <th width="400"><spring:message code="feedback.content"/></th>
                <td> <textarea rows="20" cols="140" name="description"> <c:out value="${feedback.content}"/>  </textarea> </td>              
            </tr>
	    <input type="hidden" value="10000" name="pid" > 
	    <input type="hidden" value="Create" name="Create" > 
 	    <input type="hidden" value="1" name="issuetype" > 
            <tr>
		<td>
		</td>
		<td>
		<input type=submit name="submit" value="<spring:message code="general.submit"/>">
		</td>
            </tr>
	</div> 
        </table>
        </form>            
   </div>
                
</openmrs:hasPrivilege>

<%@ include file="/WEB-INF/template/footer.jsp" %>
