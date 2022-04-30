package com.libby.letsbookit.repositories;

import com.libby.letsbookit.model.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *  Repository for class Vendor Repository
 */
@Repository
public interface VendorRepository  extends JpaRepository<Vendor, Integer> {

}
