package by.bsuir.webtech.ilya.entities;

import java.util.ArrayList;

public class Cart extends Entity{
    private Long cartId;
    private ArrayList<Book> books;

    private Long userId;

    public Cart(ArrayList<Book> books,Long cartId,Long userId)
    {
        this.books = books;
        this.cartId = cartId;
        this.userId = userId;
    }
    public Cart(){
    };

    public Long getCartId() {
        return cartId;
    }

    public Long getUserId() {
        return userId;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }

    public void setBooks(ArrayList<Book> books) {
        this.books = books;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setCartId(Long cartId) {
        this.cartId = cartId;
    }
}
