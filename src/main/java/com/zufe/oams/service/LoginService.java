package com.zufe.oams.service;

import com.zufe.oams.dto.User;
import com.zufe.oams.dto.PasswordVO;

public interface LoginService {
    User login(String id, String password);

    void changePassword(PasswordVO passwordVO);
}
