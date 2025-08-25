<%-- 
    Document   : panel
    Created on : 23/08/2025, 12:41:44 a. m.
    Author     : Elizabeth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Panel de Control</title>
    <link
        rel="stylesheet"
        href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css"
    >
</head>
<body>
    <%
        // Redirige a index.html si no hay una sesión activa
        if (session.getAttribute("usuario") == null) {
            response.sendRedirect("index.html");
            return;
        }
    %>
    <main class="container">
        <h1>Bienvenido, <%= session.getAttribute("usuario") %>!</h1>
        <p>Este es el panel principal de la aplicación de gestión de Toallas Lizzy.</p>
        
        <nav>
            <ul>
                <li><a href="producto.jsp" role="button">Gestión de Productos</a></li>
                <li><a href="registrarUsuario.jsp" role="button">Registrar Usuario</a></li>
                <li><a href="recuperarContrasena.jsp" role="button">Recuperar Contraseña</a></li>
                <li>
                  <form action="logoutServlet" method="GET">
                    <button type="submit">Cerrar Sesión</button>
                  </form>
                </li>
            </ul>
        </nav>
    </main>
</body>
</html>
