package com.example.platform

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity() {

    // Переменные для хранения логина и пароля
    private val savedEmail = "user@example.com"
    private val savedPassword = "password123"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailInput = findViewById<EditText>(R.id.etEmailLogin)
        val passwordInput = findViewById<EditText>(R.id.etPasswordLogin)
        val loginButton = findViewById<Button>(R.id.btnLogin)
        val goToRegister = findViewById<TextView>(R.id.tvGoToRegister)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()

            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Сравнение с сохранёнными значениями
                if (isValidUser(email, password)) {
                    Toast.makeText(this, "Вход успешен", Toast.LENGTH_SHORT).show()

                    // Переход на основной экран
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)
                    finish() // Закрываем LoginActivity
                } else {
                    Toast.makeText(this, "Неверные данные", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show()
            }
        }

        goToRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }

    // Функция проверки пользователя
    private fun isValidUser(email: String, password: String): Boolean {
        return email == savedEmail && password == savedPassword
    }
}
