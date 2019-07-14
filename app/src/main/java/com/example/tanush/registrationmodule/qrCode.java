package com.example.tanush.registrationmodule;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class qrCode extends AppCompatActivity {


    Button button,done_button;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qr_code);

        iv = (ImageView) findViewById(R.id.image);
        button =(Button)findViewById(R.id.gen_btn);
        done_button=(Button)findViewById(R.id.done);

                String idQR=getIntent().getStringExtra("qrId");

                MultiFormatWriter multiFormatWriter=new MultiFormatWriter();
                try
                {
                    BitMatrix bitMatrix=multiFormatWriter.encode(idQR,BarcodeFormat.QR_CODE,200,200);
                    BarcodeEncoder barcodeEncoder =new BarcodeEncoder();
                    Bitmap bitmap=barcodeEncoder.createBitmap(bitMatrix);
                    iv.setImageBitmap(bitmap);

                }
                catch (WriterException e)
                {
                    e.printStackTrace();
                }

        done_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getBaseContext(),MainActivity.class);
                finish();
                startActivity(intent1);
            }
        });



    }
}
