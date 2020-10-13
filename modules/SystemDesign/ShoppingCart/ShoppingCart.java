package SystemDesign.ShoppingCart;

import java.util.List;

//enum AccountStatus{
//    ACTIVE, INACTIVE
//}
//
//class Product {
//    String productId;
//    String name;
//    String description;
//    double price;
//    ProductCategory category;
//    int inventory;
//    Account seller;
//}
//
//class ProductCategory{
//    String categoryId;
//    String name;
//    String description;
//    ProductCategory parentCategory;
//}
//
//class Item{
//    String productId;
//    int quantity;
//    double price;
//    Coupon appliedCoupon;
//    public Item updateQuantity(int quantity){
//
//    }
//}
//
//class Account{
//    String userName;
//    String password;
//    AccountStatus status;
//    String name;
//    String email;
//    String phone;
//    Address address;
//}
////
//class Address{
//
//}
//
//class PriceCalculator{
//
//
//}
//public class ShoppingCart{
//    private List<Item> items;
//
//    public boolean addItem(Item item)
//    {
//
//    }
//
//    public boolean removeItem(Item item)
//    {
//
//    }
//
//    public boolean incrementQuantity(Item item)
//    {
//
//    }
//
//    public boolean decrementQuantity(Item item)
//    {
//
//    }
//
//    public List<Item> getItem()
//    {
//
//    }
//
//    public boolean checkout()
//    {
//
//    }
//
//    public boolean applyCoupon(Item item, Coupon coupon){
//        //if successfully applied set appliedCoupon field of Item
//    }
//
//    public double getTotalPrice()
//    {
//
//    }
//
//    public double getTotalDiscount()
//    {
//        //loop through all the items
//        //if item.getAppliedCoupon is not null -
//        double discount = 0.0;
//        for (Item item : this.items)
//        {
//            if (item.appliedCoupon != null){
//                String productId = item.productId;
//                discount += item.appliedCoupon.getDiscountStrategy().getDiscount()
//            }
//        }
//    }
//
//    public double getDiscountedPrice()
//    {
//
//    }
//
//    public void getPriceBreakUp()
//    {
//
//    }
//
////    public boolean pay(PaymentMethod method) {
////
////        double totalCost = calcTotalCost();
////        return method.pay(totalCost);
////    }
//}
//
//class Coupon {
//    DiscountType discountType;
//    double discountValue;
//
//    public Coupon(DiscountType discountType, double discountValue) {
//        this.discountType = discountType;
//        this.discountValue = discountValue;
//    }
//
//    public DiscountStrategy getDiscountStrategy()
//    {
//
//    }
//}
//
//enum DiscountType {
//    FIXED, PERCENTAGE
//}
//
//interface DiscountStrategy{
//    public double getDiscountedPrice();
//    public double getDiscount();
//}
//
//class PercentageDiscountStrategy implements DiscountStrategy
//{
//    Product product;
//    Coupon coupon;
//
//    public PercentageDiscountStrategy(Product product, Coupon coupon) {
//        this.product = product;
//        this.coupon = coupon;
//    }
//
//    @Override
//    public double getDiscountedPrice() {
//        return this.product.price - this.getDiscount();
//    }
//
//    @Override
//    public double getDiscount() {
//        return this.product.price * (this.coupon.discountValue / 100);
//    }
//}
//
//
//class FixedDiscountStrategy implements DiscountStrategy
//{
//    Product product;
//    Coupon coupon;
//
//    public FixedDiscountStrategy(Product product, Coupon coupon) {
//        this.product = product;
//        this.coupon = coupon;
//    }
//
//    @Override
//    public double getDiscountedPrice() {
//        return this.product.price - this.getDiscount();
//    }
//
//    @Override
//    public double getDiscount() {
//        return this.coupon.discountValue;
//    }
//}
//
//
//
//
enum ProductCondition {
    NEW, USED
}

class Coupon {

}

class Account {

}

class Product
{
    String productId;
    String name;
    String description;
    List<Integer> serviceablePinCodes;
    ProductCondition condition;
    List<Coupon> couponsApplicable;
    Account sellerDetails;
    int quantityAvailable;



}

class ProductCategory {

}

class CartItem {

}

