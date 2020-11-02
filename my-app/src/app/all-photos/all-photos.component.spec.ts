import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllPhotosComponent } from './all-photos.component';

describe('AllPhotosComponent', () => {
  let component: AllPhotosComponent;
  let fixture: ComponentFixture<AllPhotosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AllPhotosComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AllPhotosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
