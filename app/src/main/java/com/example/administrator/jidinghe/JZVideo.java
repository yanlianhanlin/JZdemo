package com.example.administrator.jidinghe;

import android.content.Context;
import android.util.AttributeSet;

import cn.jzvd.JZVideoPlayerStandard;

/**
 * Created by Administrator on 2017/12/12.
 */

public class JZVideo extends JZVideoPlayerStandard{
    public interface JZVideoListener{
        void StateAutoComplete();
    }
    private JZVideoListener JZVideoListener;


    public void setJZVideoListener(JZVideo.JZVideoListener JZVideoListener) {
        this.JZVideoListener = JZVideoListener;
    }

    public JZVideo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    /**进入视频自动播放完成状态*/
    @Override
    public void onStateAutoComplete() {
        super.onStateAutoComplete();
//        this.startVideo();
        JZVideoListener.StateAutoComplete();
    }
    /**进入错误状态*/
    @Override
    public void onStateError() {
        super.onStateError();
        this.startVideo();
    }

}
