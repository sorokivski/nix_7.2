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


@WebServlet("/addMovie")
public class JavaServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head><title>ADDING PAGE</title><link rel=\"shortcut icon\" href=\"image/movieIcon.jpg\" type=\"image/x-icon\"/></head>");
        out.write("<body style=\"background-color:black;color:darkorange\", align=\"center\">");

        String title = request.getParameter("title");
        String director = request.getParameter("director");
        int year = Integer.parseInt(request.getParameter("year"));
        String rate = request.getParameter("rate");
        if (((org.hibernate.query.Query) em
                .createQuery("SELECT movie " +
                        "FROM Movie movie WHERE movie.title =:tit", Movie.class)
                .setParameter("tit", request.getParameter("title"))).list().isEmpty()) {
            Movie movie = new Movie();
            movie.setTitle(title);
            movie.setDirector(director);
            movie.setYear(year);
            movie.setRate(rate);


            em.getTransaction().begin();
            em.persist(movie);
            em.getTransaction().commit();

            out.println("SAVED DATA ABOUT MOVIE: " + movie.getTitle());
            out.write("<br><a href=\"index.html\">Back to Main Page</a>");
            out.write("</body></html>");
        } else {
            out.println("DATABASE ALREADY CONTAINS THAT MOVIE: " + title);
            out.write("<br><a href=\"index.html\">Back to Main Page</a>");
            out.write("</body></html>");
        }

    }

    public void destroy() {
    }
}