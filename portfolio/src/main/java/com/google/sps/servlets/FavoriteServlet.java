// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

/** Servlet that returns HTML that contains the page view count. */
@WebServlet("/hello")
public class FavoriteServlet extends HttpServlet {


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

    ArrayList<String> favs = new ArrayList<String>();
    favs.add("Sport: Triathlon");
    favs.add("Movie: Interstellar");
    favs.add("Superhero: Captain America");
    favs.add("Singer: Taylor Swift");
    favs.add("Food: Korean BBQ");
    favs.add("National Park: Zion");
    favs.add("Drink: Tea");
    favs.add("Color: Green");
    favs.add("Cartoon: Avatar the Last Airbender");
    String json = convertToJsonUsingGson(favs);

    // Send the JSON as the response
    response.setContentType("application/json;");
    response.getWriter().println(json);
  }

  private String convertToJsonUsingGson(ArrayList<String> favs) {
    Gson gson = new Gson();
    String json = gson.toJson(favs);
    return json;
  }
}
