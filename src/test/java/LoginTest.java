import dto.UserDTO;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class LoginTest extends TestBase{

    UserDTO userDTOPositive = UserDTO.builder().email("f.ekaterin@gmail.com").password("Q9fWwzz$V").build();
    @Test
    public void loginTestPositive() {
        app.getHelperLogin().login(userDTOPositive);
    }
}
