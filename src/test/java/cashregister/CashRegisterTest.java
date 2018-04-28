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

        cashRegister.process(purchase);

        //verify that printer was called
    }

}
