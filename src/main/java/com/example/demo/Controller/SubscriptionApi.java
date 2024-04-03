package com.example.demo.Controller;

import com.example.demo.DbClass.Util;
import com.example.demo.IQuery;
import com.example.demo.Models.Users;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;

@RestController
@RequestMapping("/api/users")
public class SubscriptionApi {



    @GetMapping

    public Users get(@RequestParam Integer id) {
        try {
            Connection conn = Util.getConnection();
            ResultSet rs = conn.createStatement().executeQuery(IQuery.getUsersById(id));


            if (rs.next()) {

                Users users = new Users();
                users.setId(rs.getInt("id"));
                users.setName(rs.getString("name"));
                users.setSurname(rs.getString("surname"));
                users.setEmail(rs.getString("email"));
                users.setNumber(rs.getString("number"));
                users.setPassword(rs.getString("password"));
                users.setAvatar(rs.getString("avatar"));
                users.setBio(rs.getString("bio"));
                users.setTag(rs.getString("tag"));
                users.setDob(rs.getDate("date_of_birth").toLocalDate());
                users.setGender(rs.getString("gender"));
                users.setCountry(rs.getString("country"));
                users.setVisibility(Boolean.valueOf(rs.getString("visibility")));
                users.setFollowers(rs.getInt("followers"));
                users.setFollowees(rs.getInt("followees"));
                users.setActive(Boolean.valueOf(rs.getString("is_active")));
                users.setPro(Boolean.valueOf(rs.getString("is_pro")));
                users.setVerified(Boolean.valueOf(rs.getString("is_verified")));
                users.setLast_login(rs.getDate("last_login").toLocalDate());

                return users;
            } else {
                System.out.println("Not found. Please try again.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
