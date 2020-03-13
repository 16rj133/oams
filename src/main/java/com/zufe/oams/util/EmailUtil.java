package com.zufe.oams.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
    验证邮箱是否合法
 */
public class EmailUtil {
    public static boolean isEmail(String email) {
        Pattern emailPattern = Pattern.compile("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
        Matcher matcher = emailPattern.matcher(email);
        return matcher.find();
    }
}