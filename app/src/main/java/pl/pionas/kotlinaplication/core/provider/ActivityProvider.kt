package pl.pionas.kotlinaplication.core.provider

import android.app.Activity
import android.app.Application
import android.os.Bundle

/**
 * Created by Adrian Pionka on 01 wrzesień 2020
 * adrian@pionka.com
 */
class ActivityProvider(application: Application) {
    var foregroundActivity: Activity? = null

    init {
        application.registerActivityLifecycleCallbacks(object :
            Application.ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, bundle: Bundle?) {
                foregroundActivity = activity
            }

            override fun onActivityStarted(activity: Activity) {

            }

            override fun onActivityResumed(activity: Activity) {

            }

            override fun onActivityPaused(activity: Activity) {
                foregroundActivity = null
            }

            override fun onActivityStopped(activity: Activity) {

            }

            override fun onActivitySaveInstanceState(activity: Activity, bundle: Bundle) {

            }

            override fun onActivityDestroyed(activity: Activity) {
            }

        })
    }
}