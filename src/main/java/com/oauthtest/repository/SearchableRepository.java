package com.oauthtest.repository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;

@NoRepositoryBean
public interface SearchableRepository<T, K extends Serializable> extends PagingAndSortingRepository<T, K>, JpaSpecificationExecutor<T> {

}
