//

package com.example.user_mgmt;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Address {
    @Column(name = "Flat_No")
    private int flat_no;
    @Column(name = "City")
    private String city;
    @Column(name = "County")
    private String county;
    @Column(name = "District")
    private String district;
    @Column(name = "Country")
    private String country;
}
