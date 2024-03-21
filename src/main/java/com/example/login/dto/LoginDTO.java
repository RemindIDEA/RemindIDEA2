package com.example.login.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDTO {
    private String id;
    private String pw;
    private String username;
    private String email;
}
