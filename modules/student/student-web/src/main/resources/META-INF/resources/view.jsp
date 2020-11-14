<%@ include file="init.jsp" %>

<style>
.alert-notifications-fixed {
     position: fixed;
     top: 5rem;
     left: 2.5rem;
    }
#upload_file::-webkit-file-upload-button{
visibility: hidden;
}
#upload_file::before{
     content: "Upload";
     border: 1px solid lightgrey;
     border-radius: 6px;
     outline: none;
     font-size: 18px;
     padding : 5px 18px;
}
#upload_file{
    position:relative;
    top:1.2rem;
    outline: none;
    cursor: pointer;
    padding: 5px;
}
</style>

<liferay-ui:success key="studentAdded" message="student-added" />
<liferay-ui:success key="studentUpdated" message="student-updated" />
<liferay-ui:success key="studentDeleted" message="student-deleted" />
<liferay-ui:error key="studentActionException" message="student-action-error" />
<liferay-ui:error key="studentNullPointerException" message="student-nullPointer-error" />
<%

String filterEmail = "";
filterEmail = ParamUtil.getString(renderRequest, "filterEmail");
String searchedName = "";
searchedName = ParamUtil.getString(renderRequest, "searchedName");
 String url =  (String)renderRequest.getAttribute("downloadUrl");
List<Student> studentsByGroupId = StudentLocalServiceUtil.getStudentsByGroupId(scopeGroupId.longValue());
if(filterEmail != ""){
	studentsByGroupId = StudentLocalServiceUtil.findByUserNameEmail("akhil g", filterEmail);
}else if(searchedName != ""){
    studentsByGroupId = StudentLocalServiceUtil.findByName(searchedName+"%");
}else{
	studentsByGroupId = StudentLocalServiceUtil.getStudentsByGroupId(scopeGroupId.longValue());
}

List<SelectOption> selectOptions = new ArrayList<>();

for(Student student : StudentLocalServiceUtil.getStudentsByGroupId(scopeGroupId.longValue())){
	selectOptions.add(new SelectOption(student.getEmail(), String.valueOf(student.getEmail())));
}
%> 
 <aui:nav cssClass="nav-tabs">

 <portlet:renderURL var="calanderPageUrl">
        <portlet:param name="mvcPath" value="/calander.jsp" />
    </portlet:renderURL>


    <aui:nav-item cssClass="active" href="${calanderPageUrl }" label="Calander" />


</aui:nav> 




<portlet:renderURL var="addStudentURL">
 <portlet:param name="mvcPath" value="/edit_student.jsp"></portlet:param>
</portlet:renderURL>

<portlet:actionURL name="/filter/byEmail" var="filterStudentsByEmails" />


<clay:button icon="filter" id="filter_by_email_icon" monospaced="<%= true %>" style="secondary" />

<div class="col-md-3 offset-md-3" id="filter_by_email" style="display:none;">
<aui:form action="${filterStudentsByEmails}" name="<portlet:namespace />fm">
	<clay:select label="Filter By Email" name="<%=curPortletNameSpace+"filterEmail"%>" 
				options="<%= selectOptions %>" />
	<aui:button type="submit"></aui:button>
</aui:form>
</div>
<c:if test='<%= SessionMessages.contains(request, "studentFileUploaded") %>'>
<div class="alert alert-success alert-dismissible fade show" role="alert">
  <strong>Success!</strong> Students File Uploaded successfully.
  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
    <span aria-hidden="true">&times;</span>
  </button>
</div>
<script>
myFunction();
</script>
</c:if>
<div class="row">
<aui:button-row class="col-md-3 py-4">
    <aui:button onClick="${addStudentURL}" value="Add Student"></aui:button>
</aui:button-row>
<a class="px-4" href="http://localhost:6060/documents/20124/146322/studentDetails.xls">
<aui:button-row class="col-md-3 py-4 px-3">
 <aui:button  value="Download XLS" ></aui:button>
</aui:button-row>
</a>

<portlet:actionURL var="uploadURL" name="/students/uploadDocument"></portlet:actionURL>
<aui:form action="${uploadURL}" enctype="multipart/form-data" name="<portlet:namespace />fm">
  <input type="file" name="<portlet:namespace />uploadedFile" id="upload_file" accept=".xls,.xlsx"/>
  <aui:button type="submit"></aui:button>
</aui:form>
</div>
<portlet:actionURL  name="/search/byName" var="searchByNameURL" />
<aui:form  action="${searchByNameURL}" name="<portlet:namespace />fm">
       <div class="row">
        <div class="col-md-6 py-4 px-4">
            <aui:input name="searchName" label="" placeholder="Search Name" size="150" />
        </div>
        <div class="col-md-3 py-4">
            <aui:button  type="submit" value="find" />
        </div>
        </div>
</aui:form>

<liferay-ui:search-container total="<%=StudentLocalServiceUtil.getStudentsCount()%>">
<liferay-ui:search-container-results
    results="<%=studentsByGroupId%>" />

<liferay-ui:search-container-row
    className="com.docs.assignment.student.model.Student" modelVar="student">

    <liferay-ui:search-container-column-text property="email" />

    <liferay-ui:search-container-column-text property="name" />

  	<liferay-ui:search-container-column-text property="age" />

  	<liferay-ui:search-container-column-text property="assignment_status" />
  	
  	<liferay-ui:search-container-column-text name="UTCDate" >
  	<%
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
		String formatedUTCDate = dateFormat.format(student.getCreateDate());
     %>
        <%=formatedUTCDate %>
  	</liferay-ui:search-container-column-text>
  	
  	<liferay-ui:search-container-column-text name="BSTDate">
  	<%
  	DateFormat sdfBst = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a");
  	sdfBst.setTimeZone(TimeZone.getTimeZone("Europe/London"));
  	String BSTDateString = sdfBst.format(student.getCreateDate());
  	%>
  	<%= BSTDateString%>
  	</liferay-ui:search-container-column-text>
  	
  	<liferay-ui:search-container-column-jsp
        align="right" 
        name="ISTDate"
        path="/student_date.jsp" /> 
 
    <liferay-ui:search-container-column-jsp
        align="right" 
        path="/student_actions.jsp" /> 

</liferay-ui:search-container-row>

<liferay-ui:search-iterator />

</liferay-ui:search-container>


<portlet:resourceURL  id="/download/pdf" var="downloadStudentsPdfUrl" />
<portlet:resourceURL  id="/download/xlsx" var="downloadStudentsXlsxUrl" />

<aui:button-row>
    <aui:button onClick="${downloadStudentsXlsxUrl}" value="Download as Excel"></aui:button>
    <aui:button onClick="${downloadStudentsPdfUrl}" value="Download as Pdf"></aui:button>
</aui:button-row>


<portlet:renderURL var="renderUrl">
    <portlet:param name="mvcPath" value="/view.jsp"></portlet:param>
</portlet:renderURL>
<script>
$("#filter_by_email_icon").click(function(){
	$("#filter_by_email").toggle();
	
});
function myFunction() {
	  setTimeout(function(){ $(".alert").alert('close'); }, 4000);
	}

$("#upload_file").on("change",function(){

	var file = document.getElementById("upload_file");
	var fileName = file.value;
    idxDot = fileName.lastIndexOf(".") + 1,
    extFile = fileName.substr(idxDot, fileName.length).toLowerCase();
if (extFile=="xls" || extFile=="xlsx"){
    //TO DO
}else{
    alert("Only xls/Xlsx files are allowed!");
    file.value  ="";
}


    });
/* $("#example").on("click",function(){

    var example = "akhil.g@liferay.com";
    var requestData = {
        ["<portlet:namespace />testExample"] : example,
    }
    $.ajax({
           url : "${exampleUrl}",
           type : 'POST',
           data : {
             ["<portlet:namespace />testExample"] : example
           },
           dataType:"json",
           success : function(data) {
                console.log("Success...");
           }
    });

    }); */
</script>
<!--

<portlet:resourceURL  id="/example/resource" var="exampleUrl" />
<button id="example" >Click me<//button>

<portlet:resourceURL  id="/students/uploadDocument" var="uploadURL" />
<input type="file" name="uploadedFile" id="studentFile" />

$("#studentFile").on("change",function(){

    var formData = new FormData();
    formData.append("<portlet:namespace />uploadedFile", $('#studentFile')[0].files[0]);

    $.ajax({
           url : "${uploadURL}",
           type : 'POST',
           data : formData,
           processData: false,  // tell jQuery not to process the data
           contentType: false,  // tell jQuery not to set contentType
           success : function(data) {

           }
    });

    });
    -->

