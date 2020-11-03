import { ComponentFixture, TestBed } from '@angular/core/testing';

import { OtherHomeComponent } from './other-home.component';

describe('OtherHomeComponent', () => {
  let component: OtherHomeComponent;
  let fixture: ComponentFixture<OtherHomeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ OtherHomeComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(OtherHomeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
