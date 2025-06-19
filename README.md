# TPF Microservicios - Sistema de Productos y Pedidos

Este proyecto implementa una arquitectura de microservicios en Java usando Spring Boot. Está dividido en dos servicios principales: **product** y **orders**.

## 🧩 Estructura del Proyecto

```
TPF_Microservicios_FULL_SWAGGER/
├── docker-compose.yml
├── product (1)/
│   └── product/
│       ├── src/
│       └── pom.xml
├── orders/
│   ├── src/
│   └── pom.xml
├── pom.xml (raíz)
```

---

## 📦 Microservicios

### 1. `product`

Administra productos y categorías:
- Endpoints CRUD para productos (`/api/products`)
- Endpoints CRUD para categorías (`/api/categories`)

### 2. `orders`

Administra pedidos:
- CRUD para pedidos (`/api/orders`)
- Consulta a `product` para validar productos

---

## ⚙️ Tecnologías utilizadas

- Java 17
- Spring Boot 3
- Spring Web / Spring Data JPA
- PostgreSQL
- Swagger (Springdoc OpenAPI)
- Docker + Docker Compose

---

## 🚀 Cómo ejecutar el proyecto

### Opción 1: Docker Compose

Levanta la base de datos:

```bash
docker-compose up -d
```

Esto inicia dos contenedores PostgreSQL:
- `db-product` → puerto `5432`
- `db-orders` → puerto `5433`

> Asegurate de tener Docker Desktop corriendo.

---

### Opción 2: Ejecutar manualmente los microservicios

En dos terminales distintas:

```bash
# PRODUCT
cd product\product
mvn spring-boot:run

# ORDERS
cd orders
mvn spring-boot:run
```

> ⚠️ Requiere tener las bases de datos PostgreSQL configuradas manualmente (ver credenciales abajo).

---

## 🔐 Credenciales de la base de datos

### Product

- Base de datos: `product`
- Usuario: `postgres`
- Contraseña: `admin`
- Puerto: `5432`

### Orders

- Base de datos: `orders`
- Usuario: `axel`
- Contraseña: `axel`
- Puerto: `5433`

---

## 📑 Swagger UI

### Product
- [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

- usuario: user
- contraseña: 1234

### Orders
- [http://localhost:8085/swagger-ui.html](http://localhost:8085/swagger-ui.html)

usuario: user
contraseña: 1234

> Swagger permite probar todos los endpoints desde el navegador.

---

## ✅ Endpoints principales

### Productos

- `GET /api/products`
- `POST /api/products`
- `PUT /api/products/{id}`
- `DELETE /api/products/{id}`

### Categorías

- `GET /api/categories`
- `POST /api/categories`

### Pedidos

- `GET /api/orders`
- `POST /api/orders`

---

## 🧪 Testing

Incluye estructura para tests con JUnit 5. Si no necesitás tests, podés eliminar los archivos en `src/test/java`.

---

## 👨‍💻 Autor

Trabajo Práctico Final - Microservicios
Matias Toledo y Santiago Perez
