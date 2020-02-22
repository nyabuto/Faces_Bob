<%-- 
    Document   : service_area
    Created on : 22-Feb-2020, 08:27:33
    Author     : Geofrey Nyabuto
--%>
<%@page import="java.util.Calendar"%>
<%
String id=request.getParameter("id");
%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="images/faces/icon.PNG" style="height: 20px;padding: 0px; margin: 0px;"/>
	<title>Service Area Data</title>

	<link href="css/styles.css" rel="stylesheet">
        
        	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/font-awesome.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
        <link href="dataTables/datatables.css" rel="stylesheet">
        <!--<link href="dataTables/Buttons-1.5.1/css/buttons.dataTables.min.css" rel="stylesheet">-->
        <link href="dataTables/icons/icomoon/styles.css" rel="stylesheet" type="text/css">
        <link href="tables/styles.css" rel="stylesheet">
        <!--<link href="css/components.css" rel="stylesheet" type="text/css">-->
	<!--Custom Font-->
	<link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
	

</head>
<body>
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
				<a class="navbar-brand" href="#"><span>Bob Tu System</span> | FACES <%=year%> </a>
			</div>
		</div><!-- /.container-fluid -->
	</nav>
                        
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
			<div class="profile-usertitle">
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
    
    <div class="content-data"> <!-- start of contents body -->	
       <div class="col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main">
		<div class="row">
			<ol class="breadcrumb">
				<li><a href="#">
					<em class="fa fa-home"></em>
				</a></li>
				<li class="active">Dashboard</li>
			</ol>
		</div><!--/.row-->
                <div style="font-weight: 900; text-align: center; font-size: 18px;" id="service_area">
                   
                    </div>
<div id="al">
    <table id="data_table"  class="display cell-border row-border" style="width:100%">
       <thead id="header">
        </thead>
        <tbody>
        </tbody> 
    </table>
    </div>
	</div>	<!--/.main-->
        
        </div> <!-- end of contents body -->
        
    
	<script src="js/jquery-1.11.1.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
        <script src="js/bootbox.min.js"></script>
	<script src="js/chart.min.js"></script>
	<script src="js/chart-data.js"></script>
	<script src="js/easypiechart.js"></script>
	<script src="js/easypiechart-data.js"></script>
	<script src="js/bootstrap-datepicker.js"></script>
	<script src="js/custom.js"></script>
	
        <script src="dataTables/datatables.min.js"></script>
        <script src="dataTables/pdfmake-0.1.32/pdfmake.min.js"></script>
        <script src="dataTables/Buttons-1.5.1/js/dataTables.buttons.min.js"></script>
        <script src="dataTables/Buttons-1.5.1/js/buttons.flash.min.js"></script>
        <script src="dataTables/pdfmake-0.1.32/vfs_fonts.js"></script>
        <script src="dataTables/JSZip-2.5.0/jszip.min.js"></script>
        <script src="dataTables/Buttons-1.5.1/js/buttons.html5.min.js"></script>
        <script src="dataTables/Buttons-1.5.1/js/buttons.print.min.js"></script>
        <script type="text/javascript" src="js/notifications/jgrowl.min.js"></script>
         <script type="text/javascript" src="js/select2.min.js"></script>
        
	<script>
   $(document).ready(function() {
   load_areas();
   load_data();
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
    
    
      function load_data(){
       $.ajax({
        url:'get_service_area_data?id='+<%out.println(id);%>,
        type:"get",
        dataType:"json",
        success:function(raw_data){
       var dataSet=[];
         var response = raw_data.response;
         var data = response.data;
         var header = response.header;
         
         
         var service_area = response.service_area;
         $("#service_area").html("<b style='color:red;'>Service Area:</b> <b style='color:blue;'>"+service_area+"</b>");
         document.title=service_area;
         
        
         var outputheader = "<tr>";
         for (var i=0; i<header.length;i++){
            outputheader+="<th>"+header[i]+"</th>";
        }
         outputheader += "</tr>";
  $("#header").html(outputheader);

    for (var i=0; i<data.length;i++){
        var minSet = [];
        for (var j=0; j<header.length;j++){
       minSet.push(data[i][j]);
        }
        dataSet.push(minSet);
        }
       
        var table = $('#data_table').DataTable();
        table.destroy();
        
        
        table = $('#data_table').dataTable({
            data: dataSet,
             dom: 'Bfltip',
        buttons: [
            'copy', 'csv', 'excel', 'pdf', 'print'
        ],
            responsive: true,
            className:'',
            columnDefs: []
            
        });
        
        table.on( 'responsive-resize', function ( e, datatable, columns ) {
    var count = columns.reduce( function (a,b) {
        return b === false ? a+1 : a;
    }, 0 );
 
    console.log( count +' column(s) are hidden' );
} ); 
        
        }
  });   
    } 
    </script>	
</body>

</html>