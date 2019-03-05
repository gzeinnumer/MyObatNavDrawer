package com.gzeinnumer.myobatnavdrawer;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.SurfaceView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan);
        ButterKnife.bind(this);
    }
}
