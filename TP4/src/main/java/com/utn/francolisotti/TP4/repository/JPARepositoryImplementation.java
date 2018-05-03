package com.utn.francolisotti.TP4.repository;

import com.utn.francolisotti.TP4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface JPARepositoryImplementation extends JpaRepository<User,Long> {

    @Query("SELECT browser,operativeS, count(id) as cantidad FROM User GROUP BY browser,operativeS ORDER BY cantidad DESC")
    List<?> mostUsedCombination();


}
