package com.ismailaamassi.androidvolleyexample;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class StringRequestActivity extends AppCompatActivity {

    private static final String TAG = "StringRequestActivity";
    TextView tvRequestStatus;
    Button btnSendStringRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_string_request);
        tvRequestStatus = findViewById(R.id.tvRequestStatus);
        btnSendStringRequest = findViewById(R.id.btnSendStringRequest);

        btnSendStringRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendStringRequest();
            }
        });

    }

    private void sendStringRequest() {
        // 1- Prepare Request Queue
        RequestQueue queue = Volley.newRequestQueue(this);

        // 2- Prepare Request contain request data and handle response
        int method = Request.Method.GET;
        String url = "https://run.mocky.io/v3/b7033bfe-0e33-40ea-b3eb-a3ed4120eb3e";
        Response.Listener<String> onSuccess = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d(TAG, "onResponse: Success " + response);
                tvRequestStatus.setText("String Success\n" + response);
            }
        };
        Response.ErrorListener onError = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ", error);
                tvRequestStatus.setText("Error\n" + error.getMessage());
            }
        };

        StringRequest request = new StringRequest(method, url, onSuccess, onError);

        //3- Send this request via queue created in step 1
        queue.add(request);
    }
}