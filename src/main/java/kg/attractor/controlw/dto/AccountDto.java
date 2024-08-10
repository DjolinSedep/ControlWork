package kg.attractor.controlw.dto;

import kg.attractor.controlw.model.User;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class AccountDto {
    private long id;
    private  String currency;
    private BigDecimal balance;
    private User user;
    private Long userId;
}
