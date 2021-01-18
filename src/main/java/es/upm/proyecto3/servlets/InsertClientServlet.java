package es.upm.proyecto3.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.upm.proyecto3.controllers.AccountController;

public class InsertClientServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            /* Recuperamos los datos de los inputs del jsp */
            String name = request.getParameter("name");
            String lastname = request.getParameter("lastname");
            String savings = request.getParameter("savings");

            /* Parseamos el String y lo pasamos a double */
            double doubleSavings = Double.parseDouble(savings);

            /* LLamamos al método que inserta los datos a la DB */
            AccountController.insertClient(name, lastname, doubleSavings);

            /*
             * Además de haberlo insertado creamos una session y le agremos los siguientes
             * atributos, name, lastname, savings
             */
            HttpSession session = request.getSession(false);
            session.setAttribute("name", name);
            session.setAttribute("lastname", lastname);
            session.setAttribute("savings", doubleSavings);

            /*
             * Cuando todo termina que nos derive a otra web donde vamos a consultar los
             * savings por datos persistidos y por pasamanos de sessiones
             */
            getServletConfig().getServletContext().getRequestDispatcher("/querySavings.jsp").forward(request, response);

        } catch (Exception error) {
            error.getMessage();
            error.printStackTrace();
        }

    }

}
