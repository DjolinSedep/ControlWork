package kg.attractor.controlw.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class TransactionDto {

    private Long accountId;
    private BigDecimal amount;
    private Integer fromAccountId;
    private Long toAccountId;
}
