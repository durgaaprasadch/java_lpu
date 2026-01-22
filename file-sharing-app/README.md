# Secure File Sharing Web Application

A full-stack web application for secure file sharing with JWT authentication, built using Java Spring Boot, MySQL, and vanilla JavaScript.

## Features

### User Management
- User registration with BCrypt password hashing
- JWT-based authentication
- Secure login/logout functionality

### File Management
- Upload files (PDF, JPG, PNG, TXT only)
- Maximum file size: 10MB
- View all uploaded files
- Download files securely

### File Sharing
- Generate unique share links for files
- Time-limited access (24 hours default)
- Anyone with the link can download before expiry
- Expired links automatically become invalid

## Tech Stack

### Backend
- **Framework**: Java Spring Boot 3.2.0
- **Database**: MySQL
- **Security**: Spring Security with JWT
- **Password Hashing**: BCrypt
- **Build Tool**: Maven

### Frontend
- **HTML5**: Structure
- **CSS3**: Styling with responsive design
- **JavaScript**: API integration and dynamic UI

## Project Structure

```
file-sharing-app/
├── src/
│   ├── main/
│   │   ├── java/com/filesharing/
│   │   │   ├── config/             # Security configuration
│   │   │   ├── controller/         # REST API controllers
│   │   │   ├── dto/                # Data Transfer Objects
│   │   │   ├── entity/             # JPA entities
│   │   │   ├── exception/          # Exception handling
│   │   │   ├── repository/         # Data repositories
│   │   │   ├── security/           # JWT and security components
│   │   │   ├── service/            # Business logic
│   │   │   └── FileSharingApplication.java
│   │   └── resources/
│   │       ├── static/             # Frontend files
│   │       │   ├── register.html
│   │       │   ├── login.html
│   │       │   ├── dashboard.html
│   │       │   └── styles.css
│   │       └── application.properties
│   └── test/
├── uploads/                        # File storage directory
├── pom.xml                         # Maven dependencies
├── schema.sql                      # Database schema
└── README.md
```

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.6+
- MySQL 8.0+
- Git

### 1. Clone the Repository
```bash
git clone <repository-url>
cd file-sharing-app
```

### 2. Setup MySQL Database
```bash
# Login to MySQL
mysql -u root -p

# Run the schema file
source schema.sql

# Or manually execute:
CREATE DATABASE filesharing_db;
```

### 3. Configure Application Properties
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/filesharing_db
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

### 4. Create Uploads Directory
```bash
mkdir -p uploads
```

### 5. Build the Project
```bash
mvn clean install
```

### 6. Run the Application
```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## API Documentation

### Authentication APIs

#### Register User
- **Endpoint**: `POST /api/auth/register`
- **Body**:
```json
{
  "name": "John Doe",
  "email": "john@example.com",
  "password": "password123"
}
```
- **Response**: JWT token and user details

#### Login User
- **Endpoint**: `POST /api/auth/login`
- **Body**:
```json
{
  "email": "john@example.com",
  "password": "password123"
}
```
- **Response**: JWT token and user details

### File APIs (Requires Authentication)

#### Upload File
- **Endpoint**: `POST /api/files/upload`
- **Headers**: `Authorization: Bearer <JWT_TOKEN>`
- **Body**: multipart/form-data with "file" field
- **Response**: File metadata

#### Get My Files
- **Endpoint**: `GET /api/files/my-files`
- **Headers**: `Authorization: Bearer <JWT_TOKEN>`
- **Response**: List of user's files

#### Download File
- **Endpoint**: `GET /api/files/download/{fileId}`
- **Headers**: `Authorization: Bearer <JWT_TOKEN>`
- **Response**: File download

### Sharing APIs

#### Generate Share Link
- **Endpoint**: `POST /api/share/{fileId}`
- **Headers**: `Authorization: Bearer <JWT_TOKEN>`
- **Response**: Share link and expiry time

#### Download via Share Link (Public)
- **Endpoint**: `GET /api/share/download/{token}`
- **Response**: File download (no authentication required)

## Security Features

1. **Password Encryption**: BCrypt hashing with salt
2. **JWT Authentication**: Stateless authentication
3. **Token Expiry**: JWT tokens expire after 24 hours
4. **File Type Validation**: Only allowed file types can be uploaded
5. **File Size Validation**: Maximum 10MB per file
6. **Owner Verification**: Only file owners can share their files
7. **Time-Limited Sharing**: Share links expire after 24 hours
8. **CORS Configuration**: Controlled cross-origin access

## Usage Guide

### 1. Register/Login
- Open `http://localhost:8080/register.html`
- Create a new account or login with existing credentials

### 2. Upload Files
- After login, you'll be redirected to the dashboard
- Click "Choose File" and select a file
- Click "Upload File"

### 3. View Files
- All your uploaded files are displayed in a table
- You can see filename, type, size, and upload time

### 4. Generate Share Link
- Click the "Share" button next to any file
- A modal will appear with the share link
- Copy the link and share it with others
- The link expires in 24 hours

### 5. Download Files
- Click "Download" to download your own files
- Share links can be used by anyone to download files

## Testing

### Manual Testing Steps

1. **Test Registration**
   - Register with valid details
   - Try registering with existing email (should fail)
   - Try weak password (should fail)

2. **Test Login**
   - Login with valid credentials
   - Try invalid credentials (should fail)

3. **Test File Upload**
   - Upload allowed file types (PDF, JPG, PNG, TXT)
   - Try uploading other types (should fail)
   - Try uploading file > 10MB (should fail)

4. **Test File Sharing**
   - Generate share link
   - Open link in incognito/different browser
   - Verify file downloads
   - Wait 24 hours and test expired link

5. **Test Security**
   - Try accessing protected endpoints without token
   - Try accessing other users' files
   - Verify JWT token expiry

## Troubleshooting

### Database Connection Issues
- Verify MySQL is running: `systemctl status mysql`
- Check credentials in application.properties
- Ensure database exists: `SHOW DATABASES;`

### File Upload Issues
- Check uploads directory exists and has write permissions
- Verify file size < 10MB
- Ensure file type is allowed (PDF, JPG, PNG, TXT)

### JWT Token Issues
- Check token is being sent in Authorization header
- Verify token hasn't expired
- Check JWT secret in application.properties

## Screenshots

### Login Page
![Login Page](screenshots/login.png)

### Dashboard
![Dashboard](screenshots/dashboard.png)

### Share Link Modal
![Share Link](screenshots/share-link.png)

## Future Enhancements

- [ ] File preview functionality
- [ ] User profile management
- [ ] File sharing with specific users
- [ ] Folder organization
- [ ] File search functionality
- [ ] Email notifications for shares
- [ ] Custom expiry time for share links
- [ ] File versioning

## Contributing

1. Fork the repository
2. Create your feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License

This project is licensed under the MIT License.

## Contact

For questions or support, please contact: [your-email@example.com]
