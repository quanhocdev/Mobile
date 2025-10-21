package com.example.tuan4_thuvien.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

data class StudentRecord(
    val name: String,
    val books: List<String>
)

class LibraryViewModel : ViewModel() {
    // Danh sách các bản ghi (mỗi bản ghi = 1 sinh viên + sách đã mượn)
    private val _records = mutableStateListOf<StudentRecord>()
    val records: List<StudentRecord> get() = _records

    fun addRecord(name: String, books: List<String>) {
        if (name.isNotBlank() && books.isNotEmpty()) {
            _records.add(StudentRecord(name, books))
        }
    }

    fun clearAll() {
        _records.clear()
    }
}
