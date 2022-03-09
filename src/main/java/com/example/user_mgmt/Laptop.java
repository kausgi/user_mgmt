//

package com.example.user_mgmt;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Laptop {
    @Column(name = "Model_No")
    private int lid;
    @Column(name = "Model_Name")
    private String lname;
    @Column(name = "Model_price")
    private double price;
}
