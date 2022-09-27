package com.deitel.flixster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.deitel.flixster.R.id

/**
 * The MainActivity for the flixster app.
 * Launches a [NowPlayingMovieFragment].
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(id.content, NowPlayingMovieFragment(), null).commit()
    }
}