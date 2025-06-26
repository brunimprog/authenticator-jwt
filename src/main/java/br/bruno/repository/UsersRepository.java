package br.bruno.repository;

import br.bruno.models.Users;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UsersRepository implements PanacheRepository<Users> {
    
}
