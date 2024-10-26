package com.example.platform

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val emailInput = findViewById<EditText>(R.id.etEmailRegister)
        val passwordInput = findViewById<EditText>(R.id.etPasswordRegister)
        val confirmPasswordInput = findViewById<EditText>(R.id.etConfirmPassword)
        val registerButton = findViewById<Button>(R.id.btnRegister)
        val goToLogin = findViewById<TextView>(R.id.tvGoToLogin)

        // Найдем TextView для предупреждений
        val passwordError = findViewById<TextView>(R.id.tvPasswordError)
        val passwordNumericError = findViewById<TextView>(R.id.tvPasswordNumericError)
        val confirmPasswordError = findViewById<TextView>(R.id.tvConfirmPasswordError)

        registerButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            val confirmPassword = confirmPasswordInput.text.toString()

            // Сброс видимости всех предупреждений
            passwordError.visibility = View.GONE
            passwordNumericError.visibility = View.GONE
            confirmPasswordError.visibility = View.GONE

            if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                Toast.makeText(this, "Пожалуйста, заполните все поля", Toast.LENGTH_SHORT).show()
            } else {
                when {
                    password.length < 8 -> {
                        passwordError.visibility = View.VISIBLE
                    }
                    password.matches(Regex("^[0-9]+$")) -> {
                        passwordNumericError.visibility = View.VISIBLE
                    }
                    password != confirmPassword -> {
                        confirmPasswordError.visibility = View.VISIBLE
                        confirmPasswordError.text = "Пароли не совпадают"
                    }
                    else -> {
                        // Логика регистрации
                        Toast.makeText(this, "Регистрация успешна", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, LoginActivity::class.java))
                    }
                }
            }
        }

        goToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}
