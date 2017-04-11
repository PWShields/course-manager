package com.puffinpowered.coursemanager.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.util.Currency;
import java.util.Locale;

/**
 * Created by pshields on 7/04/2017.
 *
 */
@Data
@Entity
public class Course {
    private @Id
    @GeneratedValue
    Long id;

    private String courseName;

    @ManyToOne
    private Provider provider;

    private LocalDate datePurchased;

    private LocalDate  dateStarted;

    private LocalDate dateCompleted;

    private CourseStatus status;

    private BigDecimal purchasePrice;


    public Course(String courseName, Provider provider) {
        this.courseName = courseName;
        this.provider = provider;
    }



    public Course() {
    }
    public String displayCurrency(BigDecimal amount){
        Locale locale = new Locale("en_UK","AU");
        Currency currentCurrency = Currency.getInstance(locale);
        NumberFormat currencyFormatter =
                NumberFormat.getCurrencyInstance(locale);
        return currencyFormatter.format(amount);
    }


}
