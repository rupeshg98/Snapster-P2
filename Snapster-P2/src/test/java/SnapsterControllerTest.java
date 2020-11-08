import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import com.revature.controller.SnapsterController;
import com.revature.model.User;

class SnapsterControllerTest {

	SnapsterController mockController = mock(SnapsterController.class);
	
	@Test
	void testValidateLogin() {
		String username = "rupesh";
		String password = "pwd";
		String a = verify(mockController).validateLogin(username, password);
		assert (a) == "{\"isValidUser\":true}";
	}

	@Test
	void testViewMyInfo() {
		String username = "rupesh";
		boolean exists = false;
		List<User> users = verify(mockController).viewMyInfo(username);
		for(User user: users) {
			if(user.getUsername() == "rupesh") {
				exists = true;
				assert(true);
			}
		}
		if(exists == false)
			assert(false);
	}
}
