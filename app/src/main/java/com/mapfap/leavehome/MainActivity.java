package com.mapfap.leavehome;

import android.app.Activity;
import android.content.Context;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;


public class MainActivity extends Activity {

    private static final String TAG = "mapfap";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        silentMode();
        Toast.makeText(getBaseContext(), "Leaving home... ", Toast.LENGTH_SHORT);
        finish();
    }

    private void silentMode() {
        WifiManager wifiManager = (WifiManager) this.getSystemService(Context.WIFI_SERVICE);
        boolean wifiEnabled = wifiManager.isWifiEnabled();
        wifiManager.setWifiEnabled(false);
        Log.d(TAG, "Wifi Disabled");

        Context context = getBaseContext();
        AudioManager audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        audioManager.setStreamVolume(AudioManager.STREAM_MUSIC, 0, 0);
        Log.d(TAG, "Music Muted");

        audioManager.setRingerMode(AudioManager.RINGER_MODE_VIBRATE);
        Log.d(TAG, "RingMode Vibrate");
    }

}
