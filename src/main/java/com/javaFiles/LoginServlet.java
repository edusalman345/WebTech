//            jdbc:mysql://127.0.0.1:3306/login_app
package com.javaFiles;

import jakarta.servlet.http.*;
import jakarta.servlet.ServletException;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.sql.*;

public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        res.setContentType("text/html");

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login_app",
                    "root",
                    "toor"
            );

            // ✅ ONLY username check
            PreparedStatement ps = con.prepareStatement(
                    "SELECT password FROM users WHERE username=?"
            );

            ps.setString(1, username);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {

                String hashedPassword = rs.getString("password");

                // 🔐 BCrypt compare
                if (BCrypt.checkpw(password, hashedPassword)) {
                    res.getWriter().println("Login success!");
                } else {
                    res.getWriter().println("Invalid password!");
                }

            } else {
                res.getWriter().println("User not found!");
            }

        } catch (Exception e) {
            res.getWriter().println(e);
        }
    }
}