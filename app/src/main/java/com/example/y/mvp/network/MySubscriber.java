package com.example.y.mvp.network;

import com.example.y.mvp.data.Constant;
import com.socks.library.KLog;

import rx.Subscriber;

/**
 * by y on 2016/5/6.
 */
public class MySubscriber<T> extends Subscriber<T> {


    @Override
    public void onStart() {
        super.onStart();
        RxBus.getInstance().sendNetWork(Constant.ON_START);
    }

    @Override
    public void onCompleted() {
        RxBus.getInstance().sendNetWork(Constant.ON_COMPLETED);
    }

    @Override
    public void onError(Throwable e) {
        KLog.i(e.getMessage());
        RxBus.getInstance().sendNetWork(Constant.ON_ERROR);
    }

    @Override
    public void onNext(T t) {
        RxBus.getInstance().sendNetWork(t);
    }


}
