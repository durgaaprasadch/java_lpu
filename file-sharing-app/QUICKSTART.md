# Quick Start Guide - Secure File Sharing Application

## Prerequisites
Before you begin, ensure you have the following installed:
- ☑ Java 17 or higher
- ☑ Maven 3.6+
- ☑ MySQL 8.0+
- ☑ Git (for cloning)

## 5-Minute Setup

### Step 1: Database Setup (2 minutes)
```bash
# Login to MySQL
mysql -u root -p

# Create the database
CREATE DATABASE filesharing_db;
EXIT;
```

### Step 2: Configure Application (1 minute)
Edit `src/main/resources/application.properties`:
```properties
# Update these lines with your MySQL credentials
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD
```

### Step 3: Build & Run (2 minutes)
```bash
# Navigate to project directory
cd file-sharing-app

# Build the application
mvn clean install

# Run the application
mvn spring-boot:run
```

The application will start on `http://localhost:8080`

## First Time Usage

### 1. Register a User
- Open browser: http://localhost:8080
- Click "Register"
- Fill in your details
- Click "Register" button

### 2. Login
- After registration, you'll be redirected to login
- Enter your email and password
- Click "Login"

### 3. Upload a File
- On the dashboard, click "Choose File"
- Select a file (PDF, JPG, PNG, or TXT - max 10MB)
- Click "Upload File"
- Your file will appear in the "My Files" section

### 4. Generate Share Link
- Click "Share" button next to any file
- A modal will appear with the share link
- Click "Copy Link" to copy to clipboard
- Share this link with anyone
- The link expires in 24 hours

### 5. Download via Share Link
- Open the share link in any browser
- File will download automatically
- No login required!

## Testing the Application

### Test Scenario 1: File Upload with Validation
Try uploading:
- ✅ A PDF file (should succeed)
- ✅ A JPG file (should succeed)
- ❌ An EXE file (should fail - invalid type)
- ❌ A file > 10MB (should fail - too large)

### Test Scenario 2: Share Link Expiry
1. Generate a share link
2. Copy the link
3. Open in incognito/different browser
4. Verify download works
5. Wait 24 hours (or modify expiry time in ShareService.java for testing)
6. Try the link again (should fail)

### Test Scenario 3: Security
1. Try accessing `/api/files/my-files` without login (should fail)
2. Try accessing another user's file (should fail)
3. Verify only file owner can generate share link

## Troubleshooting

### Problem: Application won't start
**Solution**: 
- Check MySQL is running: `systemctl status mysql` (Linux) or check MySQL service (Windows)
- Verify database credentials in application.properties
- Check port 8080 is not in use: `lsof -i :8080` (Linux/Mac)

### Problem: "Table doesn't exist" error
**Solution**:
- Ensure `spring.jpa.hibernate.ddl-auto=update` in application.properties
- Or manually run schema.sql in MySQL

### Problem: File upload fails
**Solution**:
- Check `uploads` directory exists and has write permissions
- Verify file size is under 10MB
- Ensure file type is PDF, JPG, PNG, or TXT

### Problem: JWT token invalid
**Solution**:
- Token expires after 24 hours - login again
- Check token is being sent in Authorization header: `Bearer <token>`
- Verify JWT secret in application.properties

## API Testing with cURL

### Register
```bash
curl -X POST http://localhost:8080/api/auth/register \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john@example.com",
    "password": "password123"
  }'
```

### Login
```bash
curl -X POST http://localhost:8080/api/auth/login \
  -H "Content-Type: application/json" \
  -d '{
    "email": "john@example.com",
    "password": "password123"
  }'
```

### Upload File
```bash
curl -X POST http://localhost:8080/api/files/upload \
  -H "Authorization: Bearer YOUR_JWT_TOKEN" \
  -F "file=@/path/to/your/file.pdf"
```

### Get My Files
```bash
curl -X GET http://localhost:8080/api/files/my-files \
  -H "Authorization: Bearer YOUR_JWT_TOKEN"
```

### Generate Share Link
```bash
curl -X POST http://localhost:8080/api/share/FILE_ID \
  -H "Authorization: Bearer YOUR_JWT_TOKEN"
```

### Download via Share Link
```bash
curl -X GET http://localhost:8080/api/share/download/SHARE_TOKEN \
  --output downloaded_file.pdf
```

## Project Structure Overview

```
file-sharing-app/
├── src/main/java/com/filesharing/
│   ├── controller/      # REST API endpoints
│   ├── service/         # Business logic
│   ├── repository/      # Database access
│   ├── entity/          # Database models
│   ├── security/        # JWT authentication
│   ├── dto/             # Request/Response objects
│   ├── exception/       # Error handling
│   └── config/          # Security configuration
├── src/main/resources/
│   ├── static/          # Frontend files (HTML/CSS/JS)
│   └── application.properties
├── uploads/             # File storage directory
├── pom.xml              # Maven dependencies
├── schema.sql           # Database schema
└── README.md            # Full documentation
```

## Key Features Summary

✅ **User Management**
- Registration with validation
- Login with JWT token
- BCrypt password hashing

✅ **File Operations**
- Upload (PDF, JPG, PNG, TXT only)
- Download (owner only)
- List user's files
- Max 10MB file size

✅ **File Sharing**
- Generate unique share links
- 24-hour expiry
- Public download via token
- No login required for shared files

✅ **Security**
- JWT authentication
- Password hashing
- File validation
- Token expiry
- Owner-based access control

## Next Steps

After getting the application running:
1. ✅ Explore the code structure
2. ✅ Read the full README.md for detailed documentation
3. ✅ Check PROJECT_SUMMARY.md for architecture details
4. ✅ Customize configuration for your needs
5. ✅ Deploy to production (remember to change JWT secret!)

## Support

For detailed documentation, see:
- `README.md` - Complete setup and API documentation
- `PROJECT_SUMMARY.md` - Architecture and implementation details
- `schema.sql` - Database schema

## Production Deployment Tips

Before deploying to production:
1. Change JWT secret to a strong random value
2. Use environment variables for sensitive data
3. Enable HTTPS
4. Use a production-grade database
5. Configure proper CORS settings
6. Set up monitoring and logging
7. Use cloud storage for files (AWS S3, etc.)
8. Add rate limiting
9. Set up automated backups
10. Review and test all security measures

---

Happy Coding! 🚀

For questions or issues, refer to the documentation or open an issue on GitHub.
