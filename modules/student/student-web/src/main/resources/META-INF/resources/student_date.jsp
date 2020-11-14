<%@include file="init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Student student = (Student)row.getObject(); 

DateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
sdf.setTimeZone(TimeZone.getTimeZone("IST"));
String ISTdate = sdf.format(student.getCreateDate());
%>

<%=ISTdate%>

