package by.bsuir.webtech.ilya.DAO;

import by.bsuir.webtech.ilya.entities.Entity;
import by.bsuir.webtech.ilya.entities.Role;

import java.util.List;

public interface IDao <T extends Entity> {
    T findById(long id);


    List<T> findAll();

}
