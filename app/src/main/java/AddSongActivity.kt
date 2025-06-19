package code.anitha.musicplaylist

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import code.anitha.musicplaylist.databinding.ActivityAddSongBinding

class AddSongActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddSongBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddSongBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.saveButton.setOnClickListener {
            val title = binding.titleEditText.text.toString().trim()
            val artist = binding.artistEditText.text.toString().trim()
            val ratingInput = binding.ratingEditText.text.toString().trim()
            val comment = binding.commentEditText.text.toString().trim()

            val rating = ratingInput.toIntOrNull()

            if (title.isEmpty() || artist.isEmpty() || rating == null || rating !in 1..5) {
                Toast.makeText(this, "Please enter a valid title, artist, and rating (1–5)", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (SongList.songCount < SongList.songs.size) {
                SongList.songs[SongList.songCount] = Song(title, artist, rating, comment)
                SongList.songCount++
                Toast.makeText(this, "Song added successfully!", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Playlist is full (max ${SongList.songs.size} songs)", Toast.LENGTH_SHORT).show()
            }
        }
    }
}



