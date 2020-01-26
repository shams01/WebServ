import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class GetCookiesServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        Cookie[] cookies = request.getCookies();

        PrintWriter printWriter = response.getWriter();

        printWriter.print("<html>");
        for(Cookie cookie : cookies){
            printWriter.print("<h1>" + cookie.getName() + " : " + cookie.getValue() + "<h1>");
        }
        printWriter.print("</html>");
    }
}
