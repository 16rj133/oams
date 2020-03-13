package com.zufe.oams.util;


import com.zufe.oams.dto.Response;
import com.zufe.oams.exception.WorkException;

public class ResponseUtil {

    public static void notLogin() {
        throw new WorkException("未登录");
    }

    public static Response success() {
        return success(null);
    }

    public static Response success(Object data) {
        return new Response<>(200,"成功", data);

    }

    public static Response error(int code, String msg) {
        return new Response<>(code, msg, null);
    }
}
