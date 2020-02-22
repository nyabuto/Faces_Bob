package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Calendar;
import java.util.Calendar;
import java.util.Calendar;

public final class template_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(2);
    _jspx_dependants.add("/menu/topmenu.jsp");
    _jspx_dependants.add("/menu/sidebar.jsp");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write(" \n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/hsdsa/icon.png\" style=\"height: 20px;padding: 0px; margin: 0px;\"/>\n");
      out.write("\t<title>Template</title>\n");
      out.write("\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/datepicker3.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/styles.css\" rel=\"stylesheet\">\n");
      out.write("\t\n");
      out.write("\t<!--Custom Font-->\n");
      out.write("\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("    <div class=\"topmenu\"><!--  start of top menu here --->\n");
      out.write("\t");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/hsdsa/icon.png\" style=\"height: 20px;padding: 0px; margin: 0px;\"/>\n");
      out.write("\t<title>Menu</title>\n");
      out.write("\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/datepicker3.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/styles.css\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\t<nav class=\"navbar navbar-custom navbar-fixed-top\" role=\"navigation\">\n");
      out.write("\t\t<div class=\"container-fluid\">\n");
      out.write("\t\t\t<div class=\"navbar-header\">\n");
      out.write("\t\t\t\t<button type=\"button\" class=\"navbar-toggle collapsed\" data-toggle=\"collapse\" data-target=\"#sidebar-collapse\"><span class=\"sr-only\">Toggle navigation</span>\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span>\n");
      out.write("\t\t\t\t\t<span class=\"icon-bar\"></span></button>\n");
      out.write("                                         ");

                                          Calendar cal = Calendar.getInstance();  
                                          int year= cal.get(Calendar.YEAR);    
                                            
                                            
      out.write("\n");
      out.write("\t\t\t\t<!--<a class=\"navbar-brand\" href=\"#\"><span>Compliance System</span> | HSDSA ");
      out.print(year);
      out.write(" </a>-->\n");
      out.write("\t\t\t\t<ul class=\"nav navbar-top-links navbar-right\">\n");
      out.write("\t\t\t\t\t<li class=\"dropdown\"><a class=\"dropdown-toggle count-info\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("\t\t\t\t\t\t<!--<em class=\"fa fa-envelope\"></em><span class=\"label label-danger\">15</span>-->\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("<!--\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-messages\">\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"dropdown-messages-box\"><a href=\"profile.html\" class=\"pull-left\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<img alt=\"image\" class=\"img-circle\" src=\"http://placehold.it/40/30a5ff/fff\">\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"message-body\"><small class=\"pull-right\">3 mins ago</small>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\"><strong>John Doe</strong> commented on <strong>your photo</strong>.</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br /><small class=\"text-muted\">1:24 pm - 25/03/2015</small></div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"dropdown-messages-box\"><a href=\"profile.html\" class=\"pull-left\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<img alt=\"image\" class=\"img-circle\" src=\"http://placehold.it/40/30a5ff/fff\">\n");
      out.write("\t\t\t\t\t\t\t\t\t</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<div class=\"message-body\"><small class=\"pull-right\">1 hour ago</small>\n");
      out.write("\t\t\t\t\t\t\t\t\t\t<a href=\"#\">New message from <strong>Jane Doe</strong>.</a>\n");
      out.write("\t\t\t\t\t\t\t\t\t<br /><small class=\"text-muted\">12:27 pm - 25/03/2015</small></div>\n");
      out.write("\t\t\t\t\t\t\t\t</div>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\n");
      out.write("\t\t\t\t\t\t\t<li>\n");
      out.write("\t\t\t\t\t\t\t\t<div class=\"all-button\"><a href=\"#\">\n");
      out.write("\t\t\t\t\t\t\t\t\t<em class=\"fa fa-inbox\"></em> <strong>All Messages</strong>\n");
      out.write("\t\t\t\t\t\t\t\t</a></div>\n");
      out.write("\t\t\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t\t</ul>-->\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t\t<li class=\"dropdown\"><a class=\"dropdown-toggle count-info\" data-toggle=\"dropdown\" href=\"#\">\n");
      out.write("\t\t\t\t\t\t<!--<em class=\"fa fa-bell\"></em><span class=\"label label-info\">5</span>-->\n");
      out.write("\t\t\t\t\t</a>\n");
      out.write("<!--\t\t\t\t\t\t<ul class=\"dropdown-menu dropdown-alerts\">\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">\n");
      out.write("\t\t\t\t\t\t\t\t<div><em class=\"fa fa-envelope\"></em> 1 New Message\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"pull-right text-muted small\">3 mins ago</span></div>\n");
      out.write("\t\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">\n");
      out.write("\t\t\t\t\t\t\t\t<div><em class=\"fa fa-heart\"></em> 12 New Likes\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"pull-right text-muted small\">4 mins ago</span></div>\n");
      out.write("\t\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t\t<li class=\"divider\"></li>\n");
      out.write("\t\t\t\t\t\t\t<li><a href=\"#\">\n");
      out.write("\t\t\t\t\t\t\t\t<div><em class=\"fa fa-user\"></em> 5 New Followers\n");
      out.write("\t\t\t\t\t\t\t\t\t<span class=\"pull-right text-muted small\">4 mins ago</span></div>\n");
      out.write("\t\t\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\t</ul>-->\n");
      out.write("\t\t\t\t\t</li>\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t</div><!-- /.container-fluid -->\n");
      out.write("\t</nav>\n");
      out.write("\t\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\t \n");
      out.write("    </div> <!--end of top menu -->\n");
      out.write("    \n");
      out.write("    <div class=\"sidebar\"> <!-- start of side bar -->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("\t<meta charset=\"utf-8\">\n");
      out.write("\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"shortcut icon\" href=\"images/hsdsa/icon.png\" style=\"height: 20px;padding: 0px; margin: 0px;\"/>\n");
      out.write("\t<title>Menu</title>\n");
      out.write("\t<link href=\"css/bootstrap.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/font-awesome.min.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/datepicker3.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"css/styles.css\" rel=\"stylesheet\">\n");
      out.write("\t<link href=\"https://fonts.googleapis.com/css?family=Montserrat:300,300i,400,400i,500,500i,600,600i,700,700i\" rel=\"stylesheet\">\n");
      out.write("\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<div id=\"sidebar-collapse\" class=\"col-sm-3 col-lg-2 sidebar\">\n");
      out.write("\t\t<div class=\"profile-sidebar\">\n");
      out.write("\t\t\t<div class=\"profile-userpic\">\n");
      out.write("                            ");
if(session.getAttribute("gender")!=null){
                            if(session.getAttribute("gender").toString().equals("f")){
      out.write("\n");
      out.write("                            \n");
      out.write("                            <img src=\"images/female_user.png\" class=\"img-responsive fa-user\" alt=\"\">\n");
      out.write("                            \n");
      out.write("                            ");
} else if(session.getAttribute("gender").toString().equals("m")){
      out.write("\n");
      out.write("                            \n");
      out.write("                            <img src=\"images/male_user.png\" class=\"img-responsive fa-user\" alt=\"\">\n");
      out.write("                            ");
} 
                            else{
      out.write("\n");
      out.write("                            <img src=\"images/unknown_user.png\" class=\"img-responsive fa-user\" alt=\"\">\n");
      out.write("                            ");
}
                            }
                            else{
      out.write("\n");
      out.write("                           <img src=\"images/unknown_user.png\" class=\"img-responsive fa-user\" alt=\"\">\n");
      out.write("                            ");
}
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"profile-usertitle\">\n");
      out.write("                            ");
if(session.getAttribute("fullname")!=null){
      out.write("\n");
      out.write("\t\t\t\t<div class=\"profile-usertitle-name\">");
      out.print(session.getAttribute("fullname").toString());
      out.write("</div>\n");
      out.write("\t\t\t\t<div class=\"profile-usertitle-status\"><span class=\"indicator label-success\"></span>Online</div>\n");
      out.write("                                ");
} else{
      out.write("\n");
      out.write("                                <div class=\"profile-usertitle-name\">Unknown User</div>\n");
      out.write("                                <div class=\"profile-usertitle-status\"><span class=\"indicator label-danger\"></span>Offline</div>\n");
      out.write("                                ");
}
      out.write("\n");
      out.write("\t\t\t</div>\n");
      out.write("\t\t\t<div class=\"clear\"></div>\n");
      out.write("\t\t</div>\n");
      out.write("\t\t<div class=\"divider\"></div>\n");
      out.write("\t\t<ul class=\"nav menu\">\n");
      out.write("\t\t\t\n");
      out.write("\t\t\t<li><a href=\"visits_filter.jsp\"><em class=\"fa fa-calendar\">&nbsp;</em> Visits</a></li>\n");
      out.write("                        \n");
      out.write("\t\t\t<li class=\"parent \"><a data-toggle=\"collapse\" href=\"#sub-item-1\">\n");
      out.write("\t\t\t\t<em class=\"fa fa-navicon\">&nbsp;</em> Management <span data-toggle=\"collapse\" href=\"#sub-item-1\" class=\"icon pull-right\"><em class=\"fa fa-plus\"></em></span>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t\t<ul class=\"children collapse\" id=\"sub-item-1\">\n");
      out.write("\t\t\t\t\t<li><a class=\"\" href=\"areas.jsp\">\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-twitch\">&nbsp;</span> Areas of Observation\n");
      out.write("\t\t\t\t\t</a></li>\n");
      out.write("                                        <li><a class=\"\" href=\"projects.jsp\">\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-certificate\">&nbsp;</span> Projects\n");
      out.write("\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"\" href=\"counties.jsp\">\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-vk\">&nbsp;</span> Counties\n");
      out.write("\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"\" href=\"partners.jsp\">\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-won\">&nbsp;</span> Implementing Partners\n");
      out.write("\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"\" href=\"obligation.jsp\">\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-won\">&nbsp;</span> Obligation\n");
      out.write("\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"\" href=\"users.jsp\">\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-user\">&nbsp;</span> Users\n");
      out.write("\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</li>\n");
      out.write("\t\t\t<li class=\"parent \"><a data-toggle=\"collapse\" href=\"#sub-item-2\">\n");
      out.write("\t\t\t\t<em class=\"fa fa-navicon\">&nbsp;</em> Reports <span data-toggle=\"collapse\" href=\"#sub-item-1\" class=\"icon pull-right\"><em class=\"fa fa-plus\"></em></span>\n");
      out.write("\t\t\t\t</a>\n");
      out.write("\t\t\t\t<ul class=\"children collapse\" id=\"sub-item-2\">\n");
      out.write("\t\t\t\t\t<li><a class=\"\" href=\"reports_filter.jsp\">\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-area-chart\">&nbsp;</span> Visit Reports\n");
      out.write("\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t<li><a class=\"\" href=\"partners_report\">\n");
      out.write("\t\t\t\t\t\t<span class=\"fa fa-pie-chart\">&nbsp;</span> Partners & Obligations\n");
      out.write("\t\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t\t\n");
      out.write("\t\t\t\t</ul>\n");
      out.write("\t\t\t</li>\n");
      out.write("                       <li><a href=\"user_profile.jsp\"><em class=\"fa fa-user-md\">&nbsp;</em> User Profile</a></li>\n");
      out.write("\t\t\t<li><a href=\"logout\"><em class=\"fa fa-power-off\">&nbsp;</em> Logout</a></li>\n");
      out.write("\t\t</ul>\n");
      out.write("\t</div><!--/.sidebar-->\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\t\n");
      out.write("    </div> <!-- end of sidebar -->\n");
      out.write("\t\n");
      out.write("    \n");
      out.write("    <div class=\"content-data\"> <!-- start of contents body -->\t\n");
      out.write("       <div class=\"col-sm-9 col-sm-offset-3 col-lg-10 col-lg-offset-2 main\">\n");
      out.write("\t\t<div class=\"row\">\n");
      out.write("\t\t\t<ol class=\"breadcrumb\">\n");
      out.write("\t\t\t\t<li><a href=\"#\">\n");
      out.write("\t\t\t\t\t<em class=\"fa fa-home\"></em>\n");
      out.write("\t\t\t\t</a></li>\n");
      out.write("\t\t\t\t<li class=\"active\">Dashboard</li>\n");
      out.write("\t\t\t</ol>\n");
      out.write("\t\t</div><!--/.row-->\n");
      out.write("\n");
      out.write("\t</div>\t<!--/.main-->\n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("        \n");
      out.write("\t</div> <!-- end of contents body -->\n");
      out.write("        \n");
      out.write("    \n");
      out.write("\t<script src=\"js/jquery-1.11.1.min.js\"></script>\n");
      out.write("\t<script src=\"js/bootstrap.min.js\"></script>\n");
      out.write("\t<script src=\"js/chart.min.js\"></script>\n");
      out.write("\t<script src=\"js/chart-data.js\"></script>\n");
      out.write("\t<script src=\"js/easypiechart.js\"></script>\n");
      out.write("\t<script src=\"js/easypiechart-data.js\"></script>\n");
      out.write("\t<script src=\"js/bootstrap-datepicker.js\"></script>\n");
      out.write("\t<script src=\"js/custom.js\"></script>\n");
      out.write("\t\t\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
