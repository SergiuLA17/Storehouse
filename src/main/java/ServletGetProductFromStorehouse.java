import com.example.storehouse_database.DataBaseHandler;
import com.example.storehouse_database.Product;

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
        DataBaseHandler dataBaseHandler = new DataBaseHandler();
        response.setContentType("text/html");
        try {
            Product product = dataBaseHandler.checkDesireProduct(name_product);
            if (dataBaseHandler.checkDesireProduct(name_product) != null) {
                pw.write("Product was found! " + product);
            } else
                pw.write("Sorry, product wasn't found!");
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
