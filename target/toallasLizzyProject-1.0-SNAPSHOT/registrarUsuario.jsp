<%-- 
    Document   : registrarUsuario
    Created on : 23/08/2025, 12:15:44 a. m.
    Author     : Elizabeth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Registro de Usuario</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
</head>
<body class="container">
  <h2>Registrar usuario</h2>
  <form action="registrarUsuarioServlet" method="POST">
    <input type="text" name="nombre" placeholder="Nombre" required>
    <input type="email" name="email" placeholder="Correo" required>
    <input type="password" name="password" placeholder="Contraseña" required>
    <select name="id_rol" required>
      <option value="1">Administrador</option>
      <option value="2">Empleado</option>
    </select>
    <button type="submit">Crear</button>
  </form>
  <p><a href="index.html">Volver</a></p>
</body>
</html>