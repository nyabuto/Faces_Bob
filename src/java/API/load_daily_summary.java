/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;

/**
 *
 * @author Geofrey Nyabuto
 */
public class load_daily_summary extends HttpServlet {
    HttpSession session;
    String user_level,group_by;
    String area_id,get_area_id;
    String area_name,today;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        JSONObject obj = new JSONObject();
        
        session = request.getSession();
        dbConn conn = new dbConn();
        
        
        today = get_today_date();
        
        group_by="";
        area_name="FACES Program";
        if(session.getAttribute("user_type_id")!=null){
           
         user_level = session.getAttribute("user_type_id").toString();
            System.out.println("level :"+user_level);
          switch(Integer.parseInt(user_level)){
              
              case 1:
                  group_by="group by c.id";
                 get_area_id="SELECT c.id as c_id,concat(concat_ws(\" \", pn.given_name,pn.middle_name,pn.sur_name),\" [\",c.code,\"]\") AS CounsellorName FROM user u INNER JOIN counsellor c ON u.person_name_id=c.id  AND u.id in("+session.getAttribute("id").toString()+") "
                         + "INNER JOIN person_name pn ON u.person_name_id=pn.id";
                  System.out.println("get area id : "+get_area_id);
                  conn.rs = conn.st.executeQuery(get_area_id);
                  if(conn.rs.next()){
                      area_id=" c.id in("+conn.rs.getString(1)+")";
                      area_name=conn.rs.getString(2);
                  }
              break;
              case 2:
                  group_by="group by f.id";
                  get_area_id="SELECT c.facility_id as f_id,concat(f.name,\" [\",f.mflcode,\"]\") AS FacilityName FROM user u INNER JOIN counsellor c ON u.person_name_id=c.id  AND u.id in("+session.getAttribute("id").toString()+") "
                          + "INNER JOIN facility f ON c.facility_id=f.id ";
                  conn.rs = conn.st.executeQuery(get_area_id);
                  if(conn.rs.next()){
                      area_id=" f.id in("+conn.rs.getString(1)+")";
                      area_name=conn.rs.getString(2);
                  }
              break;
              case 3:
                  group_by="group by ma.id";
                  get_area_id="SELECT scu.ma_id,ma.name AS SCounty FROM user u INNER JOIN sub_county_user scu ON u.person_name_id=scu.pn_id AND u.id in("+session.getAttribute("id").toString()+") "
                          + "INNER JOIN management_area ma ON scu.ma_id=ma.id";
                  conn.rs = conn.st.executeQuery(get_area_id);
                  if(conn.rs.next()){
                      area_id=" ma.id in("+conn.rs.getString(1)+")";
                      area_name=conn.rs.getString(2)+" Sub County";
                  }
              break;       
          }
          
            System.out.println(user_level+": area_id:"+area_id);
         String get_data = "SELECT "+
            "SUM(CASE WHEN i.code in(\"T\") THEN d.achieved ELSE 0 END) AS 'T',\n" +
            "SUM(CASE WHEN i.code in(\"P\") THEN d.achieved ELSE 0 END) AS 'P',\n"+
            "SUM(CASE WHEN i.code in(\"F\") THEN d.achieved ELSE 0 END) AS 'F',\n" +
            "SUM(CASE WHEN i.code in(\"PNS\") THEN d.achieved ELSE 0 END) AS 'PNS',\n"+
            "SUM(CASE WHEN i.code in(\"L\") THEN d.achieved ELSE 0 END) AS 'L' " +
            "FROM data d INNER JOIN indicator i ON d.indicator_id=i.id AND d.date in('"+today+"')\n" +
            "INNER JOIN service_area sa ON d.service_area_id=sa.id AND sa.id IN(1) \n" + // only for PNS totals
            "INNER JOIN program_area pa ON sa.program_area_id=pa.id \n";
                 
            get_data+="INNER JOIN counsellor c ON d.counsellor_id=c.id \n";
            if(user_level.equals("1")){get_data+=" AND "+area_id+" ";}
                 
            get_data+="INNER JOIN person_name pn ON c.id=pn.id \n";
                 
            get_data+="INNER JOIN facility f ON d.facility_id=f.id ";
             if(user_level.equals("2")){get_data+=" AND "+area_id+" ";}
             
            get_data+="INNER JOIN sub_county sc ON f.sub_county_id=sc.id \n";
                 
            get_data+="INNER JOIN management_area ma ON sc.mgt_id=ma.id\n";
            if(user_level.equals("3")){get_data+=" AND "+area_id+" ";}
            
//            get_data+=" "+group_by+" ";
          
                  System.out.println("query: "+get_data);   
         conn.rs = conn.st.executeQuery(get_data);
         if(conn.rs.next()){
         JSONObject obj_data =  new JSONObject();
         obj_data.put("Tested", conn.rs.getString("T"));
         obj_data.put("Positive", conn.rs.getString("P"));
         obj_data.put("Facility", conn.rs.getString("F"));
         obj_data.put("PNS", conn.rs.getString("PNS"));
         obj_data.put("Linked", conn.rs.getString("L"));
         obj_data.put("area", area_name);
         
         obj.put("data", obj_data);
         }
         else{
             
         }
              
        }
        else{
            System.out.println("missed id");  
        }
      
        System.out.println("obj data: "+ obj); 
        out.println(obj);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(load_daily_summary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(load_daily_summary.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

        public String get_today_date(){
        String date = "";
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        Calendar dt = Calendar.getInstance();
        date = df.format(dt.getTime());
        
        
        return date;
    }
}
