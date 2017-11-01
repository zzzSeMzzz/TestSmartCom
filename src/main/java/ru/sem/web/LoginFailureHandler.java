package ru.sem.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import ru.sem.model.BaseResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Admin on 31.10.2017.
 */
public class LoginFailureHandler implements AuthenticationFailureHandler {

    private static final Logger log = LoggerFactory.getLogger("application");

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse response,
                                        AuthenticationException e) throws IOException, ServletException {

        ObjectMapper mapper = new ObjectMapper();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("failed login via handler");
        baseResponse.setSuccess(false);
        String jsonString = mapper.writeValueAsString(baseResponse);
        OutputStream out = response.getOutputStream();
        log.info(jsonString);
        response.setContentType("application/json");
        mapper.writeValue(out, baseResponse);
    }
}
