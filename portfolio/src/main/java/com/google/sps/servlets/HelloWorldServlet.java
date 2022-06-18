package com.google.sps.servlets;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ListModel;

/** Handles requests sent to the /hello URL. Try running a server and navigating to /hello! */
@WebServlet("/hello")
public class HelloWorldServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    List<String> names = new ArrayList<String>();
    names.add("Hello Neal!");
    names.add("Hello Bob!");
    names.add("Hello Joe!");
    String json = convertToJsonUsingGson(names);
    response.setContentType("application/json;");  
    response.getWriter().println(json);
  }

 /**
   * Converts the input of an arraylist of names into a JSON string using the
   * Gson library. Note: We first added the Gson library dependency to
   * pom.xml.
   */
  private String convertToJsonUsingGson(List<String> names) {
    Gson gson = new Gson();
    String json = gson.toJson(names);
    return json;
  }
}
