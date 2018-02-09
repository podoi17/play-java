package services;

import entity.User;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.UserRepository;

/**
 * Created by Manuel on 24.10.17.
 */
public class SecretMessage extends Controller {

    @Transactional
    public Result sendSecretMessage(String email) {
        User u1 = UserRepository.findByEmail(email);
        String randomString = u1.getRandomString();
        if(randomString == null) {
            return status(UNAUTHORIZED);
        } else {
            return ok("sie sind online");
        }




    }
}
