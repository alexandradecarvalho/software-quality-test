package tqs.lab2;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


class StocksPortfolioTest {

    @Test
    void getTotalValue() {
        // 1.Prepare a mock to substitute the remote service (@Mock annotation)
        IStockMarket stockMarket = mock(IStockMarket.class);

        // 2.Create an instance of the subject under test (SuT) and use the mock to set the (remote) service instance.
        StocksPortfolio portfolio = new StocksPortfolio(stockMarket);

        // 3.Load the mock with the proper expectations (when...thenReturn)
        when(stockMarket.getPrice("EBAY")).thenReturn(4.0);
        when(stockMarket.getPrice("MSFT")).thenReturn(1.5);

        // 4.Execute the test (use the service in the SuT)
        portfolio.addStock(new Stock(("EBAY"), 2));
        portfolio.addStock(new Stock(("MSFT"), 4));

        // 5.Verify the result (assert) and the use of the mock (verify)
        //assertEquals(2*4.0+4*1.5,portfolio.getTotalValue());
        assertThat(portfolio.getTotalValue(), is(2*4.0+4*1.5));

        verify(stockMarket, times(2)).getPrice(anyString());
    }
}