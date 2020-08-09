package com.yl.hz.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 脱敏数据
 *
 * @Author:runzhi
 * @Date:下午6:28 2019/11/30
 */
public class SensitiveDataUtil {

    private static final Pattern ID_CARD_PATTERN = Pattern.compile("[0-9]{15}|[0-9]{18}|[0-9]{14}X|[0-9]{17}X");
    private static final Pattern BANK_CARD_PATTERN = Pattern.compile("[0-9]{13,19}");
    private static final Pattern PHONE_TEL_PATTERN = Pattern.compile("[0-9]{3,4}[-]?[0-9]{7,8}");

    /**
     * 默认的脱敏方法
     *
     * @return
     */
    private static String defaultHide(String sensitiveDate) {
        if (StringUtils.isBlank(sensitiveDate)) {
            return sensitiveDate;
        } else {
            String temp = sensitiveDate.trim();
            int length = temp.length();
            int headNum = (int) Math.ceil(length / 3.0D);
            int tailNum = (int) Math.floor(length / 3.0D);

            return customizeHide(temp, headNum, tailNum, length - headNum - tailNum);

        }


    }

    private static String customizeHide(String sensitiveData, int headCharNum, int tailCharNum, int hideCharNum) {
        if (StringUtils.isBlank(sensitiveData)) {
            return sensitiveData;
        } else {
            String temp = sensitiveData.trim();
            int length = temp.length();
            if (headCharNum >= 0 && tailCharNum >= 0 && hideCharNum >= 0 && headCharNum + tailCharNum <= length) {
                StringBuilder sb = new StringBuilder();
                int headBeginIndex = headCharNum - 1;
                int tailBeginIndex = length - tailCharNum;
                if (headBeginIndex >= 0 && headBeginIndex < length) {
                    sb.append(temp, 0, headCharNum);
                }

                for (int i = 0; i < hideCharNum; i++) {
                    sb.append("*");
                }

                if (tailBeginIndex >= 0 && tailBeginIndex < length) {
                    sb.append(temp.substring(tailBeginIndex));
                }
                return sb.toString();

            } else {
                return temp;
            }
        }
    }

    private static String cellphoneHide(String sensitiveData) {
        if (StringUtils.isBlank(sensitiveData)) {
            return sensitiveData;
        } else {
            String temp = sensitiveData.trim();
            int length = temp.length();
            int notHideNum = length - 4;
            return customizeHide(temp, notHideNum / 2, notHideNum - notHideNum / 2, 4);
        }

    }

    private static boolean isCellPhoneOrTelNo(String cellPhoneOrTelNo) {
        if (StringUtils.isBlank(cellPhoneOrTelNo)) {
            return false;
        } else {
            Matcher matcher = PHONE_TEL_PATTERN.matcher(cellPhoneOrTelNo.trim());
            return matcher.matches();
        }
    }

    public static void main(String[] args) {
//        int length = 17;
//        int ceil = (int) Math.ceil(length / 3.0D);
//        int floor = (int) Math.floor(length / 3.0D);
//        System.out.println(ceil);
//        System.out.println(floor);

        String address = "95588";
        System.out.println(isCellPhoneOrTelNo(address));
//        StringBuilder sb = new StringBuilder();
//        System.out.println(sb.append(s, 0, 2));
//
//        System.out.println(s.substring(0, 2));

    }
}
