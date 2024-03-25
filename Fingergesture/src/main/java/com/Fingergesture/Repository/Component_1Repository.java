package com.Fingergesture.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Fingergesture.Entity.Component_1;




@Repository
public interface Component_1Repository  extends JpaRepository<Component_1, Integer> {
	Optional<Component_1> findFirstByOrderByIdDesc();
}
