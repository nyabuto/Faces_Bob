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
public class getIndicators extends HttpServlet {
    HttpSession session;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        session = request.getSession();
        dbConn conn = new dbConn();
        
        
        JSONArray array = new JSONArray();
        JSONObject fn_obj = new JSONObject();
        
        array.clear();
        fn_obj.clear();
        
        String get_indicators = "SELECT id,code,fullname,ifnull(description,''),is_non_linkage_reason,indicator_type_id FROM indicator WHERE is_active=1 AND is_indicator=1 ORDER BY order_id";
        conn.rs = conn.st.executeQuery(get_indicators);
        while(conn.rs.next()){
            JSONObject obj = new JSONObject();
            obj.put("id", conn.rs.getString(1));
            obj.put("code", conn.rs.getString(2));
            obj.put("fullname", conn.rs.getString(3));
            obj.put("description", conn.rs.getString(4));
            obj.put("is_non_linkage_reason", conn.rs.getString(5));
            obj.put("indicator_type_id", conn.rs.getString(6));
            
            array.add(obj);
            
        }
        
        
        
        fn_obj.put("indicators", array);
        out.println(fn_obj);
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
            Logger.getLogger(getIndicators.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(getIndicators.class.getName()).log(Level.SEVERE, null, ex);
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
