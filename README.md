# Student Job and Internship Portal

## About the Project

The Student Job and Internship Portal is a web-based application developed to help students find job opportunities and internships easily.

Students can create an account, log in, view available jobs and internships, apply for opportunities, and track their application status.

The project provides a simple platform to connect students with career opportunities.

## Objectives

- Provide a platform for students to find jobs and internships.
- Allow students to register and log in.
- Display available job opportunities.
- Allow students to apply for jobs.
- Track application status.
- Store student and job information in a MySQL database.

## Technologies Used

- **Frontend:** HTML, CSS, JSP
- **Backend:** Java, Jakarta Servlets
- **Database:** MySQL
- **Database Connectivity:** JDBC
- **IDE:** Apache NetBeans
- **Server:** Apache Tomcat 11
- **Build Tool:** Maven

## Main Features

1. Student Registration
2. Student Login and Logout
3. Student Dashboard
4. View Available Jobs and Internships
5. Apply for Jobs
6. View Applied Jobs
7. Track Application Status
8. Add Job Listings (Admin Demo)

## Project Structure

```text
StudentJobInternshipPortal/
│
├── pom.xml
├── database.sql
├── README.md
│
└── src/
    └── main/
        ├── java/
        │   └── com/aip/portal/
        │       ├── DB.java
        │       └── PortalServlet.java
        │
        └── webapp/
            ├── index.jsp
            ├── assets/
            │   └── style.css
            └── WEB-INF/
                └── views/
                    ├── header.jspf
                    ├── footer.jspf
                    ├── home.jsp
                    ├── register.jsp
                    ├── login.jsp
                    ├── dashboard.jsp
                    ├── jobs.jsp
                    ├── applications.jsp
                    └── admin.jsp
```

## Installation and Setup

### Step 1: Clone the Repository

```bash
git clone https://github.com/YOUR-USERNAME/student-job-internship-portal.git
```

### Step 2: Open the Project

Open the downloaded project in Apache NetBeans as a Maven project.

### Step 3: Create the Database

Open MySQL Workbench and execute the SQL commands provided in `database.sql`.

### Step 4: Configure Database Connection

Open `DB.java` and update your MySQL username and password.

```java
private static final String URL =
"jdbc:mysql://localhost:3306/student_portal";

private static final String USER = "root";

private static final String PASSWORD = "YOUR_MYSQL_PASSWORD";
```

### Step 5: Build the Project

Run the following command from the project directory:

```bash
mvn clean package
```

### Step 6: Run the Project

Deploy the generated WAR file on Apache Tomcat 11.

Open the application in your browser:

```text
http://localhost:8080/StudentJobInternshipPortal/
```

## Database Tables

The project uses the following tables:

- **students:** Stores student registration details.
- **jobs:** Stores job and internship information.
- **applications:** Stores student job applications and their status.

## Future Enhancements

- Password encryption and stronger authentication.
- Separate administrator login and role-based access.
- Resume upload functionality.
- Email notifications.
- Advanced job search and filtering.
- Company registration and management.

## Learning Outcomes

- Understanding Java web application development.
- Working with JSP and Servlets.
- Connecting Java applications with MySQL using JDBC.
- Performing database operations using SQL.
- Understanding Maven project structure.
- Deploying web applications using Apache Tomcat.


## License

This project is developed for educational and academic purposes.
