<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
        pageEncoding="ISO-8859-1"%>
    <%@ page import="es.upm.proyecto3.entities.Client"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    </head>

    <script type="text/javascript">

        function send() {
            var frm = document.frmInsertClient;
            frm.submit();
        }
    </script>

    <body>
        <h1>Insertar Cliente</h1>

        <form action="InsertClientServlet" method="get" name="frmInsertClient">
            <table>
                <tr>
                    <td><label>Nombre: </label></td>
                    <td><input type="text" name="name" /></td>
                </tr>
                <tr>

                    <td><label>Apellido: </label></td>
                    <td><input type="text" name="lastname" /></td>
                </tr>
                <tr>
                    <td><label>Saldo: </label></td>
                    <td><input type="number" name="savings" /></td>
                </tr>
                <tr>
                    <td><input type="button" value="boton" onclick="send()" /></td>
                </tr>
            </table>
        </form>

    </body>
    </html>