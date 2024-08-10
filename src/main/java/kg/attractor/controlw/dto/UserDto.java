package kg.attractor.controlw.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;

    @NotBlank
    @Size(min = 5, max = 50)
    private String username;
    @NotBlank
    @Size(min = 5, max = 100)
    private String password;
    @Email
    @NotBlank
    private String email;
}
