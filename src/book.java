public class book {
    private int id;
    private String title;
    private long price;
    private int quantity;

    public book(int id, String title, long price, int quantity)  {
        if(id < 0){
            throw  new ArithmeticException("id error");
        }
        this.id = id;
        setTitle(title);
        setPrice(price);
        setQuantity(quantity);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null || title.isBlank()){
            throw new ArithmeticException("title error");
        }
        this.title = title;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price)  {
        if(price < 0 ){
            throw new ArithmeticException("Gia khong duoc am");
        }
        this.price = price;
    }

    public int getQuantity() {
        if(quantity < 0){
            throw new ArithmeticException("so luong khong duoc am");
        }
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                '}';
    }
}
