<%-- 
    Document   : user_profile
    Created on : Apr 23, 2018, 6:29:48 PM
    Author     : GNyabuto
--%>

<%@page import="java.util.Calendar"%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="images/faces/icon.PNG" style="height: 20px;padding: 0px; margin: 0px;"/>
	<title>Users Profile</title>
	<link href="css/styles.css" rel="stylesheet">
        
        	<link href="css/bootstrap.min.css" rel="stylesheet">
      <link href="css/components.css" rel="stylesheet" type="text/css">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
        <link href="dataTables/datatables.css" rel="stylesheet">
        <link href="dataTables/Buttons-1.5.1/css/buttons.dataTables.min.css" rel="stylesheet">
        <link href="dataTables/icons/icomoon/styles.css" rel="stylesheet" type="text/css">
        <link href="tables/styles.css" rel="stylesheet">
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
       
</head>
<body>
    
 <div class="topmenu">
	<nav class="navbar navbar-custom navbar-fixed-top" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#sidebar-collapse"><span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span></button>
                                         <%
                                          Calendar cal = Calendar.getInstance();  
                                          int year= cal.get(Calendar.YEAR);    
                                            %>
				<a class="navbar-brand" href="#"><span>Bob Tu</span> | <%=year%> </a>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
           </div>   
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-userpic">
                            <%if(session.getAttribute("gender")!=null){
                            if(session.getAttribute("gender").toString().equalsIgnoreCase("F")){%>
                            
                            <img src="images/female_user.png" class="img-responsive fa-user" alt="">
                            
                            <%} else if(session.getAttribute("gender").toString().equalsIgnoreCase("M")){%>
                            
                            <img src="images/male_user.png" class="img-responsive fa-user" alt="">
                            <%} 
                            else{%>
                            <img src="images/unknown_user.png" class="img-responsive fa-user" alt="">
                            <%}
                            }
                            else{%>
                           <img src="images/unknown_user.png" class="img-responsive fa-user" alt="">
                            <%}%>
			</div>
                        <div class="profile-usertitle" style="color:black;">
                            <%if(session.getAttribute("fullname")!=null){%>
                            <div class="profile-usertitle-name" style="font-size: 13px; text-decoration: underline;"><b>Title: </b><%=session.getAttribute("user_type_name").toString()%></div>
				<div class="profile-usertitle-name"  style="font-size: 13px;"><%=session.getAttribute("fullname").toString()%></div>
				<div class="profile-usertitle-status"  style="font-size: 13px;"><span class="indicator label-success"></span>Online</div>
                                <%} else{%>
                                <div class="profile-usertitle-name"  style="font-size: 13px;">Unknown User</div>
                                <div class="profile-usertitle-status"  style="font-size: 13px;"><span class="indicator label-danger"></span>Offline</div>
                                <%}%>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		<ul class="nav menu">
                    <li><a href="home.jsp"><em class="fa fa-home">&nbsp;</em>Home</a></li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-1">
				<em class="fa fa-navicon">&nbsp;</em> Service Areas <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
                            <ul class="children collapse" id="sub-item-1" style="font-size: 10px;">
<!--					<li><a class="" href="home.jsp">
					<span class="fa fa-twitch">&nbsp;</span> Example
					</a></li>-->
  
				</ul>
			</li>
			<li><a href="user_profile.jsp"><em class="fa fa-user-md">&nbsp;</em> User Profile</a></li>
			<li><a href="logout"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>
		</ul>
	</div><!--/.sidebar-->

    <div class="content-data"> <!-- start of contents body -->	
       <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
                            <li><a href="user_profile.jsp">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">User Profile </li>
			</ol>
		</div><!--/.row-->
                <br>
        <div class="row"> 
                    <div class="col-md-12"> 
                        <form id="" method="post" action="#" class="form-horizontal"> 
                           
                              <div class="form-group"> 
                                <label class="col-md-4 control-label">Full Name <b style=\"color:red\">*</b> : </label> 
                                <div class="col-md-8"> 
                                    <input id="fullname" required name="fullname" type="text" value="<%if(session.getAttribute("fullname")!=null){out.println(session.getAttribute("fullname").toString());}%>" placeholder="Enter fullname" readonly class="form-control" style="width:60%;" > 
                                </div> 
                            </div> 
                            
                            
                              <div class="form-group"> 
                                <label class="col-md-4 control-label">UserName <b style=\"color:red\">*</b> : </label> 
                                <div class="col-md-8"> 
                                    <input id="username" required name="username" type="text" value="<%if(session.getAttribute("username")!=null){out.println(session.getAttribute("username").toString());}%>" placeholder="Enter UserName" readonly class="form-control"  style="width:60%;"> 
                                </div> 
                            </div> 
                            
                           
                              <div class="form-group"> 
                                <label class="col-md-4 control-label">Phone Number <b style=\"color:red\"></b> : </label> 
                                <div class="col-md-8"> 
                                    <input id="phone" name="phone" type="text" value="<%if(session.getAttribute("phone")!=null){out.println(session.getAttribute("phone").toString());}%>" placeholder="Enter Phone" class="form-control"  readonly style="width:60%;"> 
                                </div> 
                            </div> 
                            
                           
                              <div class="form-group"> 
                                <label class="col-md-4 control-label">Gender <b style=\"color:red\">*</b> : </label> 
                                <div class="col-md-8"> 
                                    <select id="gender" required name="gender" class="form-control" readonly style="width:60%;">
                                        <option value="f" <%if(session.getAttribute("gender")!=null){if(session.getAttribute("gender").toString().equalsIgnoreCase("f")){%>selected<%}}%>>Female</option>
                                    <option value="m" <%if(session.getAttribute("gender")!=null){if(session.getAttribute("gender").toString().equalsIgnoreCase("m")){%>selected<%}}%>>Male</option>
                                    </select> 
                                </div> 
                            </div> 
                            
                            
                              <div class="form-group"> 
                                <label class="col-md-4 control-label">Enter Password <b style=\"color:red\">*</b> : </label> 
                                <div class="col-md-8"> 
                                    <input id="pass1" required name="pass1" type="password" value="" placeholder="Enter Password"  oninput="checkPasswords()" class="form-control"  style="width:60%;"> 
                                </div> 
                            </div> 
                            
                           
                              <div class="form-group"> 
                                <label class="col-md-4 control-label">Repeat Password <b style=\"color:red\">*</b> : </label> 
                                <div class="col-md-8"> 
                                    <input id="pass2" required name="pass2" type="password" value="" placeholder="Repeat Password"  oninput="checkPasswords()" class="form-control"  style="width:60%;"> 
                                </div> 
                            </div> 
                            
                            
                              <div class="form-group"> 
                                <label class="col-md-4 control-label"></label> 
                                <div class="col-md-8"> 
                                 <input id="" required name="" type="submit" value="Update Password" placeholder="Repeat Password" class="form-control btn btn-info"  style=" margin-left:20%; width:20%;"> 
                                </div> 
                            </div> 
                            
                         </form> 
                    </div> 
                    </div>
	</div>	<!--/.main-->

        </div>
	 <!-- end of contents body -->
        
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
        <script src="js/bootbox.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/custom.js"></script>

        <script type="text/javascript" src="js/notifications/jgrowl.min.js"></script>
            <script type="text/javascript">
    
            function checkPasswords() {
                var password = document.getElementById('pass1');
                var conf_password = document.getElementById('pass2');

                if (password.value != conf_password.value) {
                    conf_password.setCustomValidity('Passwords do not match');
                } else {
                    conf_password.setCustomValidity('');
                }
                
          
        
            }
    
    </script>
	<script>
   $(document).ready(function() {
} ); 
    </script>
    
    
    <script>
    $("form").submit(function(e){

      var form_data = $("form").serialize();
                var theme="";
                var url = "update_user";
                   $.post(url,form_data , function(output) {
                                    var code = JSON.parse(output).code;
                                    var header = JSON.parse(output).message;
                                    var description = JSON.parse(output).description;
                                    
                                    if(code==1){
                                        theme = "bg-success";
                                    }
                                    else{
                                       theme = "bg-danger";  
                                    }
                                    
                                    $.jGrowl('close');
                                    
                                  $.jGrowl(description, {
                                        position: 'top-center',
                                        header: header,
                                        theme: theme
                                   }); 
                               
                                 });
        e.preventDefault();
    });   
    </script>
    <script>
   $(document).ready(function() {
         load_areas();
    });
    
  

    </script>
    	<script>
     function load_areas(){
       $.ajax({
        url:'getServiceAreas',
        type:"get",
        dataType:"json",
        success:function(raw_data){
         var id,code,name,position,output="";
         var data = raw_data.data;
  
         for (var i=0; i<data.length;i++){
            position++;
             id=code=name="";
            if( data[i].id!=null){id = data[i].id;}
            if( data[i].code!=null){code = data[i].code;}
            if( data[i].name!=null){name = data[i].name;}
            output+='<li style="font-size:10px;"><a class="" href="service_area.jsp?id='+id+'"><span class="fa fa-vk">&nbsp;</span> '+name+'</a></li>';
        }   
         // ouput
         $("#sub-item-1").html(output);
        }
  });   
    }
    </script>
</body>
</html>