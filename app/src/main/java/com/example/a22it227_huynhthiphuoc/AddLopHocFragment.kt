package com.example.a22it227_huynhthiphuoc


import com.example.a22it227_huynhthiphuoc.databinding.Quanlilophoc1Binding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.a22it227_huynhthiphuoc.databinding.AddclassBinding
import com.example.a22it227_huynhthiphuoc.model.LopHoc

class AddLopHocFragment : Fragment() {

    private var _binding: AddclassBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = AddclassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Xử lý logic sau khi view được tạo
        binding.buttonAdd.setOnClickListener {
            // Lấy dữ liệu từ EditText
            val maLop = binding.editTextMaLop.text.toString()
            val tenLop = binding.editTextTenLop.text.toString()
            val siSo = binding.editTextSiSo.text.toString().toInt()
            val khoa = binding.editTextKhoa.text.toString()

            // Kiểm tra xem các trường dữ liệu có được nhập đầy đủ hay không
            if (maLop.isEmpty() || tenLop.isEmpty() || khoa.isEmpty()) {
                Toast.makeText(requireContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Instantiate the DataAdapter
            val dataAdapter = DataAdapter(requireContext())

            // Create a new LopHoc object
            val newLopHoc = LopHoc(maLop, tenLop, siSo, khoa)

            // Add the LopHoc to the database
            dataAdapter.addLopHoc(newLopHoc)

            // Close the database connection
            dataAdapter.close()

            // Go back to the previous Fragment
            fragmentManager?.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}
