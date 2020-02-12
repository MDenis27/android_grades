package xyz.lurkin.grades


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import xyz.lurkin.grades.databinding.FragmentStudentListBinding

/**
 * A simple [Fragment] subclass.
 */
class StudentListFragment : Fragment() {

    private val viewModel: StudentListViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentStudentListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_student_list, container, false)

        Log.i("StudentListFragment", "StudentListFragment Created!")

        val adapter = StudentListAdapter()
        binding.studentList.adapter = adapter

        viewModel.students.observe(viewLifecycleOwner, Observer {
            adapter.students = it
        })

        binding.toAddStudent.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_studentListFragment))

        return binding.root
    }
}
