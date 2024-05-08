package sv.edu.ufg.fis.amb.citas

import android.os.Build
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.snackbar.Snackbar
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.Locale

class ManicuraActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_manicura)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Genera las fechas disponibles
        val dates = generateDates().map {
            it.format(DateTimeFormatter.ofPattern("EEEE, dd MMMM yyyy, hh:mm a", Locale("es", "ES")))
        }.toTypedArray()

        // Llena el Spinner con las fechas disponibles
        val dateSpinner: Spinner = findViewById(R.id.dateSpinner)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, dates)
        dateSpinner.adapter = adapter

        // Configura el botón "Atrás"
        val backButton: ImageButton = findViewById(R.id.backButton)
        backButton.setOnClickListener {
            finish()
        }

        val addToCartButton: Button = findViewById(R.id.addToCartButton)
        addToCartButton.setOnClickListener {
            // Muestra un Snackbar
            Snackbar.make(it, "Cita registrada con éxito", Snackbar.LENGTH_SHORT).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun generateDates(): List<LocalDateTime> {
        val dates = mutableListOf<LocalDateTime>()
        var now = LocalDateTime.now().truncatedTo(ChronoUnit.DAYS)
        var daysAdded = 0

        // Avanzar al próximo día hábil si hoy es sábado o domingo
        while (daysAdded < 5) {
            now = now.plusDays(1)
            if (now.dayOfWeek.value >= 1 && now.dayOfWeek.value <= 5) {
                // Generar las fechas dentro del rango de 12 PM a 5 PM
                for (hour in 12..17) {
                    dates.add(now.withHour(hour))
                }
                daysAdded++
            }
        }

        return dates
    }
}