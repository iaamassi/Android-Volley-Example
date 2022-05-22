package com.ismailaamassi.androidvolleyexample;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class ImageRequestActivity extends AppCompatActivity {
    private static final String TAG = "ImageRequestActivity";

    TextView tvRequestStatus;
    Button btnSendImageRequest;
    ImageView ivResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_request);

        tvRequestStatus = findViewById(R.id.tvRequestStatus);
        btnSendImageRequest = findViewById(R.id.btnSendImageRequest);
        ivResult = findViewById(R.id.ivResult);

        btnSendImageRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendImageRequest();
            }
        });
    }

    private void sendImageRequest() {
        // 1- Prepare Request Queue
        RequestQueue queue = Volley.newRequestQueue(this);

        // 2- Prepare Request contain request data and handle response
        String url = "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTXdEzujXOtx4OPOHCbLfe59LONvzbO7DElPlUvnlN2fUewwPTg0wJ-C2eJLOnV4dUiN1Y&usqp=CAU";
        Response.Listener<Bitmap> onSuccess = new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                Log.d(TAG, "onResponse: Success " + response);
                tvRequestStatus.setText("Bitmap Success\n" + response);
                ivResult.setImageBitmap(response);
            }
        };
        Response.ErrorListener onError = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e(TAG, "onErrorResponse: ", error);
                tvRequestStatus.setText("Error\n" + error.getMessage());
            }
        };
        //Require more info about bitmap(image)
        ImageRequest request = new ImageRequest(url, onSuccess, 180, 180, ImageView.ScaleType.FIT_XY, Bitmap.Config.RGB_565, onError);

        //3- Send this request via queue created in step 1
        queue.add(request);
    }

}