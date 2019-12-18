package com.lzy.common.utils;

import com.lzy.common.cns.LZYDE;
import com.lzy.common.cns.LZYDictionaryEnumBase;
import com.lzy.common.exception.LZYException;
import com.lzy.common.web.ResponseDto;

public class SpringUtils {
    public SpringUtils() {
    }

    public static <T> ResponseDto<T> returnSuccess() {
        return getResponDto(LZYDE.SYS_SUCCESS.getCode(), LZYDE.SYS_SUCCESS.getCodename(), (T)null);
    }

    public static <T> ResponseDto<T> returnSuccess(T pObj) {
        return getResponDto(LZYDE.SYS_SUCCESS.getCode(), LZYDE.SYS_SUCCESS.getCodename(), pObj);
    }

    public static <T> ResponseDto<T> returnSuccess(String pMessage) {
        return getResponDto(LZYDE.SYS_SUCCESS.getCode(), pMessage, (T)null);
    }

    public static <T> ResponseDto<T> returnError() {
        return getResponDto(LZYDE.SYS_ERROR.getCode(), LZYDE.SYS_ERROR.getCodename(), (T)null);
    }

    public static <T> ResponseDto<T> returnError(T pObj) {
        return getResponDto(LZYDE.SYS_ERROR.getCode(), LZYDE.SYS_ERROR.getCodename(), pObj);
    }

    public static <T> ResponseDto<T> returnError(String pMessage) {
        return getResponDto(LZYDE.SYS_ERROR.getCode(), pMessage, (T)null);
    }

    public static <T> ResponseDto<T> returnInfo(LZYDictionaryEnumBase pcodeMapEnum, T pObj) {
        return getResponDto(pcodeMapEnum.getCode(), pcodeMapEnum.getCodename(), pObj);
    }

    public static <T> ResponseDto<T> returnInfo(LZYException pCex, T pObj) {
        return getResponDto(pCex.getCode(), pCex.getMessage(), pObj);
    }

    public static <T> ResponseDto<T> returnInfo(String pCode, String pMessage, T pObj) {
        return getResponDto(pCode, pMessage, pObj);
    }

    private static <T> ResponseDto<T> getResponDto(String pCode, String pMessage, T pObj) {
        ResponseDto<T> tRes = new ResponseDto();
        tRes.setCode(pCode);
        tRes.setMessage(pMessage);
        tRes.setData(pObj);
        return tRes;
    }
}