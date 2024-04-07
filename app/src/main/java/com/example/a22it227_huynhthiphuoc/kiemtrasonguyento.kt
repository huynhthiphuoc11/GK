package com.example.a22it227_huynhthiphuoc

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.a22it227_huynhthiphuoc.databinding.KiemtrasonguyentoBinding

class kiemtrasonguyento : AppCompatActivity() {

    private lateinit var binding: KiemtrasonguyentoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = KiemtrasonguyentoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Ánh xạ các thành phần giao diện từ layout XML
        val editTextNumber = binding.editTextNumber
        val buttonCheckPrime = binding.buttonCheckPrime
        val textViewResult = binding.textViewResult
        val buttonBack = binding.buttonBack


        // Thiết lập sự kiện click cho nút "Kiểm tra"
        buttonCheckPrime.setOnClickListener {
            // Lấy số từ EditText và chuyển đổi thành số nguyên
            val number = editTextNumber.text.toString().toIntOrNull()

            // Kiểm tra xem số có phải là số nguyên hay không
            if (number != null) {
                val isPrime = isPrime(number)
                if (isPrime) {
                    textViewResult.text = "$number là số nguyên tố."
                } else {
                    textViewResult.text = "$number không phải là số nguyên tố."
                }
            } else {
                textViewResult.text = "Vui lòng nhập một số nguyên."
            }
        }
        buttonBack.setOnClickListener {
            // Quay lại hoạt động trước đó
            onBackPressed()
        }
        val buttonReset: Button = findViewById(R.id.buttonReset)
        buttonReset.setOnClickListener {
            // Xóa nội dung của EditText và TextView
            editTextNumber.text.clear()
            textViewResult.text = ""
        }
    }

    // Hàm kiểm tra số nguyên tố
    private fun isPrime(number: Int): Boolean {
        if (number <= 1) {
            return false
        }
        for (i in 2 until number) {
            if (number % i == 0) {
                return false
            }
        }
        return true
    }
}
