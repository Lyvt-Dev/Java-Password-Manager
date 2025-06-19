
# 🔐 Java Password Manager

A simple yet effective password manager written in pure Java.  
It generates strong passwords and stores them securely using AES encryption.

> ⚠️ **Disclaimer**:  
> I originally made this as a joke — _just for fun and practice_ —  
> but hey, it actually works pretty well. Feel free to use or extend it. 😉

---

## ✨ Features

- ✅ Secure random password generator
- ✅ Encrypted storage using AES
- ✅ Add and view entries via console UI
- ✅ Simple and beginner-friendly Java code

---

## 🛠️ How to Run

1. **Clone the repository**:
   ```bash
   git clone https://github.com/yourusername/PasswordManager.git
   cd PasswordManager


2. **Compile the code** (with Java 17+):

   ```bash
   javac src/*.java
   ```

3. **Run the app**:

   ```bash
   java -cp src Main
   ```

---

## 📁 Project Structure

```
PasswordManager/
├── src/
│   ├── Main.java
│   ├── PasswordEntry.java
│   ├── PasswordGenerator.java
│   └── PasswordManager.java
├── README.md
└── passwords.dat  ← encrypted file (created after saving a password)
```

---

## 📌 Notes

* AES encryption is used to store your passwords, but the key is currently hardcoded (`"1234567890123456"`). This is NOT secure for real-world usage.
* No external libraries or build tools (like Maven or Gradle) required.
* Console-based UI to keep things simple and portable.

---

## 📦 Requirements

* Java **17 or higher**
* Any IDE or just a terminal

---

## 🤓 Why I Built This

Honestly?
I was just messing around and thought,
*"Wouldn't it be funny if I made a password manager in pure Java?"*
Turns out — it was actually kinda funny to code :3.

Use it, break it, improve it — have fun! 😄

---

## 🧾 License

MIT – use it for whatever you want.


---
