package kg.attractor.controlw.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class RegisterDto {
    @NotBlank
    @Pattern(regexp = "^996 \\(\\d{3}\\) \\d{2}-\\d{2}-\\d{2}$", message = "Номер телефона должен быть в формате 996 (XXX) XX-XX-XX")
    private String phoneNumber;


    @NotBlank
    private String username;

    @NotBlank
    private String password;


}
