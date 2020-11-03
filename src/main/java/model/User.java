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

    @Embedded
    @AttributeOverrides({@AttributeOverride(name = "addressLine1", column = @Column(name = "USER_ADDRESS_LINE_1")),
            @AttributeOverride(name = "addressLine2", column = @Column(name = "USER_ADDRESS_LINE_2"))})
    Address address;

    @Formula("LOWER(DATEDIFF(CURDATE(), BIRTH_DATE)/365)")
    int age;
}
