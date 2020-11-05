package model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "TRANSACTION")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRANSACTION_ID")
    private Long transactionId;

    @Column(name = "TRANSACTION_TYPE")
    private String transactionType;

    @ManyToOne
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AMOUNT")
    private BigDecimal amount;

    @Column(name = "INITIAL_BALANCE")
    private BigDecimal initialBalance;

    @Column(name = "CLOSING_BALANCE")
    private BigDecimal closingBalance;

    @Column(name = "NOTES")
    private String notes;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name = "LAST_UPDATED_DATE")
    private LocalDateTime lastUpdatedDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;
}
