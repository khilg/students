<%@ include file="init.jsp" %>

<style>
.modal {
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}
.modal-content {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 60%;
  border-radius:5px;
}
.modal-content-text {
  background-color: #fefefe;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 40%;
  border-radius:5px;
}
#closeText{
cursor: pointer;
}
span.fa.fa-chevron-right::After{
content:">" ;
}
span.fa.fa-chevron-left::After{
content:"<";
}
</style>
Monthly calander
<div id="calendar">
</div>
<div id="myModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content">
    <span class="close">&times;</span>
    <form id="eventForm" action="">
    <div class="form-row">
		  <div class="form-group col-md-6">
		    <label for="startDate">Start Date:</label>
		    <input type="date" class="form-control" id="startDate" name="startDate" required />
		  </div>
		   <div class="form-group col-md-6" id="startDateTimeDiv" >
		    <label for="endDate">Start Time:</label>
		    <input type="time" class="form-control" id="startDateTime" name="startDateTime" required="required" />
		  </div>
		  <div class="form-group col-md-6">
		    <label for="endDate">End Date:</label>
		    <input type="date" class="form-control" id="endDate" name="endDate" required="required" />
		  </div>
		  <div class="form-group col-md-6" id="endDateTimeDiv">
		    <label for="endDate">End Time:</label>
		    <input type="time" class="form-control" id="endDateTime" name="endDateTime" required="required" />
		  </div>
		  <div class="form-group col-md-12">
		    <label for="eventName">Event Name:</label>
		    <input type="text" class="form-control" id="eventName" name="eventName" required />
		  </div>
		  <div class="form-group col-md-12">
		    <label for="eventDescription">Event Description:</label>
		    <textarea class="form-control" id="eventDescription" name="eventDescription" rows="3"></textarea>
		  </div>
	</div>
		  <div class="form-group">
		    <div class="form-check">
		      <input class="form-check-input" type="checkbox" id="allDayCheck" name="allDayCheck">
		      <label class="form-check-label" for="allDayCheck">
		        All Day
		      </label>
		    </div>
 		 </div>
 		 
		  <button type="submit" id="eventSubmit" class="btn btn-primary">Submit</button>
		</form>
  </div>

</div>

<div id="deleteModal" class="modal">

  <!-- Modal content -->
  <div class="modal-content-text">
    <span id="closeText">&times;</span>
    <div class="dispText">
    <div class="py-3">
    Event Name :<span class="eventNameText"></span>
    </div>
    <div class="py-3">
    When :<span class="whenText"></span>
    </div>
    </div>
    <button type="submit" id="deleteEvent" class="btn btn-primary">Delete</button>
</div>
</div>

<%-- <portlet:resourceURL  id="/get/events" var="getEventsUrl" >
<portlet:param name="mvcPath" value="Blank"/>
</portlet:resourceURL>  --%>

<liferay-portlet:resourceURL id="/get/events" var="getEventsUrl" copyCurrentRenderParameters="false" />
<portlet:resourceURL  id="/add/event" var="addEventUrl" >
<portlet:param name="mvcPath" value="Blank"/>
</portlet:resourceURL>
<portlet:resourceURL  id="/delete/event" var="deleteEventUrl" />


<script>


$( function() {
	
	getEvents();
	
	function addEvent(startDate,endDate,eventName,eventDescription){
		
		 $.ajax({
			   type : 'POST',
	           url : "${addEventUrl}",
	           data : {
	             ["<portlet:namespace />startDate"] : startDate,
	             ["<portlet:namespace />endDate"] : endDate,
	             ["<portlet:namespace />eventName"] : eventName,
	             ["<portlet:namespace />eventDescription"] : eventDescription,
	             
	           },
	           success : function(resp) {
	        	   getEvents();
	           },error: function (error) {
					console.log("error...", error);	
	           }
	    }); 
	}
	function deleteEvent(id){
		$.ajax({
			   type : 'POST',
	           url : "${deleteEventUrl}",
	           data : {
	             ["<portlet:namespace />id"] : id,
	           },
	           success : function(resp) {
	        	   getEvents();
	           },error: function (error) {
					console.log("error...", error);	
	           }
	    }); 
	}
	function getEvents(){
		
		$.ajax({
			   type : 'GET',
	           url : "${getEventsUrl}",
	           dataType:"json",
	           data : {
	           },
	           success : function(resp) {
	                var eventsList = resp;
	                renderCalander(eventsList);
	                console.log(eventsList);
	           },error: function (error) {
					console.log("error...", error);	
	           }
	    }); 
		<%-- AUI().use('aui-io-request', function(A){
			A.io.request('<%= getEventsUrl.toString()%>', {
				method: 'post',
				dataType : "json",
				cache: true,
				data: {
			 	},
				on: {
					success: function() {
						var responseData = this.get('responseData');
		                renderCalander(responseData);
						console.log("responseData :: " +responseData);
						
					},
					error: function(){
						alert("Error occured on server.");
					}
				}
	        });
	    }); --%>
	}

	 $('input[type="checkbox"]').click(function(){
			 if ($('#allDayCheck').is(':checked')) {
			 $("#startDateTimeDiv").hide();
	   	 	 $("#endDateTimeDiv").hide();
	   	 	 $("#startDateTime").val("");
	  	     $("#endDateTime").val("");
			 }else{
				 $("#startDateTimeDiv").show();
		   	 	 $("#endDateTimeDiv").show();
			 }
		 });
	
	function renderCalander(eventsList){
		  var calendarEl = document.getElementById('calendar');

		  var calendar = new FullCalendar.Calendar(calendarEl, {
			navLinks: true,
		    initialView: 'dayGridMonth',
		    timeZone: 'IST',
		    themeSystem: 'bootstrap',
		    headerToolbar: {
		      left: 'prev,today,next addEventButton',
		      center: 'title',
		      right: 'dayGridMonth,dayGridWeek,dayGridDay'
		    },
		    weekNumbers: true,
		    customButtons: {
		      addEventButton: {
		        text: 'Add Event',
		        click: function() {
		          var modal = document.getElementById("myModal");
		          var span = document.getElementsByClassName("close")[0];
		          var eventSubmit = document.getElementById("eventSubmit");
		          modal.style.display = "block";
		          span.onclick = function() {
		        	  modal.style.display = "none";
		        	  document.getElementById("eventForm").reset();
		        	}
		          eventSubmit.onclick = function(e) {
		        	  e.preventDefault();
		        	  var startDate = $("#startDate").val();
		        	  var endDate = $("#endDate").val();
		        	  var eventName = $("#eventName").val();
		        	  var eventDescription = $("#eventDescription").val();
		        	  var startDateTime = $("#startDateTime").val();
		        	  var endDateTime = $("#endDateTime").val();
		        	  startDate = startDate +"T" + startDateTime;
		        	  endDate = endDate + "T" + endDateTime;
		        	  if(startDate != "" && endDate != "")
		        	  	addEvent(startDate,endDate,eventName,eventDescription);
		        	  
		        	  modal.style.display = "none";
		        	  document.getElementById("eventForm").reset();
		        	}
		        }
		      }
		    },
		    eventClick: function(info) {
		        var eventObj = info.event;
		        var deleteModal = document.getElementById("deleteModal");
		        var span = document.getElementById("closeText");
		        deleteModal.style.display = "block";
		        $(".eventNameText").html(eventObj.title);
		        $(".whenText").html(eventObj.start);
		          span.onclick = function() {
		        	  deleteModal.style.display = "none";
		        	}
		          var deleteEvent = document.getElementById("deleteEvent");
		          deleteEvent.onclick = function() {
		        	  console.log(eventObj.id);
		        	  //deleteEvent(eventObj.id);
		        	  $.ajax({
							   type : 'POST',
					           url : "${deleteEventUrl}",
					           data : {
					             ["<portlet:namespace />id"] : eventObj.id,
					           },
					           success : function(resp) {
					        	   getEvents();
					           },error: function (error) {
									console.log("error...", error);	
					           }
	    				}); 
		        	  deleteModal.style.display = "none";
		        	}
		        
		      },
		    eventDidMount: function(info) {
		    	$(info.el).tooltip({ 
		          title: info.event.extendedProps.description,
		          placement: 'top',
		          trigger: 'hover',
		          container: 'body'
		        });
		      },
		    events: eventsList,
		  });

		  calendar.render();
		
	}
});
</script>