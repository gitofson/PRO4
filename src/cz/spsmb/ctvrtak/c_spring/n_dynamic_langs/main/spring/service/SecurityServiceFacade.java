package cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.spring.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import cz.spsmb.ctvrtak.c_spring.n_dynamic_langs.main.java.service.Login;
import org.springframework.stereotype.Component;

/**
 * @author Felipe Gutierrez
 *
 */
//@Component("ssFacade")
public class SecurityServiceFacade {
    private Logger log = LoggerFactory.getLogger(SecurityServiceFacade.class);

    private Login login;

    public void setLogin(Login login) {
        this.login = login;
    }

    public boolean areCredentialsValid(String email, String pass){
        log.debug("Validating Credentials > email:" + email + ", pass:" + pass);
        return this.login.isAuthorized(email, pass);
    }
}
