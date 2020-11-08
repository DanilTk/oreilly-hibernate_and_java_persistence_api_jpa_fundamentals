import model.*;
import org.hibernate.Session;
import util.HibernateUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {


    }

    private static void saveObject(Object obj) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(obj);
            session.getTransaction().commit();
        }
    }

    private static Market createMarket(Currency currency) {
        return Market.builder()
                .marketName("NASDAQ")
                .currency(currency)
                .build();
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
                .zipCode("000")
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

    private static Bank createBank(String bankName) {
        return Bank.builder()
                .name(bankName)
                .address(createAddress())
                .addressType("Headquarter")
                .isInternational(true)
                .contacts(Map.of("Dan", "Tk"))
                .createdBy("admin")
                .createdDate(LocalDate.now())
                .lastUpdatedBy("admin")
                .lastUpdatedDate(LocalDateTime.now())
                .build();
    }

    private static Transaction createNewBeltPurchase(Account account) {
        return Transaction.builder()
                .account(account)
                .title("Dress Belt")
                .amount(new BigDecimal("50.00"))
                .closingBalance(new BigDecimal("0.00"))
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .initialBalance(new BigDecimal("0.00"))
                .lastUpdatedBy("admin")
                .lastUpdatedDate(LocalDateTime.now())
                .notes("New Dress Belt")
                .transactionType("Debit")
                .build();
    }

    private static Transaction createShoePurchase(Account account) {
        return Transaction.builder()
                .account(account)
                .title("Work Shoes")
                .amount(new BigDecimal("100.00"))
                .closingBalance(new BigDecimal("0.00"))
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .initialBalance(new BigDecimal("0.00"))
                .lastUpdatedBy("admin")
                .lastUpdatedDate(LocalDateTime.now())
                .notes("Nice Pair of Shoes")
                .transactionType("Debit")
                .build();
    }
}
