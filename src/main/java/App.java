import model.*;
import org.hibernate.Session;
import util.HibernateUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
    }

    private static Budget createBudget() {
        return Budget.builder()
                .name("Emergency Fund")
                .goalAmount(BigDecimal.valueOf(10000000))
                .period("Yearly")
                .transactions(List.of(createTransaction()))
                .build();
    }

    private static Transaction createTransaction() {
        return Transaction.builder()
                .title("General")
                .account(createAccount("Savings account"))
                .transactionType("Deposit")
                .amount(BigDecimal.valueOf(500))
                .initialBalance(BigDecimal.valueOf(400))
                .closingBalance(BigDecimal.valueOf(900))
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .lastUpdatedBy("admin")
                .lastUpdatedDate(LocalDateTime.now())
                .build();
    }

    private static void saveObject(Object obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }

    private static User createUser(String name, String surname) {
        return User.builder()
                .firstName(name)
                .lastName(surname)
                .birthDate(LocalDate.of(1992, 9, 7))
                .emailAddress("dan.tk@gmail.com")
                .addresses(List.of(createAddress()))
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .lastUpdatedBy("admin")
                .lastUpdatedDate(LocalDateTime.now())
                .build();
    }

    private static Address createAddress() {
        return Address.builder()
                .addressLine1("Chmielna 104")
                .addressLine2("")
                .city("Warsaw")
                .state("")
                .zipCode("00-801")
                .build();
    }

    private static Account createAccount(String accountName) {
        return Account.builder()
                .accountType("Saving")
                .name(accountName)
                .initialBalance(BigDecimal.ZERO)
                .currentBalance(BigDecimal.valueOf(10000))
                .openDate(LocalDate.now())
                .closeDate(LocalDate.of(2024, 12, 31))
                .lastUpdatedBy("admin")
                .lastUpdatedDate(LocalDateTime.now())
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .build();
    }

    private static Credential createCredential(User user) {
        return Credential.builder()
                .user(user)
                .username(user.getEmailAddress())
                .password("querty")
                .build();
    }
}
