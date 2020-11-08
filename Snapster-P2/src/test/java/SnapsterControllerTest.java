import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import com.revature.controller.SnapsterController;

class SnapsterControllerTest {

	SnapsterController mockController = mock(SnapsterController.class);
	
	@Test
	void testValidateLogin() {
		String username = "me";
		String password = "pwd";
		String a = verify(mockController).validateLogin(username, password);
		assert (a) != null;
	}

}
