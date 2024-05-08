package sv.edu.ufg.fis.amb.citas


import androidx.annotation.NonNull
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

//login posicion de pagina

class ViewPagerAdapter(@NonNull fragmentManager: FragmentManager, @NonNull lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    @NonNull
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            1 -> SignupTabFragment()
            else -> LoginTabFragment()
        }
    }

    override fun getItemCount(): Int {
        return 2
    }
}

