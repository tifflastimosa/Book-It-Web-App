package com.libby.letsbookit.repositories;

import com.libby.letsbookit.model.Stand;
import javax.transaction.Transactional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface StandRepository extends CrudRepository {

}
