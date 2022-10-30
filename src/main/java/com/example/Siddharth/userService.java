package com.example.Siddharth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// to denote it is service layer // business logic // to get multiple service function
public class userService {
    @Autowired
    userRepo userrepo;
    List<User> getAllUser(){
        return userrepo.getListOfuserFromBD();
    }

    void addUserByBody(User user){
        userrepo.addUserInDB(user);
    }
}
