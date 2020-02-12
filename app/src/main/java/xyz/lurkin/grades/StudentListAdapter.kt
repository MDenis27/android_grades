package xyz.lurkin.grades

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentListAdapter : RecyclerView.Adapter<StudentListAdapter.ViewHolder>() {
    var students = listOf<Student>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int {
        return students.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = students[position]
        holder.name.text = "${student.firstname} ${student.lastname}"
        holder.matricule.text = students[position].matricule
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.student_list_item, parent, false)
        return ViewHolder(view)
    }

    class ViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val name : TextView = view.findViewById(R.id.name_text)
        val matricule : TextView = view.findViewById(R.id.matricule_text)
    }
}