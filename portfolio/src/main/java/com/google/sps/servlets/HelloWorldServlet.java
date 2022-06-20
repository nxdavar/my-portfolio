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
    List<String> hobbies = new ArrayList<String>();
    hobbies.add("Driving my car on back roads (#savethemanuals, also I'm going to plug my Instagram: @lt1bros)");
    hobbies.add("Traveling");
    hobbies.add("Trying new food");
    hobbies.add("Strength training and all things fitness");
    hobbies.add("Photography and taking aesthetic pictures");

    // List<String> images = new ArrayList<String>();
    hobbies.add("/images/cornering_civic.jpeg");
    hobbies.add("/images/traveling_sps.jpeg");
    hobbies.add("/images/new_food.jpeg");
    hobbies.add("/images/weight_lifting.jpeg");
    hobbies.add("/images/NYC_travel.jpg");

    String jsonHobbies = convertToJsonUsingGson(hobbies);  
    response.setContentType("application/json;");  
    response.getWriter().println(jsonHobbies);
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
