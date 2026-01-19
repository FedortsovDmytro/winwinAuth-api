# winwinAuth-api

Auth API service for a simple two-service Spring Boot system.

This service:
- Handles user registration and login
- Issues JWT tokens
- Exposes a protected `/api/process` endpoint
- Calls `data-api` to process input
- Stores processing logs in Postgres

---

## Tech Stack

- Java 21
- Spring Boot
- Spring Security (JWT, stateless)
- Spring Data JPA
- PostgreSQL
- Docker / Docker Compose

---

## API Endpoints

### Register
POST /api/auth/register
Content-Type: application/json

{
"email": "user@example.com",
"password": "password"
}


Response:
201 Created


---

### Login
POST /api/auth/login
Content-Type: application/json

{
"email": "user@example.com",
"password": "password"
}


Response:
```json
{
  "token": "JWT_TOKEN"
}
Process (Protected)
POST /api/process
Authorization: Bearer <JWT_TOKEN>
Content-Type: application/json

{
  "text": "hello"
}
Response:

{
  "result": "OLLEH"
}
This endpoint:

Validates JWT

Calls data-api with X-Internal-Token

Saves a processing log to Postgres

Environment Variables
Variable	Description
POSTGRES_URL	JDBC URL
POSTGRES_USER	DB user
POSTGRES_PASSWORD	DB password
JWT_SECRET	Secret key for JWT
INTERNAL_TOKEN	Shared token for data-api
