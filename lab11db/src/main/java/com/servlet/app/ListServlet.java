package com.servlet.app;

import com.servlet.app.entity.Movie;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/getMovies")
public class ListServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head><title>GETTING LIST PAGE</title><link rel=\"shortcut icon\" href=\"image/movie.jpg\" type=\"image/x-icon\"/></head>");
        out.write("<body style=\"background-color:black;color:darkorange\", align=\"center\">");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        out.println("<h1 align=\"center\"> LIST OF MOVIES</h1>");
        out.write("<table border ='1'>");
        out.write("<tr>");
        out.write("<th> Title         </th>");
        out.write("<th> Director </th>");
        out.write("<th> Year        </th>");
        out.write("<th> Average Rate </th>");
        out.write("</tr>");

        List<Movie> movies = em
                .createQuery("SELECT movie " +
                        "FROM Movie movie ", Movie.class)
                .getResultList();

        for (Movie c : movies) {

            out.write("<tr>");
            out.write("<td>" + c.getTitle() + "</td>");
            out.write("<td>" + c.getDirector() + "</td>");
            out.write("<td>" + c.getYear() + "</td>");
            out.write("<td>" + c.getRate() + "</td>");
            out.write("</tr>");

        }

        out.write("</table>");

        out.write("<br><a href=\"index.html\">Back to Main Page</a>");
        out.write("</body></html>");
    }

    public void destroy() {
    }
}