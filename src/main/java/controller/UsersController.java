package controller;

import model.User;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsersController {

    List<User> users = new ArrayList<User>();

    public UsersController() {
        build();
    }

    public void build() {

        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/java/data/user.txt"));
            String s;
            while ((s = br.readLine()) != null) {
                String[] userData = s.split(" ");
                users.add(new User(userData[0], userData[1], userData[2]));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public boolean isUser(User user) {
        return users.contains(user);
    }

    public User getUserByNameAndPassword(String name, String password) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(name) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
}
