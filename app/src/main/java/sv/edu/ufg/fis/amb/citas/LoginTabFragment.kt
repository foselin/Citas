package sv.edu.ufg.fis.amb.citas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginTabFragment : Fragment() {
    private lateinit var loginButton: Button
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var auth: FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login_tab, container, false)
        loginButton = view.findViewById(R.id.login_button)
        usernameEditText = view.findViewById(R.id.login_email)
        passwordEditText = view.findViewById(R.id.login_password)
        auth = Firebase.auth

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            auth.signInWithEmailAndPassword(username, password)
                .addOnCompleteListener(requireActivity()) { task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(activity, MainActivityMenu::class.java))
                        activity?.finish()
                    } else {
                        Toast.makeText(activity, "Error en el inicio de sesión: ${task.exception?.message}", Toast.LENGTH_SHORT).show()
                    }
                }
        }
        return view
    }
}
