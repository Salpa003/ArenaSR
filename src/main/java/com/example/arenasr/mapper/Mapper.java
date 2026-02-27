package com.example.arenasr.mapper;

public interface Mapper<F,T>{

    T map(F f);

    F unmap(T t);
}
