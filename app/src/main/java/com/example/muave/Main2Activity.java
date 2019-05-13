package com.example.muave;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView txtXuatTen=(TextView)findViewById(R.id.txtXuatTen);
        TextView txtXuatSDT=(TextView)findViewById(R.id.txtXuatSDT);
        TextView txtXuatVip=(TextView)findViewById(R.id.txtXuatVip);
        TextView txtXuatThuong=(TextView)findViewById(R.id.txtXuatThuong);
        TextView txtXuatGiuongNam=(TextView)findViewById(R.id.txtXuatGiuongNam);
        TextView txtXuatGheNgoi=(TextView)findViewById(R.id.txtXuatGheNgoi);
        TextView txtXuatDichVu=(TextView)findViewById(R.id.txtXuatDichVu);

        Bundle bd=getIntent().getExtras();

        if(bd!=null)
        {
            String ten=bd.getString("Ten");
            String sdt=bd.getString("SDT");
            String vip=bd.getString("Vip");
            String thuong=bd.getString("Thuong");
            String giuongnam=bd.getString("GiuongNam");
            String ghengoi=bd.getString("GheNgoi");
            String dichvuco=bd.getString("Có");
            String dichvuko=bd.getString("Không");

            txtXuatTen.setText(ten);
            txtXuatSDT.setText((sdt));
            txtXuatVip.setText(vip);
            txtXuatThuong.setText(thuong);
            txtXuatGiuongNam.setText(giuongnam);
            txtXuatGheNgoi.setText(ghengoi);
            txtXuatDichVu.setText(dichvuco);
            txtXuatDichVu.setText(dichvuko);
        }
    }
}
