package com.example.Siddharth;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Component
public class userRepo {
    //hashmap or function that interact with DB write here

    //here hashmap is our database
    HashMap<Integer, User> users=new HashMap<>();

    //functions list with thier implementation
    //1. Function to get user List

    List<User> getListOfuserFromBD(){
          List<User> listOfUsers=new ArrayList<>();
          for(User users: users.values()){
              listOfUsers.add(users);
          }
          return listOfUsers;
    }
    void addUserInDB(User user){
            users.put(user.getId(),user);
    }

}
