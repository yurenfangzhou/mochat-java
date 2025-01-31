package com.mochat.mochat.common.em.workcontact;

/**
 * 客户来源枚举.
 */
public enum AddWayEnum {
    /**
     * @Message("其他渠道")
     */
    OTHER_CHANNELS(0,"其他渠道"),
    /**
     * @Message("扫描二维码")
     */
    SCAN_QR_CODE(1,"扫描二维码"),

    /**
     * @Message("搜索手机号")
     */
    SEARCH_MOBILE_PHONE(2,"搜索手机号"),

    /**
     * @Message("名片分享")
     */
    BUSINESS_CARD_SHARING(3,"名片分享"),

    /**
     * @Message("群聊")
     */
    GROUP_CHAT(4,"群聊"),

    /**
     * @Message("手机通讯录")
     */
    MOBILE_PHONE_ADDRESS_BOOK(5,"手机通讯录"),

    /**
     * @Message("微信联系人")
     */
    WE_CHAT_CONTACT(6,"微信联系人"),

    /**
     * @Message("来自微信的添加好友申请")
     */
    ADD_FRIEND_FROM_WE_CHAT(7,"来自微信的添加好友申请"),

//    /**
//     * @Message("安装第三方应用时自动添加的客服人员")
//     */
//    const CUSTOMER_SERVICE = 8;

//    /**
//     * @Message("搜索邮箱")
//     */
//    const SEARCH_EMAIL = 9;

    /**
     * @Message("内部成员共享")
     */
    IN_MEMBER_SHARE(201,"内部成员共享"),

    /**
     * @Message("管理员/负责人分配")
     */
    ADMIN_ASSIGNMENT(202,"管理员/负责人分配"),

    //    /**
//     * @Message("渠道活码")
//     */
    CHANNEL_CODE(1001,"管理员/负责人分配"),

    /**
     * @Message("自动拉群")
     */
    AUTO_GROUP(1002,"自动拉群");


    private int code;
    private String msg;

    AddWayEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    /**
     * 根据 code 值获取对应的msg
     * @param code
     * @return msg
     */
    public static String getByCode(int code) {
        AddWayEnum[] values = values();
        for (AddWayEnum e : values) {
            if (e.getCode() == code) {
                return e.getMsg();
            }
        }
        return "";
    }
}
