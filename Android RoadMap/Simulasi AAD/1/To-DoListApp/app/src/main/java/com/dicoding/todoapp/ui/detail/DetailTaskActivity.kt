package com.dicoding.todoapp.ui.detail

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.dicoding.todoapp.R
import com.dicoding.todoapp.ui.ViewModelFactory
import com.dicoding.todoapp.ui.list.TaskActivity
import com.dicoding.todoapp.utils.DateConverter
import com.dicoding.todoapp.utils.TASK_ID
import com.google.android.material.textfield.TextInputEditText

class DetailTaskActivity : AppCompatActivity() {

    private lateinit var detailTaskViewModel: DetailTaskViewModel
    private lateinit var title : TextInputEditText
    private lateinit var description : TextInputEditText
    private lateinit var dueDate : TextInputEditText
    private lateinit var deleteBtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_detail)

        title = findViewById(R.id.detail_ed_title)
        description = findViewById(R.id.detail_ed_description)
        dueDate = findViewById(R.id.detail_ed_due_date)
        deleteBtn = findViewById(R.id.btn_delete_task)

        val factory = ViewModelFactory.getInstance(this)
        detailTaskViewModel = ViewModelProvider(this, factory).get(DetailTaskViewModel::class.java)
        //TODO 11 : Show detail task and implement delete action
        val taskId = intent.getStringExtra(TASK_ID)
        detailTaskViewModel.setTaskId(taskId?.toInt())
        detailTaskViewModel.task.observe(this, {task ->
            if(task!=null){
                title.setText(task.title)
                description.setText(task.description)
                dueDate.setText(DateConverter.convertMillisToString(task.dueDateMillis))
            }
        })
        deleteBtn.setOnClickListener {
            detailTaskViewModel.deleteTask()
            val backIntent = Intent(this@DetailTaskActivity, TaskActivity::class.java)
            startActivity(backIntent)
        }
    }
}