<%-- 
    Document   : home
    Created on : 22-Feb-2020, 08:27:33
    Author     : Geofrey Nyabuto
--%>
<%@page import="java.util.Calendar"%>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="shortcut icon" href="images/faces/icon.PNG" style="height: 20px;padding: 0px; margin: 0px;"/>
	<title>Home</title>

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
	<style type="text/css">
.highcharts-figure, .highcharts-data-table table {
    min-width: 310px; 
    max-width: 800px;
    margin: 1em auto;
}

#container {
    height: 400px;
}

.highcharts-data-table table {
	font-family: Verdana, sans-serif;
	border-collapse: collapse;
	border: 1px solid #EBEBEB;
	margin: 10px auto;
	text-align: center;
	width: 100%;
	max-width: 500px;
}
.highcharts-data-table caption {
    padding: 1em 0;
    font-size: 1.2em;
    color: #555;
}
.highcharts-data-table th {
	font-weight: 600;
    padding: 0.5em;
}
.highcharts-data-table td, .highcharts-data-table th, .highcharts-data-table caption {
    padding: 0.5em;
}
.highcharts-data-table thead tr, .highcharts-data-table tr:nth-child(even) {
    background: #f8f8f8;
}
.highcharts-data-table tr:hover {
    background: #f1f7ff;
}

		</style>

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
                
                <div style="font-weight: 900; text-align: center; font-size: 18px; margin-top: 7px; margin-bottom: 7px;" id="area">
                   
                    </div>
<div id="al">
   <div id="container"></div>
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
        
         
<script src="highcharts/highcharts.js"></script>
<script src="highcharts/modules/exporting.js"></script>
<script src="highcharts/modules/export-data.js"></script>
<script src="highcharts/modules/accessibility.js"></script>


	<script>
   $(document).ready(function() {
   load_areas();
   today_summary();
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
     function today_summary(){
       $.ajax({
        url:'load_daily_summary',
        type:"get",
        dataType:"json",
        success:function(raw_data){
         var Tested=0,Positive=0,Facility=0,PNS=0,Linked=0,area="";
         var data = raw_data.data;
            Tested = parseInt(data.Tested);
            Positive = parseInt(data.Positive);
            Facility = parseInt(data.Facility);
            PNS = parseInt(data.PNS);
            Linked = parseInt(data.Linked);
            area = data.area;
            
//          $("#area").html("Today's testing summaries for "+area);  
            
            
    Highcharts.chart('container', {
        chart: {
            type: 'column'
        },
        title: {
            text: "<b>Today's Testing Summaries for "+area+"</b>"
        },
        subtitle: {
            text: ''
        },
        xAxis: {
            categories: [
                'Indicators'
            ],
            crosshair: true
        },
        yAxis: {
            min: 0,
            title: {
                text: 'Number of Patients'
            }
        },
        legend: {
            enabled: true
        },
//        tooltip: {
//            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
//            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
//                '<td style="padding:0"><b>{point.y:.1f}</b></td></tr>',
//            footerFormat: '</table>',
//            shared: true,
//            useHTML: true
//        },
        plotOptions: {
            column: {
                pointPadding: 0.2,
                borderWidth: 0,
            dataLabels: {
                enabled: true
            }
            }
        },
        series: [{
            name: 'Total Tested',
            data: [Tested]

        }, {
            name: 'Total Positives',
            data: [Positive]

        }, {
            name: 'Facility Positives',
            data: [Facility]

        }, {
            name: 'PNS Positives',
            data: [PNS]

        }
        , {
            name: 'Linked to ART Services',
            data: [Linked]

        }]
    });  
            }
      });   
        }
    
    </script>	
</body>

</html>