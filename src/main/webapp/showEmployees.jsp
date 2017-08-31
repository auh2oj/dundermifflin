<!DOCTYPE html>
<%@page import="com.josh.dundermifflin.web.controller.model.EmployeeForm"%>
<%@page import="java.util.List"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show Profiles</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
     <style type="text/css">
    .bs-example{
    	margin-left:120px;
    }
    
   .parentimage {
	width: 60px;
	height: 60px; 
	-webkit-transition: all .3s ease-out;
	-moz-transition: all .3s ease-out;
	-o-transition: all .3s ease-out;
	transition: all .3s ease-out;
} 
.parentimage:hover {
	-moz-transform: scale(3);
	-webkit-transform: scale(3);
	-o-transform: scale(3);
	-ms-transform: scale(3);
	transform: scale(3);
} 
    
</style>

  <script type="text/javascript">
  			//We are definition function in JavaScript
   			function openPopup(eid) {
  					  $("#pdid").val(eid);
  					  $("#photoTitle").attr("src","findImageByEid.do?eid="+eid);
   					 $("#uploadImagePopup").modal('show');
   			}
  			
   			function editPopup(eid) {
   				
				  $("#edid").val(eid);
				  //This the code to access the value from a row on the basis rowid
				  var eid=$("#"+eid).children("td:nth-child(1)").text();
				  var name=$("#"+eid).children("td:nth-child(2)").text();
				  var email=$("#"+eid).children("td:nth-child(3)").text();
				  var department=$("#"+eid).children("td:nth-child(4)").text();
				  var branch=$("#"+eid).children("td:nth-child(5)").text();
				  
				  //Code to populate the value into the popup form
				  $("input[type='text'][name='name']").val(name);
				  $("input[type='text'][name='email']").val(email);
				  $("input[type='text'][name='department']").val(department);
				  $("input[type='text'][name='branch']").val(branch);
				  
				  $("#ephotoTitle").attr("src","findImageByEid.do?eid="+eid);
				 $("#editEmployeePopup").modal('show');
			}
   </script>

</head>
<body>
<a href="index.jsp"><img alt="" src="img/hello.gif" height="120px;">Add Employee</a>

<a href="showEmployees.do"><img alt="" src="img/show-dogs.png" height="120px;" style="margin-left: 200px;"> <span style="font-size: 20px;">Employees</span></a>
<hr/>

	<span style="color: red;font-size: 16px;">${message}</span>
  <div class="bs-example">
    <table class="table table-bordered" style="width: 90%;">
        <thead>
            <tr style="background-color: rgba(1, 171, 114, 0.18);">
                <th>Employee ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Department</th>
                <th>Branch</th>
                <th>Photo</th>
                <th>Action</th>
            </tr>
        </thead>
        
        <%
        List<EmployeeForm> employeeList = (List<EmployeeForm>) request.getAttribute("employeeList");
        int count=1;
        for(EmployeeForm ef : employeeList) {
        %>
        <tbody>
            <tr id="<%=ef.getEmployeeId() %>">
                <td><%=ef.getEmployeeId() %></td>
                <td><%=ef.getName() %></td>
                <td><%=ef.getEmail() %></td>
                <td><%=ef.getDepartment() %></td>
                <td><%=ef.getBranch() %></td>
           <td>
<%--             <a href="donwnloadImage.do?did=<%=ef.getEmployeeId() %>"> 
        		   <img src="findDogImageByDid.do?did=<%=ef.getEmployeeId() %>" height="60px;" class="parentimage" >
           </a>
            
             <a href="javascript:openPopup(<%=ef.getEmployeeId() %>);">
              		<img src="img/change.png" height="20px;"/>
              </a> --%>
              
              <a href="javascript:openPopup(<%=ef.getEmployeeId() %>);">
              		<img src="findImageByEid.do?eid=<%=ef.getEmployeeId() %>" height="60px;" class="parentimage" >
              </a>
           </td>
           
              <td>
              <a href="deleteEmployee.do?eid=<%=ef.getEmployeeId()%>"><img alt="" src="img/delete.png" height="24px;"></a>
               /
         	<a href="javascript:editPopup(<%=ef.getEmployeeId()%>)">
		   			<img alt="" src="img/edit.png" height="24px;">
		   </a>
              </td>
            </tr>
            <%
            }
        %>
        </tbody>
    </table>
</div>


        <!-- Modal -->
  <div class="modal fade" id="uploadImagePopup" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">
           <img src="" height="80px;"   id="photoTitle">
          Upload Image	</h4>
        </div>
        <div class="modal-body">
        <form  action="changeEmployeePhoto.do" method="post" name="uploadImageForm"  id="uploadImageForm"  enctype="multipart/form-data">
          <input type="hidden" class="form-control" id="pdid"  name="employeeId" style="width: 200px;"/>	
          <div class="form-group">
            <label>Image :</label>
            <input type="file" class="form-control" id="image" placeholder="Select Image"  name="image">
        </div>
    <div class="modal-footer">
          <button type="submit" class="btn btn-danger"  id="uploadImageButton">Upload Image</button>
        </div>
         </form>
        </div>
         
      </div>
      
    </div>
  </div>
  
          <!-- Modal -->
  <div class="modal fade" id="editEmployeePopup" role="dialog">
    <div class="modal-dialog">
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">
             <img src="" height="80px;"   id="ephotoTitle">
          Edit Employee Information	</h4>
        </div>
        <div class="modal-body">
        <form  action="updateEmployee.do" method="post" name="updateEmployeeForm"  id="updateEmployeeForm" >
          <input type="hidden" class="form-control" id="edid"  name="employeeId" style="width: 200px;"/>
           <div class="form-group">
            <label>Name :</label>
            <input type="text" class="form-control" id="name" placeholder="Name"  name="name">
        </div>
        
           <div class="form-group">
            <label>Email :</label>
            <input type="text" class="form-control" id="email" placeholder="Email"  name="email">
        </div>
        
            <div class="form-group">
            <label>Department :</label>
            <input type="text" class="form-control" id="department" placeholder="Department"  name="department">
        </div>
        
        
            <div class="form-group">
            <label>Branch :</label>
             <select name="branch" class="form-control" id="branch" placeholder="Branch" name="branch">
             		<option>Scranton, PA</option>
             		<option>Syracuse, NY</option>
             		<option>Stamford, CT</option>
             		<option>New York, NY</option>
             		<option>Nashua, NH</option>
             		<option>Ithaca, NY</option>
             </select>
            <!-- <input type="text" class="form-control" id="branch" placeholder="Branch"  name="branch"> -->
        </div>

    <div class="modal-footer">
      	 <button type="button" data-dismiss="modal"  class="btn btn-danger"  id="cancel">Cancel</button>
          <button type="submit" class="btn btn-danger"  id="uploadImageButton">Update Employee Information</button>
        </div>
         </form>
        </div>
         
      </div>
      
    </div>
  </div>
</body>
</html>