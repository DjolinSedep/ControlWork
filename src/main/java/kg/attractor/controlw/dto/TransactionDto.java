package kg.attractor.controlw.dto;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Data
@Builder
public class TransactionDto {
    private Long id;
    private Long AccountId;
    private Long toAccountId;
    private BigDecimal amount;
    private String currency;
    private String status;
    private boolean isApproved;
    private LocalDateTime createdAt;



}
