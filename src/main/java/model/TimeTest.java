package model;

import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.ZoneId;

@Entity
@ToString
@Table(name = "time_test")
@NoArgsConstructor
public class TimeTest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIME_TEST_ID")
    private Long timeTestId;

    @Column(name = "DATETIME_COLUMN")
    private java.util.Date datetimeColumn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "TIMESTAMP_COLUMN")
    private java.util.Date timestampColumn;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_COLUMN")
    private java.util.Date dateColumn;

    @Temporal(TemporalType.TIME)
    @Column(name = "TIME_COLUMN")
    private java.util.Date timeColumn;

    @Column(name = "SQL_DATETIME_COLUMN")
    private java.sql.Timestamp sqlDatetimeColumn;

    @Column(name = "SQL_TIMESTAMP_COLUMN")
    private java.sql.Timestamp sqlTimestampColumn;

    @Column(name = "SQL_DATE_COLUMN")
    private java.sql.Date sqlDateColumn;

    @Column(name = "SQL_TIME_COLUMN")
    private Time sqlTimeColumn;

    @Column(name = "LOCAL_DATETIME_COLUMN")
    private LocalDateTime localDatetimeColumn;

    public TimeTest(java.util.Date date) {
        this.datetimeColumn = date;
        this.timestampColumn = date;
        this.timeColumn = date;
        this.dateColumn = date;

        this.sqlDatetimeColumn = new Timestamp(date.getTime());
        this.sqlTimestampColumn = new Timestamp(date.getTime());
        this.sqlDateColumn = new Date(date.getTime());
        this.sqlTimeColumn = new Time(date.getTime());

        this.localDatetimeColumn = date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDateTime();
    }
}