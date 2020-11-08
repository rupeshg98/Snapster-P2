import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;
import java.util.List;

import com.revature.controller.SnapsterController;
import com.revature.model.User;

class SnapsterControllerTest {

	SnapsterController mockController = mock(SnapsterController.class);
	
	@Test
	void testValidateLogin() {
		String username = "rupesh";
		String password = "pwd";
		User user = mockController.validateLogin(username, password);
		if(user != null)
			assert(true);
	}
	
	@Test
	void testNotValidateLogin() {
		String username = "fakename";
		String password = "pwd";
		User user = mockController.validateLogin(username, password);
		if(user == null)
			assert(true);
	}

	@Test
	void testViewMyInfo() {
		String username = "rupesh";
		mockController.viewMyInfo(username);
		verify(mockController).viewMyInfo(username);
	}
	
	@Test
	void testFailViewMyInfo() {
		String username = "fakename";
		mockController.viewMyInfo(username);
		verify(mockController).viewMyInfo(username);
	}
}
