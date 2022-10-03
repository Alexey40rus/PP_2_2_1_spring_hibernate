package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class  MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      Car car1 = new Car("porsche", 1 );
      Car car2= new Car("bmw", 2 );
      Car car3 = new Car("mercedes", 3 );
      Car car4 = new Car("lamborghini", 4 );

      userService.add(new User("Alex", "Mareev", "alex@mail.ru", car1));
      userService.add(new User("Elena", "Mareeva", "elena@mail.ru", car2));
      userService.add(new User("Darya", "Mareeva", "darya@mail.ru", car3));
      userService.add(new User("Nikita", "Mareev", "nikitos@mail.ru", car4));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println("Car model = "+user.getCar().getModel());
         System.out.println("Car series = "+user.getCar().getSeries());
         System.out.println();
      }

      User user = userService.getUserByCar("lamborghini", 4);
      System.out.println("User: " + user.getFirstName()+ " " + user.getLastName());

      context.close();
   }
}
