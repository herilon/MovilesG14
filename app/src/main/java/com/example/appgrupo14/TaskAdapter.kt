package com.example.appgrupo14

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appgrupo14.TaskAdapter.*

class TaskAdapter (private val datos: ArrayList<Task>, val clickListener: (Task) -> Unit ):
    RecyclerView.Adapter<TaskAdapter.TaskViewHolder>(){

    class TaskViewHolder(val layout: View): RecyclerView.ViewHolder(layout)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.task_list_items, parent, false) as LinearLayout
        return TaskViewHolder(layout)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = datos[position]
        val textViewTask: TextView = holder.layout.findViewById(R.id.textViewTask)
        val textViewTime: TextView = holder.layout.findViewById(R.id.textViewTime)
        textViewTask.text = task.task
        textViewTime.text = task.time
        holder.layout.setOnClickListener { clickListener(task) }
    }

    override fun getItemCount(): Int {
        return datos.size
    }
}