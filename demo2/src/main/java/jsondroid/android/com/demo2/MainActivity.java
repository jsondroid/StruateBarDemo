package jsondroid.android.com.demo2;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.ColorInt;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.ColorUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioGroup;

import java.util.ArrayList;

import jsondroid.android.com.demo2.fragments.Fragment1;
import jsondroid.android.com.demo2.fragments.Fragment2;
import jsondroid.android.com.demo2.fragments.Fragment3;
import jsondroid.android.com.demo2.fragments.Fragment4;
import jsondroid.android.com.demo2.fragments.Fragment5;

public class MainActivity extends AppCompatActivity {


    /**
     * 全透状态栏
     */
    protected void initState() {
        if (Build.VERSION.SDK_INT >= 21) {//21表示5.0
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        } else if (Build.VERSION.SDK_INT >= 19) {//19表示4.4
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //虚拟键盘也透明
            //getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

    protected FragNavController activityNavController;
    protected ArrayList<Fragment> fragments;
    int color;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initState();
        setContentView(R.layout.activity_main);
        fragments = new ArrayList<>();
        fragments.add(new Fragment1());
        fragments.add(new Fragment2());
        fragments.add(new Fragment3());
        fragments.add(new Fragment4());
        fragments.add(new Fragment5());

        activityNavController = new FragNavController(savedInstanceState, getSupportFragmentManager(), R.id.content, fragments);

        initView();
    }


    private RadioGroup btnm;

    private void initView() {
        btnm = (RadioGroup) findViewById(R.id.btnm);
        activityNavController.switchTab(0);
        btnm.check(R.id.btn1);
        btnm.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.btn1:
                        activityNavController.switchTab(0);
                        break;
                    case R.id.btn2:
                        activityNavController.switchTab(1);
                        break;
                    case R.id.btn3:
                        activityNavController.switchTab(2);
                        break;
                    case R.id.btn4:
                        activityNavController.switchTab(3);
                        break;
                    case R.id.btn5:
                        activityNavController.switchTab(4);
                        break;
                }
            }
        });
    }
}
