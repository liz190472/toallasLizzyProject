package com.mycompany.toallaslizzyproject.servlets;

import com.mycompany.toallaslizzyproject.util.Conexion;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet(name = "recuperarContrasenaServlet", urlPatterns = {"/recuperarContrasenaServlet"})
public class recuperarContrasenaServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String email = req.getParameter("email");
        String nueva = req.getParameter("nueva");
        String conf = req.getParameter("confirmacion");

        // Simple validación en el Servlet
        if (!nueva.equals(conf)) {
            resp.sendRedirect("recuperarContrasena.jsp?error=nomatch");
            return;
        }

        String sql = "UPDATE usuario SET password=? WHERE email=?";
        try (Connection con = Conexion.getConexion();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, nueva);
            ps.setString(2, email);

            int filas = ps.executeUpdate();
            if (filas > 0) {
                resp.sendRedirect("index.html?success=updated");
            } else {
                resp.sendRedirect("recuperarContrasena.jsp?error=notfound");
            }
        } catch (SQLException e) {
            throw new ServletException("Error al actualizar la contraseña.", e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        resp.sendRedirect("recuperarContrasena.jsp");
    }
}