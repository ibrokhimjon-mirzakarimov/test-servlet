import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
public class Home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp){
        try {
            PrintWriter writer = resp.getWriter();
            resp.setContentType("text/html");
            writer.write("<h2>Hello home page from servlet</h2>");
            writer.write("<a href='/login'>Tizimga kirish</a>");
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
