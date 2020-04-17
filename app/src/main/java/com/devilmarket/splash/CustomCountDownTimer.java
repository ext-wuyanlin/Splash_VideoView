package com.devilmarket.splash;


import android.os.Handler;

public class CustomCountDownTimer implements Runnable {
    private int time;
    private final ICountDownHandler countDownHandler;
    private final Handler handler;
    private boolean isRun;
    private int countDowntime;

    //1、实时去回调这个时候的时间---倒计时到几秒
    //2、支持传入总时间
    //3、没过1秒总时间减一
    //4、总时间倒计时为0时，要回调完成的状态---显示“跳过”
    public CustomCountDownTimer  (int time, ICountDownHandler countDownHandler)
    {
        handler=new Handler();
        this.time=time;
        this.countDownHandler=countDownHandler;
        this.countDowntime=time;
    }
    //实现具体逻辑
    @Override
    public void run() {
        if(isRun)
        {
            if(countDownHandler!=null)
            {
                countDownHandler.onTicker(countDowntime);
            }
            if(countDowntime==0){
                cancel();
                if(countDownHandler!=null){
                    countDownHandler.onFinish();
                }
            }else {
                countDowntime=time--;
                handler.postDelayed(this,1000);
            }
        }
    }
    //开启倒计时
    public void start(){
        isRun=true;
        handler.post(this);
    }
    //跳出循环
    public void cancel(){
        isRun=false;
        handler.removeCallbacks(this);
    }

    public interface ICountDownHandler {
        //倒计时回调
        void onTicker(int time);

        //完成时回调
        void onFinish();
    }
}
