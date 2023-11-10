package com.junkfoood.reponsitory;

import com.junkfoood.model.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountReponsitory extends JpaRepository<AccountEntity,String> {
//    @Query("SELECT DISTINCT ar.accountAuth FROM AuthorityEntity ar WHERE ar.role.id IN ('DIRE','STAF')")
//    List<AccountEntity> getAdminstrators();

    AccountEntity findByUsername(String username);

}
