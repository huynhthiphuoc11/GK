package com.example.a22it227_huynhthiphuoc
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.a22it227_huynhthiphuoc.R
import com.example.a22it227_huynhthiphuoc.model.LopHoc

class LopHocAdapter(private val classes: List<LopHoc>) :
    RecyclerView.Adapter<LopHocAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val classId: TextView = itemView.findViewById(R.id.classid)
        val className: TextView = itemView.findViewById(R.id.classname)
        val classNum: TextView = itemView.findViewById(R.id.classnum)
        val classDepart: TextView = itemView.findViewById(R.id.classdepart)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_class, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val lopHoc = classes[position]
        holder.classId.text = "Class ID: ${lopHoc.maLop}"
        holder.className.text = "Class Name: ${lopHoc.tenLop}"
        holder.classNum.text = "Class of number: ${lopHoc.siSo}"
        holder.classDepart.text = "Department: ${lopHoc.khoa}"
    }

    override fun getItemCount(): Int {
        return classes.size
    }
}
