package org.his.repository;

import org.his.bean.ApplicationRegisteration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizinAppRepo extends JpaRepository<ApplicationRegisteration, Integer> {

}
