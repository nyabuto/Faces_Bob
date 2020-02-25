/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Database.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
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
public class update_user extends HttpServlet {
    HttpSession session;
    String user_id,pass1,pass2,password;
    int code;
    String message,description;
    MessageDigest m;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
       
        session = request.getSession();
        dbConn conn = new dbConn();
       
        pass1 = request.getParameter("pass1");
        pass2 = request.getParameter("pass2");
        
        
        if(pass1.equals(pass2)){
        if(session.getAttribute("id")!=null){
            user_id = session.getAttribute("id").toString();
          
                m = MessageDigest.getInstance("MD5");
            m.update(pass1.getBytes(), 0, pass1.length());
            password = new BigInteger(1, m.digest()).toString(16);
            
            
         String update = "UPDATE user SET password=? WHERE id IN(?)";
         conn.pst = conn.conn.prepareStatement(update);
         conn.pst.setString(1, password);
         conn.pst.setString(2, user_id);
           
         conn.pst.executeUpdate();
         code=1;
         message="Success";
         description="User password updated successfully.";
        }
        else{
         code=0;
         message="Error";   
         message="We could not authenticate your information. Try logging in again.";   
        }    
        }
        else{
            code=0;
            message="Error";
            description="Wrong passwords entered. They dont match.";
        }
    
        JSONObject obj = new JSONObject();
        obj.put("code", code);
        obj.put("message", message);
        obj.put("description", description);
        
        
        System.out.println(obj);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(update_user.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(update_user.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(update_user.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(update_user.class.getName()).log(Level.SEVERE, null, ex);
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
