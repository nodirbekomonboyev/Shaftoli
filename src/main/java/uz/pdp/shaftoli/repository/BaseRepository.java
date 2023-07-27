package uz.pdp.shaftoli.repository;

import java.util.ArrayList;
import java.util.UUID;

public interface BaseRepository<T>{

    T save(T t);
    ArrayList<T> getAll();
    T getById(UUID id);


}
