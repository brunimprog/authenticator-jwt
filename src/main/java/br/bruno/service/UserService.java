package br.bruno.service;

import br.bruno.models.Users;
import br.bruno.repository.UsersRepository;
import br.bruno.exceptions.*;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@Transactional
@ApplicationScoped
public class UserService {

    @Inject
    private UsersRepository usersRepository;

    @Inject
    private PasswordService passwordService;
    
    public Users registerUser(Users users) {
        Users user = new Users();
        user.setName(users.getName());
        user.setEmail(users.getEmail());
        user.setPassword(passwordService.hashPassoword(users.getPassword()));
        validateData(user);
        usersRepository.persist(user);
        return user;
    }

    public void validateData(Users user){
        if (user.getName() == null || user.getName().isEmpty()){
            throw new InvalidFieldsException("Name is not valid");
        }
        if (user.getEmail() == null || user.getEmail().isEmpty()){
            throw new InvalidFieldsException("Email is not valid");
        }
        if (user.getPassword() == null || user.getPassword().isEmpty()){
            throw new InvalidFieldsException("Password is not valid");
        }
    }
}
