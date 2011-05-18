<%@ include file="/WEB-INF/template/include.jsp" %>

<openmrs:require privilege="View Hello World" otherwise="/login.htm" redirect="/module/helloworld/viewHelloWorld.htm" />
	
<%@ include file="/WEB-INF/template/header.jsp" %>

<br/>

<openmrs:globalProperty key="helloworld.repeatNumber" var="repeatNum" />

<c:forEach begin="1" end="${repeatNum}">
	<spring:message code="helloworld.helloWorld"/> <br/>
</c:forEach>
        
        
<br/>

<%@ include file="/WEB-INF/template/footer.jsp" %>