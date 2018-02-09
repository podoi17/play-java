package services;

import entity.User;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import repositories.UserRepository;



public class RegistrationService extends Controller {

    // Use body for parameters
    @Transactional
    public Result save(String name, String email, String password) {


        //!
        if(checkMail(email) == false) {
            return badRequest("keine gültige email");
        } else {
            if (UserRepository.findByEmail(email) != null) {
                return status(CONFLICT);
            } else {
                User u1 = new User(name.toLowerCase(), email, password);
                UserRepository.save(u1);
                return ok( u1.print() + " gespeichert!");
            }
        }


    }

    @Transactional
    public Result exist(String email) {
        User u1 = UserRepository.findByEmail(email);
        if(u1 != null) {
            return ok(u1.getName() + " " + u1.getEmail());
        } else {
            return badRequest("nicht gefunden");
        }
    }

    private boolean checkMail(String email) {

        return email.contains("@");
    }


}
