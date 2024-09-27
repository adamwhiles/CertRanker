package com.certranker.CertRankerBackend.utility;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Throwable cause = exception.getCause();

        if (cause instanceof UserNotVerifiedException) {
            System.out.println("User not verified");
            response.sendRedirect("/login?error=verification");  // Directly handle redirect
        } else {
            System.out.println("Exception: " + exception.getMessage());
            response.sendRedirect("/login?error=true");  // Directly handle redirect
        }
    }
}
