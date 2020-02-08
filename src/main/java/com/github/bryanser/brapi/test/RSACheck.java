package com.github.bryanser.brapi.test;

import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public class RSACheck {
    public static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCWUX9rQURvO32hmI0xlQimLAr+9RyvoAyU3eHHFB61ySlUWna0ytRaDS6EYC+KeaXnxf3To+xnhwXVqljsyRT5DvFMcLMf/9MSL2Qj4CiHDYEC7/hhqoJgipdL/6MDl6v7KdAZ9xmuacCehD8CFZxyvKh/vEoNUUxpKliqYlZWPwIDAQAB";

    public static RSAPublicKey getPublicKey() {
        try {
            byte[] keyBytes = decoder.decode(publicKey);
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);
            return (RSAPublicKey) keyFactory.generatePublic(x509EncodedKeySpec);
        } catch (InvalidKeySpecException e) {
        }
        return null;
    }

    public static String decryptByPublic(String content) {
        RSAPublicKey publicKey = getPublicKey();
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.DECRYPT_MODE, publicKey);
            int splitLength = (publicKey).getModulus().bitLength() / 8;
            byte[] contentBytes = hexStringToBytes(content);
            byte[][] arrays = splitBytes(contentBytes, splitLength);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte[] array : arrays) {
                stringBuffer.append(new String(cipher.doFinal(array)));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
        } catch (NoSuchPaddingException e) {
        } catch (InvalidKeyException e) {
        } catch (BadPaddingException e) {
        } catch (IllegalBlockSizeException e) {
        }
        return null;
    }

    private static final String ALGORITHM = "RSA";

    private static KeyFactory keyFactory = null;
    private static Base64.Decoder decoder = Base64.getDecoder();

    static {
        try {
            keyFactory = KeyFactory.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
        }
    }

    public static byte[][] splitBytes(byte[] bytes, int splitLength) {
        //bytes与splitLength的余数
        int remainder = bytes.length % splitLength;
        //数据拆分后的组数，余数不为0时加1
        int quotient = remainder != 0 ? bytes.length / splitLength + 1 : bytes.length / splitLength;
        byte[][] arrays = new byte[quotient][];
        byte[] array = null;
        for (int i = 0; i < quotient; i++) {
            //如果是最后一组（quotient-1）,同时余数不等于0，就将最后一组设置为remainder的长度
            if (i == quotient - 1 && remainder != 0) {
                array = new byte[remainder];
                System.arraycopy(bytes, i * splitLength, array, 0, remainder);
            } else {
                array = new byte[splitLength];
                System.arraycopy(bytes, i * splitLength, array, 0, splitLength);
            }
            arrays[i] = array;
        }
        return arrays;
    }

    public static byte[] hexStringToBytes(String hex) {
        int len = (hex.length() / 2);
        hex = hex.toUpperCase();
        byte[] result = new byte[len];
        char[] chars = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(chars[pos]) << 4 | toByte(chars[pos + 1]));
        }
        return result;
    }

    private static byte toByte(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }
}
