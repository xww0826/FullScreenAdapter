package nd.no.xww.fullscreenadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * 根据像素缩放比例方案进行适配 - 适合所有分辨率的手机
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_linear);
//        setContentView(R.layout.activity_main_relative);
        setContentView(R.layout.activity_main_frame);
    }
}
