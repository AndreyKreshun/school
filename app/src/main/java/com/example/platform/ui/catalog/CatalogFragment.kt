package com.example.platform.ui.catalog

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.platform.LessonAdapter
import com.example.platform.databinding.FragmentCatalogBinding

class CatalogFragment : Fragment() {

    private var _binding: FragmentCatalogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val catalogViewModel =
            ViewModelProvider(this).get(CatalogViewModel::class.java)

        _binding = FragmentCatalogBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // Список уроков
        val lessons = listOf(
            "Урок 1: Введение в программирование в Python",
            "Урок 2: Знакомство с базовыми конструкциями в Python",
            "Урок 3: Работа с функциями и модулями",
            "Урок 4: Введение в работу с API Telegram",
            "Урок 5: Создание простого Telegram-бота",
            "Урок 6: Улучшение функционала бота",
            "Урок 7: Интерактивные функции бота",
            "Урок 8: Завершение проекта и публикация бота"
        )

        // Настройка RecyclerView
        val lessonsRecyclerView = binding.lessonsRecyclerView
        lessonsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        lessonsRecyclerView.adapter = LessonAdapter(lessons)

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
