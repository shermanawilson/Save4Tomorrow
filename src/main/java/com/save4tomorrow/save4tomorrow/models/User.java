package com.save4tomorrow.save4tomorrow.models;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, length = 100)
    @Getter
    @Setter
    private String firstName;

    @Column(nullable = false, length = 150)
    @Getter
    @Setter
    private String lastName;

    @Column(nullable = false, length = 175)
    @Getter
    @Setter
    private String email;

    @Column(nullable = false, length = 100)
    @Getter
    @Setter
    private String username;

    @Column(nullable = false, length = 100)
    @Getter
    @Setter
    private String password;

    public User(User copy){

        id = copy.id;
        firstName = copy.firstName;
        lastName = copy.lastName;
        email = copy.email;
        username = copy.username;
        password = copy.password;

    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
