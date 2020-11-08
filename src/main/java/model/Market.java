package model;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "market")
public class Market {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MARKET_ID")
    private Long marketId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumns({@JoinColumn(name = "CURRENCY_NAME", referencedColumnName = "NAME"),
            @JoinColumn(name = "COUNTRY_NAME", referencedColumnName = "COUNTRY_NAME")})
    private Currency currency;

    @Column(name = "MARKET_NAME")
    private String marketName;
}
