package com.muyclound.external.util.hash;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by yanglikai on 2018/3/19.
 */
public final class MD5Utils {
  private MD5Utils() {
  }

  public static String MD5(String source) {
    String result = "";

    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      md.update(source.getBytes());
      byte[] b = md.digest();
      StringBuffer buf = new StringBuffer("");

      for (int offset = 0; offset < b.length; ++offset) {
        int i = b[offset];
        if (i < 0) {
          i += 256;
        }

        if (i < 16) {
          buf.append("0");
        }

        buf.append(Integer.toHexString(i));
      }

      result = buf.toString();
      return result;
    } catch (NoSuchAlgorithmException var7) {
      throw new RuntimeException(var7);
    }
  }
}
