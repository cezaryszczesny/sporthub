package pl.studies.sporthub.service.login;

import pl.studies.sporthub.controller.AuthAO;


public interface LoginService {

    void checkCredentials(AuthAO authAO);
}
