package com.example.demo;

public interface IQuery {
    static String getUsersById(int id){
        return "select * from users where id = '" + id + "';";
    }
}
