package com.example.haroutine_android.ui.notification;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;

import com.example.haroutine_android.MainActivity;
import com.example.haroutine_android.R;

public class NotificationService extends Service {
    NotificationManager Notifi_M;
    ServiceThread thread;
    Notification Notifi ;
    int flag = 0;
    int start = 0;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Notifi_M = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        myServiceHandler handler = new myServiceHandler();
        flag = flags;
        start = startId;
        thread = new ServiceThread(handler);
        thread.start();
        return START_STICKY;
    }


    class myServiceHandler extends Handler {
        @RequiresApi(api = Build.VERSION_CODES.S)
        @Override
        public void handleMessage(android.os.Message msg) {

            Intent intent = new Intent(NotificationService.this, MainActivity.class);

            PendingIntent pendingIntent =
                    PendingIntent.getActivity(NotificationService.this, 0, intent,PendingIntent.FLAG_MUTABLE);

            Notifi = new Notification.Builder(getApplicationContext(), "my_channel_01")
                    .setOngoing(true)
                    .setContentTitle("오늘 하루 약속한 루틴이 있습니다.")
                    .setContentText("지금은 수학 숙제를 하는 시간입니다.")
                    .setSmallIcon(R.drawable.logo2)
                    .setTicker("알림!!!")
                    .setContentIntent(pendingIntent)
                    .build();

            Notifi_M.notify( 100 , Notifi);
        }
    };
}
