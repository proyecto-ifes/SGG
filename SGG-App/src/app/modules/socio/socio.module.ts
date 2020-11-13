import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { RouteReuseStrategy } from '@angular/router';

import { SocioRoutingModule } from './socio-routing.module';
import { SocioComponent } from './socio/socio.component';
import { SocioService } from './servicios/socio.service';

import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';
import { RutinasComponent } from './rutinas/rutinas.component';
import { RutinasService } from './servicios/rutinas.service';
import { MetasService } from './servicios/metas.service';
import { MetasComponent } from './metas/metas.component';



@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule.forRoot(),
    SocioRoutingModule
    
  ],
  declarations: [SocioComponent, RutinasComponent, MetasComponent],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy },
    SocioService, RutinasService, MetasService
  ]
})
export class SocioModule {}
