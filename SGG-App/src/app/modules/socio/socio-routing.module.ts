import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AsistenciasComponent } from './asistencias/asistencias.component';
import { CrearMetaComponent } from './crear-meta/crear-meta.component';
import { CrearObjetivoComponent } from './crear-objetivo/crear-objetivo.component';
import { LoginComponent } from './login/login.component';
import { MetasComponent } from './metas/metas.component';
import { PagosComponent } from './pagos/pagos.component';
import { RutinasComponent } from './rutinas/rutinas.component';
import { SocioComponent } from './socio/socio.component';


const routes: Routes = [
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'socio/:id',
    component: SocioComponent
  },
  {
    path: 'rutinas/:id',
    component: RutinasComponent
  },
  {
    path: 'metas/:id',
    component: MetasComponent
  },
  {
    path: 'asistencias/:id',
    component: AsistenciasComponent
  },
  {
    path: 'pagos/:id',
    component: PagosComponent
  },
  {
    path: 'crearMeta/:id',
    component: CrearMetaComponent
  },
  {
    path: 'crearObjetivo/:id',
    component: CrearObjetivoComponent
  }

];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SocioRoutingModule {}
