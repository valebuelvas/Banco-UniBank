package control;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ConsignarServlet", urlPatterns = { "/ConsignarServlet" })
public class ConsignarServlet extends HttpServlet {

    private double comision = 0;
    private int consignaciones = 0;
    private ArrayList<Integer> cuentasConsig = new ArrayList<>();

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

        HttpSession session = request.getSession();
        Integer numCuenta = (Integer) session.getAttribute("numCuenta");
        if (numCuenta == null) {
            response.getWriter().write(
                    "<script>alert('Número de cuenta no encontrado'); window.location.href='cuenta.jsp';</script>");
            return;
        }

        String tipoMoneda = request.getParameter("respuesta");
        String ingreso = request.getParameter("ingreso");
        double ingresoDouble;
        try {
            ingresoDouble = Double.parseDouble(ingreso);
        } catch (NumberFormatException e) {
            response.getWriter()
                    .write("<script>alert('Valor ingresado inválido'); window.location.href='consignar.jsp';</script>");
            return;
        }

        if ("opcion2".equals(tipoMoneda)) { // Dólar
            ingresoDouble = ingresoDouble * 3900.0;
        } else if ("opcion3".equals(tipoMoneda)) { // Euro
            ingresoDouble = ingresoDouble * 4200.0;
        }

        Operaciones DB = new Operaciones();
        boolean actualizado = DB.consignar(ingresoDouble, numCuenta);

        if (actualizado) {
            consignaciones++;
            cuentasConsig.add(numCuenta);
            HttpSession applicationSession = request.getSession();
            applicationSession.setAttribute("conteoCuentasConsig", consignaciones);
            applicationSession.setAttribute("cuentasConsig", cuentasConsig);
            if (ingresoDouble > 50000) {
                DB.retirar(ingresoDouble * 0.01, numCuenta);
                comision = comision + (ingresoDouble * 0.01);
            } else {
                DB.retirar(100, numCuenta);
                comision = comision + 100;
            }
            applicationSession.setAttribute("comisionC", comision);
            response.getWriter()
                    .write("<script>alert('Consignación exitosa'); window.location.href='consignar.jsp';</script>");
        } else {
            response.getWriter()
                    .write("<script>alert('Error al consignar'); window.location.href='consignar.jsp';</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para proceso de consignación";
    }
}
