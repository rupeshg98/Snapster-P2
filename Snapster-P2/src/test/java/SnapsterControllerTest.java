import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import com.revature.controller.SnapsterController;
import com.revature.model.User;

class SnapsterControllerTest {

	SnapsterController mockController = mock(SnapsterController.class);
	
	@Test
	void testValidateLogin() {
		String username = "me";
		String password = "pwd";
		User user = verify(mockController).validateLogin(username, password);
		assert (user) != null;
	}

}
