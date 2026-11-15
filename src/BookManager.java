import java.util.ArrayList;
import java.util.List;

public class BookManager {
   private final ArrayList<book> books = new ArrayList<>();
   private int nextID = 1;
   public book add(String title,long price ,int quantity){
       book sach = new book(nextID,title,price,quantity);
       books.add(sach);
       nextID++;
       return sach;
   }
   public List<book> allbook(){
        return new ArrayList<>(books);
   }
   public book findID(int id){
        for(book x : books){
            if(x.getId() == id){
                return x;
            }
        }
        return null ;
   }
   public boolean update(int id,String title, long price, int quantity){
            book sach = findID(id);
            if(sach == null){
                System.out.println("sách không tồn tại");
            }

            sach.setId(id);
            sach.setTitle(title);
            sach.setPrice(price);
            sach.setQuantity(quantity);
            return true;
   }
   public boolean delete (int id){
       for(int i = 0; i < books.size(); i++){
           if(books.get(i).getId() == id){
               books.remove(i);
               return true;
           }
       }return false;
   }
   public long sum(){
       int tong = 0;
       for(book x : books){
           tong += x.getQuantity()* x.getPrice();
       }
        return tong;
   }
   public List<book> outstock() {
       List<book> sach = new ArrayList<>();
       for (book x : books) {
           if (x.getQuantity() == 0) {
               sach.add(x);
           }
       }
       return sach;
   }
}
