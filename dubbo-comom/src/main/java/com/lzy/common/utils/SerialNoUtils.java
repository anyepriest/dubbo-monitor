package com.lzy.common.utils;

import com.lzy.common.cns.LZYCNS;

public class SerialNoUtils {
    private static int CurId = 0;

    public static String getSerialNo() {
        return getSerialNo(LZYCNS.SERVICE_ID);
    }

    /**
     * 生成serialNo
     * @param prefix
     * @return
     */
    public static synchronized String getSerialNo(String prefix) {
        String tID = Long.toString(System.currentTimeMillis());
        ++CurId;
        if (CurId > 9999) {
            CurId = 1;
        }

        tID = tID + String.format("%0" + 4 + "d", CurId);
        return prefix + tID;
    }
}
