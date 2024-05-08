package sv.edu.ufg.fis.amb.citas

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Button
import android.widget.EditText
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

data class Usuario(val nombre: String, val telefono: String)

class SignupTabFragment : Fragment() {

    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup_tab, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        auth = Firebase.auth

        val signup_nombre = view.findViewById<EditText>(R.id.signup_nombre)
        val signup_email = view.findViewById<EditText>(R.id.signup_email)
        val signup_telefono = view.findViewById<EditText>(R.id.signup_telefono)
        val signup_password = view.findViewById<EditText>(R.id.signup_password)
        val signup_confirm = view.findViewById<EditText>(R.id.signup_confirm)
        val signup_button = view.findViewById<Button>(R.id.signup_button)

        signup_button.setOnClickListener {
            val name = signup_nombre.text.toString()
            val email = signup_email.text.toString()
            val phone = signup_telefono.text.toString()
            val password = signup_password.text.toString()
            val confirmPassword = signup_confirm.text.toString()

            if (password == confirmPassword) {
                auth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(requireActivity()) { task ->
                        if (task.isSuccessful) {
                            val user = auth.currentUser
                            Firebase.database.getReference("Usuarios").child(user!!.uid)
                                .setValue(Usuario(name, phone))
                            Toast.makeText(
                                requireContext(),
                                "Registro exitoso",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "Error en el registro: ${task.exception?.message}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
            } else {
                Toast.makeText(
                    requireContext(),
                    "Las contraseñas no coinciden",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    companion object {
        fun newInstance() = SignupTabFragment()
    }
}
