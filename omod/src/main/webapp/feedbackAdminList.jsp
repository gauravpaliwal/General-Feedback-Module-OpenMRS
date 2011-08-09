<%@ include file="local_header.jsp"%>
<%@ taglib prefix="kc" tagdir="/WEB-INF/tags/module/feedback/"%>
<openmrs:htmlInclude file="/scripts/jquery/dataTables/css/dataTables.css" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/js/jquery.dataTables.js" />
<openmrs:htmlInclude file="/scripts/jquery/dataTables/css/demo_table_jui.css" />
<openmrs:htmlInclude file="/scripts/jquery-ui/css/redmond/jquery-ui.custom.css" />
<openmrs:htmlInclude file="/moduleResources/feedback/jquery.dataTables.js" />


<script type="text/javascript">
	$j(document).ready(function() {
		$j('#table').dataTable( {
		"bFilter": true,
		"iDisplayLength": 10,
		"bProcessing": true,
		"sDom": 'R<"H"lfr>t<"F"ip<',
		"bJQueryUI": true,
		"sPaginationType": "full_numbers"

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
                </tr>      
            </c:forEach>   

    </tbody> 
        </table>
   </div>


<%@ include file="/WEB-INF/template/footer.jsp" %>