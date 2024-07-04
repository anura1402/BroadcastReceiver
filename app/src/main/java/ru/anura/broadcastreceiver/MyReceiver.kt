package ru.anura.broadcastreceiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver:BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        when(intent?.action){
            ACTION_CLICKED ->{
                val clickCount = intent.getIntExtra(EXTRA_COUNT, 0)
                Toast.makeText(
                    context,
                    "Clicked $clickCount times",
                    Toast.LENGTH_SHORT
                ).show()
            }
            Intent.ACTION_AIRPLANE_MODE_CHANGED ->{
                val turnedOn = intent.getBooleanExtra("state", false)
                Toast.makeText(
                    context,
                    "Airplane mode changed, turned on: $turnedOn",
                    Toast.LENGTH_SHORT
                ).show()
            }
            Intent.ACTION_BATTERY_LOW ->{
                Toast.makeText(
                    context,
                    "Battery low",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
    companion object{
        const val ACTION_CLICKED = "clicked"
        const val EXTRA_COUNT = "count"
    }
}