package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "RetirarServlet", urlPatterns = { "/RetirarServlet" })
public class RetirarServlet extends HttpServlet {

    private double comision = 0;
    private int retiros = 0;
    private ArrayList<Integer> cuentasRetir = new ArrayList<>();

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
        String retiro = request.getParameter("retiro");
        double retiroDouble;
        try {
            retiroDouble = Double.parseDouble(retiro);
        } catch (NumberFormatException e) {
            response.getWriter()
                    .write("<script>alert('Valor ingresado inválido'); window.location.href='consignar.jsp';</script>");
            return;
        }

        if ("opcion2".equals(tipoMoneda)) { // Dólar
            retiroDouble = retiroDouble * 3900.0;
        } else if ("opcion3".equals(tipoMoneda)) { // Euro
            retiroDouble = retiroDouble * 4200.0;
        }

        Operaciones DB = new Operaciones();
        boolean actualizado = DB.retirar(retiroDouble, numCuenta);

        if (actualizado) {
            retiros++;
            cuentasRetir.add(numCuenta);
            HttpSession applicationSession = request.getSession();
            applicationSession.setAttribute("conteoCuentasRetir", retiros);
            applicationSession.setAttribute("cuentasRetir", cuentasRetir);
            if (retiroDouble > 50000) {
                DB.retirar(retiroDouble * 0.01, numCuenta);
                comision = comision + (retiroDouble * 0.01);
            } else {
                DB.retirar(100, numCuenta);
                comision = comision + 100;
            }
            applicationSession.setAttribute("comisionR", comision);
            response.getWriter()
                    .write("<script>alert('Retiro exitoso'); window.location.href='retirar.jsp';</script>");
        } else {
            response.getWriter()
                    .write("<script>alert('Error al retirar'); window.location.href='retirar.jsp';</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para proceso de retiro de dinero";
    }

}
