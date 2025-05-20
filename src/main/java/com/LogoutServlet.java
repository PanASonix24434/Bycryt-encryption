package com;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1117661381211791003L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate();  // Invalidate the session to log the user out

        // Log for debugging
        System.out.println("User logged out. Redirecting to register.jsp.");

        response.sendRedirect("register.jsp");  // Redirect to the register.jsp page
    }
}
