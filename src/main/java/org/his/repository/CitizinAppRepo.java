package org.his.repository;

import java.io.Serializable;

import org.his.bean.CitizinAppEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizinAppRepo extends JpaRepository<CitizinAppEntity, Serializable> {

}
