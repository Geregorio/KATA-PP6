package hiber;

import hiber.config.AppConfig;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));
        userService.add(new User("User5", "LastName5", "user5@mail.ru", "BMW", 5));
        userService.add(new User("User6", "LastName6", "user6@mail.ru", "AUDI", 6));
        userService.add(new User("User7", "LastName7", "user7@mail.ru", "Mercedes", 220));
        userService.add(new User("User8", "LastName8", "user8@mail.ru", "Porsche", 911));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            if (user.car.getModel() == null) {
                System.out.println("No car");
                System.out.println();
            } else {
                System.out.println("Model = " + user.car.getModel());
                System.out.println("Series = " + user.car.getSeries());
                System.out.println();
            }
        }

        List<User> userCar = userService.getUserByCar("Porsche", 911);
        for (User user : userCar) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Model = " + user.car.getModel());
            System.out.println("Series = " + user.car.getSeries());
            System.out.println();
        }
        context.close();
    }
}
