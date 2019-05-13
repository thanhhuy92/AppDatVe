package com.example.muave;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.app.AlertDialog;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Spinner spinLang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHuy=(Button)findViewById(R.id.btnHuy);
        Button btnThanhToan=(Button)findViewById(R.id.btnThanhToan);

        final EditText editTen=(EditText)findViewById(R.id.editTen);
        final EditText editSDT=(EditText)findViewById(R.id.editSDT);

        final RadioButton rdVip=(RadioButton)findViewById(R.id.rdVip);
        final RadioButton rdThuong=(RadioButton)findViewById(R.id.rdThuong);

        final RadioButton rdGiuongNam=(RadioButton)findViewById(R.id.rdGiuongNam);
        final RadioButton rdGheNgoi=(RadioButton)findViewById(R.id.rdGheNgoi);

        final CheckBox ckDichVu=(CheckBox)findViewById(R.id.ckDichVu);

        spinLang =  (Spinner) findViewById(R.id.spinner);

        ArrayList<String> lan_array =  new ArrayList<String>();

        lan_array.add("VND");

        lan_array.add("USD");

        ArrayAdapter adapter = new ArrayAdapter(
                this, android.R.layout.simple_spinner_item, lan_array);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item
        );

        spinLang.setAdapter(adapter);

        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Huy(v);
            }
        });

        btnThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Intent mh2 = new Intent(MainActivity.this, Main2Activity.class);
                mh2.putExtra("Ten",editTen.getText().toString());
                mh2.putExtra("SDT",editSDT.getText().toString());

                if(rdVip.isChecked())
                {
                    mh2.putExtra("Vip",rdVip.getText().toString());
                }
                else{
                    mh2.putExtra("Thuong",rdThuong.getText().toString());
                }

                if(rdGiuongNam.isChecked())
                {
                    mh2.putExtra("GiuongNam",rdGiuongNam.getText().toString());
                }
                else {
                    mh2.putExtra("GheNgoi",rdGheNgoi.getText().toString());
                }

//                if(ckDichVu.isChecked()){
//                     mh2.putExtra("DichVu",ckDichVu.getText().toString());
//                }

                if(spinLang.isSelected())
                {
                    mh2.putExtra("ThanhToan",spinLang.getCount());
                }
                if(ckDichVu.isChecked())
                    mh2.putExtra("Không",ckDichVu.getText().toString());
                else
                    mh2.putExtra("Có",ckDichVu.getText().toString());

                startActivity(mh2);*/



                int giuongnam=1200000;
                int ghengoi=800000;
                int phi=60000;

                String info = "Tên: " + editTen.getText().toString() +
                        System.getProperty("line.separator") +
                        "SĐT: " + editSDT.getText().toString() +
                        System.getProperty("line.separator");

                if(rdVip.isChecked()) {
                    info += "Thành Viên: " + rdVip.getText().toString() +
                            System.getProperty("line.separator");
                }
                else {
                    info += "Thành Viên: " + rdThuong.getText().toString() +
                            System.getProperty("line.separator");
                }

                if(rdGiuongNam.isChecked()){
                    info += "Loại Vé: " + rdGiuongNam.getText().toString() +
                            System.getProperty("line.separator") + "Gía Tiền: "+ giuongnam + System.getProperty("line.separator") + "Dịch Vụ: ";
                }
                else {
                    info += "Loại Vé: " + rdGheNgoi.getText().toString() +
                            System.getProperty("line.separator") + "Gía Tiền: "+ ghengoi + System.getProperty("line.separator") + "Dịch Vụ: ";
                }

                if(ckDichVu.isChecked())
                {
                    info += "Có" + System.getProperty("line.separator") + "Phí: " +phi;
                }
                else {
                    info +="Không";
                }

                info += System.getProperty("line.separator") + "Thanh Toán: " +
                        spinLang.getSelectedItem().toString();

                int giuongnamvipdv = giuongnam-((giuongnam*30)/100)+phi;
                int giuongnamdv = giuongnam+phi;
                int giuongnamvip = giuongnam-((giuongnam*30)/100);

                if(rdGiuongNam.isChecked())
                {
                    if(spinLang.getSelectedItem()=="VND")
                    {
                        if(ckDichVu.isChecked()&&rdVip.isChecked())
                        {
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + giuongnamvipdv + " đồng";
                        }
                        else if(ckDichVu.isChecked()){
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + giuongnamdv + " đồng";
                        }
                        else if(rdVip.isChecked()){
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + giuongnamvip + " đồng";
                        }
                        else{
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + giuongnam + " đồng";
                        }

                    }
                    else
                    {
                        if(ckDichVu.isChecked()&&rdVip.isChecked())
                        {
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + giuongnamvipdv/20000 + " $";
                        }
                        else if(ckDichVu.isChecked())
                        {
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + giuongnamdv/20000 + " $";
                        }
                        else if(rdVip.isChecked())
                        {
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + giuongnamvip/20000 + " $";
                        }
                        else {
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + giuongnam/20000 + " $";
                        }
                    }
                }

                int ghengoivipdv = ghengoi-((ghengoi*30)/100)+phi;
                int ghengoivip = ghengoi-((ghengoi*30)/100);
                int ghengoidv = ghengoi+phi;

                if(rdGheNgoi.isChecked())
                {
                    if(spinLang.getSelectedItem()=="VND")
                    {
                        if(ckDichVu.isChecked()&&rdVip.isChecked())
                        {
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + ghengoivipdv + " đồng";
                        }
                        else if(ckDichVu.isChecked()){
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + ghengoidv + " đồng";
                        }
                        else if(rdVip.isChecked()){
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + ghengoivip + " đồng";
                        }
                        else{
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + ghengoi + " đồng";
                        }
                    }
                    else
                    {
                        if(ckDichVu.isChecked()&&rdVip.isChecked())
                        {
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + ghengoivipdv/20000 + " $";
                        }
                        else if(ckDichVu.isChecked())
                        {
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + ghengoidv/20000 + " $";
                        }
                        else if(rdVip.isChecked())
                        {
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + ghengoivip/20000 + " $";
                        }
                        else {
                            info += System.getProperty("line.separator") + "Tổng Tiền: " + ghengoi/20000 + " $";
                        }
                    }
                }


                ThanhToan(v,info);
            }
        });
    }

    public void Huy(View v)
    {
        System.exit(0);
    }

    public void ThanhToan(View v, String info)
    {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage(info);
        dlgAlert.setTitle("Hóa Đơn");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }
}
