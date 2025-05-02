package org.example.crmsystem_dp.service;

import org.example.crmsystem_dp.entities.Users;
import org.example.crmsystem_dp.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UsersRepository usersRepository;

    public Users createUser(Long id) {
        Users user = usersRepository.findByID(id).orElse(null);;

        Users userDto = new Users();

        userDto.setId(user.getId());
        userDto.setLogin(user.getLogin());
        userDto.setPassword(user.getPassword());
        userDto.setRole(String.valueOf(user.getRole()));

        return userDto;
    }

    public Optional<Users> authenticate(String login, String password) {
        return usersRepository.findByLoginAndPassword(login, password);
    }
}
