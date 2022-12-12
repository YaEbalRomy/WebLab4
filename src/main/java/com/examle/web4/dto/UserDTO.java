package com.examle.web4.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@AllArgsConstructor
public class UserDTO {

    @NotBlank
    @Length(min = 6, max = 20)
    private String username;

    @NotBlank
    @Length(min = 6, max = 20)
    private String password;
}
