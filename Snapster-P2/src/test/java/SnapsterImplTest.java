import static org.junit.jupiter.api.Assertions.*; 
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.revature.model.FriendRequest;
import com.revature.model.Photo;
import com.revature.model.User;
import com.revature.repository.SnapsterImpl;

class SnapsterImplTest {

	SnapsterImpl mockRepo = mock(SnapsterImpl.class);
	User mockUser = mock(User.class);
	Photo mockPhoto = mock(Photo.class);
	FriendRequest mockReq = mock(FriendRequest.class);
	
	@Test
	void testInsertUser() {
		mockRepo.insertUser(mockUser);
		verify(mockRepo).insertUser(mockUser);
	}
	
	@Test
	void testGetUser() {
		mockUser = mockRepo.getUser("rupesh");
		if(mockUser != null)
			assert(true);
	}
	
	@Test
	void testFailGetUser() {
		mockUser = mockRepo.getUser("fakename");
		if(mockUser == null)
			assert(true);
	}
	
	@Test
	void testInsertPhoto() {
		mockRepo.insertPhoto(mockPhoto);
		verify(mockRepo).insertPhoto(mockPhoto);
	}
	
	@Test
	void testGetPhotos() {
		List<Photo> photos = mockRepo.getPhotos("rupesh");
		if(photos != null)
			assert(true);
	}
	
	@Test
	void testFailGetPhotos() {
		List<Photo> photos = mockRepo.getPhotos("fakename");
		if(photos == null)
			assert(true);
	}
	
	@Test
	void testInsertFriendRequest() {
		mockRepo.insertFriendRequest(mockReq);
		verify(mockRepo).insertFriendRequest(mockReq);
	}

	@Test
	void testGetRequests() {
		List<FriendRequest> requests = mockRepo.getFriendRequests("rupesh");
		if(requests != null)
			assert(true);
	}
	
	@Test
	void testFailGetRequests() {
		List<FriendRequest> requests = mockRepo.getFriendRequests("fakename");
		if(requests == null)
			assert(true);
	}
	
	@Test
	void testApproveRequest() {
		mockRepo.approveRequest(mockReq);
		verify(mockRepo).approveRequest(mockReq);
	}
	
	@Test
	void testApproveFalseRequest() {
		mockReq.setApproved(false);
		mockRepo.approveRequest(mockReq);
		verify(mockRepo).approveRequest(mockReq);
	}
	
	@Test
	void testDeleteRequest() {
		mockRepo.deleteRequest(mockReq);
		verify(mockRepo).deleteRequest(mockReq);
	}
}
