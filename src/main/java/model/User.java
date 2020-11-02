package model;

import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "FINANCES_USER")
@Access(AccessType.FIELD)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "BIRTH_DATE", nullable = false)
    private LocalDate birthDate;

    @Column(name = "EMAIL_ADDRESS")
    private String emailAddress;

    @Column(name = "LAST_UPDATED_BY")
    private String lastUpdatedBy;

    @Column(name = "LAST_UPDATED_DATE")
    private LocalDateTime lastUpdatedDate;

    @Column(name = "CREATED_BY")
    private String createdBy;

    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDate;

    @Column(name = "USER_ADDRESS_LINE_1")
    private String userAddressLine1;

    @Column(name = "USER_ADDRESS_LINE_2")
    private String userAddressLine2;

    @Column(name = "CITY")
    private String city;

    @Column(name = "STATE")
    private String state;

    @Column(name = "ZIP_CODE")
    private String zipCode;

    @Formula("LOWER(DATEDIFF(CURDATE(), BIRTH_DATE)/365)")
    int age;
}
