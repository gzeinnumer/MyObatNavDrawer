package com.gzeinnumer.myobatnavdrawer.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.gzeinnumer.myobatnavdrawer.R;
import com.gzeinnumer.myobatnavdrawer.model.ResponseReadObat;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AdapterReadOpData extends RecyclerView.Adapter<AdapterReadOpData.MyHolder> {

    private Context mContenx;
    private List<ResponseReadObat> mList = new ArrayList<>();

    public AdapterReadOpData(Context mContenx, List<ResponseReadObat> mList) {
        this.mContenx = mContenx;
        this.mList = mList;
    }


    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(mContenx).inflate(R.layout.item, viewGroup, false);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder myHolder, int i) {
        myHolder.unitIdItem.setText(mList.get(i).getUnitID());
        myHolder.brgIdItem.setText(mList.get(i).getBrgID());
        myHolder.brgNameItem.setText(mList.get(i).getBrgName());
        myHolder.jamItem.setText(mList.get(i).getJam());
        myHolder.lokasiNameItem.setText(mList.get(i).getLokasiName());
        myHolder.qtyItem.setText(String.valueOf(mList.get(i).getQty()));
        myHolder.tglItem.setText(mList.get(i).getTgl());
        myHolder.lokasiIdItem.setText(mList.get(i).getLokasiID());
        myHolder.unitNameItem.setText(mList.get(i).getUnitName());
        myHolder.satuanItem.setText(mList.get(i).getSatuan());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class MyHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.unit_id_item)
        TextView unitIdItem;
        @BindView(R.id.brg_id_item)
        TextView brgIdItem;
        @BindView(R.id.brg_name_item)
        TextView brgNameItem;
        @BindView(R.id.jam_item)
        TextView jamItem;
        @BindView(R.id.lokasi_name_item)
        TextView lokasiNameItem;
        @BindView(R.id.qty_item)
        TextView qtyItem;
        @BindView(R.id.tgl_item)
        TextView tglItem;
        @BindView(R.id.lokasi_id_item)
        TextView lokasiIdItem;
        @BindView(R.id.unit_name_item)
        TextView unitNameItem;
        @BindView(R.id.satuan_item)
        TextView satuanItem;

        public MyHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }


}
