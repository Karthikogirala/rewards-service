package com.retail.rewards.web.factory;

import com.retail.rewards.web.model.MonthlyPoints;
import com.retail.rewards.web.model.Rewards;
import com.retail.rewards.web.model.Transaction;
import lombok.experimental.UtilityClass;

import java.time.LocalDate;
import java.util.List;

@UtilityClass
public class TestData {

    public Rewards getRewards() {
        return new Rewards("benjaminbrooks", 124, List.of(getMonthlyPoints()));
    }

    public MonthlyPoints getMonthlyPoints() {
        return new MonthlyPoints("February 2024", 124);
    }

    public Transaction getTransaction() {
        final Transaction transaction = new Transaction();
        transaction.setCustomerId("benjaminbrooks");
        transaction.setAmount(137.45);
        transaction.setDate(LocalDate.of(2024, 2, 2));
        return transaction;
    }

}
