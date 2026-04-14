package com.javaFiles;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.mindrot.jbcrypt.BCrypt;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class signupServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws IOException {

        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/login_app",
                    "root",
                    "toor"
            );

            // check if user already exists
            PreparedStatement check = con.prepareStatement(
                    "SELECT * FROM users WHERE username=?"
            );
            check.setString(1, username);

            ResultSet rs = check.executeQuery();

            if (rs.next()) {
                out.println("<h3 style='color:red'>Username already exists!</h3>");
            } else {

                PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO users(username, password) VALUES (?, ?)"
                );

                ps.setString(1, username);
                ps.setString(2, hashedPassword);

                int i = ps.executeUpdate();

                if (i > 0) {
                    out.println("<h3 style='color:green'>Signup Successful!</h3>");
                    out.println("<a href='login.jsp'>Go to Login</a>");
                } else {
                    out.println("<h3 style='color:red'>Signup Failed</h3>");
                }
            }

            con.close();

        } catch (Exception e) {
            out.println(e);
        }
    }
}