package kg.attractor.controlw.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Transaction {
    private Long id;
    private BigDecimal amount;
    private Account fromAccount;
    private LocalDateTime createdAt;
    private Account toAccount;
    private String currency;
    private String status;
    private Boolean isApproved ;



}
