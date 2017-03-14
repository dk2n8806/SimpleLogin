package com.core.dao;

import java.io.Serializable;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

@Validated
public interface GenericRepository<E, I extends Serializable>
{
	
    
    List<E> getList();

    E findById(@NotNull I id);

    void persist(@NotNull E entity);

    void update(@NotNull E entity);

    void delete(@NotNull E entity);

  
}

