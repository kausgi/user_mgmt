//

package com.example.user_mgmt;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "user_details")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String username;
    private String name;
    private int age;
    @Embedded
    private Address address;
    private String phone;
    @Embedded
    private Laptop laptop;
    private double salary;
}
