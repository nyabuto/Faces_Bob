/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

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

/**
 *
 * @author Geofrey Nyabuto
 */
public class login extends HttpServlet {

HttpSession session;
String id,password,fullname,username,phone,pass,nextPage,message,user_type_id,user_type_name,gender;
MessageDigest m;
int code;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NoSuchAlgorithmException, SQLException {
       
           session = request.getSession();
           dbConn conn = new dbConn();
           
           username = request.getParameter("username");
           pass = request.getParameter("password");
           //encrypt the password
             m = MessageDigest.getInstance("MD5");
            m.update(pass.getBytes(), 0, pass.length());
            password = new BigInteger(1, m.digest()).toString(16);
       //end of password encryption
       
       
       String login = 
               "SELECT u.id,concat_ws(\" \",pn.given_name,pn.middle_name,pn.sur_name) AS FullName,"+
               "u.username AS username,u.user_type_id as user_type,ut.name AS UserTypeName, pn.gender  " +
               "FROM user u INNER JOIN person_name pn ON u.person_name_id=pn.id AND u.status=1 AND pn.status=1 " +
               "INNER JOIN user_type ut ON u.user_type_id=ut.id WHERE u.username=? AND u.password=?";
       conn.pst = conn.conn.prepareStatement(login);
       conn.pst.setString(1, username);
       conn.pst.setString(2, password);
       
       conn.rs = conn.pst.executeQuery();
       if(conn.rs.next()){
        id = conn.rs.getString(1);
        fullname = conn.rs.getString(2);
        username = conn.rs.getString(3);
        user_type_id = conn.rs.getString(4);
        user_type_name = conn.rs.getString(5);
        gender = conn.rs.getString(6);

        
        
        session.setAttribute("id", id);
        session.setAttribute("fullname", fullname);
        session.setAttribute("username", username);
        session.setAttribute("user_type_id", user_type_id);
        session.setAttribute("user_type_name", user_type_name);
        session.setAttribute("gender", gender);

        nextPage =  "home.jsp";    
        
       }
       else{
           code = 0;
           message = "login failed. Wrong username and password combination.";
           nextPage = "index.jsp";
           session.setAttribute("message", message);
       }
        
        
        response.sendRedirect(nextPage);
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
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
    } catch (SQLException ex) {
        Logger.getLogger(login.class.getName()).log(Level.SEVERE, null, ex);
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
