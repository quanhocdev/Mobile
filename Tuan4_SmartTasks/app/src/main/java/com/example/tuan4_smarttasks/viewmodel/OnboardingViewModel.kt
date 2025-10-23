package com.example.tuan4_smarttasks.viewmodel

import androidx.lifecycle.ViewModel
import com.example.tuan4_smarttasks.R
import com.example.smarttasks.model.OnboardingPage

class OnboardingViewModel : ViewModel() {

    val pages = listOf(
        OnboardingPage(
            "Easy Time Management",
            "With management based on priority and daily tasks, you will gain convenience in managing and determining the tasks that must be done first.",
            R.drawable.onboard1
        ),
        OnboardingPage(
            "Increase Work Effectiveness",
            "Time management and the determination of more important tasks give you job statistics and better performance.",
            R.drawable.onboard2
        ),
        OnboardingPage(
            "Reminder Notification",
            "This app provides reminders so you don’t forget to keep doing your assignments well and according to your schedule.",
            R.drawable.onboard3
        )
    )
}
