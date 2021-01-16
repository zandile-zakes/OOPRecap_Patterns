package oop_recap;

class ShoppingCart implements ShoppingCartI {
    private String itemName;
    private int itemQty;
    private double itemPrice;

    public ShoppingCart(String itemName, int itemQty, double itemPrice){
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
    }

    @Override
    public String getItemName(){
        return itemName;
    }

    @Override
    public int getItemQty(){
        return itemQty;
    }

    @Override
    public double getItemPrice(){
        return itemPrice;
    }

    @Override
    public double getTotalPrice(){
        return itemPrice * itemQty;
    }

}

class BuyOneGetOneFree implements ShoppingCartI{
    private ShoppingCartI shoppingCart;
    
    public BuyOneGetOneFree(ShoppingCartI shoppingCart){
        this.shoppingCart = shoppingCart;
    }

    @Override
    public String getItemName() {
        return shoppingCart.getItemName();
    }

    @Override
    public int getItemQty() {
        return shoppingCart.getItemQty();
    }

    @Override
    public double getItemPrice() {
        return shoppingCart.getItemPrice();
    }

    @Override
    public double getTotalPrice() {
        return shoppingCart.getTotalPrice()/2;
    }
}

class BuyThreePayForTwo implements ShoppingCartI{
    private ShoppingCartI shoppingCart;

    public BuyThreePayForTwo(ShoppingCartI shoppingCart){
        this.shoppingCart = shoppingCart;
    }
    @Override
    public String getItemName() {
        return shoppingCart.getItemName();
    }

    @Override
    public int getItemQty() {
        return shoppingCart.getItemQty();
    }

    @Override
    public double getItemPrice() {
        return shoppingCart.getItemPrice();
    }

    @Override
    public double getTotalPrice() {
        return shoppingCart.getTotalPrice() -shoppingCart.getItemPrice();
    }
}

public class DecoratorPattern {

    public static void main(String[] args) {
        ShoppingCartI cart = new ShoppingCart("Chocolate", 3, 16.99);
        System.out.println("without the decorator");
        System.out.println(cart.getTotalPrice());

        if (cart.getItemQty() ==2){
            cart = new BuyOneGetOneFree(cart);
            System.out.println("buy one get one free "+ cart.getItemName());
            System.out.println(cart.getTotalPrice());
        }else if (cart.getItemQty() ==3){
            cart = new BuyThreePayForTwo(cart);
            System.out.println("Buy 3 get 1 for free "+ cart.getItemName());
            System.out.println(cart.getTotalPrice());
        }else {
            System.out.println(cart.getItemName()+": "+cart.getTotalPrice());
        }
    }
}
