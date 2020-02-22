<%-- 
    Document   : menu
    Created on : Apr 16, 2018, 9:05:03 AM
    Author     : GNyabuto
--%>
<%@page import="java.util.Calendar"%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="images/hsdsa/icon.png" style="height: 20px;padding: 0px; margin: 0px;"/>
	<title>Menu</title>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
        
<script src="js/jquery-1.11.1.min.js"></script>
</head>
<body>
<div id="sidebar-collapse" class="col-sm-3 col-lg-2 sidebar">
		<div class="profile-sidebar">
			<div class="profile-userpic">
                            <%if(session.getAttribute("gender")!=null){
                            if(session.getAttribute("gender").toString().equals("f")){%>
                            
                            <img src="images/female_user.png" class="img-responsive fa-user" alt="">
                            
                            <%} else if(session.getAttribute("gender").toString().equals("m")){%>
                            
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
			<div class="profile-usertitle">
                            <%if(session.getAttribute("fullname")!=null){%>
				<div class="profile-usertitle-name"><%=session.getAttribute("fullname").toString()%></div>
				<div class="profile-usertitle-status"><span class="indicator label-success"></span>Online</div>
                                <%} else{%>
                                <div class="profile-usertitle-name">Unknown User</div>
                                <div class="profile-usertitle-status"><span class="indicator label-danger"></span>Offline</div>
                                <%}%>
			</div>
			<div class="clear"></div>
		</div>
		<div class="divider"></div>
		<ul class="nav menu">
			
			<!--<li><a href="visits_filter.jsp"><em class="fa fa-calendar">&nbsp;</em> Visits</a></li>-->
                        
			<li class="parent "><a data-toggle="collapse" href="#sub-item-1">
				<em class="fa fa-navicon">&nbsp;</em> Service Areas <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-1">
					<li><a class="" href="totals.jsp">
					<span class="fa fa-twitch">&nbsp;</span> HTS Positive
					</a></li>
                                        <li><a class="" href="pns.jsp?">
						<span class="fa fa-certificate">&nbsp;</span> PNS for New positives
					</a></li>
					<li><a class="" href="pns.jsp">
						<span class="fa fa-vk">&nbsp;</span> PNS for High VLs
					</a></li>
					
				</ul>
			</li>
			<li class="parent "><a data-toggle="collapse" href="#sub-item-2">
				<em class="fa fa-navicon">&nbsp;</em> Reports <span data-toggle="collapse" href="#sub-item-1" class="icon pull-right"><em class="fa fa-plus"></em></span>
				</a>
				<ul class="children collapse" id="sub-item-2">
					<li><a class="" href="reports_filter.jsp">
						<span class="fa fa-area-chart">&nbsp;</span> Visit Reports
					</a></li>
					<li><a class="" href="partners_report">
						<span class="fa fa-pie-chart">&nbsp;</span> Partners & Obligations
					</a></li>
					
				</ul>
			</li>
                       <li><a href="user_profile.jsp"><em class="fa fa-user-md">&nbsp;</em> User Profile</a></li>
			<li><a href="logout"><em class="fa fa-power-off">&nbsp;</em> Logout</a></li>
		</ul>
	</div><!--/.sidebar-->

</body>
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
</html>