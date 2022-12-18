package mapper;
import entity.Role;
import entity.User;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper {
    public static User mapToUser(ResultSet resultSet) throws SQLException {
        User user = null;
        while (resultSet.next()) {
            user = new User();
            user.setId(resultSet.getInt(1));
            user.setFirst_name(resultSet.getString(2));
            user.setLast_name(resultSet.getString(3));
            user.setEmail(resultSet.getString(4));
            user.setPassword(resultSet.getString(5));
            user.setRole(Role.valueOf(resultSet.getString(6)));
        }
        return user;
    }
}
