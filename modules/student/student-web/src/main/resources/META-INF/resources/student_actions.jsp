<%@include file="init.jsp" %>

<%
String mvcPath = ParamUtil.getString(request, "mvcPath");

ResultRow row = (ResultRow)request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);

Student student = (Student)row.getObject(); 
%>

<liferay-ui:icon-menu>

        <portlet:renderURL var="editStudentURL">
            <portlet:param name="studentId"
                value="<%= String.valueOf(student.getStudentId()) %>" />
            <portlet:param name="mvcPath" value="/edit_student.jsp" />
        </portlet:renderURL>

        <liferay-ui:icon image="edit" message="Edit"
            url="${editStudentURL}" />

        <portlet:actionURL name="deleteStudent" var="deleteStudentURL">
            <portlet:param name="studentId"
                value="<%= String.valueOf(student.getStudentId()) %>" />
        </portlet:actionURL>

        <liferay-ui:icon image="close" message="Delete" url="${deleteStudentURL}" />
        
        <liferay-security:permissionsURL
			modelResource="<%= Student.class.getName() %>"
			modelResourceDescription="<%= student.getName() %>"
			resourcePrimKey="<%= String.valueOf(student.getStudentId()) %>"
			var="permissionsURL" />

    	<liferay-ui:icon image="permissions" message="Permissions" url="${permissionsURL}" />
        

</liferay-ui:icon-menu>