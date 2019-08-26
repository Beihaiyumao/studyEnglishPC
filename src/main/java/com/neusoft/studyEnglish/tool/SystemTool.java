package com.neusoft.studyEnglish.tool;

import java.util.Date;
import java.util.UUID;

/**
 * 工具类
 *
 */
public class SystemTool {
    /**
     * 产生12位随机数
     *
     * @return
     */
    public static String uuid() {
        String s = UUID.randomUUID().toString();
        s = s.substring(0, 8) + s.substring(9, 13) + s.substring(14, 18) + s.substring(19, 23) + s.substring(24);
        String uuid = s.substring(0, 12);
        return uuid;
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Date getDateTime() {
        Date time = new java.sql.Date(new Date().getTime());
        return time;
    }

}
