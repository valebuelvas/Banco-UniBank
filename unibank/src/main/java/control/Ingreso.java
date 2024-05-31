package control;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "Ingreso", urlPatterns = { "/Ingreso" })
public class Ingreso extends HttpServlet {
    private ArrayList<Integer> cuentasCorrectas = new ArrayList<>();
    private int conteoCuentasCorrectas = 0;

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

        String nuCuenta = request.getParameter("numCuenta");
        int numCuenta;
        try {
            numCuenta = Integer.parseInt(nuCuenta);
        } catch (NumberFormatException e) {
            response.getWriter()
                    .write("<script>alert('Número de cuenta inválido'); window.location.href='ingresar.jsp';</script>");
            return;
        }

        Operaciones DB = new Operaciones();
        System.out.println("Verificando cuenta: " + numCuenta);
        boolean cuentaValida = DB.verificarExisteCuenta(numCuenta);
        if (cuentaValida) {
            System.out.println("Número de cuenta recibido: " + numCuenta);
            cuentasCorrectas.add(numCuenta);
            conteoCuentasCorrectas++;
            HttpSession applicationSession = request.getSession();
            applicationSession.setAttribute("conteoCuentasCorrectas", conteoCuentasCorrectas);
            applicationSession.setAttribute("cuentasCorrectas", cuentasCorrectas);
            HttpSession session = request.getSession();
            session.setAttribute("numCuenta", numCuenta);
            response.getWriter()
                    .write("<script>alert('Número de cuenta válido'); window.location.href='ingresar.jsp?valid=true';</script>");
        } else {
            response.getWriter()
                    .write("<script>alert('Número de cuenta no válido'); window.location.href='ingresar.jsp';</script>");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para ingreso a la cuenta";
    }

    public ArrayList<Integer> getCuentasCorrectas() {
        return cuentasCorrectas;
    }

    public int getConteoCuentasCorrectas() {
        return conteoCuentasCorrectas;
    }
}
