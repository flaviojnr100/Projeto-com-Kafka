package com.ms.user.repository;

import com.ms.user.model.User;
import org.springframework.data.repository.CrudRepository;


import java.util.UUID;

public interface UserRepository extends CrudRepository<User,UUID> {

}