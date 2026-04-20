# 🏌️‍♂️ ProShop Management App

Aplicación desarrollada en **Java + PostgreSQL** para la gestión de una tienda ProShop de golf.
Permite administrar clientes, productos y ventas mediante operaciones CRUD y consultas avanzadas.

---

## 🚀 Funcionalidades

### 👤 Gestión de Clientes

* Crear clientes
* Listar clientes
* Eliminar clientes

### 🛍️ Gestión de Productos

* Crear productos
* Listar productos

### 🧾 Gestión de Ventas

* Crear ventas con múltiples productos
* Uso de transacciones
* Relación entre tablas (`ventas` y `detalle_venta`)

### 🔎 Consultas Avanzadas

* Listado de ventas con JOIN (cliente + producto + cantidad)
* Informe de productos más vendidos (TOP ventas)

---

## 🗄️ Base de Datos

Base de datos relacional en **PostgreSQL** con las siguientes tablas:

* `clientes`
* `productos`
* `ventas`
* `detalle_venta`

### 🔗 Relaciones

* Un cliente → varias ventas
* Una venta → varios productos
* Relación N:M mediante `detalle_venta`

---

## 🧱 Estructura del Proyecto

```
src/
 ├── DAO/
 │    ├── ClienteDAO.java
 │    ├── ProductoDAO.java
 │    ├── VentaDAO.java
 │    └── ConsultaDAO.java
 │
 ├── Model/
 │    ├── Cliente.java
 │    ├── Producto.java
 │    ├── Venta.java
 │    └── DetalleVenta.java
 │
 ├── DataBase/
 │    └── ConexionDB.java
 │
 └── Main.java
```

---

## 🔌 Tecnologías utilizadas

* Java (JDK 17+)
* JDBC
* PostgreSQL
* SQL

---

## ⚙️ Configuración

1. Crear la base de datos en PostgreSQL:

```sql
CREATE DATABASE proshop;
```

2. Crear las tablas (`clientes`, `productos`, `ventas`, `detalle_venta`)

3. Configurar la conexión en `ConexionDB.java`:

```java
String url = "jdbc:postgresql://localhost:5432/proshop";
String user = "postgres";
String password = "tu_password";
```

---

## 🖥️ Uso de la aplicación

Al ejecutar el programa se muestra un menú por consola:

```
1. Crear cliente
2. Listar clientes
3. Crear producto
4. Listar productos
5. Crear venta
6. Ver ventas
7. Eliminar cliente
8. Top productos vendidos
0. Salir
```

---
## 👨‍💻 Autor

**Fran Rebollo**
Estudiante de Desarrollo de Aplicaciones Multiplataforma (DAM)

---
