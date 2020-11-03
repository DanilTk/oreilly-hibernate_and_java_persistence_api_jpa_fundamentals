package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "bank")
public class Bank {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BANK_ID")
    private Long bankId;

    @Column(name = "NAME")
    private String name;

    @Embedded
    private Address address;

    @Column(name = "IS_INTERNATIONAL")
    private boolean isInternational;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name = "LAST_UPDATED_DATE")
    private LocalDate lastUpdatedDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private LocalDate createdDate;

    @Column(name = "ADDRESS_TYPE")
    private String addressType;

    @ElementCollection
    @CollectionTable(name = "BANK_CONTACT", joinColumns = @JoinColumn(name = "BANK_ID"))
    @Column(name = "NAME")
    private List<String> contacts;
}
