package pl.studies.sporthub.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.codec.Base64;
import pl.studies.sporthub.service.login.LoginService;

import java.nio.charset.StandardCharsets;


public class BaseApiController {

    protected static final String DELETE_SUCCESSFUL_MSG = "Pomyślnie usunięto";
    private static final String HEADER_AUTH = "Authorization";

    @Resource
    private HttpServletRequest request;

    @Autowired
    private LoginService loginService;


    protected void loginBasic64() {
        AuthAO authFromHeader;
        try {
            authFromHeader = getAuthFromHeader(request.getHeader(HEADER_AUTH));

        } catch (Exception e) {
            throw new RuntimeException("Nie podano danych logowania");
        }
        loginService.checkCredentials(authFromHeader);

    }


    protected AuthAO getAuthFromHeader(final String authHeader) {
        byte[] decodeAuth = Base64.decode(authHeader.substring(6).getBytes(StandardCharsets.UTF_8));
        String usernameAndPassword = new String(decodeAuth, StandardCharsets.UTF_8);
        int userNameIndex = usernameAndPassword.indexOf(":");
        String username = usernameAndPassword.substring(0, userNameIndex);
        String password = usernameAndPassword.substring(userNameIndex + 1);
        return new AuthAO(username, password);
    }
}
