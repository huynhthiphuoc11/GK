package com.example.a22it227_huynhthiphuoc

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.a22it227_huynhthiphuoc.databinding.ActivityMainBinding
import android.content.Intent
import quanlilophoc

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Gán ClickListener cho mỗi FrameLayout
        binding.framelayout1.setOnClickListener {
            Toast.makeText(this, "Kiểm tra số nguyên tố", Toast.LENGTH_SHORT).show()
            // Chuyển sang layout mới
            val intent = Intent(this, kiemtrasonguyento::class.java)
            startActivity(intent)
        }

        binding.framelayout2.setOnClickListener {
            // Hành động cần thực hiện khi FrameLayout 2 được nhấp
            Toast.makeText(this, "Tính phương trình bậc 1", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, tinhPTB1::class.java)
            startActivity(intent)
        }

        binding.framelayout3.setOnClickListener {
            // Hành động cần thực hiện khi FrameLayout 3 được nhấp
            Toast.makeText(this, "Quản lí lớp học", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, quanlilophoc::class.java)
            startActivity(intent)
        }


    }
}
