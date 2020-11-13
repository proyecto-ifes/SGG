import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
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
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SocioRoutingModule {}
