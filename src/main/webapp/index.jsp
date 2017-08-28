<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add Employee</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
     
</head>
<body>
<a href="index.jsp"><img alt="" src="img/hello.gif" height="120px;">Upload</a>

 <a href="showEmployees.do"><img alt="" src="img/show-dogs.png" height="120px;" style="margin-left: 200px;"> <span style="font-size: 20px;">Employees</span></a>
<hr/>

	<span style="color: red;font-size: 16px;">${message}</span>
    <div style="margin-left: 30px;">
    <form action="addEmployee.do" method="post" enctype="multipart/form-data">>
    	<table>
    	<tr>
    	<td>
        <div class="form-group">
            <label>Name:</label>
            <input type="text" class="form-control"  name="name" placeholder="name" style="width: 300px;display: inline;margin-left: 40px;"/>
              <br/>   <br/>
        </div>
        <div class="form-group">
            <label>Email:</label>
            <input type="email" class="form-control"  name="email" placeholder="email" style="margin-left: 40px;width: 400px;display: inline;margin-right: 40px;" ng-model="email"/>
              <br/>   <br/>
        </div>
        
        <div class="form-group">
            <label>Department:</label>
            <input type="text" class="form-control"  name="department" placeholder="department" style="margin-left: 40px;width: 400px;display: inline;margin-right: 40px;" ng-model="department"/>
              <br/>   <br/>
        </div>
        
          <div class="form-group">
            <label>Branch:</label>
             <select name="branch" class="form-control" style="margin-left: 40px;width: 240px;display: inline;margin-right: 40px;">
             		<option>Scranton, PA</option>
             		<option>Syracuse, NY</option>
             		<option>Stamford, CT</option>
             		<option>New York, NY</option>
             		<option>Nashua, NH</option>
             		<option>Ithaca, NY</option>
             </select>
               <br/>   <br/>
        </div>
        
		<div class="form-group">
            <label>Manager ID:</label>
            <input type="text" class="form-control"  name="managerId" placeholder="managerId" style="margin-left: 40px;width: 400px;display: inline;margin-right: 40px;" ng-model="managerId"/>
              <br/>   <br/>
        </div>
        
        <div class="form-group">
            <label>Photo:</label>
             <input type="file" name="photo" class="form-control" style="margin-left: 40px;width: 240px;display: inline;margin-right: 40px;">
               <br/>   <br/>
        </div>

          <button type="submit" class="btn btn-danger" style="display: inline;margin-right: 40px;">Add Employee</button>
            <button type="button" class="btn btn-danger" style="display: inline;" ng-click="clearSearch();">Clear</button>
        </td>
         <td>
         		<img alt="" src="img/captain-america2.png"  width="300px;"/>
         </td>
        </tr>
        
        </table>
    </form>
    <br/><br/>
    </div>
</body>
</html>