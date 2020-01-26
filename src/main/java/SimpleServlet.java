import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

public class SimpleServlet extends HttpServlet{
    private volatile int vizitsCounter;

    public void counter(){
        vizitsCounter = 0;
    }

    synchronized void viziCoun(){
        vizitsCounter++;
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        viziCoun();

        response.setContentType("text/html");

        PrintWriter printWriter = new PrintWriter(response.getWriter());

        String docType = "<!DOCTYPE html>";

        Date currentDate = new Date();

        printWriter.println(docType + "<html>" +
                "<head>" +
                "</head>" +
                "<body>" +
                currentDate.toString() +
                "</body>" +
                "<body>" +
                vizitsCounter +
                "</body>" +
                "</html>");
        }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}