import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AsistenciasService } from '../servicios/asistencias.service';

@Component({
  selector: 'app-asistencias',
  templateUrl: './asistencias.component.html',
  styleUrls: ['./asistencias.component.scss'],
})
export class AsistenciasComponent implements OnInit {

  socioId: any;
  asistencias: any[] = [];

  constructor(private asistenciaService: AsistenciasService, private paramRoute: ActivatedRoute) { }

  ngOnInit() {
    this.paramRoute.paramMap.subscribe( param => {
      this.socioId = param.get('id');      
    }) 
    this.getAsistencias(this.socioId);
  }

  getAsistencias(socioId){
    this.asistenciaService.getAsistencias(socioId).subscribe((asistencias: any) => {       
      this.asistencias = asistencias;
    });
  }

}
