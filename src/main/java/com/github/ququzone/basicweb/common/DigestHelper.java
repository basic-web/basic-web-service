package com.github.ququzone.basicweb.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * digest helper.
 *
 * @author Yang XuePing
 */
public class DigestHelper {
    private static byte[] digestBytes(String algorithm, String... infos) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(algorithm);
            for (String info : infos) {
                messageDigest.update(info.getBytes());
            }
        } catch (NoSuchAlgorithmException e) {
            // can't occur
        }
        return messageDigest != null ? messageDigest.digest() : new byte[0];
    }

    public static String digest(String algorithm, String... infos) {
        return NumberTools.bytesToHex(digestBytes(algorithm, infos));
    }
}
