package com.junkfoood.reponsitory;

import com.junkfoood.model.entity.AccountEntity;
import com.junkfoood.model.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorityReponsitory extends JpaRepository<AuthorityEntity,Integer> {
    @Query("SELECT DISTINCT a FROM AuthorityEntity a WHERE a.accountAuth IN ?1")
    List<AuthorityEntity> authoritiesOf(List<AccountEntity> accounts);
}
