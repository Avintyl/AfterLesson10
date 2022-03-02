package com.example.afterlesson10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.afterlesson10.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnSearchPicture.setOnClickListener {
            loadRequestPicture(binding.etPictureQuery.text.toString().lowercase())
        }

        binding.btnClearQuery.setOnClickListener(ClearClickListener(binding.etPictureQuery))
    }

    private fun loadRequestPicture(query: String) {
        val id = resources.getIdentifier(query, "drawable", packageName)
        if (id == 0) {
            Snackbar.make(
                binding.root,
                "Не найдено изображение по указанному запросу",
                Snackbar.LENGTH_SHORT
            )
                .setAction(
                    "Очистить запрос",
                    ClearClickListener(binding.etPictureQuery)
                )
                .show()
        } else binding.ivPicture.setBackgroundResource(id)

    }

}

class ClearClickListener(private val clearingEditText: android.widget.EditText) :
    View.OnClickListener {
    override fun onClick(p0: View?) {
        clearingEditText.text.clear()
    }

}