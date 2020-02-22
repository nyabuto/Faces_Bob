<%-- 
    Document   : index
    Created on : 21-Feb-2020, 16:52:39
    Author     : Geofrey Nyabuto
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>HTS Daily Tracking System</title>
        <link rel="shortcut icon" href="images/faces/icon.PNG" style="height: 20px;padding: 0px; margin: 0px;"/>
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/datepicker3.css" rel="stylesheet">
	<link href="css/styles.css" rel="stylesheet">
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Dancing+Script" />
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Merienda+One" />
        <link href="css/font-awesome.min.css" rel="stylesheet">
        <link href="css/components.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">
        
<style>
    .title{
        font-family: Merienda One;
	font-size: 35px;
	font-style: normal;
	font-variant: normal;
	font-weight: 900;
	line-height: 26.4px;
    }    
    .row{
        margin-top: 3%;
    }
    .header{
        padding-top: 8%;
    } 
    .panel-body{
        padding-bottom: 7%;
    } 
    body{
        max-width: 90%;
    }
    .header-img{
        max-width: 90%;
    }
</style>
 
</head>
<body style="margin-left: 7%;">
    <br><br>
    <div class="title" style="text-align: center;">Daily HTS Testing Tracking System <br><br>(Bob Tu)</div>
                                <br>
                                <div class="row">
            <div class="col-xs-10 col-xs-offset-1 col-sm-8 col-sm-offset-2 col-md-4 col-md-offset-4">
                    
                    <div class="login-panel panel panel-default">
                            
                            <div class="text-center header">
                                
                                <div class="icon-object border-slate-300 text-slate-300"><img class='header-img' style="height: 100px; margin-top: -30px;" src="images/faces/faces.png"></div>
                                <h4 style="font-weight: bolder;" class="content-group">Login to your account </h4>
							</div>
                            
				<!--<div class="panel-heading">Log in</div>-->
				<div class="panel-body">
                                    <form role="form" method="post" action="login">
                                        <fieldset>
                                            <div class="form-group">
                                                    <input class="form-control" placeholder="Username" name="username" type="text" autofocus="">
                                            </div>
                                            <div class="form-group">
                                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                            </div>
                                            <div class="form-group">
                                                    <input class="form-control btn-info" placeholder="Password" name="password" type="submit" value=" Login">
                                            </div>
                                        </fieldset>
					</form>
				</div>
			</div>
		</div><!-- /.col-->
	</div><!-- /.row -->	
	
<script src="js/jquery-1.11.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script type="text/javascript" src="js/notifications/jgrowl.min.js"></script>
    
    <%if(session.getAttribute("message")!=null){
    String message = session.getAttribute("message").toString();
    String theme="bg-danger";
   
    %>
     <script type="text/javascript">
     $.jGrowl('<%=message%>', {
        position: 'top-center',
        header: 'ERROR',
        theme: '<%=theme%>'
     });
    </script>
    <% 
        session.removeAttribute("message");
        }
    %>

    
</body>
</html>
