<%-- 
    Document   : recuperarContrasena
    Created on : 23/08/2025, 12:13:51 a. m.
    Author     : Elizabeth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Recuperar contraseña</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
</head>
<body class="container">
  <h2>Recuperar contraseña</h2>
  <form action="recuperarContrasenaServlet" method="POST">
    <input type="email" name="email" placeholder="Correo registrado" required>
    <input type="password" name="nueva" placeholder="Nueva contraseña" required>
    <input type="password" name="confirmacion" placeholder="Confirmar contraseña" required>
    <button type="submit">Actualizar</button>
  </form>
  <p><a href="index.html">Volver</a></p>
</body>
</html>