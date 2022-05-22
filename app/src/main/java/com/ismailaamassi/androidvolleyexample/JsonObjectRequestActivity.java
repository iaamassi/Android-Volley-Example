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
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

public class JsonObjectRequestActivity extends AppCompatActivity {
    private static final String TAG = "JsonObjectRequestActivi";

    TextView tvRequestStatus;
    Button btnSendJsonObjectRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_object_request);

        tvRequestStatus = findViewById(R.id.tvRequestStatus);
        btnSendJsonObjectRequest = findViewById(R.id.btnSendJsonObjectRequest);

        btnSendJsonObjectRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendJsonObjectRequest();
            }
        });
    }

    private void sendJsonObjectRequest() {
        // 1- Prepare Request Queue
        RequestQueue queue = Volley.newRequestQueue(this);

        // 2- Prepare Request contain request data and handle response
        int method = Request.Method.GET;
        String url = "https://run.mocky.io/v3/0d377451-e3a0-40ea-a5f7-3713b4b11d71";
        JSONObject requiredData = null;
        Response.Listener<JSONObject> onSuccess = new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.d(TAG, "onResponse: Success " + response);
                tvRequestStatus.setText("JSONObject Success\n" + response);
            }
        };
        Response.ErrorListener onError = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ", error);
                tvRequestStatus.setText("Error\n" + error.getMessage());
            }
        };

        JsonObjectRequest request = new JsonObjectRequest(method, url, requiredData, onSuccess, onError);

        //3- Send this request via queue created in step 1
        queue.add(request);
    }

}