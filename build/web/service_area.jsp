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
				<li class="active">Service Area</li>
			</ol>
		</div><!--/.row-->
                <br/>
                <div>
                    <table>
                        <tr>
                            <%if(session.getAttribute("user_type_id")!=null){
                            if(session.getAttribute("user_type_id").toString().equals("1")){
                            %> 
                            <td>
            <div>
               <button type="button" class="btn btn-info btn-raised" onclick="add_data();load_indicators();"  style="margin-left: 1%; margin-bottom: 1%; font-weight: 900;"><i class="icon-plus3 position-left"></i> New Data</button>
           </div>
                        </td>
                        
                        <%}}%>
                 <td>   
                <div style="font-weight: 900; text-align: center; font-size: 20px; color: #0088cc;" id="area">
                   
                </div>
                        </td>
                        </tr>
                </table>
                </div>
                <div id="data"></div>      
<div id="al">
    <table id="data_table"  class="display cell-border row-border" style="width:100%">
       <thead id="header">
        </thead>
        <tbody>
        </tbody> 
    </table>
    </div>
                <p id="sa_header"></p>
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
        
         <script type="text/javascript" language="en">
   function numbers(evt){
        var charCode=(evt.which) ? evt.which : event.keyCode
        if(charCode > 31 && (charCode < 48 || charCode>57))
        return false;
        return true;
  }
//-->
</script>
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
         var area = response.area;
         var service_area = response.service_area;
                  
         $("#area").html("Daily HTS Results by "+area+"<b style='color:red;'> in </b> <b style='color:blue;'>"+service_area+"</b>");
         $("#sa_header").html(service_area);
         
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
    
    function load_indicators(){
     var sa_id=parseInt(<%out.println(id);%>);
    var output_indicators="<div><div style=\"text-align:center; font-weight: 900; font-size: 16px; text-decoration:underline;\">Reportable Indicators</div><br/>";
    var output_reasons="<div><div style=\"text-align:center; font-weight: 900; font-size: 16px; text-decoration:underline; color:red;\">Reasons for Non-Linkage</div><br/>";
    
    if(sa_id!=1){
       output_indicators+='<div><b style="color:red">Note: </b> <b style="color:blue;">Enter data only for clients whose age is 15+ Years.</b></div><br/>';    
        
    }
     $.ajax({
        url:'getIndicators',
        type:"get",
        dataType:"json",
        success:function(raw_data){
         var id,code,fullname,description,is_non_linkage_reason,indicator_type_id;
         var data = raw_data.indicators;
  
         for (var i=0; i<data.length;i++){
            id="";code="";fullname="";description="";is_non_linkage_reason=0;indicator_type_id=0;
            
            if( data[i].id!=null){id = data[i].id;}
            if( data[i].code!=null){code = data[i].code;}
            if( data[i].fullname!=null){fullname = data[i].fullname;}
            if( data[i].description!=null){description = data[i].description;}
            if( data[i].is_non_linkage_reason!=null){is_non_linkage_reason = data[i].is_non_linkage_reason;}
            if( data[i].indicator_type_id!=null){indicator_type_id = data[i].indicator_type_id;}
            
            
            if(is_non_linkage_reason==0){
                if(sa_id==1){
                  if(indicator_type_id==2 || indicator_type_id==3){
                   output_indicators+='<div class="form-group">' +
                                '<label class="col-md-4 control-label">'+fullname+'['+code+']<b style=\"color:red\"></b> : </label>' +
                                '<div class="col-md-6">' +
                                    '<input id="'+code+'" required name="'+code+'" onkeypress="return numbers(event)" type="text" value="" maxlength="2" placeholder="Enter data for '+code+'" class="form-control"  style="width:80%;"/>' +
                                '</div>' +
                            '</div>';   
                     }  
            }
                else{
                        
                  if(indicator_type_id==1 || indicator_type_id==3){     // for pns & both  
           output_indicators+='<div class="form-group">' +
                                '<label class="col-md-4 control-label">'+fullname+' 15+ Years ['+code+']<b style=\"color:red\"></b> : </label>' +
                                '<div class="col-md-6">' +
                                    '<input id="'+code+'" required name="'+code+'" onkeypress="return numbers(event)" type="text" value="" maxlength="2" placeholder="Enter data for '+code+'" class="form-control"  style="width:80%;"/>' +
                                '</div>' +
                            '</div>';
                }
                }
            }
    else if(is_non_linkage_reason==1){
        output_reasons+='<div class="form-group">' +
                                '<label class="col-md-4 control-label">'+fullname.replace("Not Linked: ","")+'['+code+']<b style=\"color:red\"></b> : </label>' +
                                '<div class="col-md-6">' +
                                    '<input id="'+code+'" name="'+code+'" onkeypress="return numbers(event)" type="text" value="" maxlength="2" placeholder="Enter data for '+code+'" class="form-control"  style="width:80%;"/>' +
                                '</div>' +
                            '</div>';   
         }  
        }   
         // ouput
        
    output_indicators +="</div>";
    output_reasons +="</div>";  
    
    
    // input them into their areas
    
    $("#entry_indicators").html(output_indicators);
    $("#entry_reasons").html(output_reasons);
     }
  });

    }
    
   
    function add_data(){    
  var title = $("#sa_header").html();
  
                var dialog = bootbox.dialog({
    title: '<b style="text-align:center; font-size: 18px; color:#0DF6ED;">'+title+' </b>',
    message: '<div class="row">' +
                    '<div class="col-lg-12">' +
                        '<form id="new_data_entry" method="post" class="form-horizontal">'+
                            '<input type="hidden" id="sa_id" name="sa_id" value="'+<%out.println(id);%>+'">' +
                            '<div id="entry_indicators"> </div>' +
                            '<hr/>'+
                              '<div id="entry_reasons"> </div>' +
                             
                         '</form>' +
                    '</div>' +
                    '</div>',
    buttons: {
        cancel: {
            label: "Cancel",
            className: 'btn-danger',
            callback: function(){
                
            }
        },
        ok: {
            label: "Save",
            className: 'btn-info',
            callback: function(){
                var form_data = $("form").serialize();
               // $("#data").html(form_data);
                var theme="",header="",message="";
                var url = "ReceiveSMS";
                   $.post(url,form_data , function(output) {
                                    var code = JSON.parse(output).code;
                                    var header = JSON.parse(output).message;
                                    var description = JSON.parse(output).description;
                                    var source = JSON.parse(output).source;
                                    
                                    if(source=="web"){
                                    if(code==1){
                                        theme = "bg-success";
                                       load_data(); 
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
                               }
                                 });
                        
            }
        }
        
    }
    
    });
    
    // load all data and push it into dialogue
    //load_indicators();
    
    }
    </script>	
</body>

</html>