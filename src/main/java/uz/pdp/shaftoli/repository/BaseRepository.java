package uz.pdp.shaftoli.repository;

import java.util.ArrayList;
import java.util.UUID;

public interface BaseRepository<T>{

    void save(T t);
    ArrayList<T> getAll();
    T getById(UUID id);


}
