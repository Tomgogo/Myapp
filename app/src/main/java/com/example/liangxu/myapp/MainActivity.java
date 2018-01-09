package com.example.liangxu.myapp;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v4.math.MathUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Data mData;
    private TextView mTextView;
    int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mData = new Data();
        mData.id = 1;
        mData.name = "abc";
        mTextView = (TextView) findViewById(R.id.test);
        mTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeData(mData);
                Log.e("tom","1== "+mData.toString());
                DataHelper.changeData(mData);
                Log.e("tom",mData.toString());
                a = Integer.MAX_VALUE+10;
                Log.e("tom",a+"");
            }
        });
        int type = getNetworkType(this);
        testList();
    }
    private  void changeData(Data data){
        data.id = 123;
        data.name = "MainActivity";
        data = new Data();
    }
    private void testList(){
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("c");
        arrayList.add("b");
        arrayList.add("a");
        arrayList.add("c");
        arrayList.add("f");
        arrayList.add("g");
        for (String s : arrayList){
            Log.e("MainActivity", s);
        }
    }
    public static NetworkInfo getAvailableNetWorkInfo(Context context){
        try {
            ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if(netInfo != null && netInfo.isAvailable()){
                return netInfo;
            }else{
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Integer getNetworkType(Context context){

        if(context == null)
            return -1;
        Integer netWorkType = -1;

        NetworkInfo networkInfo = getAvailableNetWorkInfo(context);
        if(networkInfo != null){
//            if(networkInfo.getType() == ConnectivityManager.TYPE_WIFI){
//                netWorkType =  1;
//            }else if(networkInfo.getType() == ConnectivityManager.TYPE_MOBILE){
                TelephonyManager tm = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
                switch (tm.getNetworkType()) {
                    case TelephonyManager.NETWORK_TYPE_GPRS:
                        netWorkType = 2;
                        break;
                    case TelephonyManager.NETWORK_TYPE_EDGE:
                        netWorkType = 3;
                        break;
                    case TelephonyManager.NETWORK_TYPE_UMTS:
                        netWorkType = 4;
                        break;
                    case TelephonyManager.NETWORK_TYPE_HSDPA:
                        netWorkType = 5;
                        break;
                    case TelephonyManager.NETWORK_TYPE_HSUPA:
                        netWorkType = 6;
                        break;
                    case TelephonyManager.NETWORK_TYPE_HSPA:
                        netWorkType = 7;
                        break;
                    case TelephonyManager.NETWORK_TYPE_CDMA:
                        netWorkType = 8;
                        break;
                    case TelephonyManager.NETWORK_TYPE_EVDO_0:
                        netWorkType = 9;
                        break;
                    case TelephonyManager.NETWORK_TYPE_EVDO_A:
                        netWorkType = 10;
                        break;
                    case TelephonyManager.NETWORK_TYPE_1xRTT:
                        netWorkType = 11;
                        break;
                    case TelephonyManager.NETWORK_TYPE_HSPAP:
                        netWorkType = 12;
                        break;
                    case TelephonyManager.NETWORK_TYPE_LTE:
                        netWorkType = 14;
                        break;

                    default:
                        netWorkType = -1;
//                }
            }
        }
        return netWorkType;
    }

}
