package code.anitha.musicplaylist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import code.anitha.musicplaylist.databinding.ActivityPlaylistBinding

class PlaylistActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPlaylistBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlaylistBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.displayPlaylistButton.setOnClickListener {
            var playlistText = ""
            var totalRating = 0

            for (i in 0 until SongList.songCount) {
                val song = SongList.songs[i]
                if (song != null) {
                    playlistText += "${song.title} by ${song.artist} - Rating: ${song.rating} - Comment: ${song.comment}\n"
                    totalRating += song.rating
                }
            }

            playlistText = if (playlistText.isEmpty()) {
                "No songs in playlist"
            } else {
                val averageRating = totalRating / SongList.songCount.toFloat()
                playlistText + "\nAverage rating: $averageRating"
            }

            playlistText.also { binding.playlistTextView.text = it }
        }

        binding.returnButton.setOnClickListener {
            finish()
        }
    }
}

