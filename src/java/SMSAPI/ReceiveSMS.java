/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SMSAPI;

import Database.dbConn;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 *
 * @author Geofrey Nyabuto
 */
public class ReceiveSMS extends HttpServlet {
    HttpSession session;
String sms,message,sender,build_data;
dbConn conn = new dbConn();
String sa_id,sa_code,counsellor_id,counsellor_code,facility_id;
String indicator_data;
HashMap<String, String> indicator_codes;
int all_errors,errors,success;
String all_error_message,error_message="";
String today;
String counsellor_indic_id="1";
String response_message,response_description;
int response_code,data_elems_counter;
String source,pn_id,user_type_id,c_code;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            session = request.getSession();
         indicator_codes = get_all_indicators(); // method to get all indicators and push them to hashmap
         today = get_today_date(); // method to get today's date                    
            message=sender=all_error_message="";
            data_elems_counter = all_errors=0;
            response_code=222;
            
            
            if(request.getParameter("sa_id")!=null){
                source="web";
                sa_id=request.getParameter("sa_id");
                build_data = "";
                
                if(session.getAttribute("pn_id")!=null && session.getAttribute("user_type_id")!=null){
                pn_id = session.getAttribute("pn_id").toString();
                user_type_id = session.getAttribute("user_type_id").toString();
                String get_counsellor = "SELECT code FROM counsellor WHERE id in("+pn_id+")";
                conn.rs = conn.st.executeQuery(get_counsellor);
                if(conn.rs.next()){
                  c_code="C"+conn.rs.getString(1);
                }
                else{
                    c_code="";
                }
                  System.out.println("2");
                if(!user_type_id.equals("1") || c_code.equals("")){
                response_code=0;
                response_message="Failed";
                response_description="This user is not a counsellor. Only counsellors can send data over web interface."; 
                }
                else{
               String get_area_code="SELECT code FROM service_area WHERE id in("+sa_id+")";
               conn.rs = conn.st.executeQuery(get_area_code);
               if(conn.rs.next()){
                   sa_code=conn.rs.getString(1);
               }
               String getelems = "SELECT code FROM indicator";
               conn.rs = conn.st.executeQuery(getelems);
               while(conn.rs.next()){
                   if(request.getParameter(conn.rs.getString(1))!=null){
                       String dt = request.getParameter(conn.rs.getString(1));
                       if(!dt.equals("")){
                           build_data +=conn.rs.getString(1)+""+dt+" ";
                           data_elems_counter++;
                       }
                   }
               }
             
                    System.out.println("data elems counter : "+data_elems_counter);
                    if(data_elems_counter>0){
               sms="{\"message\":\""+c_code+" "+sa_code+" "+build_data+" \",\"sender\":\"web\"}";
                    }
                    else{
                        sms=null;
                    response_code=0;
                    response_message="Failed";
                    response_description="No data elements to be added into the system";
                    }
                 System.out.println(sms);
                }
                }
                else{
                    sms="";
                    response_code=0;
                    response_message="Failed";
                    response_description="Failed to authenticate user. Log out and login again";
                }
               
            }
            
            
            
            else{
                source="sms";
//            sms = request.getParameter("json");
         BufferedReader in = new BufferedReader(
         new InputStreamReader(request.getInputStream()));
         String inputLine;
         StringBuffer res = new StringBuffer();
         while ((inputLine = in.readLine()) != null) {
            res.append(inputLine);
         }
         in.close();
         
            System.out.println("res : "+res);
         sms = res.toString();
            } // end of receiving sms
         
         
         
            System.out.println("sms :"+sms);
//          sms="{\"message\":\"C084 HTSP T26 P1 PNS1 L1 END C084 PNSANC IND1 INDSC1 CL5 CLE3 CKP2 T1 P1  L1 \",\"sender\":\"+254725627847\"}";
        //  sms="{\"message\":\"C098 HTSP T12 P3 F1 PNS2 L2 OD1\",\"sender\":\"+254780698944\"}";
            
            
            if(response_code!=0){ // if it is missing any important data, discard it 
            JSONParser parser = new JSONParser();
            try{
            JSONObject jsonSMS = (JSONObject) parser.parse(sms);
            
            message = (String)jsonSMS.get("message");
            sender = (String) jsonSMS.get("sender");
            
                System.out.println("message : "+message);
                System.out.println("sender : "+sender);
                
                
                // log sms as being received 
                savesmslog();
                
                String [] messages =message.split("END");
                
               for(String s_message:messages){
                   errors=0;
                   error_message="";
                   System.out.println("message is: "+s_message);
                  
                  getServiceArea(s_message.trim());

                  indicator_data = s_message.replace(sa_code,"").trim();
                 
                System.out.println("said : "+sa_id+" sa code : "+sa_code);
                ArrayList indics = getIndicators(indicator_data);
                getCounsellorinfo(); 
                
                   System.out.println("counsellor id : "+counsellor_code);
                if(counsellor_id.equals("")){
                    errors++;
                    error_message+=" Missing/incorrect counsellor's code\n";
                }
                if(sa_id.equals("")){
                    errors++;
                    error_message+=" Missing/incorrect service area code\n";
                }
                
                   System.out.println("errors : "+all_error_message);
                   
                if(errors==0){
                       for (Object indic : indics) {
                           HashMap<String,String> decoded_data = (HashMap)indic;
                           String indicator_id = decoded_data.get("id");
                           String achieved = decoded_data.get("data");
                           System.out.println("phone :"+sender+" date :"+today+" facility_id :"+facility_id+" counsellor_id :"+counsellor_id+" service area_id :"+sa_id+" indicator_id :"+indicator_id+" achieved: "+achieved);

                           // insert data into system.
                       save_data(indicator_id,achieved);
                       
                       }
                  
                }
                else{
                   System.out.println("SKIPPED : no of errors : "+errors+" details: "+error_message); 
                }
                all_errors+=errors;
                all_error_message+=error_message;
               }
                System.out.println("all error msms"+all_error_message);   
            }
            catch(Exception e){
                System.out.println("Error occured : "+e);
                all_errors +=1;
                all_error_message+="Unknow error occured";
            }
            
            System.out.println("all errors : "+all_errors);
            
            if(all_errors==0){
                //update as processed
              updatesmslog();  
            response_code=1;
            response_message="success";
            if(source.equals("web")){
            response_description = c_code+"'s data saved successfully. <b style='color: blue;'>"+data_elems_counter+"</b> element(s) saved";
            }
            else{
           response_description = "Data extracted from the SMS and was saved successfully";     
            }
            }
            else{
            response_code=0;
            response_message="Failed";
            response_description = "SMS had errors as described : "+all_error_message;     
            }
        }
           JSONObject obj = new JSONObject();
           obj.put("code", response_code);
           obj.put("message", response_message);
           obj.put("description", response_description);
           obj.put("source", source);
            
            System.out.println(obj);
            out.println(obj);
//      ************************************************
//      ***********************END**********************
//      ************************************************
            
        } finally {
            out.close();
        }
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
        Logger.getLogger(ReceiveSMS.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(ReceiveSMS.class.getName()).log(Level.SEVERE, null, ex);
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

    public void getServiceArea(String message) throws SQLException{
        
        message = message.replace(" ", "','");
        message = "'"+message+"'";
       // System.out.println("final message : "+message);
        
        String query = "SELECT id,code FROM service_area WHERE code in("+message+")";
        conn.pst = conn.conn.prepareStatement(query);       
        conn.rs = conn.pst.executeQuery();
        if(conn.rs.next()){
            sa_id = conn.rs.getString(1);
            sa_code = conn.rs.getString(2);
        }
        else{
         sa_id = "";
         sa_code = "";   
        }
    }
    public ArrayList getIndicators(String data){
          ArrayList formatted_data = new ArrayList();
        formatted_data.clear();
        
          String [] all_data = data.split(" ");
          for(String ind_data:all_data){
              if(ind_data.trim().length()>1){
                System.out.println("indic : "+ind_data);
                  if(!getIndicator(ind_data).isEmpty()){
                formatted_data.add(getIndicator(ind_data));
                  }
              }
    } 
   return formatted_data;
    }
    public HashMap<String,String> getIndicator(String ind_data){
     HashMap<String,String> dt = new HashMap<String, String>(); 
     dt.clear();
   String data= ind_data.replaceAll("[^0-9]", "");
   String code = ind_data.replace(data, "");
    System.out.println("code :"+code+" data :"+data);
    if(!data.isEmpty()){
   String id = indicator_codes.get(code);
   if(id == null){
   all_error_message+= " Wrong indicator code : "+code+"\n"; 
   all_errors++;
   }
   else{
   if(id.equals(counsellor_indic_id)){
       counsellor_code = data;
   }
   else{
             dt.put("id", id);
              dt.put("data", data);
   }
   }
       // System.out.println("id :"+id+" code :"+code+" data :"+data);
    }
        
        return dt;
    }
    public HashMap<String,String> get_all_indicators() throws SQLException{
       HashMap<String,String> data = new HashMap<String, String>();
       data.clear();
        String query = "SELECT id,code FROM indicator";
        conn.rs = conn.st.executeQuery(query);
        while(conn.rs.next()){
          data.put(conn.rs.getString(2), conn.rs.getString(1));
        }
    
        return data;
    }
    public void getCounsellorinfo() throws SQLException{
  String query = "SELECT id,facility_id FROM counsellor WHERE code in(?)";
  conn.pst = conn.conn.prepareStatement(query);
  conn.pst.setString(1, counsellor_code);
  conn.rs = conn.pst.executeQuery();
  if(conn.rs.next()){
      counsellor_id = conn.rs.getString(1);
      facility_id = conn.rs.getString(2);
  }
  else{
   counsellor_id = "";
   facility_id = "";   
  }
 
}
    public void savesmslog() throws SQLException{
        String query = "select id FROM logs WHERE message=? AND date=?";
        conn.pst = conn.conn.prepareStatement(query);
        conn.pst.setString(1, message);
        conn.pst.setString(2, today);
        conn.rs = conn.pst.executeQuery();
        if(conn.rs.next()){
            //sms already logged
        }
        else{
            //log as a new entry
            String inserter = "INSERT INTO logs(sender,message,date) VALUES(?,?,?)";
            conn.pst = conn.conn.prepareStatement(inserter);
            conn.pst.setString(1, sender);
            conn.pst.setString(2, message);
            conn.pst.setString(3, today);
            conn.pst.executeUpdate();
        }
    }
    public void updatesmslog() throws SQLException{
        String update = "UPDATE logs set status=? WHERE message=? AND date=?";
        conn.pst = conn.conn.prepareStatement(update);
        conn.pst.setInt(1,1);
        conn.pst.setString(2, message);
        conn.pst.setString(3, today);
        conn.pst.executeUpdate();
       
    }
    public String get_today_date(){
        String date = "";
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        Calendar dt = Calendar.getInstance();
        date = df.format(dt.getTime());
        
        
        return date;
    }
    public int save_data(String indicator_id,String achieved) throws SQLException{
       int saved=0;
        //checker
        String checker = "SELECT obs_id FROM data WHERE date=? AND facility_id=? AND counsellor_id=? AND service_area_id=? AND indicator_id=?";
        conn.pst = conn.conn.prepareStatement(checker);
        conn.pst.setString(1, today);
        conn.pst.setString(2, facility_id);
        conn.pst.setString(3, counsellor_id);
        conn.pst.setString(4, sa_id);
        conn.pst.setString(5, indicator_id);
        
        conn.rs = conn.pst.executeQuery();
        if(conn.rs.next()){
            // update the values
            String update = "UPDATE data SET achieved=? WHERE obs_id=?";
            conn.pst1 = conn.conn.prepareStatement(update);
            conn.pst1.setString(1, achieved);
            conn.pst1.setString(2, conn.rs.getString(1));
           saved = conn.pst1.executeUpdate();
        }
        else{
            //insert as new record
            String insert = "INSERT INTO data (phone,date,facility_id,counsellor_id,service_area_id,indicator_id,achieved) VALUES(?,?,?,?,?,?,?)";
            conn.pst = conn.conn.prepareStatement(insert);
            conn.pst.setString(1, sender);
            conn.pst.setString(2, today);
            conn.pst.setString(3, facility_id);
            conn.pst.setString(4, counsellor_id);
            conn.pst.setString(5, sa_id);
            conn.pst.setString(6, indicator_id);
          conn.pst.setString(7, achieved);
          saved = conn.pst.executeUpdate();
            
        }
        
         System.out.println("phone :"+sender+" date :"+today+" facility_id :"+facility_id+" counsellor_id :"+counsellor_id+" service area_id :"+sa_id+" indicator_id :"+indicator_id+" achieved: "+achieved);
       
         return saved;
    }
}
