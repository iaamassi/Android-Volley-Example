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
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class JsonArrayRequestActivity extends AppCompatActivity {
    private static final String TAG = "JsonArrayRequestActivit";

    TextView tvRequestStatus;
    Button btnSendJsonArrayRequest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json_array_request);
        tvRequestStatus = findViewById(R.id.tvRequestStatus);
        btnSendJsonArrayRequest = findViewById(R.id.btnSendJsonArrayRequest);

        btnSendJsonArrayRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendJsonArrayRequest();
            }
        });
    }

    private void sendJsonArrayRequest() {
        // 1- Prepare Request Queue
        RequestQueue queue = Volley.newRequestQueue(this);

        // 2- Prepare Request contain request data and handle response
        int method = Request.Method.GET;
        String url = "https://run.mocky.io/v3/538d998c-1698-4309-b6a7-0c59bcd13dca";
        JSONArray requiredData = null;
        Response.Listener<JSONArray> onSuccess = new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                Log.d(TAG, "onResponse: Success " + response);
                tvRequestStatus.setText("JSONArray Success\n" + response);
            }
        };
        Response.ErrorListener onError = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ", error);
                tvRequestStatus.setText("Error\n" + error.getMessage());
            }
        };

        JsonArrayRequest request = new JsonArrayRequest(method, url, requiredData, onSuccess, onError);

        //3- Send this request via queue created in step 1
        queue.add(request);
    }

}