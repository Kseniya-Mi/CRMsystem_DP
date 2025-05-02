package org.example.crmsystem_dp.repository;

import org.example.crmsystem_dp.entities.Users;
import org.example.crmsystem_dp.interfaces.DataAccessObject;
import org.example.crmsystem_dp.mappers.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepository implements DataAccessObject<Users> {
    private final JdbcTemplate jdbcTemplate;
    private final UserMapper rowMapper;

    @Autowired
    public UsersRepository(JdbcTemplate jdbcTemplate, UserMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    @Override
    public void save(Users user) {
        jdbcTemplate.update(
                "INSERT INTO users (login, password, role) VALUES (?, crypt(?, gen_salt('md5')), ?)",
                user.getLogin(),
                user.getPassword(),
                user.getRole()
        );
    }

    @Override
    public void delete(Users user) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", user.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id = ?", id);
    }

    @Override
    public void update(Long id, Users user) {
        jdbcTemplate.update(
                "UPDATE users SET login = ?, password = ?, role = ? WHERE id = ?",
                user.getLogin(),
                user.getPassword(),
                user.getRole(),
                id
        );
    }

    @Override
    public List<Users> findAll() {
        return jdbcTemplate.query("SELECT * FROM users", rowMapper);
    }

    @Override
    public Optional<Users> findByID(Long id) {
        try {
            Users user = jdbcTemplate.queryForObject(
                    "SELECT * FROM users WHERE id = ?",
                    (rs, rowNum) -> {
                        Users u = new Users();
                        u.setId(rs.getLong("id"));
                        u.setLogin(rs.getString("login"));
                        u.setPassword(rs.getString("password"));
                        u.setRole(rs.getString("role"));
                        return u;
                    },
                    id
            );
            return Optional.ofNullable(user);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public Optional<Users> findByUsername(String username) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT * FROM users WHERE username = ?",
                    rowMapper,
                    username
            ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    public Optional<Users> findByLoginAndPassword(String login, String password) {
        try {
            return Optional.ofNullable(jdbcTemplate.queryForObject(
                    "SELECT * FROM users WHERE login = ? AND password = ? LIMIT 1",
                    rowMapper,
                    login,
                    password
            ));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }
}





