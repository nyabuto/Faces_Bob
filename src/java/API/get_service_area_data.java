/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Geofrey Nyabuto
 */
public class get_service_area_data extends HttpServlet {
    HttpSession session;
    String sa_id,start_date,end_date,service_area_name;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        session = request.getSession();
        dbConn conn = new dbConn();
        if(session.getAttribute("id")!=null){
        service_area_name = "";
        sa_id = request.getParameter("id");
        System.out.println("area id : "+sa_id);
       // sa_id="1";
        JSONObject fn_obj = new JSONObject();
        JSONArray arr_data = new JSONArray();
        JSONArray arrayheader = new JSONArray();
       arrayheader.clear();
        
        HashMap<String,String> indicator_labels = new HashMap<String, String>();
        indicator_labels.clear();
        
        // get indicator labels 
        String labels="SELECT code,fullname from indicator WHERE is_active=1";
        conn.rs = conn.st.executeQuery(labels);
        while(conn.rs.next()){
         indicator_labels.put(conn.rs.getString(1), conn.rs.getString(2));
        }
        
        //get service area name
        String service_area = "SELECT code,fullname FROM service_area WHERE id in(?)";
        conn.pst = conn.conn.prepareStatement(service_area);
        conn.pst.setString(1, sa_id);
        conn.rs = conn.pst.executeQuery();
        if(conn.rs.next()){
            service_area_name=conn.rs.getString(2)+" ["+conn.rs.getString(1)+"]";
        }
        
        //System.out.println("length is : "+indicator_labels.size());
        
        String get_data = "SELECT "+
                "ma.name AS 'Sub County',"+
//                + "sc.name AS SubCounty,"
                "f.name AS 'Facility Name',"+
//                + "f.mflcode AS 'MFL Code',\n" +
//            "c.code AS 'Counsellor Code',"+
             "concat_ws(\" \", pn.given_name,pn.middle_name,pn.sur_name) as 'Counsellor Name', \n" +
//            "pa.name AS ProgramArea,"+
                // "sa.code AS ServiceAreaCode,"+
                // "sa.fullname AS ServiceAreaName,  \n" +
            "d.phone AS PhoneNumber,"+
                "d.date AS Date,\n";
                if(!sa_id.equals("1")){
            get_data+="SUM(CASE WHEN i.code in(\"IND\") THEN d.achieved ELSE 0 END) AS 'IND',\n" +
            "SUM(CASE WHEN i.code in(\"INDSC\") THEN d.achieved ELSE 0 END) AS 'INDSC',\n" +
            "SUM(CASE WHEN i.code in(\"CL\") THEN d.achieved ELSE 0 END) AS 'CL',\n" +
            "SUM(CASE WHEN i.code in(\"CKP\") THEN d.achieved ELSE 0 END) AS 'CKP',\n" +
            "SUM(CASE WHEN i.code in(\"CLE\") THEN d.achieved ELSE 0 END) AS 'CLE',\n" +
            "concat(1,\":\",ROUND(SUM(CASE WHEN i.code in(\"CL\") THEN d.achieved ELSE 0 END)/SUM(CASE WHEN i.code in(\"INDSC\") THEN d.achieved ELSE 0 END),0)) as 'Elicitation Rate',\n";
                    }
            get_data+="SUM(CASE WHEN i.code in(\"T\") THEN d.achieved ELSE 0 END) AS 'T',\n" +
            "SUM(CASE WHEN i.code in(\"P\") THEN d.achieved ELSE 0 END) AS 'P',\n";
            
            if(sa_id.equals("1")){
            get_data+="SUM(CASE WHEN i.code in(\"F\") THEN d.achieved ELSE 0 END) AS 'F',\n" +
            "SUM(CASE WHEN i.code in(\"PNS\") THEN d.achieved ELSE 0 END) AS 'PNS',\n";
            }
           get_data+= "concat(1,\":\",ROUND(SUM(CASE WHEN i.code in(\"T\") THEN d.achieved ELSE 0 END)/SUM(CASE WHEN i.code in(\"P\") THEN d.achieved ELSE 0 END),0)) as 'Positivity Rate',\n" +
            "SUM(CASE WHEN i.code in(\"L\") THEN d.achieved ELSE 0 END) AS 'L',\n" +
            "SUM(CASE WHEN i.code in(\"NR\") THEN d.achieved ELSE 0 END) AS 'NR',\n" +
            "SUM(CASE WHEN i.code in(\"AH\") THEN d.achieved ELSE 0 END) AS 'AH',\n" +
            "SUM(CASE WHEN i.code in(\"KP\") THEN d.achieved ELSE 0 END) AS 'KP',\n" +
            "SUM(CASE WHEN i.code in(\"WL\") THEN d.achieved ELSE 0 END) AS 'WL',\n" +
            "SUM(CASE WHEN i.code in(\"DL\") THEN d.achieved ELSE 0 END) AS 'DL',\n" +
            "SUM(CASE WHEN i.code in(\"DC\") THEN d.achieved ELSE 0 END) AS 'DC',\n" +
            "SUM(CASE WHEN i.code in(\"PV\") THEN d.achieved ELSE 0 END) AS 'PV',\n" +
            "SUM(CASE WHEN i.code in(\"MT\") THEN d.achieved ELSE 0 END) AS 'MT',\n" +
            "SUM(CASE WHEN i.code in(\"WP\") THEN d.achieved ELSE 0 END) AS 'WP',\n" +
            "SUM(CASE WHEN i.code in(\"OD\") THEN d.achieved ELSE 0 END) AS 'OD',\n" +
            "SUM(CASE WHEN i.code in(\"RE\") THEN d.achieved ELSE 0 END) AS 'RE',\n" +
            "SUM(CASE WHEN i.code in(\"TD\") THEN d.achieved ELSE 0 END) AS 'TD' \n" +
//            "d.timestamp AS Timestamp  \n" +
            "FROM data d INNER JOIN indicator i ON d.indicator_id=i.id -- AND d.date BETWEEN DATE('2020-02-01') AND DATE('2019-02-03')\n" +
            "INNER JOIN service_area sa ON d.service_area_id=sa.id  AND sa.id IN("+sa_id+")\n" +
            "INNER JOIN program_area pa ON sa.program_area_id=pa.id \n" +
            "INNER JOIN counsellor c ON d.counsellor_id=c.id -- AND c.id IN(2) \n" +
            "INNER JOIN person_name pn ON c.id=pn.id \n" +
            "INNER JOIN facility f ON d.facility_id=f.id -- and f.id in(2)\n" +
            "INNER JOIN sub_county sc ON f.sub_county_id=sc.id \n" +
            "INNER JOIN management_area ma ON sc.mgt_id=ma.id\n" +
            " group by d.date,c.id,sa.id,ma.id \n" +
            " ORDER BY d.date DESC,d.timestamp DESC";
        
        
        conn.rs = conn.st.executeQuery(get_data);
        
        // get db column labels
       ResultSetMetaData metaData = conn.rs.getMetaData();
        int columnCount = metaData.getColumnCount();
         String label;
         for(int j=1;j<=columnCount;j++){
           label = indicator_labels.get(metaData.getColumnLabel(j));
           if(label==null){label=metaData.getColumnLabel(j);}
            arrayheader.add(label);
         }
         
         // get data elements
        while(conn.rs.next()){
          JSONArray arr = new JSONArray();
          for(int j=1;j<=columnCount;j++){
         arr.add(conn.rs.getString(j));
         }
          arr_data.add(arr);   
        }
       
        fn_obj.put("header", arrayheader);
        fn_obj.put("data", arr_data);
        fn_obj.put("service_area", service_area_name);
       
        JSONObject outObj = new JSONObject();
        outObj.clear();
        outObj.put("response", fn_obj);
        
        out.println(outObj);
        System.out.println("ob: "+outObj);
        }
        else{
            System.out.println("Login to continue using this system.");  
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
            Logger.getLogger(get_service_area_data.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(get_service_area_data.class.getName()).log(Level.SEVERE, null, ex);
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

}
