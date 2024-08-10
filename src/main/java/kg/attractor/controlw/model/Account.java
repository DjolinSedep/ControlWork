package kg.attractor.controlw.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
@Builder
@AllArgsConstructor
public class Account {

    private long id;
    private  String currency;
    private BigDecimal balance;
    private User user;
}
