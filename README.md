# User Dashboard Project

## Overview
The User Dashboard is a full-stack web application designed to manage user and organization details with robust authentication and data management capabilities. The project leverages modern technologies to provide a secure and efficient solution for user information management.

## Technologies Used
- **Backend:**
  - Java
  - Spring Boot
  - Maven
- **Frontend:**
  - JavaScript
  - React
  - Node.js
- **Package Managers:**
  - NPM
  - Yarn

## Project Structure
The project is organized into well-defined packages to maintain a clean and modular architecture:

### Backend Packages
- `com.User.Dashboard.controller`: REST controllers handling HTTP requests
- `com.User.Dashboard.DTO`: Data Transfer Objects for inter-layer data transfer
- `com.User.Dashboard.Entity`: Entity classes representing database tables
- `com.User.Dashboard.Repo`: Repository interfaces for database operations
- `com.User.Dashboard.service`: Service classes implementing business logic

## API Endpoints

### Health Check
- **Endpoint:** `GET /health`
- **Description:** Verifies the service is running
- **Response:** Service status message

### Authentication
1. **User Login**
   - **Endpoint:** `POST /login`
   - **Description:** Authenticates user credentials
   - **Request Body:** Login credentials
   - **Response:** Authentication token or error message

2. **User Registration**
   - **Endpoint:** `POST /register`
   - **Description:** Registers a new user
   - **Request Body:** Registration details
   - **Response:** Registered user information or error message

### User Details Management
1. **Register User Details**
   - **Endpoint:** `POST /user-details/{email}`
   - **Description:** Registers personal information for a user
   - **Parameters:** User email
   - **Request Body:** User personal details

2. **Retrieve User Details**
   - **Endpoint:** `GET /user-details/{username}`
   - **Description:** Fetches user details by username
   - **Parameters:** Username
   - **Response:** User details

3. **Retrieve All User Details**
   - **Endpoint:** `GET /findall-details`
   - **Description:** Retrieves details for all registered users
   - **Response:** List of user details

### Organization Details Management
1. **Register Organization Details**
   - **Endpoint:** `POST /org-details/{username}`
   - **Description:** Registers organization details for a user
   - **Parameters:** Username
   - **Request Body:** Organization details

2. **Retrieve Organization Details**
   - **Endpoint:** `GET /org-details/{username}`
   - **Description:** Fetches organization details by username
   - **Parameters:** Username
   - **Response:** Organization details

3. **Retrieve All Organization Details**
   - **Endpoint:** `GET /find-all-userOrg`
   - **Description:** Retrieves details for all registered organizations
   - **Response:** List of organization details

## Setup and Installation

### Prerequisites
- Java 8 or higher
- Maven
- Node.js
- NPM or Yarn

### Backend Setup
1. Clone the repository
   ```bash
   git clone <repository-url>
   ```

2. Navigate to the project directory
   ```bash
   cd user-dashboard
   ```

3. Build the backend application
   ```bash
   mvn clean install
   ```

4. Run the Spring Boot application
   ```bash
   mvn spring-boot:run
   ```

### Frontend Setup
1. Navigate to the frontend directory
   ```bash
   cd frontend
   ```

2. Install dependencies
   ```bash
   npm install
   # or
   yarn install
   ```

3. Start the development server
   ```bash
   npm start
   # or
   yarn start
   ```

## Configuration
- Configure database connection in `application.properties`
- Set up environment variables for sensitive information
- Adjust application settings in respective configuration files

## Testing
- Backend: Run unit and integration tests with Maven
  ```bash
  mvn test
  ```
- Frontend: Run React test suite
  ```bash
  npm test
  # or
  yarn test
  ```

## Deployment
- Backend: Build a JAR file for deployment
  ```bash
  mvn package
  ```
- Frontend: Build production-ready assets
  ```bash
  npm run build
  # or
  yarn build
  ```

## Contributing
1. Fork the repository
2. Create a feature branch
3. Commit changes
4. Push to the branch
5. Create a Pull Request
