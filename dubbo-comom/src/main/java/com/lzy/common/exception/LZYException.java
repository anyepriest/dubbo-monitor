package com.lzy.common.exception;

import com.lzy.common.cns.LZYDE;
import com.lzy.common.cns.LZYDictionaryEnumBase;

public class LZYException extends RuntimeException {
    private static final long serialVersionUID = 992342056431259058L;
    private String code;

    public LZYException(String code, String message) {
        super(message);
        this.code = code;
    }

    public LZYException(Throwable cause) {
        super(LZYDE.SYS_EXCEPTION.getCodename(), cause);
        this.code = LZYDE.SYS_EXCEPTION.getCode();
    }

    public LZYException(String code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public LZYException(LZYDictionaryEnumBase pLZYDE, Throwable cause) {
        super(pLZYDE.getCodename(), cause);
        this.code = pLZYDE.getCode();
    }

    public LZYException(LZYDictionaryEnumBase pLZYDE) {
        super(pLZYDE.getCodename());
        this.code = pLZYDE.getCode();
    }

    public LZYException(LZYDictionaryEnumBase pLZYDE, String pOtherMsg) {
        super(pLZYDE.getCodename() + " " + pOtherMsg);
        this.code = pLZYDE.getCode();
    }

    public String getCode() {
        return this.code;
    }
}
