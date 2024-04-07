package com.example.a22it227_huynhthiphuoc

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class tinhPTB1 : AppCompatActivity() {

    private lateinit var editTextA: EditText
    private lateinit var editTextB: EditText
    private lateinit var buttonCalculate: Button
    private lateinit var buttonBack: Button
    private lateinit var textViewResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tinhptb1)

        // Ánh xạ các thành phần giao diện từ layout XML
        editTextA = findViewById(R.id.editTextA)
        editTextB = findViewById(R.id.editTextB)
        buttonCalculate = findViewById(R.id.buttonCalculate)
        buttonBack = findViewById(R.id.buttonBack)
        textViewResult = findViewById(R.id.textViewResult)

        // Thiết lập sự kiện click cho nút "Tính"
        buttonCalculate.setOnClickListener {
            // Lấy hệ số a và b từ EditText và chuyển đổi thành số thực
            val a = editTextA.text.toString().toDoubleOrNull()
            val b = editTextB.text.toString().toDoubleOrNull()

            // Kiểm tra xem hệ số a và b có null hay không
            if (a != null && b != null) {
                // Tính toán kết quả của phương trình bậc 1: ax + b = 0
                val result = -b / a
                textViewResult.text = "Nghiệm của phương trình: x = $result"
            } else {
                // Hiển thị thông báo nếu hệ số a hoặc b là null
                textViewResult.text = "Vui lòng nhập hệ số a và b là số thực."
            }
        }
        buttonBack.setOnClickListener {
            // Tạo Intent để quay lại Activity trước đó (hoặc MainActivity)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            // Đóng Activity hiện tại (tinhPTB1)
            finish()
        }
        val buttonReset: Button = findViewById(R.id.buttonReset)
        buttonReset.setOnClickListener {
            // Xóa nội dung của EditText và TextView
            editTextA.text.clear()
            editTextB.text.clear()
            textViewResult.text = ""
        }
    }

}
