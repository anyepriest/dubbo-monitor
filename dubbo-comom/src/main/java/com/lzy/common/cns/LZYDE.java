package com.lzy.common.cns;

public enum LZYDE implements LZYDictionaryEnumBase {
    SYS_SUCCESS("0", "成功"),
    SYS_ERROR("-1", "失败"),
    SYS_EXCEPTION("-2", "系统异常"),
    SYS_DBTEXCEPTION("-3", "事务处理异常"),
    SYS_PARAMETER_NULL("00000001", "参数获取失败"),
    SYS_DB_CLOSE_EXCEPTION("00000002", "数据库关闭异常"),
    ENCRYPT_CONTENT_NULL("00001001", "加密/解密内容为空"),
    ENCRYPT_KEY_NULL("00001002", "密钥为空"),
    ENCRYPT_KEYANDCONTENT_NULL("00001003", "加密/解密内容为空或密钥为空"),
    ENCRYPT_ENCR_EXCEPTION("00001004", "加密异常"),
    ENCRYPT_DECR_EXCEPTION("00001005", "解密异常"),
    ENCRYPT_KEYLENGH16_ERROR("00001006", "密钥长度不为16"),
    ENCRYPT_SYSTYPE_NULL("00001007", "系统类型为空"),
    CHECK_IDNO_SUCCESS("0", "该身份证有效"),
    CHECK_IDNO_ERROR_LEN("00001101", "身份证号码长度应该为15位或18位"),
    CHECK_IDNO_ERROR_NUM("00001102", "身份证15位号码都应为数字 ; 18位号码除最后一位外，都应为数字"),
    CHECK_IDNO_ERROR_BRI("00001103", "身份证出生日期无效"),
    CHECK_IDNO_ERROR_DTE("00001104", "身份证生日不在有效范围"),
    CHECK_IDNO_ERROR_MON("00001105", "身份证月份无效"),
    CHECK_IDNO_ERROR_DAY("00001106", "身份证日期无效"),
    CHECK_IDNO_ERROR_DIS("00001107", "身份证地区编码错误"),
    CHECK_IDNO_ERROR_CHK("00001108", "身份证校验码无效，不是合法的身份证号码"),
    CHECK_EMAIL_PASSWORD_DECRYPT_ERROR("00001109", "邮箱密码解密错误"),
    CHECK_EMAIL_ERROR_FMT("00001201", "邮箱格式错误"),
    CHECK_WEIXIN_TOKEN_ERROR("00001109", "微信Token校验异常"),
    EXCEL_INIT_ERROR("00001200", "初始化错误"),
    EXCEL_MAKE_PATHISNULL("00001201", "未配置导出路径"),
    EXCEL_MAKE_RESULTISNULL("00001202", "未获取到结果"),
    EXCEL_MAKE_DEALERROR("00001203", "生成Excel时发生错误"),
    EXCEL_READ_FILENULL("00001300", "获取文件失败"),
    EXCEL_READ_WBERROR("00001301", "获取工作簿失败"),
    EXCEL_READ_WBNULL("00001302", "工作簿为空"),
    EXCEL_READ_SHEETERROR("00001303", "不存在的SHEET页"),
    EXCEL_READ_VALUEERROR("00001304", "错误的值"),
    EXCEL_READ_EXCEPTION("00001305", "读取异常"),
    EXCEL_READ_LIMIT("00001306", "超过EXCEL读取文件大小限制"),
    IMG_TYPE_ERROR("00001300", "不支持的图片类型"),
    IMG_EXCEPTION("00001301", "图片处理异常"),
    IMG_NULL_ERROR("00001302", "源图片不存在"),
    IMG_DNULL_ERROR("00001303", "目标图片/路径不存在"),
    IMG_PARM_ERROR("00001304", "参数值错误"),
    CACHE_BEAN_NULL("00001400", "未获取到缓存处理类"),
    CACHE_SET_EXCEPTION("00001401", "设置缓存异常"),
    CACHE_GET_EXCEPTION("00001402", "获取缓存异常"),
    FILE_UPLOAD_ERROR("00001500", "上传失败"),
    FILE_UPLOAD_EXCEPTION("00001501", "上传异常"),
    FILE_UPLOAD_NULL_ERROR("00001502", "上传文件为空"),
    FILE_UPLOAD_NULLORMULTI_ERROR("00001503", "上传文件为空或者上传了多个文件"),
    FILE_UPLOAD_PRM_ERROR("00001504", "缺少参数或者格式错误"),
    FILE_UPLOAD_MAXSIZE_ERROR("00001505", "超出上传文件大小限制"),
    FILE_DOWNLOAD_NOT_EXISTS("00001506", "文件不存在"),
    CALC_PRECISION_ERROR("00001507", "精度不能小于0"),
    RSA_PUBLICKEY_NULL("00001600", "公钥为空"),
    RSA_PRIVATEKEY_NULL("00001601", "私钥为空"),
    RSA_ENCRYPT_EXCEPTION("00001602", "加密异常"),
    RSA_DECRYPT_EXCEPTION("00001603", "解密异常"),
    BASE64_ENCODE_EXCEPTION("00001700", "BASE64编码异常"),
    BASE64_DECODE_EXCEPTION("00001701", "BASE64解码异常"),
    BASE64_DECODE_ERROR("00001702", "非BASE64编码"),
    REDIS_POST_SUB_TEMPLATE_NULL("00001703", "Redis订阅发布模板为空"),
    MQ_COMPONENT_ERROR("00001704", "MQ组件异常"),
    MQ_COMPONENT_DEFAULT_QUEUE_NULL_ERROR("00001705", "MQ默认队列未配置"),
    MQ_COMPONENT_DESTINATION_NULL_ERROR("00001706", "MQ目标参数为空"),
    MQ_COMPONENT_NULL_TEMPLATE_ERROR("00001707", "MQ模板为空"),
    FILE_COPY_ERROR("00001708", "文件拷贝错误"),
    FILE_COPY_SOUCE_NOT_FOUND_ERROR("00001709", "文件拷贝源文件不存在"),
    FILE_COPY_DEST_NOT_FOUND_ERROR("00001710", "文件拷贝目标文件、目录不存在"),
    FILE_COPY_SOUCE_TYPE_IS_NOT_FILE_ERROR("00001711", "文件拷贝，拷贝源类型不是文件"),
    FILE_COPY_CREATE_DIR_ERROR("00001712", "文件拷贝，创建目录失败"),
    FILE_COPY_DEST_FILE_NAME_NULL_ERROR("00001713", "文件拷贝，目标文件名为空"),
    FILE_COPY_DEST_TYPE_IS_NOT_FILE_ERROR("00001714", "文件拷贝，拷贝目标类型不是文件"),
    FILE_PDF_GENERATE_INVALID_TEMPLATE_ERROR("00001715", "生成PDF文件，模板无效"),
    FILE_PDF_GENERATE_INVALID_TARGET_ERROR("00001716", "生成PDF文件，目标路径无效"),
    FILE_PDF_GENERATE_ERROR("00001717", "生成PDF文件，生成过程异常："),
    LOCK_NOT_EXISTS_ERROR("00001718", "锁在使用中被释放，实际业务过程结束"),
    HTTP_SEND_ERROR("00001801", "发送请求异常");

    private String code;
    private String codename;

    private LZYDE(String pCode, String pCodename) {
        this.code = pCode;
        this.codename = pCodename;
    }
    public String getCode() {
        return this.code;
    }

    public String getCodename() {
        return this.codename;
    }

    public String getAllInfo() {
        return this.code + "-" + this.codename;
    }
}
