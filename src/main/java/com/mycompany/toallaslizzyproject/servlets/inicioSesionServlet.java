package com.mycompany.toallaslizzyproject.servlets;

import com.mycompany.toallaslizzyproject.util.Conexion; // Importa tu nueva clase de utilidad
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement; // Usamos PreparedStatement en lugar de Statement
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "inicioSesionServlet", urlPatterns = {"/inicioSesion"})
public class inicioSesionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String usuario = req.getParameter("usuario");
        String password = req.getParameter("password");

        // Esta es la consulta SQL mejorada con PreparedStatement.
        // Los signos de interrogación (?) son marcadores de posición.
        String sql = "SELECT id FROM usuario WHERE nombre=? AND password=?";

        // Usamos un bloque try-with-resources para manejar la conexión y el PreparedStatement automáticamente.
        try (Connection con = Conexion.getConexion(); // Llama a la clase de utilidad para obtener la conexión
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Asigna los valores a los marcadores de posición de forma segura
            ps.setString(1, usuario);
            ps.setString(2, password);

            // Ejecuta la consulta
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    // Si el usuario existe, se crea la sesión y se redirige
                    req.getSession(true).setAttribute("usuario", usuario);
                    resp.sendRedirect("panel.jsp");
                } else {
                    // Si no, se redirige de vuelta al login
                    resp.sendRedirect("index.html");
                }
            }
        } catch (SQLException e) {
            // Maneja la excepción de forma más robusta si la conexión falla
            throw new ServletException("Error al conectar a la base de datos.", e);
        }
    }

    // Este método es para cuando alguien intenta entrar al servlet directamente por la URL.
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        // Simplemente lo redirigimos al formulario de inicio de sesión.
        resp.sendRedirect("index.html");
    }
}