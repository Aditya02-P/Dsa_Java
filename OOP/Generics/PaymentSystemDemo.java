/**
 * PART 1: BAD DESIGN - WITHOUT INTERFACES AND ABSTRACT CLASSES
 * This demonstrates the problems that arise without proper abstraction
 */
//package com.example.bad;
package Generics;
// Concrete payment processors without any abstraction
class PayPalProcessor {
    public void processPayPalPayment(double amount, String email) {
        System.out.println("Processing PayPal payment of $" + amount + " for " + email);
        // PayPal-specific logic
    }

    public boolean verifyPayPalAccount(String email) {
        return email != null && email.contains("@");
    }
}

class StripeProcessor {
    public void executeStripeTransaction(double amount, String cardToken) {
        System.out.println("Executing Stripe transaction of $" + amount + " with token " + cardToken);
        // Stripe-specific logic
    }

    public boolean validateStripeToken(String token) {
        return token != null && token.length() > 10;
    }
}

class CryptoProcessor {
    public void sendCryptoPayment(double amount, String walletAddress) {
        System.out.println("Sending crypto payment of $" + amount + " to " + walletAddress);
        // Crypto-specific logic
    }

    public boolean checkWalletAddress(String address) {
        return address != null && address.startsWith("0x");
    }
}

/**
 * Problem 1: Tight Coupling
 * The OrderService is tightly coupled to specific implementations
 */
class BadOrderService {
    private PayPalProcessor payPalProcessor;
    private StripeProcessor stripeProcessor;
    private CryptoProcessor cryptoProcessor;

    public BadOrderService() {
        this.payPalProcessor = new PayPalProcessor();
        this.stripeProcessor = new StripeProcessor();
        this.cryptoProcessor = new CryptoProcessor();
    }

    /**
     * Problem 2: Code Duplication and No Polymorphism
     * We need different methods for each payment type
     */
    public void processOrderWithPayPal(double amount, String email) {
        if (payPalProcessor.verifyPayPalAccount(email)) {
            payPalProcessor.processPayPalPayment(amount, email);
        }
    }

    public void processOrderWithStripe(double amount, String token) {
        if (stripeProcessor.validateStripeToken(token)) {
            stripeProcessor.executeStripeTransaction(amount, token);
        }
    }

    public void processOrderWithCrypto(double amount, String wallet) {
        if (cryptoProcessor.checkWalletAddress(wallet)) {
            cryptoProcessor.sendCryptoPayment(amount, wallet);
        }
    }

    /**
     * Problem 3: Open/Closed Principle Violation
     * Adding a new payment method requires modifying this class
     */
}

/**
 * Problem 4: Testing Nightmare
 * Cannot easily mock or test in isolation
 */
class BadOrderServiceTest {
    public void testOrderProcessing() {
        // Cannot inject mock processors - tightly coupled to real implementations
        BadOrderService service = new BadOrderService();
        // Tests will always use real PayPal, Stripe, Crypto processors
    }
}

// ====================================================================================
// PART 2: GOOD DESIGN - WITH INTERFACES AND ABSTRACT CLASSES
// ====================================================================================

/**
 * INTERFACE: Defines the contract for payment processing
 * Benefit: Allows for polymorphism and loose coupling
 */
interface PaymentProcessor {
    /**
     * Process a payment
     * @param amount The amount to process
     * @param paymentDetails Payment-specific details (email, token, wallet, etc.)
     * @return true if payment was successful
     */
    boolean processPayment(double amount, String paymentDetails);

    /**
     * Validate payment details before processing
     */
    boolean validatePaymentDetails(String paymentDetails);

    /**
     * Get the payment method name
     */
    String getPaymentMethodName();

    /**
     * Get transaction fee percentage
     */
    double getTransactionFee();
}

/**
 * ABSTRACT CLASS: Provides common functionality for all payment processors
 * Benefit: Code reuse, enforces structure, can have state and concrete methods
 *
 * Use Abstract Class when:
 * 1. You want to share code among several closely related classes
 * 2. You expect classes that extend it to have many common methods or fields
 * 3. You want to declare non-static or non-final fields
 */
abstract class BasePaymentProcessor implements PaymentProcessor {
    protected String processorName;
    protected boolean isEnabled;
    protected int maxRetries;

    public BasePaymentProcessor(String processorName) {
        this.processorName = processorName;
        this.isEnabled = true;
        this.maxRetries = 3;
    }

    /**
     * Template Method Pattern - defines the skeleton of payment processing
     * This is the power of abstract classes - common algorithm with customizable steps
     */
    @Override
    public boolean processPayment(double amount, String paymentDetails) {
        if (!isEnabled) {
            System.out.println(processorName + " is currently disabled");
            return false;
        }

        // Common validation logic
        if (amount <= 0) {
            System.out.println("Invalid amount: " + amount);
            return false;
        }

        // Delegate to subclass for specific validation
        if (!validatePaymentDetails(paymentDetails)) {
            System.out.println("Invalid payment details for " + processorName);
            return false;
        }

        // Common retry logic (code reuse!)
        for (int attempt = 1; attempt <= maxRetries; attempt++) {
            try {
                System.out.println("Attempt " + attempt + " for " + processorName);

                // Delegate to subclass for actual processing
                executePayment(amount, paymentDetails);

                // Common post-processing
                logTransaction(amount, paymentDetails);
                sendConfirmationEmail(paymentDetails);

                return true;
            } catch (Exception e) {
                System.out.println("Attempt " + attempt + " failed: " + e.getMessage());
                if (attempt == maxRetries) {
                    System.out.println("All retry attempts exhausted");
                    return false;
                }
            }
        }
        return false;
    }

    /**
     * Abstract method - forces subclasses to implement their specific logic
     */
    protected abstract void executePayment(double amount, String paymentDetails) throws Exception;

    /**
     * Common functionality shared by all processors
     */
    protected void logTransaction(double amount, String details) {
        System.out.println("[LOG] " + processorName + ": $" + amount + " - " + details);
    }

    protected void sendConfirmationEmail(String details) {
        System.out.println("[EMAIL] Confirmation sent for " + processorName);
    }

    @Override
    public String getPaymentMethodName() {
        return processorName;
    }

    public void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }
}

/**
 * Concrete implementation for PayPal
 */
class PayPalPaymentProcessor extends BasePaymentProcessor {
    private static final double PAYPAL_FEE = 0.029; // 2.9%

    public PayPalPaymentProcessor() {
        super("PayPal");
    }

    @Override
    protected void executePayment(double amount, String email) throws Exception {
        // PayPal-specific implementation
        System.out.println("→ Processing PayPal payment of $" + amount + " for " + email);
        // Simulate API call to PayPal
        if (Math.random() > 0.9) { // 10% failure rate for demo
            throw new Exception("PayPal API error");
        }
    }

    @Override
    public boolean validatePaymentDetails(String email) {
        return email != null && email.contains("@") && email.contains(".");
    }

    @Override
    public double getTransactionFee() {
        return PAYPAL_FEE;
    }
}

/**
 * Concrete implementation for Stripe
 */
class StripePaymentProcessor extends BasePaymentProcessor {
    private static final double STRIPE_FEE = 0.029 + 0.30; // 2.9% + $0.30

    public StripePaymentProcessor() {
        super("Stripe");
    }

    @Override
    protected void executePayment(double amount, String cardToken) throws Exception {
        System.out.println("→ Executing Stripe charge of $" + amount + " with token " + cardToken);
        // Simulate API call to Stripe
        if (Math.random() > 0.9) {
            throw new Exception("Stripe API error");
        }
    }

    @Override
    public boolean validatePaymentDetails(String token) {
        return token != null && token.startsWith("tok_") && token.length() > 10;
    }

    @Override
    public double getTransactionFee() {
        return STRIPE_FEE;
    }
}

/**
 * Concrete implementation for Cryptocurrency
 */
class CryptoPaymentProcessor extends BasePaymentProcessor {
    private static final double CRYPTO_FEE = 0.01; // 1%

    public CryptoPaymentProcessor() {
        super("Cryptocurrency");
    }

    @Override
    protected void executePayment(double amount, String walletAddress) throws Exception {
        System.out.println("→ Sending crypto payment of $" + amount + " to " + walletAddress);
        // Simulate blockchain transaction
        if (Math.random() > 0.9) {
            throw new Exception("Blockchain network congestion");
        }
    }

    @Override
    public boolean validatePaymentDetails(String walletAddress) {
        return walletAddress != null &&
                (walletAddress.startsWith("0x") || walletAddress.startsWith("bc1"));
    }

    @Override
    public double getTransactionFee() {
        return CRYPTO_FEE;
    }
}

/**
 * NEW: Adding a new payment method is EASY!
 * Just implement the interface or extend the abstract class
 * No need to modify existing code (Open/Closed Principle)
 */
class ApplePayProcessor extends BasePaymentProcessor {
    private static final double APPLE_PAY_FEE = 0.025; // 2.5%

    public ApplePayProcessor() {
        super("Apple Pay");
    }

    @Override
    protected void executePayment(double amount, String deviceToken) throws Exception {
        System.out.println("→ Processing Apple Pay payment of $" + amount);
        if (Math.random() > 0.9) {
            throw new Exception("Apple Pay service unavailable");
        }
    }

    @Override
    public boolean validatePaymentDetails(String deviceToken) {
        return deviceToken != null && deviceToken.startsWith("device_");
    }

    @Override
    public double getTransactionFee() {
        return APPLE_PAY_FEE;
    }
}

/**
 * BENEFIT 1: POLYMORPHISM & LOOSE COUPLING
 * OrderService depends on the interface, not concrete implementations
 * This is "Dependency Inversion Principle" - depend on abstractions, not concretions
 */
class GoodOrderService {
    private PaymentProcessor paymentProcessor;

    /**
     * Dependency Injection via Constructor
     * We can inject ANY payment processor that implements the interface
     */
    public GoodOrderService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    /**
     * SINGLE METHOD handles all payment types!
     * Compare this to BadOrderService which needed separate methods
     */
    public boolean processOrder(double amount, String paymentDetails) {
        System.out.println("\n=== Processing Order ===");
        System.out.println("Payment Method: " + paymentProcessor.getPaymentMethodName());
        System.out.println("Amount: $" + amount);

        double fee = paymentProcessor.getTransactionFee();
        double totalCharge = amount + (amount * fee);
        System.out.println("Transaction Fee: $" + (amount * fee));
        System.out.println("Total Charge: $" + totalCharge);

        // Polymorphism in action - the actual implementation is determined at runtime
        boolean success = paymentProcessor.processPayment(amount, paymentDetails);

        if (success) {
            System.out.println("✓ Order completed successfully!");
        } else {
            System.out.println("✗ Order failed!");
        }

        return success;
    }

    /**
     * BENEFIT 2: RUNTIME FLEXIBILITY
     * We can change payment processor at runtime
     */
    public void setPaymentProcessor(PaymentProcessor processor) {
        this.paymentProcessor = processor;
    }
}

/**
 * BENEFIT 3: STRATEGY PATTERN
 * We can switch strategies (payment methods) dynamically
 */
class PaymentStrategyService {
    private PaymentProcessor primaryProcessor;
    private PaymentProcessor fallbackProcessor;

    public PaymentStrategyService(PaymentProcessor primary, PaymentProcessor fallback) {
        this.primaryProcessor = primary;
        this.fallbackProcessor = fallback;
    }

    public boolean processWithFallback(double amount, String primaryDetails, String fallbackDetails) {
        System.out.println("\n=== Processing with Fallback Strategy ===");

        // Try primary processor first
        if (primaryProcessor.processPayment(amount, primaryDetails)) {
            return true;
        }

        // Fall back to secondary processor
        System.out.println("Primary failed, trying fallback...");
        return fallbackProcessor.processPayment(amount, fallbackDetails);
    }
}

/**
 * BENEFIT 4: EASY TESTING WITH MOCKS
 * We can create mock implementations for testing
 */
class MockPaymentProcessor implements PaymentProcessor {
    private boolean shouldSucceed;
    private int callCount = 0;

    public MockPaymentProcessor(boolean shouldSucceed) {
        this.shouldSucceed = shouldSucceed;
    }

    @Override
    public boolean processPayment(double amount, String paymentDetails) {
        callCount++;
        System.out.println("Mock processor called (attempt " + callCount + ")");
        return shouldSucceed;
    }

    @Override
    public boolean validatePaymentDetails(String paymentDetails) {
        return true;
    }

    @Override
    public String getPaymentMethodName() {
        return "Mock";
    }

    @Override
    public double getTransactionFee() {
        return 0.0;
    }

    public int getCallCount() {
        return callCount;
    }
}

/**
 * BENEFIT 5: COMPOSITION AND DECORATOR PATTERN
 * We can wrap processors to add functionality
 */
class LoggingPaymentProcessor implements PaymentProcessor {
    private PaymentProcessor wrappedProcessor;

    public LoggingPaymentProcessor(PaymentProcessor processor) {
        this.wrappedProcessor = processor;
    }

    @Override
    public boolean processPayment(double amount, String paymentDetails) {
        System.out.println("[AUDIT LOG] Starting payment processing...");
        long startTime = System.currentTimeMillis();

        boolean result = wrappedProcessor.processPayment(amount, paymentDetails);

        long duration = System.currentTimeMillis() - startTime;
        System.out.println("[AUDIT LOG] Completed in " + duration + "ms. Success: " + result);

        return result;
    }

    @Override
    public boolean validatePaymentDetails(String paymentDetails) {
        return wrappedProcessor.validatePaymentDetails(paymentDetails);
    }

    @Override
    public String getPaymentMethodName() {
        return wrappedProcessor.getPaymentMethodName() + " (with logging)";
    }

    @Override
    public double getTransactionFee() {
        return wrappedProcessor.getTransactionFee();
    }
}

/**
 * BENEFIT 6: FACTORY PATTERN
 * Create processors based on configuration
 */
class PaymentProcessorFactory {
    public static PaymentProcessor createProcessor(String type) {
        switch (type.toLowerCase()) {
            case "paypal":
                return new PayPalPaymentProcessor();
            case "stripe":
                return new StripePaymentProcessor();
            case "crypto":
                return new CryptoPaymentProcessor();
            case "applepay":
                return new ApplePayProcessor();
            default:
                throw new IllegalArgumentException("Unknown payment type: " + type);
        }
    }

    /**
     * Create processor with logging wrapper
     */
    public static PaymentProcessor createWithLogging(String type) {
        PaymentProcessor processor = createProcessor(type);
        return new LoggingPaymentProcessor(processor);
    }
}

/**
 * INTERFACE for discount calculation - another real-world example
 */
interface DiscountCalculator {
    double calculateDiscount(double amount);
    String getDiscountDescription();
}

/**
 * ABSTRACT CLASS for common discount logic
 */
abstract class BaseDiscountCalculator implements DiscountCalculator {
    protected String description;
    protected boolean isActive;

    public BaseDiscountCalculator(String description) {
        this.description = description;
        this.isActive = true;
    }

    @Override
    public String getDiscountDescription() {
        return description;
    }

    /**
     * Template method with common validation
     */
    public double calculateDiscount(double amount) {
        if (!isActive || amount <= 0) {
            return 0.0;
        }
        return computeDiscount(amount);
    }

    protected abstract double computeDiscount(double amount);
}

class PercentageDiscount extends BaseDiscountCalculator {
    private double percentage;

    public PercentageDiscount(double percentage) {
        super(percentage + "% discount");
        this.percentage = percentage;
    }

    @Override
    protected double computeDiscount(double amount) {
        return amount * (percentage / 100.0);
    }
}

class FixedAmountDiscount extends BaseDiscountCalculator {
    private double fixedAmount;

    public FixedAmountDiscount(double fixedAmount) {
        super("$" + fixedAmount + " off");
        this.fixedAmount = fixedAmount;
    }

    @Override
    protected double computeDiscount(double amount) {
        return Math.min(fixedAmount, amount);
    }
}

// ====================================================================================
// DEMONSTRATION: Main class showing all benefits
// ====================================================================================

public class PaymentSystemDemo {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  DEMONSTRATING PROBLEMS WITHOUT INTERFACES & ABSTRACT CLASSES     ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝\n");

        demonstrateProblems();

        System.out.println("\n\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║  DEMONSTRATING BENEFITS WITH INTERFACES & ABSTRACT CLASSES        ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝\n");

        demonstrateBenefits();
    }

    private static void demonstrateProblems() {
        System.out.println("❌ PROBLEM 1: Tight Coupling");
        System.out.println("   - OrderService is tied to specific implementations");
        System.out.println("   - Cannot easily swap payment providers\n");

        BadOrderService badService = new BadOrderService();
        badService.processOrderWithPayPal(100.0, "user@example.com");

        System.out.println("\n❌ PROBLEM 2: Code Duplication");
        System.out.println("   - Need separate methods for each payment type");
        System.out.println("   - processOrderWithPayPal(), processOrderWithStripe(), etc.");

        System.out.println("\n❌ PROBLEM 3: Open/Closed Principle Violation");
        System.out.println("   - Adding new payment method requires modifying existing code");
        System.out.println("   - Risk of breaking existing functionality");

        System.out.println("\n❌ PROBLEM 4: Testing Difficulties");
        System.out.println("   - Cannot inject mock processors");
        System.out.println("   - Tests depend on real implementations");
        System.out.println("   - Cannot test edge cases easily");

        System.out.println("\n❌ PROBLEM 5: No Polymorphism");
        System.out.println("   - Cannot treat different processors uniformly");
        System.out.println("   - Cannot use collections of mixed processors");
    }

    private static void demonstrateBenefits() {

        // BENEFIT 1: Polymorphism - treating different types uniformly
        System.out.println("✓ BENEFIT 1: POLYMORPHISM");
        System.out.println("   Different payment processors can be treated uniformly\n");

        PaymentProcessor[] processors = {
                new PayPalPaymentProcessor(),
                new StripePaymentProcessor(),
                new CryptoPaymentProcessor(),
                new ApplePayProcessor()
        };

        // Same code works for all processors!
        for (PaymentProcessor processor : processors) {
            System.out.println("  • " + processor.getPaymentMethodName() +
                    " - Fee: " + (processor.getTransactionFee() * 100) + "%");
        }

        // BENEFIT 2: Dependency Injection and Loose Coupling
        System.out.println("\n✓ BENEFIT 2: DEPENDENCY INJECTION & LOOSE COUPLING");
        System.out.println("   Service depends on interface, not concrete class\n");

        GoodOrderService orderService1 = new GoodOrderService(new PayPalPaymentProcessor());
        orderService1.processOrder(100.0, "customer@email.com");

        // Easy to switch implementations!
        GoodOrderService orderService2 = new GoodOrderService(new StripePaymentProcessor());
        orderService2.processOrder(150.0, "tok_visa1234567890");

        // BENEFIT 3: Abstract Class Code Reuse
        System.out.println("\n✓ BENEFIT 3: ABSTRACT CLASS PROVIDES CODE REUSE");
        System.out.println("   Common logic (retry, logging) inherited by all processors\n");

        PaymentProcessor cryptoProcessor = new CryptoPaymentProcessor();
        cryptoProcessor.processPayment(200.0, "0x742d35Cc6634C0532925a3b844Bc9e7595f0bEb");

        // BENEFIT 4: Easy Testing with Mocks
        System.out.println("\n✓ BENEFIT 4: EASY TESTING WITH MOCKS");
        System.out.println("   Can inject mock implementations for testing\n");

        MockPaymentProcessor mockProcessor = new MockPaymentProcessor(true);
        GoodOrderService testService = new GoodOrderService(mockProcessor);
        testService.processOrder(50.0, "test-details");
        System.out.println("   Mock was called " + mockProcessor.getCallCount() + " time(s)");

        // BENEFIT 5: Strategy Pattern
        System.out.println("\n✓ BENEFIT 5: STRATEGY PATTERN - RUNTIME FLEXIBILITY");
        System.out.println("   Can switch payment strategies dynamically\n");

        PaymentStrategyService strategyService = new PaymentStrategyService(
                new StripePaymentProcessor(),
                new PayPalPaymentProcessor()
        );
        strategyService.processWithFallback(
                75.0,
                "tok_invalid",  // Will fail
                "fallback@email.com"  // Will succeed
        );

        // BENEFIT 6: Decorator Pattern
        System.out.println("\n✓ BENEFIT 6: DECORATOR PATTERN - ADDING FUNCTIONALITY");
        System.out.println("   Can wrap processors to add cross-cutting concerns\n");

        PaymentProcessor wrappedProcessor = new LoggingPaymentProcessor(
                new ApplePayProcessor()
        );
        GoodOrderService decoratedService = new GoodOrderService(wrappedProcessor);
        decoratedService.processOrder(120.0, "device_abc123xyz");

        // BENEFIT 7: Factory Pattern
        System.out.println("\n✓ BENEFIT 7: FACTORY PATTERN - CONFIGURATION-DRIVEN");
        System.out.println("   Create processors based on configuration\n");

        String[] paymentTypes = {"paypal", "stripe", "crypto"};
        for (String type : paymentTypes) {
            PaymentProcessor processor = PaymentProcessorFactory.createWithLogging(type);
            System.out.println("  Created: " + processor.getPaymentMethodName());
        }

        // BENEFIT 8: Open/Closed Principle
        System.out.println("\n✓ BENEFIT 8: OPEN/CLOSED PRINCIPLE");
        System.out.println("   Open for extension, closed for modification");
        System.out.println("   Adding Apple Pay didn't require changing existing code!\n");

        // We added ApplePayProcessor without modifying OrderService!
        GoodOrderService applePayService = new GoodOrderService(new ApplePayProcessor());
        applePayService.processOrder(99.99, "device_iphone_xyz");

        // BENEFIT 9: Combining Multiple Patterns
        System.out.println("\n✓ BENEFIT 9: COMBINING INTERFACES FOR COMPLEX SCENARIOS");
        demonstrateDiscountIntegration();

        // BENEFIT 10: Interface Segregation
        System.out.println("\n✓ BENEFIT 10: INTERFACE SEGREGATION");
        System.out.println("   Clients depend only on methods they use");
        demonstrateInterfaceSegregation();
    }

    private static void demonstrateDiscountIntegration() {
        System.out.println("   Combining Payment and Discount interfaces\n");

        class SmartOrderService {
            private PaymentProcessor paymentProcessor;
            private DiscountCalculator discountCalculator;

            public SmartOrderService(PaymentProcessor payment, DiscountCalculator discount) {
                this.paymentProcessor = payment;
                this.discountCalculator = discount;
            }

            public void processOrderWithDiscount(double amount, String paymentDetails) {
                double discount = discountCalculator.calculateDiscount(amount);
                double finalAmount = amount - discount;

                System.out.println("  Original Amount: $" + amount);
                System.out.println("  Discount (" + discountCalculator.getDiscountDescription() + "): -$" + discount);
                System.out.println("  Final Amount: $" + finalAmount);

                paymentProcessor.processPayment(finalAmount, paymentDetails);
            }
        }

        SmartOrderService smartService = new SmartOrderService(
                new StripePaymentProcessor(),
                new PercentageDiscount(20)
        );
        smartService.processOrderWithDiscount(100.0, "tok_card123");
    }

    private static void demonstrateInterfaceSegregation() {
        System.out.println("   Simple payment validator only needs validation method\n");

        // Interface segregation - this component only needs validation
        class PaymentValidator {
            public boolean validate(PaymentProcessor processor, String details) {
                return processor.validatePaymentDetails(details);
            }
        }

        PaymentValidator validator = new PaymentValidator();
        PaymentProcessor processor = new PayPalPaymentProcessor();

        boolean isValid = validator.validate(processor, "user@example.com");
        System.out.println("  Validation result: " + (isValid ? "Valid" : "Invalid"));
    }
}