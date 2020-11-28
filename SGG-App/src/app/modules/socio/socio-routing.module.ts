import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AsistenciasComponent } from './asistencias/asistencias.component';
import { MetasComponent } from './metas/metas.component';
import { PagosComponent } from './pagos/pagos.component';
import { RutinasComponent } from './rutinas/rutinas.component';
import { SocioComponent } from './socio/socio.component';


const routes: Routes = [
  {
    path: 'socio',
    component: SocioComponent
  },
  {
    path: 'rutinas',
    component: RutinasComponent
  },
  {
    path: 'metas',
    component: MetasComponent
  },
  {
    path: 'asistencias',
    component: AsistenciasComponent
  },
  {
    path: 'pagos',
    component: PagosComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SocioRoutingModule {}
