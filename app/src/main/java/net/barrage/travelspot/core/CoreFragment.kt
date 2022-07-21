package net.barrage.travelspot.core

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.navigation.fragment.findNavController

open class CoreFragment : Fragment() {

    val activityLifecycleValid: FragmentActivity?
        get() {
            val activity = activity
            return if (isLifecycleInvalid) null else activity
        }

    val isLifecycleInvalid: Boolean
        get() {
            val activity: Activity? = activity
            return activity == null || activity.isFinishing || !isAdded || isRemoving || isDetached || view == null
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    fun navControllerNavigate(destinationId: Int, bundle: Bundle? = null) {
        if (isLifecycleInvalid) return
        findNavController().navigate(destinationId, bundle)
    }
}