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

@WebServlet("/findMovie")
public class FindServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head><title>SEEKING PAGE</title><link rel=\"shortcut icon\" href=\"image/movieIcon.jpg\" type=\"image/x-icon\"/></head>");
        out.write("<body style=\"background-color:black;color:darkorange\", align=\"center\">");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        out.println("<h1 align=\"center\"> founded movie</h1>");
        out.write("<table border ='1'>");
        out.write("<tr>");
        out.write("<th> Title         </th>");
        out.write("<th> Director </th>");
        out.write("<th> Year        </th>");
        out.write("<th> Average Rate </th>");
        out.write("</tr>");


        if (((org.hibernate.query.Query) em
                .createQuery("SELECT movie " +
                        "FROM Movie movie WHERE movie.title =:tit", Movie.class)
                .setParameter("tit", request.getParameter("title"))).list().isEmpty()) {

            out.write("<td>" + "MOVIE NOT FOUNDED" + "</td>");
            out.write("</tr>");

        } else {
            Movie movie = em
                    .createQuery("SELECT movie " +
                            "FROM Movie movie WHERE movie.title =:tit", Movie.class)
                    .setParameter("tit", request.getParameter("title"))
                    .getSingleResult();
            out.println(movie.toStringAboutMovie());
            out.write("<td>" + movie.getTitle() + "</td>");
            out.write("<td>" + movie.getDirector() + "</td>");
            out.write("<td>" + movie.getYear() + "</td>");
            out.write("<td>" + movie.getRate() + "</td>");
            out.write("</tr>");
        }

        out.write("</table>");

        out.write("<br><a href=\"index.html\">Back to Main Page</a>");
        out.write("</body></html>");
    }

    public void destroy() {
    }
}