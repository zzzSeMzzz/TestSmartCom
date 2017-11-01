package ru.sem.web;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import ru.sem.model.BaseResponse;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by Admin on 31.10.2017.
 */
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    private static final Logger log = LoggerFactory.getLogger("application");

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        log.info("success");
        ObjectMapper mapper = new ObjectMapper();
        BaseResponse baseResponse = new BaseResponse();
        baseResponse.setMessage("success login");
        baseResponse.setSuccess(true);
        OutputStream out = response.getOutputStream();
        mapper.writeValue(out, baseResponse);
    }
}
