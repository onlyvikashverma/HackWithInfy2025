public class BuyTwoChoco {
   public static int buyTwochoco(int[] prices,int money){
      int minPrice = Integer.MAX_VALUE;
      int secMinPrice = Integer.MAX_VALUE;
      for(int price:prices){
         if(price<minPrice){
            secMinPrice = minPrice;
            minPrice = price;
         }
         else{
            secMinPrice = Math.min(secMinPrice, price);

         }
      }
      if(minPrice + secMinPrice > money){
         return money;
      }
      else{
         return money - (minPrice + secMinPrice);
      }
   } 
   public static void main(String[] args) {
      int[] prices = {3, 2, 3};
      int money = 3;
      System.out.println(buyTwochoco(prices, money)); 
   }
    
}
