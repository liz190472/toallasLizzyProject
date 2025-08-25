/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.mycompany.toallaslizzyproject.servlets;

import com.mycompany.toallaslizzyproject.util.Conexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "productoServlet", urlPatterns = {"/productoServlet"})
public class productoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String referencia = req.getParameter("referencia");
        String tamano = req.getParameter("tamano");
        BigDecimal gramos = new BigDecimal(req.getParameter("gramos"));
        String color = req.getParameter("color");
        BigDecimal precio = new BigDecimal(req.getParameter("precioUnitario"));
        int cantidad = Integer.parseInt(req.getParameter("cantidadStock"));
        String estado = req.getParameter("estado");

        String sql = "INSERT INTO producto (referencia, tamano, gramos, color, precioUnitario, cantidadStock, estado) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, referencia);
            ps.setString(2, tamano);
            ps.setBigDecimal(3, gramos);
            ps.setString(4, color);
            ps.setBigDecimal(5, precio);
            ps.setInt(6, cantidad);
            ps.setString(7, estado);
            
            ps.executeUpdate();
            resp.sendRedirect("producto.jsp");

        } catch (SQLException e) {
            throw new ServletException("Error al registrar el producto.", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.sendRedirect("producto.jsp");
    }
}
