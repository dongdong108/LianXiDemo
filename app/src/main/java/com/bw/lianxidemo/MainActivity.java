package com.bw.lianxidemo;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private List<Fragment> mList;
    private RadioButton mRb1,mRb2,mRb3;
    private ViewPager dVp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //添加数据源
//        addDatas();
        //控件初始化
        initView();
        mRb1.setOnClickListener(this);
        mRb2.setOnClickListener(this);
        mRb3.setOnClickListener(this);

        dVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return 3;
            }

            @Override
            public Fragment getItem(int arg0) {
                // TODO Auto-generated method stub
                return new MyFragment();
            }
        });

        dVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int arg0) {
                switch (arg0) {
                    case 0:
                        mRb1.setChecked(true);
                        mRb2.setChecked(false);
                        mRb3.setChecked(false);

                        mRb1.setBackgroundColor(Color.YELLOW);
                        mRb2.setBackgroundColor(Color.BLUE);
                        mRb3.setBackgroundColor(Color.BLUE);

                        mRb1.setTextColor(Color.RED);
                        mRb2.setTextColor(Color.BLACK);
                        mRb3.setTextColor(Color.BLACK);

                        break;

                    case 1:
                        mRb1.setChecked(false);
                        mRb2.setChecked(true);
                        mRb3.setChecked(false);
                        mRb1.setBackgroundColor(Color.BLUE);
                        mRb2.setBackgroundColor(Color.YELLOW);
                        mRb3.setBackgroundColor(Color.BLUE);
                        mRb1.setTextColor(Color.BLACK);
                        mRb2.setTextColor(Color.RED);
                        mRb3.setTextColor(Color.BLACK);
                        break;

                    case 2:
                        mRb1.setChecked(false);
                        mRb2.setChecked(false);
                        mRb3.setChecked(true);
                        mRb1.setBackgroundColor(Color.BLUE);
                        mRb2.setBackgroundColor(Color.BLUE);
                        mRb3.setBackgroundColor(Color.YELLOW);
                        mRb1.setTextColor(Color.BLACK);
                        mRb2.setTextColor(Color.BLACK);
                        mRb3.setTextColor(Color.RED);
                        break;


                    default:
                        break;
                }
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });
    }


    private void initView() {
        dVp = (ViewPager) findViewById(R.id.hp_viewPager);
        mRb1 = (RadioButton) findViewById(R.id.rb1);
        mRb2 = (RadioButton) findViewById(R.id.rb2);
        mRb3 = (RadioButton) findViewById(R.id.rb3);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rb1:
                dVp.setCurrentItem(0);
                break;
            case R.id.rb2:
                dVp.setCurrentItem(1);
                break;
            case R.id.rb3:
                dVp.setCurrentItem(2);
                break;

            default:
                break;
        }
    }
}
