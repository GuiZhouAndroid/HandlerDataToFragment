package com.zs.itking.handlerdatatofragment;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

/**
 * created by on 2021/11/3
 * 描述：接口Handler消息
 *
 * @author ZSAndroid
 * @create 2021-11-03-16:29
 */


public class HandlerFragment extends Fragment {

    private TextView text;

    // 接收MainActivity发送消息，匹配消息what值(消息标记)
    public Handler mHandler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            switch (msg.what) {
                case 1:
                    //匹配成功，把object类型的数据强转为String，并设置到TextView控件上
                    text.setText((String) msg.obj);
                    break;
            }
        };
    };
    private String titles;

    public HandlerFragment() {
    }

    public static HandlerFragment getInstance() {
        return new HandlerFragment();
    }


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        MainActivity mActivity = (MainActivity) activity;
        //通过强转成宿主activity，就可以获取到传递过来的数据
        titles = mActivity.getTitles();
        mActivity.setHandler(mHandler);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_handler, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        text = (TextView) view.findViewById(R.id.text);
        text.setText(titles);
    }
}

