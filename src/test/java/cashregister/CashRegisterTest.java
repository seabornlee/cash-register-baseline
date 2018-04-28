package cashregister;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CashRegisterTest {
    @Mock
    private Printer mockPrinter;

    @Mock
    private Purchase stubPurchase;

    @Test
    public void should_print_the_real_purchase() {
        //initialize CashRegister and fake Printer
        MockPrinter mockPrinter = new MockPrinter();
        CashRegister cashRegister = new CashRegister(mockPrinter);
        Purchase purchase = new Purchase(new Item[] {
                new Item("Milk", 5.0)
        });

        cashRegister.process(purchase);

        //verify that printer was called
        mockPrinter.verifyThatPrintWasCalledWith(purchase.asString());
    }

    @Test
    public void should_print_the_stubbed_purchase() {
        //initialize CashRegister and fake Printer
        MockPrinter mockPrinter = new MockPrinter();
        CashRegister cashRegister = new CashRegister(mockPrinter);
        StubPurchase purchase = new StubPurchase("test purchase string");

        cashRegister.process(purchase);

        //verify that printer was called
        mockPrinter.verifyThatPrintWasCalledWith("test purchase string");
    }

    @Test
    public void should_mock_with_mockito() throws Exception {
        when(stubPurchase.asString()).thenReturn("some test text");
        CashRegister cashRegister = new CashRegister(mockPrinter);
        cashRegister.process(stubPurchase);

        verify(mockPrinter).print("some test text");
    }
}
