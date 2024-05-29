package com.Wiley.mytodoApp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NegativeOrZero;
import jakarta.validation.constraints.NotBlank;

public record UserDto(int userID, @NotBlank(message = "FirstName cannot be blank") String firstname,
                      @NotBlank(message = "LastName cannot be blank") String lastname,
                      @Email(message = "Invalid email") String email,
                      @NegativeOrZero(message = "cannot be negative") @NotBlank(message = "Phone number cannot be blank") String contact) {
}
