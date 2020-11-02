import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DisplayFilteredProductsComponent } from './display-filtered-products.component';

describe('DisplayFilteredProductsComponent', () => {
  let component: DisplayFilteredProductsComponent;
  let fixture: ComponentFixture<DisplayFilteredProductsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DisplayFilteredProductsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(DisplayFilteredProductsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
