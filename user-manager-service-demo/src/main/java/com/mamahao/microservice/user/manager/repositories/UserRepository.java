package com.mamahao.microservice.user.manager.repositories;

import com.mamahao.microservice.user.manager.model.User;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Company        :   mamahao.com
 * author         :   guxiaolong
 * Date           :   2016/3/1
 * Time           :   16:20
 * Description    :
 */
@RepositoryRestResource(collectionResourceRel = "users",path = "users")
public interface UserRepository extends GraphRepository<User> {
}
