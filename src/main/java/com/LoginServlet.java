package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;  // Import PropertyConfigurator

import org.mindrot.jbcrypt.BCrypt;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(LoginServlet.class);

    static {
        // Load log4j configuration
        PropertyConfigurator.configure("src/log4j.properties");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String jdbcUrl = "jdbc:mysql://localhost:3306/webappdb?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            Connection connection = DriverManager.getConnection(jdbcUrl, "root", "root");

            String query = "SELECT * FROM users WHERE username=?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) { 
                String hashedPasswordFromDB = resultSet.getString("password");

                if (BCrypt.checkpw(password, hashedPasswordFromDB)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("username", username);
                    response.sendRedirect(request.getContextPath() + "/welcome.jsp");
                } else {
                    response.sendRedirect("login.jsp?error=InvalidCredentials");
                }
            } else {
                response.sendRedirect("login.jsp?error=InvalidCredentials");
            }

            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            logger.error("Exception occurred during login:", e);
            response.sendRedirect("error.jsp?error=" + e.getMessage());
        } catch (Exception e) {
            logger.error("Unexpected error occurred during login:", e);
            response.sendRedirect("error.jsp?error=UnexpectedError");
        }
    }
}
