import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

<<<<<<< HEAD
import org.junit.jupiter.api.Test;
=======
import java.util.List;
>>>>>>> 8248ca9207237105a1463f184abd09aee6e75fdb

import com.revature.controller.SnapsterController;
import com.revature.model.User;

class SnapsterControllerTest {

	SnapsterController mockController = mock(SnapsterController.class);
	
	@Test
	void testValidateLogin() {
		String username = "rupesh";
		String password = "pwd";
		User user = verify(mockController).validateLogin(username, password);
		assert (user) != null;
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
