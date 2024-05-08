package sv.edu.ufg.fis.amb.citas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class AgendarFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_agendar, container, false)

        val serviceName = arguments?.getString("serviceName")
        val selectedDate = arguments?.getString("selectedDate")

        val serviceNameTextView: TextView = view.findViewById(R.id.serviceNameTextView)
        serviceNameTextView.text = serviceName

        val selectedDateTextView: TextView = view.findViewById(R.id.selectedDateTextView)
        selectedDateTextView.text = selectedDate

        return view
    }
}




