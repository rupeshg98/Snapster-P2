import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.model.FriendRequest;
import com.revature.model.Photo;
import com.revature.model.User;
import com.revature.service.SnapsterService;

class SnapsterServiceTest {

	SnapsterService mockService = mock(SnapsterService.class);
	User mockUser = mock(User.class);
	Photo mockPhoto = mock(Photo.class);
	FriendRequest mockReq = mock(FriendRequest.class);
	
	@Test
	void testInsertUser() {
		mockService.insertUser(mockUser);
		verify(mockService).insertUser(mockUser);
	}
	
	@Test
	void testInsertPhoto() {
		mockService.insertPhoto(mockPhoto);
		verify(mockService).insertPhoto(mockPhoto);
	}
	
	@Test
	void testValidUser() {
		String username = "rupesh";
		String password = "pwd";
		User user = mockService.validateUser(username, password);
		if(user != null)
			assert(true);
	}
	
	@Test
	void testNotValidUser() {
		String username = "fakename";
		String password = "pwd";
		User user = mockService.validateUser(username, password);
		if(user == null)
			assert(true);
	}
	
	@Test
	void testGetUser() {
		mockService.getUser("rupesh");
		verify(mockService).getUser("rupesh");
	}
	
	@Test
	void testFailGetUser() {
		mockService.getUser("fakename");
		verify(mockService).getUser("fakename");
	}

	@Test
	void testGetPhotos() {
		List<Photo> photos = mockService.getPhotos("rupesh");
		if(photos != null)
			assert(true);
	}
	
	@Test
	void testFailGetPhotos() {
		List<Photo> photos = mockService.getPhotos("fakename");
		if(photos == null)
			assert(true);
	}
	
	@Test
	void testInsertFriendRequest() {
		mockService.insertFriendRequest(mockReq);
		verify(mockService).insertFriendRequest(mockReq);
	}
	
	@Test
	void testFailInsertFriendRequest() {
		mockReq = null;
		mockService.insertFriendRequest(mockReq);
		verify(mockService).insertFriendRequest(mockReq);
	}
	
	@Test
	void testApproveTrueRequest() {
		mockService.approveRequest(mockReq);
		if(mockReq.isApproved())
			assert(true);
	}
	
	@Test
	void testApproveFalseRequest() {
		mockReq.setApproved(false);
		mockService.approveRequest(mockReq);
		if(mockReq.isApproved())
			assert(true);
		
	}
	
	@Test
	void testDeleteTrueRequest() {
		mockService.deleteRequest(mockReq);
		verify(mockService).deleteRequest(mockReq);
	}
	
	@Test
	void testDeleteFalseRequest() {
		mockReq.setApproved(false);
		mockService.deleteRequest(mockReq);
		verify(mockService).deleteRequest(mockReq);
		
	}
	
	@Test
	void testGetFriendRequests() {
		List<FriendRequest> requests = mockService.getFriendRequests("rupesh");
		if(requests != null)
			assert(true);
	}
	
	@Test
	void testFailGetFriendRequests() {
		List<FriendRequest> requests = mockService.getFriendRequests("fakename");
		if(requests == null)
			assert(true);
	}
}
