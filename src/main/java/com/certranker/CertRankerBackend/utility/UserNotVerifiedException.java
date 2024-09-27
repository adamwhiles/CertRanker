package com.certranker.CertRankerBackend.utility;

import org.springframework.security.core.AuthenticationException;

public class UserNotVerifiedException extends AuthenticationException {
    public UserNotVerifiedException(String msg) {
        super(msg);
    }
}
