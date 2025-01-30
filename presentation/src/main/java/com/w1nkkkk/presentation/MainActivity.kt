package com.w1nkkkk.presentation

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.w1nkkkk.presentation.databinding.ActivityMainBinding
import com.w1nkkkk.presentation.viewmodels.FavouritesViewModel
import org.koin.java.KoinJavaComponent.inject
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class MainActivity : AppCompatActivity(), ControllerProvider {

    private lateinit var binding : ActivityMainBinding
    private lateinit var controller: NavController
    private val favouritesViewModel : FavouritesViewModel by inject(FavouritesViewModel::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, 0, 0, systemBars.bottom)
            insets
        }
        val navHostFragment =
            supportFragmentManager.findFragmentById(binding.fragmentContainerView.id) as NavHostFragment?
        controller = navHostFragment!!.navController
        binding.bottomMenuView.setupWithNavController(controller)

        val badge = binding.bottomMenuView.getOrCreateBadge(R.id.favouritesFragment)
        badge.backgroundColor = Color.RED
        badge.badgeTextColor = Color.WHITE

        favouritesViewModel.itemsCount.observe(this) { count ->
            if (count > 0) {
                badge.number = count
                badge.isVisible = true
            } else {
                badge.isVisible = false
            }
        }
    }

    override fun getController() = controller
}

fun Fragment.changeFragment(containerId : Int, fragment : Fragment) {
    activity?.let {
        it.supportFragmentManager.beginTransaction().replace(containerId, fragment).commit()
    }
}

fun String.formatDate(): String {
    val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
    val date: Date = inputFormat.parse(this) ?: Date()

    val outputFormat = SimpleDateFormat("d MMMM", Locale("ru"))
    return outputFormat.format(date)
}