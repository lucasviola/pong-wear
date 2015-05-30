package br.com.pongwear.pongwear;

import android.content.Context;
import android.os.Bundle;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.Wearable;

public class WearHelper implements GoogleApiClient.ConnectionCallbacks, DataApi.DataListener{

    private GoogleApiClient googleApiClient;

    public WearHelper(Context context) {
        googleApiClient = new GoogleApiClient.Builder(context).addApi(Wearable.API).addConnectionCallbacks(this).build();
        googleApiClient.connect();
    }

    public void newGame(){
        
    }

    @Override
    public void onConnected(Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onDataChanged(DataEventBuffer dataEventBuffer) {

    }
}