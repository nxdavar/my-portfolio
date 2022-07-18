package com.google.sps.servlets;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/form-handler")
public class BaseServlet extends HttpServlet {

  // method that redirects user to Neal's Linkedin or Github depending
  // on form input
  @Override
  public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
    boolean visitLinkedin = Boolean.parseBoolean(getParameter(request, "linkedin-btn", "false"));
    if(visitLinkedin) {
        response.sendRedirect("https://www.linkedin.com/in/nealdavar/");
    }
    else {
        response.sendRedirect("https://github.com/nxdavar");
    }
  }

  private String getParameter(HttpServletRequest request, String name, String defaultValue) {
    String value = request.getParameter(name);
    if (value == null) {
      return defaultValue;
    }
    return value;
  }
  
}