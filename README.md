# 🌤️ Weather App (Java + Swing)

A simple desktop weather application built using Java and Swing that fetches real-time weather data using the WeatherAPI (https://www.weatherapi.com/). This application displays current weather details including temperature, feels like, humidity, precipitation, wind speed, and condition for any city entered by the user.

---

## 🛠 Features

- GUI built with Java Swing
- Live weather data from WeatherAPI
- Displays:
  - City and Country
  - Temperature (°C)
  - Feels Like Temperature
  - Humidity (%)
  - Precipitation (mm)
  - Wind Speed (kph)
  - Weather Condition

---

## 📸 Screenshot

 
> Example:
> <img width="1366" height="768" alt="Screenshot (148)" src="https://github.com/user-attachments/assets/e21c72bf-aa1b-42b3-9b0f-dced9afb9f8a" />


---

## 🚀 How to Run

### Prerequisites

- Java JDK 8 or above
- Internet connection
- WeatherAPI Key (free from [weatherapi.com](https://www.weatherapi.com/))

### Steps

1. Clone or download the repository.
2. Replace the `API_KEY` value in `WeatherApp.java` with your personal key:
   ```java
   private final String API_KEY = "your_api_key_here";

3. Compile and run the application:

```bash

javac -cp .;json.jar WeatherApp.java
java -cp .;json.jar WeatherApp
Note: You must include json.jar (e.g., org.json library) in your classpath. You can download it from https://github.com/stleary/JSON-java or use Maven/Gradle for dependency management.
```

## 📂 Project Structure

WeatherApp/
│
├── WeatherApp.java
├── README.md
└── json.jar         # (External library)


## 👩‍💻 Author
Ekta Naresh Chandak
B.Tech in Artificial Intelligence & Data Science

## 📄 License
This project is for educational purposes only.
