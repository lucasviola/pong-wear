package br.com.pongwear.pongwear;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.DataEvent;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.Wearable;
import com.google.android.gms.wearable.WearableListenerService;

public class WearService extends WearableListenerService{
    private GoogleApiClient googleApiClient;

    public WearService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        googleApiClient = new GoogleApiClient.Builder(this).addApi(Wearable.API).build();
        //googleApiClient.connect();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDataChanged(DataEventBuffer dataEvents) {
        super.onDataChanged(dataEvents);

        for(DataEvent event : dataEvents){
            if(event.getDataItem().getUri().getPath().equals("/new-game-pong")){
                Notification.Builder builder = new Notification.Builder(this).setSmallIcon(R.mipmap.ic_aaa).setContentTitle("Air Pong").setContentText("New game begining!");


                PendingIntent pendingIntent;
                Intent intent = new Intent(this, MainActivity.class);
                pendingIntent = PendingIntent.getActivity(this, 0, intent, 0);
                builder.addAction(R.mipmap.ic_aaa, "Start Game", pendingIntent);
                ((NotificationManager) getSystemService(NOTIFICATION_SERVICE)).notify(0, builder.build());
            }
        }

    }
}
