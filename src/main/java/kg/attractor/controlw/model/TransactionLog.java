package kg.attractor.controlw.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class TransactionLog {
    private Long id;
    private Transaction transaction;
    private String action;
}
