import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a22it227_huynhthiphuoc.LopHocAdapter
import com.example.a22it227_huynhthiphuoc.R
import com.example.a22it227_huynhthiphuoc.databinding.Quanlilophoc1Binding
import com.example.a22it227_huynhthiphuoc.model.LopHoc

class quanlilophoc : AppCompatActivity() {
    private lateinit var binding: Quanlilophoc1Binding
    private lateinit var classAdapter: LopHocAdapter
    private val classes = mutableListOf<LopHoc>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = Quanlilophoc1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        classAdapter = LopHocAdapter(classes)
        binding.myRecyclerView.adapter = classAdapter
        binding.myRecyclerView.layoutManager = LinearLayoutManager(this)
        initData()

        binding.buttonAdd.setOnClickListener {
            showAddClassDialog()
        }
    }

    private fun initData() {
        classes.add(LopHoc("22JIT", "Class 1", 30, "Math"))
        classes.add(LopHoc("22CS1", "Class 2", 25, "Science"))
        classes.add(LopHoc("22HST", "Class 3", 28, "History"))
        classAdapter.notifyDataSetChanged()
    }

    private fun addNewClass(classID: String, className: String, classSize: Int, subject: String) {
        val newClass = LopHoc(classID, className, classSize, subject)
        classes.add(newClass)
        classAdapter.notifyDataSetChanged()
    }

    private fun showAddClassDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_class, null)
        val editTextClassID = dialogView.findViewById<EditText>(R.id.editTextClassID)
        val editTextClassName = dialogView.findViewById<EditText>(R.id.editTextClassName)
        val editTextClassSize = dialogView.findViewById<EditText>(R.id.editTextClassSize)
        val editTextClassSubject = dialogView.findViewById<EditText>(R.id.editTextClassSubject)

        val dialog = AlertDialog.Builder(this)
            .setTitle("Add New Class")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                val classID = editTextClassID.text.toString()
                val className = editTextClassName.text.toString()
                val classSize = editTextClassSize.text.toString().toIntOrNull() ?: 0
                val subject = editTextClassSubject.text.toString()

                addNewClass(classID, className, classSize, subject)
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()
    }
}
