package services;

import entity.User;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;
import repositories.UserRepository;

/**
 * Created by Manuel on 24.10.17.
 */
public class LoginService extends Controller {


    //POST
    //Use body for parameters
    @Transactional
    public Result login(String email, String password) {
        User u1 = UserRepository.findByEmail(email);
        if(u1 != null) {
            String userPw = u1.getPassword();
            if(userPw.equals(password)) {
                u1.setRandomString();
                return ok(u1.getRandomString());
            } else {
                return status(FORBIDDEN);
            }
        } else {
            return status(NOT_FOUND);
        }
    }
}
