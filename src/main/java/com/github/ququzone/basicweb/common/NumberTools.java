package com.github.ququzone.basicweb.common;

import java.text.NumberFormat;

/**
 * number tools.
 *
 * @author Yang XuePing
 */
public class NumberTools {
    private NumberTools() {
    }

    public static String bytesToHex(byte[] bytes) {
        String result = "";
        for (byte aByte : bytes) result += byteToHex(aByte);
        return result.toLowerCase();
    }

    public static String byteToHex(byte bt) {
        String temp = Integer.toHexString(bt & 0XFF);
        if (temp.length() == 1) {
            return "0" + temp;
        } else {
            return temp;
        }
    }

    public static String formatData(Double data) {
        if (data == null) {
            return "0.0";
        }
        NumberFormat format = NumberFormat.getNumberInstance();
        if (data > 0.01) {
            format.setMaximumFractionDigits(2);
        } else if (data > 0.0001) {
            format.setMaximumFractionDigits(4);
        } else if (data > 0) {
            format.setMaximumFractionDigits(6);
        } else if (data > -0.0001) {
            format.setMaximumFractionDigits(6);
        } else if (data > -0.01) {
            format.setMaximumFractionDigits(4);
        } else {
            format.setMaximumFractionDigits(2);
        }
        return format.format(data);
    }
}
