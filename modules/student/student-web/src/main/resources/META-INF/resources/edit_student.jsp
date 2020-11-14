<%@ include file="init.jsp" %>

<% 

long studentId = ParamUtil.getLong(renderRequest, "studentId");
Student student = null;
if (studentId > 0) {
	student = StudentLocalServiceUtil.getStudent(studentId);
}


%>

<portlet:renderURL var="viewURL">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>


<portlet:actionURL name="addStudent" var="addStudentURL" />

<aui:form action="${addStudentURL}" name="<portlet:namespace />fm">

<aui:model-context bean="<%=student %>" model="<%= Student.class %>" />

	<aui:fieldset>

		<aui:input name="name" placeholder="Enter Name">
			<aui:validator name="required" />
		</aui:input>
		<aui:input name="email" placeholder="Enter Email">
            <aui:validator name="required" />
		</aui:input>
		<aui:input name="age" placeholder="Age">
			<aui:validator name="required" />
			<aui:validator errorMessage="Please enter your correct age." 
				name="range">[10,100]</aui:validator>
		</aui:input>
		<aui:input name="studentId" type="hidden" value="<%= student == null ? String.valueOf(studentId) : String.valueOf(student.getStudentId()) %>"  />

	</aui:fieldset>

	<aui:button-row>

		<aui:button type="submit"></aui:button>
		 <aui:button onClick="${viewURL}" type="cancel" value="Back"></aui:button>
	</aui:button-row>
</aui:form>