import constant.Constant;
import model.User;
import service.AuthService;
import service.UserService;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<User> DS = new ArrayList<>();
        DS.add(new User("lili", "lili1234", "lili12@gmail.com", "0982655491"));
        DS.add(new User("anna", "anna1234", "ana@gmail.com", "0344353036"));
        DS.add(new User("bob", "bob12634", "bob@gmail.com", "0982623191"));
        DS.add(new User("lacey", "lacey1234", "lacey@gmail.com", "0981468491"));
        DS.add(new User("layla", "layla1234", "layla12@gmail.com", "0982651234"));
        AuthService authService = new AuthService(DS);
        UserService userService = new UserService(DS);
        System.out.println("-----------Menu Auth---------");
        System.out.println("1. Login");
        System.out.println("2. Register");
        System.out.println("3. Exit");
        while(true) {
            System.out.print("Enter choose: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch(choose) {
                case 1:
                    System.out.print("Username: ");
                    String username = sc.nextLine();
                    System.out.print("Password: ");
                    String password = sc.nextLine();
                    if(AuthService.login(username, password))
                        menuUser(userService, authService);
                    break;
                case 2:
                    System.out.print("Username: ");
                    String usernameRegister = sc.nextLine();
                    System.out.print("Password: ");
                    String passwordRegister = sc.nextLine();
                    System.out.print("Email: ");
                    String emailRegister = sc.nextLine();
                    System.out.print("Phone number: ");
                    String phoneNumberRegister = sc.nextLine();
                    AuthService.register(usernameRegister, passwordRegister, emailRegister, phoneNumberRegister);
                    break;
                case 3:
                    return;
                default:
                    System.out.println(Constant.ErrorMessage.INVALID_CHOOSE);
            }
        }
    }
    public static void menuUser(UserService userService, AuthService authService) {
        Scanner sc = new Scanner(System.in);
        System.out.println("-----------Menu User---------");
        System.out.println("1. Get user by id");
        System.out.println("2. Get all user");
        System.out.println("3. Change password");
        System.out.println("4. Logout");
        while(true) {
            System.out.print("Enter choose: ");
            int choose = sc.nextInt();
            sc.nextLine();
            switch(choose) {
                case 1:
                    System.out.print("Id: ");
                    String id = sc.nextLine();
                    UserService.getUserById(id);
                    break;
                case 2:
                    UserService.getAllUsers();
                    break;
                case 3:
                    System.out.print("User id to change password: ");
                    String userId = sc.nextLine();
                    System.out.print("New password: ");
                    String newPassword = sc.nextLine();
                    System.out.print("Confirm password: ");
                    String confirmPassword = sc.nextLine();
                    UserService.changePassword(userId, newPassword, confirmPassword);
                    break;
                case 4:
                    System.out.println(Constant.SucessfulMessage.SUCCESS_LOGOUT);
                    return;
                default:
                    System.out.println(Constant.ErrorMessage.INVALID_CHOOSE);
            }
        }
    }
}