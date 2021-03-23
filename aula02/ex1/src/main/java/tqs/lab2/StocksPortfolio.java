package tqs.lab2;

import java.util.ArrayList;

public class StocksPortfolio {
    private String name;
    private IStockMarket stockMarket;
    private ArrayList<Stock> my_stocks = new ArrayList<>();

    public StocksPortfolio(IStockMarket stockMarket){
        this.stockMarket = stockMarket;
    }

    public IStockMarket getMarketService(){
        return this.stockMarket;
    }

    public void setMarketService(IStockMarket stockMarket){
        this.stockMarket=stockMarket;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name=name;
    }

    public void addStock(Stock stock){
        my_stocks.add(stock);
    }

    public Double getTotalValue(){
        double result = 0;
        for (Stock stock : my_stocks){
            result += stockMarket.getPrice(stock.getName()) * stock.getQuantity();
        }
        return result;
    }

}
