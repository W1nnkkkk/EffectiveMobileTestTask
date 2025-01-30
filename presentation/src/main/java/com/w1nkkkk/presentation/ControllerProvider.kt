package com.w1nkkkk.presentation

import androidx.navigation.NavController

interface ControllerProvider {
    fun getController() : NavController
}