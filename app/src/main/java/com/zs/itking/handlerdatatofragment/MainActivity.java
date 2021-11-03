package com.zs.itking.handlerdatatofragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText edit;
    private Handler mHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        // 1.填充Fragment到FrameLayout控件中
        getFragmentManager().beginTransaction().replace(R.id.layout_fragment, HandlerFragment.getInstance()).commit();
        // 2.获取输入框控件
        edit = (EditText) findViewById(R.id.edit);
    }

    /**
     * MainActivity 与 HandlerFragment 共享Handler实例
     *
     * @param handler
     */
    public void setHandler(Handler handler) {
        // 3.在HandlerFragment中通过调用此方法，即可实现共享Handler消息对象
        mHandler = handler;
    }

    public String getTitles(){
        return "hello";
    }


    /**
     * 点击开始传递数据
     *
     * @param view
     */
    public void star(View view) {
        //4.创建发送消息实例，在HandlerFragment中接收此消息，即可得到传输的数据信息
        Message msg = new Message();
        //5.携带数据为输入框文本数据
        msg.obj = edit.getText().toString();
        //5.消息标记为1
        msg.what = 1;
        //5.开始发送消息
        mHandler.sendMessage(msg);
    }
}