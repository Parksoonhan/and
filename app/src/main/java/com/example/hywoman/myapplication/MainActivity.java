package com.example.hywoman.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterViewFlipper;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

import static com.example.hywoman.myapplication.R.layout.fragment_fragment1;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private final int FRAGMENT1 = 1;
    private final int FRAGMENT2 = 2;
    private final int FRAGMENT3 = 3;
    private final int FRAGMENT4 = 4;

    private Button bt_tab1, bt_tab2,bt_tab3, bt_tab4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // 위젯에 대한 참조
        bt_tab1 = (Button)findViewById(R.id.bt_tab1);
        bt_tab2 = (Button)findViewById(R.id.bt_tab2);
        bt_tab3 = (Button)findViewById(R.id.bt_tab3);
        bt_tab4 = (Button)findViewById(R.id.bt_tab4);

        // 탭 버튼에 대한 리스너 연결
        bt_tab1.setOnClickListener(this);
        bt_tab2.setOnClickListener(this);
        bt_tab3.setOnClickListener(this);
        bt_tab4.setOnClickListener(this);

        // 임의로 액티비티 호출 시점에 어느 프레그먼트를 프레임레이아웃에 띄울 것인지를 정함
        callFragment(FRAGMENT2);

        ImageView imageView1 = (ImageView) findViewById(R.id.image) ;
        imageView1.setImageResource(R.drawable.book) ;

        ImageView imageView2 = (ImageView) findViewById(R.id.image2) ;
        imageView1.setImageResource(R.drawable.book2) ;


        Button button1 = (Button) findViewById(R.id.activityButton); //해당 버튼을 지정합니다.
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //버튼이 눌렸을 때
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent); //액티비티 이동
            }
        });



    }
    public void onButtonClick(View v){
        Toast.makeText(this, "Parksoonhan 216230090",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_tab1 :
                // '버튼1' 클릭 시 '프래그먼트1' 호출
                callFragment(FRAGMENT1);
                break;

            case R.id.bt_tab2 :
                // '버튼2' 클릭 시 '프래그먼트2' 호출
                callFragment(FRAGMENT2);
                break;

            case R.id.bt_tab3 :
                // '버튼3' 클릭 시 '프래그먼트3' 호출
                callFragment(FRAGMENT3);
                break;

            case R.id.bt_tab4 :
                // '버튼4' 클릭 시 '프래그먼트4' 호출
                callFragment(FRAGMENT4);
                break;
        }
    }

    private void callFragment(int frament_no){

        // 프래그먼트 사용을 위해
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (frament_no){
            case 1:
                // '프래그먼트1' 호출
                Fragment1 fragment1 = new Fragment1();
                transaction.replace(R.id.fragment_container, fragment1);
                transaction.commit();
                break;

            case 2:
                // '프래그먼트2' 호출
                Fragment2 fragment2 = new Fragment2();
                transaction.replace(R.id.fragment_container, fragment2);
                transaction.commit();
                break;
            case 3:
                // '프래그먼트1' 호출
                Fragment3 fragment3 = new Fragment3();
                transaction.replace(R.id.fragment_container, fragment3);
                transaction.commit();
                break;

            case 4:
                // '프래그먼트2' 호출
                Fragment4 fragment4 = new Fragment4();
                transaction.replace(R.id.fragment_container, fragment4);
                transaction.commit();
                break;
        }

    }
}