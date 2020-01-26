import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;

public class SetCookiesServlet extends HttpServlet{
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        Cookie cookie1 = new Cookie("id", "274962");
        Cookie cookie2 = new Cookie("name", "Tom");

        cookie1.setMaxAge(24*60*60);
        cookie2.setMaxAge(24*60*60);

        response.addCookie(cookie1);
        response.addCookie(cookie2);
    }
}
