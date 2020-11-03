import { TestBed } from '@angular/core/testing';

import { FriendServiceService } from './friend-service.service';

describe('FriendServiceService', () => {
  let service: FriendServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(FriendServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
