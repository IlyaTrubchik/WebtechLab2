package by.bsuir.webtech.ilya.DAO;

import by.bsuir.webtech.ilya.entities.Cart;

import java.util.List;

public class CartDao implements IDao<Cart>{
    @Override
    public Cart findById(long id) {
        return null;
    }
    public Cart findByUserId(long id){
        return  null;
    }

    @Override
    public List<Cart> findAll() {
        return null;
    }
}
