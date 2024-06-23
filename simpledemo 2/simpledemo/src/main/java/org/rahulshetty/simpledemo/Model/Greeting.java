package org.rahulshetty.simpledemo.Model;


import lombok.*;

import org.springframework.stereotype.Component;


@Component
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
public class Greeting {
    private String Context;
    private long Id;
    private int guestNum;
}
