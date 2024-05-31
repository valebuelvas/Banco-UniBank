package control;

import java.util.Random;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.*;

@WebServlet(name = "Registrar", urlPatterns = { "/Registrar" })
public class Registrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String nombre1 = request.getParameter("name");
        String nombre2 = request.getParameter("email");
        String apellido = request.getParameter("message");
        String id = request.getParameter("phone");

        Cliente cliente = new Cliente(-1, id, nombre1, nombre2, apellido);
        Operaciones DB = new Operaciones();
        DB.agregarClienteDB(cliente);
        int consecutivo = DB.obtenerPKCliente(cliente);

        if (consecutivo != -1) {
            cliente.setConsecutivo(consecutivo);
            int numCuenta = new Random().nextInt(100);
            Cuenta cuenta = new Cuenta(numCuenta, cliente, 0);
            DB.agregarCuentaDB(cuenta);
            request.setAttribute("numCuenta", numCuenta);

        } else {
            System.err.println("Error: No se pudo obtener el consecutivo del cliente.");
        }

        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para registro de nueva cuenta";
    }

}
