<%@ include file="local_header.jsp"%>

<openmrs:hasPrivilege privilege="Admin Feedback">
    
<%@ taglib prefix="kc" tagdir="/WEB-INF/tags/module/feedback/"%>
<openmrs:htmlInclude file="/moduleResources/feedback/demo_table_jui.css" />
<openmrs:htmlInclude file="/moduleResources/feedback/jquery.dataTables.min.js" />


<script type="text/javascript">
	$j(document).ready(function() {
		$j('#table').dataTable( {
		"bFilter": true,
		"iDisplayLength": 15,
		"bProcessing": true,
		"bJQueryUI": true,
		"sPaginationType": "full_numbers",
		"aaSorting": [[ 5, "desc" ]],
		"aoColumns": [ 
		   	  { "bSearchable": true,
			    "bVisible":    true },
			  { "bSearchable": true,
			    "bVisible":    true },
			  { "bSearchable": true,
			    "bVisible":    true },
			  { "bSearchable": true,
			    "bVisible":    true },
			  { "bSearchable": true,
			    "bVisible":    true } ,
			  { "bVisible":    false } ,
		]

	} );
	} );
</script>

<h2><spring:message code="feedback.manageFeedback"/></h2>


    <b class="boxHeader"><spring:message code="feedback.submit"/></b>
    <div class="box" >

        <table cellspacing="0" cellpadding="2" id="table" class="display">
    <thead>
            <tr>
                <th width="300"><spring:message code="feedback.creator"/></th>
                <th width="400"><spring:message code="feedback.subject"/></th>
                <th width="300"><spring:message code="feedback.severity"/></th>
                <th width="400"><spring:message code="feedback.status"/></th>
                <th width="400"><spring:message code="feedback.dateCreated"/></th>
                <th width="400"><spring:message code="feedback.dateCreated"/></th>
            </tr>
    </thead>
    <tbody> 
            <c:forEach items="${feedbacks}" var="feedbackObj" varStatus="loopStatus">
                <tr class="">
                    <td><c:out value="${feedbackObj.creator.personName} "/> </td>
                    <td><a href="<openmrs:contextPath/>/module/feedback/feedback.form?feedbackId=<c:out value="${feedbackObj.feedbackId}"/>"><c:out value="${feedbackObj.subject} "/> </td>
                    <td><c:out value="${feedbackObj.severity} "/> </td>
                    <td><c:out value="${feedbackObj.status} "/> </td>
                    <td><kc:prettyTime date="${feedbackObj.dateCreated}"></kc:prettyTime></td>          
                    <td>${feedbackObj.dateCreated}</td>                            
                </tr>      
            </c:forEach>   

    </tbody> 
        </table>
   </div>
</openmrs:hasPrivilege>


<%@ include file="/WEB-INF/template/footer.jsp" %>