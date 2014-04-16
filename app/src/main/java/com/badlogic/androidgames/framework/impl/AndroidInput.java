package com.badlogic.androidgames.framework.impl;

import android.content.Context;
import android.os.Build;
import android.view.View;

import com.badlogic.androidgames.framework.Input;
import com.badlogic.androidgames.framework.TouchHandler;

/**
 * Created by jason on 16/04/14.
 */
public class AndroidInput implements Input {

    AccelerometerHandler accelHandler;
    KeyboardHandler keyHandler;
    TouchHandler touchHandler;

    public AndroidInput(Context context, View view, float scaleX, float scaleY) {
        accelHandler = new AccelerometerHandler(context);
        keyHandler = new KeyboardHandler(view);
        if (Build.VERSION.SDK_INT < 5)
            touchHandler = new SingleTouchHandler(view, scaleX, scaleY);
        else
            touchHandler = new MultiTouchHandler(view, scaleX, scaleY);
    }

    public boolean isKeyPressed(int keyCode) {
        return keyHandler.isKeyPressed(keyCode);
    }
}
