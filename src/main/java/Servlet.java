import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        HttpSession session = request.getSession();
        Integer count = (Integer) session.getAttribute("count");
        if(count==null){
            session.setAttribute("count", 1);
            count = 1;
        } else {
            session.setAttribute("count", count + 1);
        }

//        Cart cart = (Cart)session.getAttribute("cart");
//        String name = request.getParameter("name");
//        int quantity = Integer.parseInt(request.getParameter("quantity"));
//
//        if(cart==null){
//            cart = new Cart();
//            cart.setName(name);
//            cart.setQuantity(quantity);
//        }
//        session.setAttribute("cart", cart);

        PrintWriter printWriter = response.getWriter();
        printWriter.print("your is count : " + count);

    }
}
