package es.upm.proyecto3.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.upm.proyecto3.controllers.AccountController;

public class QuerySavingsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            /* Grabados en session */
            HttpSession session = request.getSession(false);
            PrintWriter pw = response.getWriter();
            pw.println("Este saldo es que escribimos en la pantallas pasadas y que lo grabamos en memoria Session");
            pw.println("******************************   " + session.getAttribute("savings")
                    + "   **************************************");

            /* Consultados en la Base de Datos, información persistida */
            String name = (String) session.getAttribute("name");
            String lastname = (String) session.getAttribute("lastname");
            double persistedSavings = AccountController.getPersistedSavings(name, lastname);
            pw.println("Este saldo es el que está persistido en la DB y que consultamos por medio una consulta");
            pw.println("******************************   " + persistedSavings
                    + "   **************************************");

        } catch (Exception error) {
            error.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
