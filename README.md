# EduNova - Education & Progress Tracker Mobile Application 🚀

EduNova is a modern, student-centric Android application built using Kotlin. It is designed to help students evaluate their academic knowledge through interactive single-page quizzes and monitor their ongoing subject performance with a dynamic, highly-visual Grades Report module.

The application architecture relies heavily on clean UI components, dynamic data filtering, and high-fidelity layouts heavily inspired by modern UI/UX design wireframes.

---

## 🛠️ Technology Stack & Architecture

* **Development Language:** Kotlin (100%)  
* **UI Layout Engine:** XML (ConstraintLayout, MaterialCardView, RecyclerView, Custom ScrollViews)  
* **Minimum SDK Support:** Android API 24 (Nougat) or higher  
* **Development IDE:** Android Studio  
* **Core Concepts Used:** View Binding, WindowInsetsCompat (Edge-to-Edge), Structural Layout Inflation  

---

## ✨ Key Features & Technical Breakdown

### 💡 Smart Input Validation & Real-time Scoring
The application integrates strict dynamic validation constraints prior to processing user data. If a student attempts to submit the assessment with one or more fields or questions left unselected, a defensive validation routine triggers an immediate Toast alert and aborts the network/local submission workflow.

### 📊 Contextual Pop-up Overlays (Modal Views)
To preserve the user's focus and context, the application heavily utilizes contextual pop-up overlays rather than navigating away to entirely new screens. The Grades and Performance module renders as a beautifully contained modal sheet over a dimmed background, giving users an immediate data snapshot.

### 🎨 Figma-Driven Interaction & Prototyping
Every functional view, transition, and hover/click color-state toggle in the application is constructed based on pixel-perfect Figma layouts.

### 🔐 Secure User Registration & Authentication
The application incorporates a structured onboard user registration module that allows new students to safely create accounts. This flows into a secure Login ecosystem tasked with authenticating credentials, establishing active user sessions, and enforcing permission boundaries across the app, ensuring that student data remains isolated and protected.

### 🎯 Seamless Course Enrollment System
EduNova features a dynamic Course Enrollment module enabling authenticated students to browse available educational tracks and enroll in specified subjects.

### 📚 Structured Lesson Management
To maintain a high-quality flow, the platform integrates a robust Lesson Management engine. This component organizes curriculum content into sequential modules, tracking real-time student completion rates.

### 💳 Integrated Payment Gateway Simulation
The application supports financial transactions via a simulated Payment Gateway infrastructure. This module manages checkout workflows securely, allowing users to process premium course purchases or subscription renewals.

---

## ⚙️ Full CRUD Operations

The application architecture is backed by a local/mock data layer supporting complete CRUD (Create, Read, Update, Delete) capability:

* **Create:** Allows users to submit new quiz records, log performance inputs, and initiate file upload requests.  
* **Read:** Dynamically fetches and binds active subject datasets to render individual row-items inside custom list view adapters.  
* **Update:** Updates individual grade metrics, modifies overall progress percentages, and toggles selection states in real-time.  
* **Delete:** Supports the clean flushing of previous quiz states, clearing user selections when transitioning or safely terminating active screen instances.  

---

## 📁 Project Directory Structure

```text
EduNova/
│
├── app/
│   ├── src/
│   │   └── main/
│   │       ├── java/com/example/myapplication/   <- Kotlin Source Files
│   │       └── res/layout/                       <- XML Layout Architecture
│   └── build.gradle.kts
│
├── screenshots/                                  <- Application UI Wireframes
│
└── README.md                                     <- Project Landing Documentation
