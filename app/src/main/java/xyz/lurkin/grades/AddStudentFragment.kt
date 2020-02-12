package xyz.lurkin.grades


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import xyz.lurkin.grades.databinding.FragmentAddStudentBinding
import xyz.lurkin.grades.databinding.FragmentTitleBinding



/**
 * A simple [Fragment] subclass.
 */
class AddStudentFragment : Fragment() {

    private val viewModel: StudentListViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentAddStudentBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_student, container, false)

        binding.buttonSubmit.setOnClickListener {

            viewModel.addStudent(binding.matricule.text.toString(), binding.firstname.text.toString(), binding.lastname.text.toString())
            binding.matricule.text.clear()
            binding.firstname.text.clear()
            binding.lastname.text.clear()
            it.findNavController().popBackStack()


        }

        return binding.root
    }


}
