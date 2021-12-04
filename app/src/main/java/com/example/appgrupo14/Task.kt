package com.example.appgrupo14

data class Task (val id: Int, val task: String, val time: String, val place: String){
    override fun toString(): String {
        return task
    }
}