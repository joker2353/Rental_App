package com.malkinfo.rentalapp;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.paypal.checkout.approve.Approval;
import com.paypal.checkout.approve.OnApprove;
import com.paypal.checkout.createorder.CreateOrder;
import com.paypal.checkout.createorder.CreateOrderActions;
import com.paypal.checkout.createorder.CurrencyCode;
import com.paypal.checkout.createorder.OrderIntent;
import com.paypal.checkout.createorder.UserAction;
import com.paypal.checkout.order.Amount;
import com.paypal.checkout.order.AppContext;
import com.paypal.checkout.order.CaptureOrderResult;
import com.paypal.checkout.order.OnCaptureComplete;
import com.paypal.checkout.order.OrderRequest;
import com.paypal.checkout.order.PurchaseUnit;
import com.paypal.checkout.paymentbutton.PaymentButtonContainer;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

/**
 * The Payment class facilitates the payment process using PayPal Checkout SDK.
 * It allows users to make payments securely using their PayPal account.
 */
public class Payment extends AppCompatActivity {

    private static final String TAG = "PaymentActivity";
    private PaymentButtonContainer paymentButtonContainer;

    /**
     * Initializes the activity, sets up the payment process using PayPal Checkout SDK.
     * This method is called when the activity is first created.
     *
     * @param savedInstanceState A Bundle containing the activity's previously saved state, if any.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        // Initialize payment button container
        paymentButtonContainer = findViewById(R.id.payment_button_container);

        // Set up PayPal payment process
        paymentButtonContainer.setup(
                // Create order action
                new CreateOrder() {
                    @Override
                    public void create(@NotNull CreateOrderActions createOrderActions) {
                        // Create a purchase unit with amount
                        ArrayList<PurchaseUnit> purchaseUnits = new ArrayList<>();
                        purchaseUnits.add(
                                new PurchaseUnit.Builder()
                                        .amount(
                                                new Amount.Builder()
                                                        .currencyCode(CurrencyCode.USD)
                                                        .value("10.00")
                                                        .build()
                                        )
                                        .build()
                        );

                        // Create order request
                        OrderRequest order = new OrderRequest(
                                OrderIntent.CAPTURE,
                                new AppContext.Builder()
                                        .userAction(UserAction.PAY_NOW)
                                        .build(),
                                purchaseUnits
                        );

                        // Create order
                        //createOrderActions.create(order, null);
                    }
                },
                // On approve action
                new OnApprove() {
                    @Override
                    public void onApprove(@NotNull Approval approval) {
                        // Capture the order
                        approval.getOrderActions().capture(new OnCaptureComplete() {
                            @Override
                            public void onCaptureComplete(@NotNull CaptureOrderResult result) {
                                // Handle successful payment
                                Log.d(TAG, String.format("CaptureOrderResult: %s", result));
                                Toast.makeText(Payment.this, "Payment Successful", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
        );
    }

    /**
     * Overrides the back button behavior to finish the activity when pressed.
     */
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
