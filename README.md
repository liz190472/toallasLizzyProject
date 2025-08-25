## Proyecto de Gestión de la comercializadora - Toallas Lizzy
Proyecto Demo – Comercializadora de Toallas Lizzy
Curso: ADSO 2025
Ficha: 2983215
Estudiante: Elizabeth Hernández Aroca
Descripción del proyecto

Este proyecto corresponde a la codificación de un módulo de software para la gestión de una aplicación web, como parte de la actividad de aprendizaje GA7-220501096-AA2-EV02. 
La aplicación está desarrollada en Java con Servlets y JSP, utilizando el servidor de aplicaciones Apache Tomcat,diseñada para la gestión de inicioSesion, recuperarContraseña, registrousuario y productos de la comercializadora Toallas Lizzy.

Permite realizar operaciones con formularios HTML , Utilizar métodos get y pos, demostrando la conexión entre Java y MySQL usando JDBC.

###Tecnologías utilizadas
Lenguaje de programación: Java con Servlets y JSP
Gestor de Base de Datos: MySQL (con XAMPP/phpMyAdmin)
Conectividad: JDBC (Java Database Connectivity)
Entorno de Desarrollo: Apache NetBeans IDE 25
JDK: 21
Conector MySQL: mysql-connector-j-8.0.32
Descargas necesarias
Antes de ejecutar el proyecto, debe estar:
Apache Tomcat 10.1
JDK 21 (Kit de desarrollo de Java)
IDE Apache NetBeans 25
XAMPP (incluye MySQL y phpMyAdmin)
Conector MySQL/J (Versión 8.0.32)

###Estructura del Proyecto
La estructura del proyecto sigue el estándar de una aplicación web Java:
src/main/java/com/mycompany/toallaslizzyproject/: Contiene las clases Java, incluyendo Servlets y clases de utilidad.
  servlets/: Archivos .java para los Servlets.
	util/: Clases de ayuda, como la conexión a la base de datos (Conexion.java).
  src/main/webapp/: Contiene los archivos web.
  jsp: Páginas de la aplicación (index.jsp, panel.jsp, etc.).
  WEB-INF/: Contiene el archivo web.xml y otras configuraciones.

###La base de datos contiene 24 tablas
(clientes, pedidos, ventas, proveedores, inventario, etc.), pero en este proyecto demo solo se implementan los módulos principales:inicioSesion, recuperarContraseña, registrousuario y productos.
Usuario→ Para manejar el acceso de usuarios al sistema (inicioSesion, recuperarContraseña).
Producto→ Para la gestión de productos en inventario.
####Ejemplo de las tablas
´´´´CREATE TABLE Producto (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Referencia VARCHAR(255) NOT NULL,
    Gramos DOUBLE,
    Tamano VARCHAR(50),
    Color VARCHAR(50),
    PrecioUnitario DOUBLE,
    CantidadStock INT,
    Estado VARCHAR(50)
);´´´´
´´CREATE TABLE Usuario (
    Id INT AUTO_INCREMENT PRIMARY KEY,
    Nombre VARCHAR(255) NOT NULL,
    Email VARCHAR(255) UNIQUE,
    Telefono VARCHAR(20),
    RolId INT
);´´´´
###Ejecución del Proyecto
Configurar la BD en MySQL:
Crear la BD toallas_lizzy. Crear las tablas usuario y producto.

###Configurar la conexión en Conexion.java:
´´´´private static final String URL = "jdbc:mysql://localhost:3306/toallas_lizzy";
private static final String USER = "root";
private static final String PASSWORD = "";´´´´
Probar en NetBeans:
Ejecutar tomcat 10.1

###utilizar el nombre de usuario y contraseña para poder acceder a la ejecucion con tomcat
Usuario: lisha
Contraseña: 2903
Y también:
Usuario: Milena Orozco
Contraseña: 1265

💡 Importante: La lógica implementada corresponde únicamente a los módulos Usuarioy Producto, aunque la BD incluye más tablas para un futuro desarrollo completo.
