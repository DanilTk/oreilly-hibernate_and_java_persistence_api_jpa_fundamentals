import model.Account;
import model.Budget;
import model.Transaction;
import org.hibernate.Session;
import util.HibernateUtil;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class App {
    public static void main(String[] args) {
        Account account = Account.builder()
                .accountType("Saving")
                .name("Credit Account")
                .initialBalance(BigDecimal.ZERO)
                .currentBalance(BigDecimal.valueOf(10000))
                .openDate(LocalDate.of(2020, 1, 1))
                .closeDate(LocalDate.of(2024, 12, 31))
                .lastUpdatedBy("admin")
                .lastUpdatedDate(LocalDateTime.now())
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .build();

        Transaction transaction = Transaction.builder()
                .title("General")
                .account(account)
                .transactionType("Deposit")
                .amount(BigDecimal.valueOf(500))
                .initialBalance(BigDecimal.valueOf(400))
                .closingBalance(BigDecimal.valueOf(900))
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .lastUpdatedBy("admin")
                .lastUpdatedDate(LocalDateTime.now())
                .build();

        Budget budget = Budget.builder()
                .name("Emergency Fund")
                .goalAmount(BigDecimal.valueOf(10000000))
                .period("Yearly")
                .transactions(List.of(transaction))
                .build();

//        account.setTransactions(List.of(transaction));

        saveObject(budget);
    }

    private static void saveObject(Object obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }
}
