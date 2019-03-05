package com.gzeinnumer.myobatnavdrawer;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.android.gms.vision.CameraSource;
import com.google.android.gms.vision.Detector;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.barcode.BarcodeDetector;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScanActivity extends AppCompatActivity {

    @BindView(R.id.barcode)
    SurfaceView barcode;
    @BindView(R.id.tvkodebrg)
    TextView tvkodebrg;
    @BindView(R.id.edkodebrg)
    EditText edkodebrg;
    @BindView(R.id.tvnamabrg)
    TextView tvnamabrg;
    @BindView(R.id.ednamabrg)
    EditText ednamabrg;
    @BindView(R.id.tvsatuan)
    TextView tvsatuan;
    @BindView(R.id.edsatuan)
    EditText edsatuan;
    @BindView(R.id.tvlokasistok)
    TextView tvlokasistok;
    @BindView(R.id.splokasistok)
    Spinner splokasistok;
    @BindView(R.id.tvqtystok)
    TextView tvqtystok;
    @BindView(R.id.edqtystok)
    EditText edqtystok;
    @BindView(R.id.btnsimpan)
    Button btnsimpan;

    //buat ini
    CameraSource cameraSource;
    final int PERMISSION = 1111;
    BarcodeDetector barcodeDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        ButterKnife.bind(this);



        //buat ini
        barcodeDetector = new BarcodeDetector.Builder(this)
                .setBarcodeFormats(Barcode.ALL_FORMATS)
                .build();
        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(641, 481)
                .setAutoFocusEnabled(true)
                .build();

        cameraSource = new CameraSource.Builder(this, barcodeDetector)
                .setRequestedPreviewSize(641, 481)
                .setAutoFocusEnabled(true)
                .build();

        barcode.getHolder().addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {

                if (ActivityCompat.checkSelfPermission(ScanActivity.this, android.Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(ScanActivity.this, new String[]{Manifest.permission.CAMERA}, PERMISSION);
                    return;
                }
                try {
                    cameraSource.start(barcode.getHolder());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

                cameraSource.stop();
            }
        });

        barcodeDetector.setProcessor(new Detector.Processor<Barcode>() {
            @Override
            public void release() {

            }

            @Override
            public void receiveDetections(Detector.Detections<Barcode> detections) {
                final SparseArray<Barcode> qr = detections.getDetectedItems();
                if (qr.size() != 0){
                    tvkodebrg.post(new Runnable() {
                        @Override
                        public void run() {
                            Vibrator vibrator = (Vibrator) getApplicationContext().getSystemService(Context.VIBRATOR_SERVICE);
                            vibrator.vibrate(999);
                            tvkodebrg.setText(qr.valueAt(0).displayValue);
                        }
                    });
                }
            }
        });
    }
}
