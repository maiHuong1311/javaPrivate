package service;
import java.util.ArrayList;
import model.User;
import constant.Constant;
public class AuthService {
    static ArrayList<User> DS;
    public AuthService() {
        DS = new ArrayList<>();
    }
    public AuthService(ArrayList<User> DS) {
        this.DS = DS;
    }
    public static boolean login(String username, String password) {
        for(User x : DS) {
            if(x.getUsername().equals(username) && x.getPassword().equals(password)) {
                System.out.println(Constant.SucessfulMessage.SUCCESS_LOGIN);
                return true;
            }
        }
        System.out.println(Constant.ErrorMessage.ERROR_LOGIN);
        return false;
    }
    public static void register(String username, String password, String email, String phoneNumber) {
        if(!checkUsername(username)) {
            System.out.println(Constant.ErrorMessage.USERNAME_EXISTED);
            return;
        }
        if(!checkPassword(password)) {
            System.out.println(Constant.ErrorMessage.INVALID_PASSWORD);
            return;
        }
        if(!checkEmail(email)) {
            return;
        }
        if(!checkPhoneNumber(phoneNumber)) {
            return;
        }
        DS.add(new User(username, password, email, phoneNumber));
        System.out.println(Constant.SucessfulMessage.SUCCESS_REGISTER);
    }
    public static boolean checkUsername(String username) {
        for(User x : DS) {
            if(x.getUsername().equals(username)) {
                return false;
            }
        }
        return true;
    }
    public static boolean checkPassword(String password) {
        if(password.length() < 8)
            return false;
        return true;
    }
    public static boolean checkEmail(String email) {
        if(!email.contains("@gmail.com")) {
            System.out.println(Constant.ErrorMessage.INVALID_EMAIL_FORMAT);
            return false;
        }
        for(User x : DS) {
            if(x.getEmail().equals(email)) {
                System.out.println(Constant.ErrorMessage.EMAIL_EXISTED);
                return false;
            }
        }
        return true;
    }
    public static boolean checkPhoneNumber(String phoneNumber) {
        if(phoneNumber.charAt(0) != '0' || phoneNumber.length() > 10 || phoneNumber.length() < 10) {
            System.out.println(Constant.ErrorMessage.INVALID_PHONE_NUMBER);
            return false;
        }
        for(int i = 1; i < phoneNumber.length(); i++) {
            if(phoneNumber.charAt(i) < '0' || phoneNumber.charAt(i) > '9') {
                System.out.println(Constant.ErrorMessage.INVALID_PHONE_NUMBER);
                return false;
            }
        }
        for(User x : DS) {
            if(x.getPhoneNumber().equals(phoneNumber)) {
                System.out.println(Constant.ErrorMessage.PHONE_NUMBER_EXISTED);
                return false;
            }
        }
        return true;
    }
}
