package com.puffinpowered.coursemanager.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
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
 * @Todo the Jackson annotations are to make the output pretty for human readers and we will need to adjust for machine to machine communications
 *
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
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

    @JsonGetter("datePurchased")
    public String formatDate(){
        return datePurchased.getDayOfMonth()+"/"+datePurchased.getMonthValue()+"/"+datePurchased.getYear();
    }

    @JsonGetter("purchasePrice")
    public String formatPrice() {
        return displayCurrency(this.purchasePrice);
    }

    public Course() {
    }

    public String displayCurrency(BigDecimal amount){
        Locale locale = new Locale("en_UK","AU");
        Currency currentCurrency = Currency.getInstance(locale);
        NumberFormat currencyFormatter =
                NumberFormat.getCurrencyInstance(locale);

//        return currencyFormatter.format(amount);
        return currentCurrency.getCurrencyCode()+" $"+amount;
    }


}
