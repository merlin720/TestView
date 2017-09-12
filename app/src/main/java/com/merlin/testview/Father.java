package com.merlin.testview;

import android.nfc.Tag;
import android.util.Log;

/**
 * Created by zhouyang on 2017/8/29.
 */

public class Father {
    public static final String TAG= "father";
    public int num1 = 1;
    private int num2 = 2;
    public String str1 = "string";
    private String str2 = "merlin";

    public Father(){
        Log.e(TAG,"father构造方法num1_____________"+String.valueOf(num1));
        Log.e(TAG,"father构造方法str1_____________"+str1);
    }

    public void test1(){
        Log.e(TAG,"father__test1___num1_____________"+String.valueOf(num1));
        Log.e(TAG,"father__test1___str1_____________"+str1);
    }
    private void test2(){
        Log.e(TAG,"father__test2___num1_____________"+String.valueOf(num1));
        Log.e(TAG,"father__test2___str1_____________"+str1);
    }
}
