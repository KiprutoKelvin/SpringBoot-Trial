# Student Management API

A simple Spring Boot RESTful API for managing student records. This project demonstrates how to build a CRUD-based web service using Spring Boot, JPA, and a relational database (e.g., PostgreSQL or H2 for dev/testing).

## 🧰 Features

- Add new students with validation
- Retrieve all students
- Update student details (name, email)
- Delete students by ID
- Prevent duplicate email registration
- Auto-calculate student age from DOB
- Preload sample student data at startup (dev only)

## 📦 Tech Stack

- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- Hibernate
- H2/PostgreSQL (depending on your configuration)
- Maven

## 📁 Project Structure

```
.
├── pom.xml                                # Maven configuration
├── README.md
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/example/demo/
    │   │       ├── DemoApplication.java           # Main Spring Boot application
    │   │       └── student/
    │   │           ├── Student.java               # JPA Entity
    │   │           ├── StudentRepository.java     # Repository interface
    │   │           ├── StudentService.java        # Business logic
    │   │           ├── StudentController.java     # REST API controller
    │   │           └── StudentConfig.java         # Sample data initializer
    │   └── resources/
    │       ├── application.properties             # App configuration
    │       ├── static/                            # Static web assets
    │       └── templates/                         # Template files
    └── test/
        └── java/
            └── com/example/demo/
                └── DemoApplicationTests.java      # Unit tests
```

## 🚀 Getting Started

### Prerequisites

- Java 17+
- Maven
- IDE (e.g., IntelliJ, VS Code)

### Running the Application

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/student-management-api.git
   cd student-management-api
   ```

2. Build the project:
   ```bash
   mvn clean install
   ```

3. Run the application:
   ```bash
   mvn spring-boot:run
   ```

4. Test the endpoints using Postman or curl.

## 🧪 API Endpoints

**Base URL:** `http://localhost:8080/api/v1/student`

| Method | Endpoint        | Description              |
|--------|-----------------|--------------------------|
| GET    | `/`             | Get all students         |
| POST   | `/`             | Register a new student   |
| DELETE | `/{studentId}`  | Delete student by ID     |
| PUT    | `/{studentId}`  | Update student (name/email) |

### Example JSON for POST:
```json
{
  "name": "Kipruto",
  "email": "kipruto@gmail.com",
  "dob": "2000-01-04"
}
```

## ⚙️ Configuration

### application.properties
```properties
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=

spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
spring.jpa.show-sql=true
```

You can replace H2 with PostgreSQL or another database for production.

## 🛡️ Validation & Error Handling

Throws `IllegalStateException` if:
- A student with the same email already exists
- You try to update/delete a student that doesn't exist

## 📌 Notes

- `@Transactional` is used in update operations to ensure atomicity.
- Age is a derived field, calculated at runtime from date of birth.
- `StudentConfig` is used only during dev to preload test data.

## 🤝 Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request