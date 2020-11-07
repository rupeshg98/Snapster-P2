import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewMyDetailsComponent } from './view-my-details.component';

describe('ViewMyDetailsComponent', () => {
  let component: ViewMyDetailsComponent;
  let fixture: ComponentFixture<ViewMyDetailsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewMyDetailsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewMyDetailsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
