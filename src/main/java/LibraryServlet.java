import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class LibraryServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        PrintWriter printWriter = response.getWriter();

        try{
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/javadb",
                    "postgres", "postgres");

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT title from books");

            while(resultSet.next()){
               printWriter.println(resultSet.getString("title"));
               statement.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
