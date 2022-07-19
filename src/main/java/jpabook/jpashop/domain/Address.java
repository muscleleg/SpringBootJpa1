package jpabook.jpashop.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable //어딘가에 내장이 될 수 있따.
@Getter
public class Address {
    private String city;
    private String street;
    private String zipcode;

    protected Address() { //동일패키지와 자식만 쓸 수 있음
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }
}
