package br.com.pongwear.pongwear;

import android.content.Context;
import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.wearable.DataApi;
import com.google.android.gms.wearable.DataEventBuffer;
import com.google.android.gms.wearable.PutDataMapRequest;
import com.google.android.gms.wearable.PutDataRequest;
import com.google.android.gms.wearable.Wearable;

import java.util.Date;

public class WearHelper implements GoogleApiClient.ConnectionCallbacks, DataApi.DataListener{

    private GoogleApiClient googleApiClient;
    private static final String PATH = "/new-game-pong";

    public WearHelper(Context context) {
        googleApiClient = new GoogleApiClient.Builder(context).addApi(Wearable.API).addConnectionCallbacks(this).build();
        googleApiClient.connect();
    }

    public void newGame(){
        PutDataMapRequest putDataMapRequest = PutDataMapRequest.create(PATH);
        putDataMapRequest.getDataMap().putString("novo", new Date().toString());
        PutDataRequest request = putDataMapRequest.asPutDataRequest();
        Wearable.DataApi.putDataItem(googleApiClient, request)
                .setResultCallback(new ResultCallback<DataApi.DataItemResult>() {
                    @Override
                    public void onResult(DataApi.DataItemResult dataItemResult) {
                        if (!dataItemResult.getStatus().isSuccess()) {
                            System.out.println("erro!");
                        }
                    }
                });
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