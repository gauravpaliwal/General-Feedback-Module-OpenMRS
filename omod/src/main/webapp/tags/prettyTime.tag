<%@ tag import="com.ocpsoft.pretty.time.PrettyTime"  import="java.util.Date"%>
<%@ attribute name="date" required="true" type="java.util.Date" %>
  
<%
 PrettyTime p = new PrettyTime();
    String prettier = p.format(date);
 out.println(prettier);
%>