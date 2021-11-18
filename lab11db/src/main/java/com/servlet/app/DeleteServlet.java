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

@WebServlet("/deleteMovie")
public class DeleteServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();

        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head><title>DELETING PAGE</title><link rel=\"shortcut icon\" href=\"image/movie.jpg\" type=\"image/x-icon\"/></head>");
        out.write("<body style=\"background-color:black;color:darkorange\", align=\"center\">");

        String title = request.getParameter("title");
        List<Long> ids = em
                .createQuery("SELECT movie.id " +
                        "FROM Movie movie WHERE movie.title =:tit", Long.class)
                .setParameter("tit", request.getParameter("title")).getResultList();
        em.getTransaction().begin();
        for (Long id : ids) {
            Movie movie = em.find(Movie.class, id);
            out.println(movie.toStringAboutMovie());
            em.remove(movie);

        }
        em.getTransaction().commit();
        out.println("MOVIE DELETED: " + title);

        out.write("<br><a href=\"index.html\">Back to Main Page</a>");
        out.write("</body></html>");

    }

    public void destroy() {
    }
}
