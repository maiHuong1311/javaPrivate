package service;

import model.User;
import constant.Constant;
import java.util.ArrayList;

public class UserService {
    static ArrayList<User> DS;

    public UserService() {
        this.DS = new ArrayList<>();
    }
    public UserService(ArrayList<User> DS) {
        this.DS = DS;
    }
    public static void getUserById(String userId) {
        boolean found = false;
        for(User x : DS) {
            if(x.getId().equals(userId)) {
                System.out.println("User's information");
                System.out.println(x.toString());
                found = true;
                break;
            }
        }
        if(!found)
            System.out.println(Constant.ErrorMessage.USER_NOT_EXIST);
    }
    public static void getAllUsers() {
        System.out.println("All User's Information");
        for(User x : DS) {
            System.out.println(x.toString());
        }
    }
    public static void changePassword(String id, String newPassword, String confirmNewPassWord) {
        boolean found = false;
        if(newPassword.length() < 8) {
            System.out.println(Constant.ErrorMessage.INVALID_PASSWORD);
            return;
        }
        if(!newPassword.equals(confirmNewPassWord)) {
            System.out.println(Constant.ErrorMessage.INCORRECT_CONFIRM_PASSWORD);
            return;
        }
        for(User x : DS) {
            if(x.getId().equals(id)) {
                x.setPassword(newPassword);
                System.out.println(Constant.SucessfulMessage.SUCCESS_CHANGE_PASSWORD);
                found = true;
                break;
            }
        }
        if(!found)
            System.out.println(Constant.ErrorMessage.USER_NOT_EXIST);
    }
}
