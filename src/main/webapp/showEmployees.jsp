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
   			function openPopup(did) {
  					  $("#pdid").val(did);
  					  $("#photoTitle").attr("src","findDogImageByDid.do?did="+did);
   					 $("#uploadImagePopup").modal('show');
   			}
  			
   			function editPopup(did) {
   				
				  $("#pdid").val(did);
				  //This the code to access the value from a row on the basis rowid
				  var sno=$("#"+did).children("td:nth-child(1)").text();
				  var name=$("#"+did).children("td:nth-child(2)").text();
				  var email=$("#"+did).children("td:nth-child(3)").text();
				  var breed=$("#"+did).children("td:nth-child(4)").text();
				  var color=$("#"+did).children("td:nth-child(5)").text();
				  var price=$("#"+did).children("td:nth-child(6)").text();
				  
				  //Code to populate the value into the popup form
				  $("input[type='text'][name='name']").val(name);
				  $("input[type='text'][name='email']").val(email);
				  $("input[type='text'][name='breed']").val(breed);
				  $("input[type='text'][name='color']").val(color);
				  $("input[type='text'][name='price']").val(price);
				  
				  $("#ephotoTitle").attr("src","findDogImageByDid.do?did="+did);
				 $("#editProfilePopup").modal('show');
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
                <td><%=count++ %></td>
                <td><%=ef.getName() %></td>
                <td><%=ef.getEmail() %></td>
                <td><%=ef.getDepartment() %></td>
                <td><%=ef.getBranch() %></td>
           <td>
            <a href="donwnloadImage.do?did=<%=ef.getEmployeeId() %>"> 
        		   <img src="findDogImageByDid.do?did=<%=ef.getEmployeeId() %>" height="60px;" class="parentimage" >
           </a>
            
             <a href="javascript:openPopup(<%=ef.getEmployeeId() %>);">
              		<img src="img/change.png" height="20px;"/>
              </a>
           </td>
           
              <td>
              <a href="deleteDog.do?did=<%=ef.getEmployeeId()%>"><img alt="" src="img/delete.png" height="24px;"></a>
               /
         	<a href="javascript:editPopup(<%=ef.getEmployeeId()%>)">
		   			<img alt="" src="img/edit1.png" height="24px;">
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
          Upload  Image Popup	</h4>
        </div>
        <div class="modal-body">
        <form  action="changeDogImage.do" method="post" name="uploadImageForm"  id="uploadImageForm"  enctype="multipart/form-data">
          <input type="hidden" class="form-control" id="pdid"  name="did" style="width: 200px;"/>	
          <div class="form-group">
            <label>Image :</label>
            <input type="file" class="form-control" id="image" placeholder="Select Image"  name="photo">
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
  <div class="modal fade" id="editProfilePopup" role="dialog">
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
        <form  action="updateDogProfile.do" method="post" name="updateDogProfileForm"  id="updateDogProfileForm" >
          <input type="hidden" class="form-control" id="pdid"  name="did" style="width: 200px;"/>
           <div class="form-group">
            <label>Name :</label>
            <input type="text" class="form-control" id="name" placeholder="Name"  name="name">
        </div>
        
           <div class="form-group">
            <label>Email :</label>
            <input type="text" class="form-control" id="email" placeholder="Email"  name="email">
        </div>
        
            <div class="form-group">
            <label>Breed :</label>
            <input type="text" class="form-control" id="breed" placeholder="Breed"  name="breed">
        </div>
        
        
            <div class="form-group">
            <label>Color :</label>
            <input type="text" class="form-control" id="color" placeholder="Color"  name="color">
        </div>
        
          <div class="form-group">
            <label>Price :</label>
            <input type="text" class="form-control" id="price" placeholder="Price"  name="price">
        </div>
    <div class="modal-footer">
      	 <button type="button" data-dismiss="modal"  class="btn btn-danger"  id="cancel">Cancel</button>
          <button type="submit" class="btn btn-danger"  id="uploadImageButton">Update Profile</button>
        </div>
         </form>
        </div>
         
      </div>
      
    </div>
  </div>
</body>
</html>