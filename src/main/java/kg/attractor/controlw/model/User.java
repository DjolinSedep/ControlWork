package kg.attractor.controlw.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String password;
    private String email;
    private Boolean enabled;
}
