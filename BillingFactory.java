package za.ac.cput.carservice.factory;


import za.ac.cput.carservice.domain.Billing;
import za.ac.cput.carservice.domain.ServiceOrder;

import java.time.LocalDate;

public class BillingFactory {
    public BillingFactory () {}

    public static Billing createBilling (ServiceOrder serviceOrder,
                                         Double amount,
    String paymentStatus,
    LocalDate paymentDate)

    {if (serviceOrder == null) {
        throw new IllegalArgumentException("ServiceOrder is required");
    }
        if (amount == null || amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than 0");
        }
        if (paymentStatus == null || paymentStatus.isEmpty()) {
            throw new IllegalArgumentException("Payment status is required");
        }
        if (paymentDate == null) {
            throw new IllegalArgumentException("Payment date is required");
        }

        return new Billing.Builder()
                .setServiceOrder(serviceOrder)
                .setAmount(amount)
                .setPaymentStatus(paymentStatus)
                .setPaymentDate(paymentDate)
                .build();
    }

    }

