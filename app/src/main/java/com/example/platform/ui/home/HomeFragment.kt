package com.example.platform.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.platform.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Заполнение текстовых полей с данными пользователя
        binding.userName.text = "Имя: Иван Иванов"
        binding.userWallet.text = "Кошелёк: 1000.00 RUB"
        binding.registrationDate.text = "Дата регистрации: 01.01.2023"
        binding.lastLoginDate.text = "Дата последнего входа: 10.10.2023"
        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}