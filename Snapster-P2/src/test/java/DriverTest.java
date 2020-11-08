import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.Test;

import com.revature.Driver;

class DriverTest {
	
	Driver mockDriver = mock(Driver.class);
	@Test
	void testGetAllMyFriends() {
		mockDriver.getAllMyFriends();
		verify(mockDriver).getAllMyFriends();
	}

	@Test
	void testGetMyPendingFriendRequests() {
		mockDriver.getMyPendingFriendRequests();
		verify(mockDriver).getMyPendingFriendRequests();
	}
	
	@Test
	void testGetAllUserPosts() {
		mockDriver.getAllUserPosts();
		verify(mockDriver).getAllUserPosts();
	}
	
	@Test
	void testAddImageToS3() {
		mockDriver.addImageToS3();
		verify(mockDriver).addImageToS3();
	}
}
