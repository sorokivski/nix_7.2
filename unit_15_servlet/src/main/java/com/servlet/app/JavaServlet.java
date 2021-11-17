package com.servlet.app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/javaServlet")
public class JavaServlet extends HttpServlet {

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("default");
        EntityManager em = emf.createEntityManager();
        PrintWriter out = response.getWriter();
        out.write("<html>");
        out.write("<head><title>LIST</title><link rel=\"shortcut icon\" href=\"image/anony.jpg\" type=\"image/x-icon\"/></head>");
        out.write("<body style=\"background-color:black;color:darkorange\", align=\"center\">");

        String host = request.getRemoteHost();
        String agent = request.getHeader("User-Agent");
        if(((org.hibernate.query.Query) em
                .createQuery("SELECT c " +
                        "FROM Connection c WHERE c.userHost =:h", Connection.class)
                .setParameter("h", host)).list().isEmpty()) {
            Connection connection = new Connection();
            connection.setUserHost(host);
            connection.setUserAgent(agent);


            em.getTransaction().begin();
            em.persist(connection);
            em.getTransaction().commit();
        }
            out.println("<h1 align=\"center\">Servlet GET LIST OF CONNECTIONS method processing</h1>");
            out.println("<h3 align=\"center\">Request from: " + host  + "</h3>");

            out.write("<table border ='1'>");
            out.write("<tr>");
            out.write("<th> User Host          </th>");
            out.write("<th> User-Agent </th>");
            out.write("</tr>");

            List<Connection> connections = em
                    .createQuery("Select c from Connection c", Connection.class)
                    .getResultList();
            for (Connection c: connections) {
                if(c.getUserHost() == host){
                    out.write("<tr>");
                    out.write("<td><b>" + c.getUserHost() +"</b></td>");
                    out.write("<td><b>" + c.getUserAgent() +"</b></td>");
                    out.write("</tr>");
                }
                else{
                    out.write("<tr>");
                    out.write("<td>" + c.getUserHost() +"</td>");
                    out.write("<td>" + c.getUserAgent() +"</td>");
                    out.write("</tr>");
                }
            }

            out.write("</table>");

    out.write("<br><a href=\"index.html\">Back to Main Page</a>");
    out.write("</body></html>");
    }

    public void destroy() {
    }
}