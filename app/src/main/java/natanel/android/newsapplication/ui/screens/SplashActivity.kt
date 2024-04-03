package natanel.android.newsapplication.ui.screens

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import natanel.android.newsapplication.MainActivity
import natanel.android.newsapplication.R
import natanel.android.newsapplication.ui.repository.NewsRepository
import javax.inject.Inject


@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {

    @Inject
    lateinit var newsRepository: NewsRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        newsRepository.loadNewsHeadlines("us")
        lifecycleScope.launch {
            delay(2000)
            withContext(Dispatchers.IO) {
                val intent = Intent(this@SplashActivity, MainActivity::class.java)
                newsRepository.flow.collectLatest {
                    Log.d("newsRepository1", it.toString())
                }
                startActivity(intent)
                finish()
            }
        }
        val image = findViewById<ImageView>(R.id.logoScreen)
        image.animate()
            .rotation(360.0f)
            // .scaleY(1.0f)
            .setDuration(2100)
            .start()
    }
}