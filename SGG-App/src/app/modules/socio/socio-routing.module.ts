import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { SocioComponent } from './socio/socio.component';


const routes: Routes = [
  {
    path: 'socio',
    component: SocioComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule],
})
export class SocioRoutingModule {}
