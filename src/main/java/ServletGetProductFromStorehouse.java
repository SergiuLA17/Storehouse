import com.example.storehouse.DateBaseHandler;

import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;


@WebServlet(name = "ServletGetProduct", value = "/GetMeProduct")
public class ServletGetProductFromStorehouse extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {

        String name_product = request.getParameter("product");
        PrintWriter pw = response.getWriter();
        DateBaseHandler dateBaseHandler = new DateBaseHandler();
        response.setContentType("text/html");
        try {
            dateBaseHandler.checkDesireProduct(name_product);

            if (DateBaseHandler.product == null) {
                pw.write("Sorry, product wasn't found!");
            } else
                pw.write("Product was found! " + DateBaseHandler.product);
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
