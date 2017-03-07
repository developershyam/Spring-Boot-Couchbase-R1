package com.sample.data.repository;

import org.springframework.data.couchbase.repository.CouchbaseRepository;
import org.springframework.stereotype.Repository;

import com.sample.data.model.User;
/**
 * This is User repository.
 * 
 * @author shyam.pareek
 *
 */
@Repository
public interface UserRepository extends CouchbaseRepository<User, Long>{

}
