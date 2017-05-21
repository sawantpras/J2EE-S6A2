//importing servlet files
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//class extends HttpServlet 
public class SessionDestroyExample extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    //here we write doGet Method
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        String name = request.getParameter("userName");
        if (name.equalsIgnoreCase("web")) {
            out.println("<Center><h3>");
            out.println("Creating A New Session...........");
            out.println("</h3></Center>");
            HttpSession session = request.getSession(true);
            session.setAttribute("loggedUser", name);
            out.println("<Center><h3>");
            out.println("Session Created");
            out.println("<br>Session Id - ");
            out.println(session.getId());
            out
                    .println("<br><a href=\"http://localhost:8080/DestroySession/destroy\">Destroy Session </a>");
            out.println("</h3></Center>");
        } else {
            out.println("<h1>");
            out.println("Please enter the name \"web\"");
            out.println("<h1>");
        }
    }

}
