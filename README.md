![Java](https://img.shields.io/badge/Language-Java-red)
![CLI](https://img.shields.io/badge/Interface-CLI-yellow)
![Pomodoro](https://img.shields.io/badge/Feature-Pomodoro-navy)
![License](https://img.shields.io/badge/License-MIT-green)

# **Productivity App (Java Console)**

## Project Overview
A minimal console-based productivity tool built in Java — designed to help manage tasks, track progress with a Pomodoro timer, and stay inspired with motivational quotes.

---

## Features

1. Task Management: Add, edit, delete, and mark tasks as done

2. Pomodoro Timer: Stay focused with time-boxed work sessions

3. Daily Summary Dashboard: See pending tasks and Pomodoros completed

4. Motivational Quotes: Get a new quote each time you start the app

5. JSON Persistence: Saves data locally between runs

---

## Tech Stack

- Language: Java

- Libraries: Gson (for JSON parsing)

- Data Storage: Local JSON files

---

## Project Structure

```
Productivity_App/
├── src/
│   ├── organizer/
│   │   ├── Main.java
│   │   ├── Task.java
│   │   ├── TaskManager.java
│   │   ├── PomodoroTimer.java
│   │   ├── QuotesManager.java
│   │   └── Dashboard.java
│   └── data/
│       ├── quotes.json
│       └── tasks.json
├── lib/
│   └── gson-2.8.9.jar
└── bin/
```

---

## Run Instructions

Open terminal in project directory

Compile:

javac -cp ".;lib/gson-2.8.9.jar" -d bin src/organizer/*.java


Run:

java -cp "bin;lib/gson-2.8.9.jar" organizer.Main

---

## Future Enhancements

1. Add GUI using JavaFX or Swing

2. Task deadlines and reminders

3. Export summaries as reports
