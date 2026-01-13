# 🚖 Cab Booking System

A Java-based Cab Booking System with both GUI (Swing) and Console interfaces. This project demonstrates Object-Oriented Programming (OOP) concepts including encapsulation, inheritance, interfaces, and polymorphism.

---

## ✨ Features

### Admin Module
- 🔐 Secure admin login with username and password
- 🚗 Add new cabs to the system
- 📝 Manage cab details (name, model, type, location, quality, seats, price)
- 👨‍✈️ Assign drivers to cabs

### Customer Module
- 📝 Customer registration with personal details
- 🔑 Create login credentials (username & password)
- 🔍 Search available cabs by location
- 🚕 Book cabs based on preferences:
  - Vehicle type (Car, Bike, Rickshaw)
  - Quality (AC / Non-AC)
  - Number of seats
- 📋 View cab details and pricing
- ✅ Booking confirmation with unique Booking ID

### Driver Module
- 📝 Driver registration with CNIC verification
- 🔑 Create driver login credentials
- 🔄 Change cab availability status
- 📊 View assigned cab information

### GUI Features
- 🖥️ User-friendly graphical interface built with Java Swing
- 📱 Multiple windows for different operations
- ⚠️ Input validation with error messages
- 🎨 Color-coded buttons and panels

---

## 📁 Project Structure

```
OOP Project GUI/
│
├── Main.java              # Application entry point (launches GUI)
├── GUI.java               # Main GUI window with navigation
├── Security.java          # Admin authentication handling
│
├── Cab.java               # Cab entity with properties and GUI
├── CabInterface.java      # Interface for cab operations
├── CabDetails.txt         # Cab data storage file
│
├── RegisterCustomer.java  # Customer registration logic and GUI
├── CustomerData.txt       # Customer information storage
├── Password.txt           # Customer credentials storage
│
├── BookingCab.java        # Cab booking logic and GUI
├── Booking.java           # Booking interface definition
│
├── Driver.java            # Driver management and GUI
├── DriverAuthantication.txt # Driver credentials storage
│
└── README.md              # Project documentation
```

---

## 💻 Requirements

- **Java Development Kit (JDK)** 11 or higher
- **Operating System:** Windows / macOS / Linux

---

## 🚀 Installation & Running

### 1. Install Java (if not installed)

**Windows (using winget):**
```powershell
winget install Microsoft.OpenJDK.21
```

**macOS (using Homebrew):**
```bash
brew install openjdk@21
```

**Linux (Ubuntu/Debian):**
```bash
sudo apt install openjdk-21-jdk
```

### 2. Compile the Project

Navigate to the project directory and compile all Java files:

```bash
cd "OOP Project GUI"
javac *.java
```

### 3. Run the Application

**Launch GUI Mode (default):**
```bash
java Main
```

**Launch GUI directly:**
```bash
java GUI
```

---

## 📖 User Guide

### Admin Operations

1. Click **"Admin"** button on the main screen
2. Enter credentials:
   - Username: `abc`
   - Password: `123`
3. After login, you can:
   - **Add Cab:** Enter cab details including name, model, type, location, quality, seats, and price
   - **Assign Driver:** Link a driver to the cab

### Customer Operations

1. Click **"Customer"** button on the main screen
2. Choose an option:
   - **Register:** Create a new customer account
     - Enter: Name, Age, Phone Number, CNIC, Gender
     - Set: Username and Password
   - **Book Cab:** Login and book a cab
     - Select vehicle type (Car/Bike/Rickshaw)
     - Choose quality (AC/Non-AC for cars)
     - Enter desired location
     - View available cabs and select one
     - Receive booking confirmation

### Driver Operations

1. Click **"Driver"** button on the main screen
2. Choose an option:
   - **Register:** Register as a driver
     - Enter CNIC for verification
     - Create username and password
   - **Change Status:** Update cab availability
     - Login with credentials
     - Enter Cab ID to change status

---

## 🔑 Login Credentials

### Default Admin Credentials
| Role  | Username | Password |
|-------|----------|----------|
| Admin | `abc`    | `123`    |

> **Note:** Customer and Driver credentials are created during registration and stored in respective files.

---

## 🎓 OOP Concepts Used

### 1. **Encapsulation**
- Private fields with public getters/setters in all classes
- Data hiding for sensitive information (passwords, CNIC)

### 2. **Interfaces**
- `Booking` interface defines contract for booking operations:
  - `login()`, `verify()`, `Book()`, `display()`
- `CabInterface` defines contract for cab management:
  - `add()`, `writeCab()`

### 3. **Inheritance & Implementation**
- `BookingCab` implements `Booking` interface
- `Cab` implements `CabInterface`

### 4. **Polymorphism**
- `ActionListener` interface implementation across multiple classes
- Method overriding for `actionPerformed()`

### 5. **Abstraction**
- Interface-based design for loose coupling
- GUI components abstracted into reusable arrays

---

## 💾 Data Storage

The application uses text files for persistent data storage:

| File | Purpose |
|------|---------|
| `CabDetails.txt` | Stores cab information (ID, name, model, type, etc.) |
| `CustomerData.txt` | Stores customer personal information |
| `Password.txt` | Stores customer login credentials |
| `DriverAuthantication.txt` | Stores driver login credentials |

---

## 🛠️ Technical Details

- **GUI Framework:** Java Swing
- **Layout Manager:** Null Layout (absolute positioning)
- **Event Handling:** ActionListener interface
- **File I/O:** BufferedReader, BufferedWriter, FileReader, FileWriter
- **Input Validation:** Try-catch blocks for number parsing

---

## 👨‍💻 Author

**OOP Project** - Cab Booking System

---

## 📄 License

This project is created for educational purposes as part of an Object-Oriented Programming course.
