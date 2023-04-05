package ibf2022.paf.assessment.server.repositories;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ibf2022.paf.assessment.server.models.User;

// TODO: Task 3
@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final String SELECT_BY_USERNAME_SQL= "select user_id, username, name from user where username = ?";
    private final String INSERT_USER_SQL = "insert into user (user_id, username, name) values (?,?,?)";

    public Optional<User> findUserByUsername(String username){

        try{

            User user = jdbcTemplate.queryForObject(SELECT_BY_USERNAME_SQL, BeanPropertyRowMapper.newInstance(User.class),username);
            return Optional.of(user);

        }catch(Exception ex){

            return Optional.empty();

        }
        
    }

    public String insertUser(User user){

        String userId = UUID.randomUUID().toString().substring(0,8);
        user.setUserId(userId);

        try{
            Integer affectedRows = jdbcTemplate.update(INSERT_USER_SQL, user.getUserId(), user.getUsername(), user.getName());
            if(affectedRows > 0){
                return userId;
            }else{
                return null; // test if can return null or return ""
            }
        }catch(Exception ex){ // try dataacessexception
            System.out.println("fail to insert user in user repo"); // debug
            return null;
        }


    }

}
