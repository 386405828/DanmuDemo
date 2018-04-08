package com.tidemedia.danmudemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

public class MainActivity extends AppCompatActivity{
    private JCVideoPlayer mVideoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Window window = this.getWindow();
        //设置透明状态栏,这样才能让 ContentView 向上
        // window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

        // 不然输入框直接弹出
       // getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
        //getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        setContentView(R.layout.activity_main);

        findViews();
    }



    private void findViews() {
        mVideoView = (JCVideoPlayer) findViewById(R.id.videoview);
        mVideoView.danMuInit();
        if (mVideoView != null) {
            mVideoView.setUp("http://2449.vod.myqcloud.com/2449_43b6f696980311e59ed467f22794e792.f20.mp4",
                    "http://p.qpic.cn/videoyun/0/2449_43b6f696980311e59ed467f22794e792_1/640",
                    "视频的标题",MainActivity.this);
        }
    }




    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }




}
