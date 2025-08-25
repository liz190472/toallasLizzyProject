<%-- 
    Document   : producto
    Created on : 23/08/2025, 12:15:04 a. m.
    Author     : Elizabeth
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, com.mycompany.toallaslizzyproject.util.Conexion"%>
<!DOCTYPE html>
<html lang="es">
<head>
  <meta charset="UTF-8">
  <title>Gestión de Productos</title>
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/@picocss/pico@2/css/pico.min.css">
</head>
<body class="container">
  <%
    if (session.getAttribute("usuario") == null) {
      response.sendRedirect("index.html");
      return;
    }
  %>
  <h2>Gestión de Productos</h2>
  <p><a href="panel.jsp">Volver al panel</a></p>

  <h3>Registrar nuevo producto</h3>
  <form action="productoServlet" method="POST">
    <input type="text" name="referencia" placeholder="Referencia" required>
    <input type="text" name="tamano" placeholder="Tamano" required>
    <input type="number" name="gramos" step="0.01" placeholder="Gramos" required>
    <input type="text" name="color" placeholder="Color" required>
    <input type="number" name="precioUnitario" step="0.01" placeholder="Precio unitario" required>
    <input type="number" name="cantidadStock" placeholder="Cantidad en stock" required>
    <select name="estado" required>
      <option value="Activo">Activo</option>
      <option value="Inactivo">Inactivo</option>
    </select>
    <button type="submit">Crear Producto</button>
  </form>

  <hr>

  <h3>Productos registrados</h3>
  <table role="grid">
    <thead>
      <tr>
        <th>ID</th>
        <th>Referencia</th>
        <th>Tamano</th>
        <th>Gramos</th>
        <th>Color</th>
        <th>Precio</th>
        <th>Stock</th>
        <th>Estado</th>
      </tr>
    </thead>
    <tbody>
      <%
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement("SELECT * FROM producto ORDER BY id DESC");
             ResultSet rs = ps.executeQuery()) {
          while (rs.next()) {
      %>
      <tr>
        <td><%= rs.getInt("id") %></td>
        <td><%= rs.getString("referencia") %></td>
        <td><%= rs.getString("tamano") %></td>
        <td><%= rs.getBigDecimal("gramos") %></td>
        <td><%= rs.getString("color") %></td>
        <td><%= rs.getBigDecimal("precioUnitario") %></td>
        <td><%= rs.getInt("cantidadStock") %></td>
        <td><%= rs.getString("estado") %></td>
      </tr>
      <%
          }
        } catch (SQLException e) {
          out.println("<tr><td colspan='8'>Error al cargar los productos: " + e.getMessage() + "</td></tr>");
        }
      %>
    </tbody>
  </table>
</body>
</html>

