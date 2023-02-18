package dio.aulaspringdatajpa;

import dio.aulaspringdatajpa.model.User;
import dio.aulaspringdatajpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;
    @Override
    public void run(String... args) throws Exception {
        insertUser("Erick", "ErickCB", "123cb");
        insertUser("Gislaine", "GiAesthetic", "jabuti123");
        insertUser("Osvaldo", "PorcoOsvaldo", "suino123");
        insertUser("Poou", "kungFuPanda", "mestre123");

        for (User u: repository.findAll()) {
            System.out.println(u);
        }
    }
    private void insertUser(String name, String userName, String password){
        User user = new User();
        user.setName(name);
        user.setUserName(userName);
        user.setPassword(password);
        repository.save(user);

    }

}
