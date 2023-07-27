package uz.pdp.shaftoli.repository;

import java.util.ArrayList;

public interface BaseRepository<T>{

    T save(T t);
    ArrayList<T> getAll();
    T getById();


}
