package com.example.appgreattask.ImagesFragment;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

class MyVolley {

    private RequestQueue requestQueue;
    private static MyVolley instance;

    private MyVolley(Context context){
        requestQueue = Volley.newRequestQueue(context.getApplicationContext());
    }

    public static synchronized MyVolley getInstance(Context context){

        if(instance == null){
            instance = new MyVolley(context);
        }
        return instance;
    }

    public RequestQueue getRequestQueue(){
        return  requestQueue;
    }
}
