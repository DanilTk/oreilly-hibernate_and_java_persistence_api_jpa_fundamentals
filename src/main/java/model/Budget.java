package model;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "BUDGET")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BUDGET_ID")
    private Long budgetId;

    @Column(name = "NAME")
    private String name;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "BUDGET_TRANSACTION", joinColumns = @JoinColumn(name = "BUDGET_ID"),
            inverseJoinColumns = @JoinColumn(name = "TRANSACTION_ID"))
    private List<Transaction> transactions;

    @Column(name = "GOAL_AMOUNT")
    private BigDecimal goalAmount;

    @Column(name = "PERIOD")
    private String period;

}
