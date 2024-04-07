package com.example.a22it227_huynhthiphuoc



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.a22it227_huynhthiphuoc.databinding.EditclassBinding

class EditLopHocFragment : Fragment() {

    private var _binding: EditclassBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = EditclassBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonSave.setOnClickListener {
            // Xử lý logic khi người dùng nhấn nút "Lưu"
            // Ví dụ: Cập nhật thông tin của lớp học trong cơ sở dữ liệu

            // Sau khi cập nhật thành công, có thể đóng Fragment
            fragmentManager?.popBackStack()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
