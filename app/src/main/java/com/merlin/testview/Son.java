package com.merlin.testview;

import android.util.Log;

import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.Reader;

/**
 * Created by zhouyang on 2017/8/29.
 */

public class Son extends Father{

    public Son(){
        super();
        Log.e(TAG,"son构造方法num1_____________"+String.valueOf(num1));
        Log.e(TAG,"sonr构造方法str1_____________"+str1);
    }

    @Override
    public void test1() {
        super.test1();
        super.num1 = 10;
        super.str1 = "num10";
        Log.e(TAG,"Son__test1___num1_____________"+String.valueOf(num1));
        Log.e(TAG,"Son__test1___str1_____________"+str1);
    }

    /**
     * 获取手机的MAC地址
     *
     * @return
     */
    public static String getMac() {
        String str = "";
        String macSerial = "";
        try {
            Process pp = Runtime.getRuntime().exec(
                    "cat /sys/class/net/wlan0/address ");
            InputStreamReader ir = new InputStreamReader(pp.getInputStream());
            LineNumberReader input = new LineNumberReader(ir);

            for (; null != str;) {
                str = input.readLine();
                if (str != null) {
                    macSerial = str.trim();// 去空格
                    break;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if (macSerial == null || "".equals(macSerial)) {
            try {
                return loadFileAsString("/sys/class/net/eth0/address")
                        .toUpperCase().substring(0, 17);
            } catch (Exception e) {
                e.printStackTrace();

            }

        }
        return macSerial;
    }

    public static String loadFileAsString(String fileName) throws Exception {
        FileReader reader = new FileReader(fileName);
        String text = loadReaderAsString(reader);
        reader.close();
        return text;
    }

    public static String loadReaderAsString(Reader reader) throws Exception {
        StringBuilder builder = new StringBuilder();
        char[] buffer = new char[4096];
        int readLength = reader.read(buffer);
        while (readLength >= 0) {
            builder.append(buffer, 0, readLength);
            readLength = reader.read(buffer);
        }
        return builder.toString();
    }

}
