import { async, ComponentFixture, TestBed } from '@angular/core/testing';
import { IonicModule } from '@ionic/angular';

import { SocioComponent } from './socio.component';

describe('SocioComponent', () => {
  let component: SocioComponent;
  let fixture: ComponentFixture<SocioComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SocioComponent ],
      imports: [IonicModule.forRoot()]
    }).compileComponents();

    fixture = TestBed.createComponent(SocioComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  }));

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
