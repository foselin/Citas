package sv.edu.ufg.fis.amb.citas

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView




    class HomeFragment : Fragment() {
        private lateinit var corte: CardView
        private lateinit var manicura: CardView
        private lateinit var maquillaje: CardView
        private lateinit var depilacion: CardView
        private lateinit var peinadosespeciales: CardView
        private lateinit var tratamientosfaciales: CardView
        private lateinit var pedicura: CardView
        private lateinit var extensiones: CardView
        private lateinit var masajes: CardView





        @SuppressLint("MissingInflatedId")
        override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            val view = inflater.inflate(R.layout.fragment_home, container, false)

            corte = view.findViewById(R.id.corte)
            manicura = view.findViewById(R.id.manicura)
            maquillaje = view.findViewById(R.id.maquillaje)
            tratamientosfaciales= view.findViewById(R.id.tratamientos_faciales)
            pedicura = view.findViewById(R.id.pedicura)
            extensiones = view.findViewById(R.id.extensiones_pelo)
            masajes = view.findViewById(R.id.masajes)
            peinadosespeciales = view.findViewById(R.id.peinados_especiales)
            depilacion = view.findViewById(R.id.depilacion)


            corte.setOnClickListener {
                val intent = Intent(requireContext(), CorteActivity::class.java)
                startActivity(intent)
            }

            manicura.setOnClickListener {
                val intent = Intent(requireContext(), ManicuraActivity::class.java)
                startActivity(intent)
            }

            depilacion.setOnClickListener {
                val intent = Intent(requireContext(), DepilacionActivity::class.java)
                startActivity(intent)
            }

            maquillaje.setOnClickListener {
                val intent = Intent(requireContext(), MaquillajeActivity::class.java)
                startActivity(intent)
            }

            tratamientosfaciales.setOnClickListener {
                val intent = Intent(requireContext(), TratamientosActivity::class.java)
                startActivity(intent)
            }

            pedicura.setOnClickListener {
                val intent = Intent(requireContext(), PedicuraActivity::class.java)
                startActivity(intent)
            }

            extensiones.setOnClickListener {
                val intent = Intent(requireContext(), ExtensionesActivity::class.java)
                startActivity(intent)
            }

            masajes.setOnClickListener {
                val intent = Intent(requireContext(), MasajesActivity::class.java)
                startActivity(intent)
            }

            peinadosespeciales.setOnClickListener {
                val intent = Intent(requireContext(), PeinadosActivity::class.java)
                startActivity(intent)
            }




            return view
        }}




