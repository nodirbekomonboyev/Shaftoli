package uz.pdp.shaftoli.service;

import java.util.ArrayList;

public interface BaseService <T>{
    T add(T t);
    ArrayList<T> getAll();
    T getById();

}
