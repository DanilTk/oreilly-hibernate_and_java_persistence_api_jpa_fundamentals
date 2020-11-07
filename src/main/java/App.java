import model.*;
import org.hibernate.Session;
import util.HibernateUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        Account account1 = createAccount("Investment");
        Account account2 = createAccount("Spending");

        User user1 = createUser("Rob", "Wk");
        User user2 = createUser("John", "Snow");

        account1.setUsers(Set.of(user1, user2));
        account2.setUsers(Set.of(user1, user2));
        user1.setAccounts(Set.of(account1, account2));
        user2.setAccounts(Set.of(account1, account2));

        saveObject(account1);
        saveObject(account2);
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
        User user = new User();
        return user.builder()
                .firstName(name)
                .lastName(surname)
                .birthDate(LocalDate.of(1992, 9, 7))
                .emailAddress("dan.tk@gmail.com")
                .addresses(List.of(createAddress()))
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .lastUpdatedBy("admin")
                .lastUpdatedDate(LocalDateTime.now())
                .credential(createCredential(user))
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
