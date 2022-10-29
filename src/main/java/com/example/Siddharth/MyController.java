package com.example.Siddharth;

import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController //Annotations-->In this class I'll write API's
public class MyController {
    // for DB purpose creating hashmap<Integer with ID,Object of user>
    HashMap<Integer, User> hmUser=new HashMap<>();
    // http://localhost:8080/get_users
    @GetMapping("/get_users")
    public List<User> getAllUser(){
        //server side logic
        List<User> listOfUser=new ArrayList<>();
        //iterating using for loop
        for(Map.Entry<Integer, User> entry: hmUser.entrySet()){
            listOfUser.add(entry.getValue());
        }
        return listOfUser;
    }
    //http://localhost:8080/get_user?id=10
    @GetMapping("/get_user")// with id
    public  User getUser(@RequestParam("id")int id){
        return hmUser.get(id);
    }
   //http://localhost:8080/add_user?id=10&name=sid&country=India&age=20
    @PostMapping("/add_user")
    public void addUser(@RequestParam("id")int id,
                        @RequestParam("name")String name,
                        @RequestParam("country") String country,
                        @RequestParam("age")int age){
        User user=new User(id, name, country, age);
        hmUser.put(id,user);
    }

    @PostMapping("/add_user_body")
    public void addUser(@RequestBody(required=true)User user){
        hmUser.put(user.getId(),user);
    }

    @PutMapping("/modify_user")
    public void modifyUser(@RequestBody(required=true) User user){
        hmUser.put(user.getId(),user);
    }

    @DeleteMapping("/delete_user")
    public void deleteUser(@RequestParam("id")int id){
        hmUser.remove(id);
    }
    @DeleteMapping("/delete_user/{id}")
    public void deleteUserWithPathVariable(@PathVariable("id")int id){
        hmUser.remove(id);
    }
    //pathvariable //not @PathParam
}
