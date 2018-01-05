package com.example.administrator.jidinghe;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.HashMap;
import java.util.LinkedHashMap;
import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;

public class MainActivity3 extends AppCompatActivity {
    private JZVideo videoplayer;
    private int videoIndex = 0;
    private  LinkedHashMap map;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        map = new LinkedHashMap();
        initview();
        video();
    }

    private void initview() {
        videoplayer = findViewById(R.id.videoplayer);
        videoplayer.setJZVideoListener(videoListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
        JZVideoPlayer.goOnPlayOnResume();
    }

    private void  video(){
        map.put("","http://oag8sza90.bkt.clouddn.com/3bcf4fd0-8254-4799-a003-588fd77f8814.mp4");
        map.put("","http://oag8sza90.bkt.clouddn.com/d811da90-a180-4b00-a5d4-6e201c12ba50.mp4");
        map.put("","http://oag8sza90.bkt.clouddn.com/2017/12/14/3f7daaedc4cf4941.mp4");
        videoIndex = 0;
        openVideo();
    }
    private void openVideo(){
        Object[] objects = new Object[3];
        objects[0] = map;
        objects[1] = false;//looping
        objects[2] = new HashMap<>();
        ((HashMap) objects[2]).put("key", "value");
        videoplayer.setUp(objects,videoIndex, JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
//        JZVideoPlayer.setVideoImageDisplayType(JZVideoPlayer.VIDEO_IMAGE_DISPLAY_TYPE_FILL_PARENT);
        videoplayer.startVideo();
    }

    private JZVideo.JZVideoListener videoListener = new JZVideo.JZVideoListener() {
        @Override
        public void StateAutoComplete() {
            if(videoIndex != map.size()-1){
                ++videoIndex;
            }else if(videoIndex == map.size()-1){
                videoIndex = 0;
            }
            videoplayer.onStatePreparingChangingUrl(videoIndex,0);
        }
    };

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }
}
