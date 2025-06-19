package code.anitha.musicplaylist

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import code.anitha.musicplaylist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.addToPlaylistButton.setOnClickListener {
            val intent = Intent(this, AddSongActivity::class.java)
            startActivity(intent)
        }

        binding.viewPlaylistButton.setOnClickListener {
            val intent = Intent(this, PlaylistActivity::class.java)
            startActivity(intent)
        }

        binding.exitButton.setOnClickListener {
            finish()
        }
    }
}
