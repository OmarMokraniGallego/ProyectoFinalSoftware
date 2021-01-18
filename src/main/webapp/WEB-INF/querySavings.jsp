<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <%@ page import="es.upm.proyecto3.entities.Client"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Averiguar saldo</title>
    </head>

    <script type="text/javascript">

        function send() {
            var frm = document.frmSavings;
            frm.submit();
        }
    </script>
    <body>

        <h1>Averiguar saldo</h1>

        <%
            session.getAttribute("name");
            session.getAttribute("savings");
            session.getAttribute("lastname");
        %>
    Esta es la sessión de <% out.print(session.getAttribute("name")); %><br>

        <form action="QuerySavingsServlet" method="get" name="frmSavings">
            <input type="hidden" name="id" value=<% out.print(session.getAttribute("name")); %> /> <br> 
            <input type="text" value=<% out.print(session.getAttribute("savings")); %>> <input type="button" value="Averiguar Saldo" onclick="send()" />
        </form>
    </body>
    </html>