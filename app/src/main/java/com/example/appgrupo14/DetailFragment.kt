package com.example.appgrupo14

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.room.Room
import com.example.appgrupo14.room_database.ToDoDAO
import com.example.appgrupo14.room_database.ToDoDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DetailFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmento: View = inflater.inflate(R.layout.fragment_detail, container, false)
/*
        var txvTarea: TextView = fragmento.findViewById(R.id.textViewTarea)
        var txvHora: TextView = fragmento.findViewById(R.id.textViewHora)
        var txvLugar: TextView = fragmento.findViewById(R.id.textViewLugar)
        txvTarea.text = requireArguments().getString("tarea")
        txvHora.text = requireArguments().getString("hora")
        txvLugar.text = requireArguments().getString("lugar")
*/
        return fragmento
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var txvTarea: TextView = view.findViewById(R.id.textViewTarea)
        var txvHora: TextView = view.findViewById(R.id.textViewHora)
        var txvLugar: TextView = view.findViewById(R.id.textViewLugar)
        var id = requireArguments().getInt("id")
        val room: ToDoDatabase = Room
            .databaseBuilder(context?.applicationContext!!, ToDoDatabase::class.java, "ToDoDatabase")
            .build()
        var toDoDAO: ToDoDAO = room.todoDao()
        runBlocking {
            launch {
                var result = toDoDAO.findById(id)
                txvTarea.text = result.title
                txvHora.text = result.time
                txvLugar.text = result.place
            }
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}