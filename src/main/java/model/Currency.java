package model;

import lombok.*;
import model.keys.CurrencyId;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@IdClass(CurrencyId.class)
@Table(name = "CURRENCY")
public class Currency {
    @Id
    @Column(name = "NAME")
    private String name;

    @Id
    @Column(name = "COUNTRY_NAME")
    private String countryName;

    @Column(name = "SYMBOL")
    private String symbol;
}
