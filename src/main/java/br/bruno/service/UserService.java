package br.bruno.service;

import br.bruno.models.Users;
import br.bruno.repository.UsersRepository;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
public class UserService {

    @Inject
    private UsersRepository usersRepository;
    
    public Users authenticationUser(Users user) {
        validateData(user);
        usersRepository.persist(user);
        return user;
    }

    public void validateData(Users user){
        if (user.getName().isEmpty() || user.getName() == null){
            throw new NullPointerException();
        }
        if (user.getEmail().isEmpty() || user.getEmail() == null){
            throw new NullPointerException();
        }
        if (user.getPassword().isEmpty() || user.getPassword() == null){
            throw new NullPointerException();
        }
    }
}
