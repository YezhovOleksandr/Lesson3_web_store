package dto;

import entity.User;
import lombok.Data;

@Data
public class UserDTO {
    private int id;
    private String first_name;
    private String last_name;
    private String email;

    public UserDTO(User user) {
        this.id = user.getId();
        this.first_name = user.getFirst_name();
        this.last_name = user.getLast_name();
        this.email = user.getEmail();
    }
}
