package com.example.demo.Model;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Customer {
    private String id;
    private String name;
    private String phone;
    private String email;

}
