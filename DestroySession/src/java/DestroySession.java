//importing servlet files
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.tools.ant.types.PatternSet.NameEntry;
public class DestroySession extends HttpServlet {

    /**
     *
     * @param request
     * @param response
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {
        PrintWriter out = response.getWriter();
        response.setContentType("text/html");
        HttpSession session = request.getSession(false);
        String name = null;
        if (session != null) {
            name = (String) session.getAttribute("loggedUser");
        }
        if (name.equalsIgnoreCase("web")) {
            session.removeAttribute("loggedUser");
            session.invalidate();
            session.setMaxInactiveInterval(0);
            out.println("<h1><center>");
            out.println("Session Deleted........");
            out.println("</center><h1>");
        } else {
            out.println("<h1><center>");
            out.println("Session is not Maintained");
            out.println("</center><h1>");
        }
    }

}
