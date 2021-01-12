import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouteReuseStrategy } from '@angular/router';

import { SocioRoutingModule } from './socio-routing.module';
import { SocioComponent } from './socio/socio.component';
import { SocioService } from './servicios/socio.service';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
import { IonicModule, IonicRouteStrategy } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

import { RutinasComponent } from './rutinas/rutinas.component';
import { RutinasService } from './servicios/rutinas.service';
import { MetasService } from './servicios/metas.service';
import { MetasComponent } from './metas/metas.component';
import { AsistenciasComponent } from './asistencias/asistencias.component';
import { AsistenciasService } from './servicios/asistencias.service';
import { PagosComponent } from './pagos/pagos.component';
import { PagosService } from './servicios/pagos.service';




@NgModule({
  imports: [
    CommonModule,
    FormsModule,
    IonicModule.forRoot(),
    SocioRoutingModule,
    ReactiveFormsModule,
    FormsModule
    
  ],
  declarations: [SocioComponent, RutinasComponent, MetasComponent, AsistenciasComponent, PagosComponent],
  providers: [
    StatusBar,
    SplashScreen,
    { provide: RouteReuseStrategy, useClass: IonicRouteStrategy },
    SocioService, RutinasService, MetasService, AsistenciasService, PagosService
  ]
})
export class SocioModule {}
