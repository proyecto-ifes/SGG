import { Component, OnInit } from '@angular/core';
import { AsistenciasService } from '../servicios/asistencias.service';

@Component({
  selector: 'app-asistencias',
  templateUrl: './asistencias.component.html',
  styleUrls: ['./asistencias.component.scss'],
})
export class AsistenciasComponent implements OnInit {

  id = 1;
  asistencias: any[] = [];

  // mostrar: boolean = false;
  // ver: boolean = true;

  constructor(private asistenciaService: AsistenciasService) { }

  ngOnInit() {
    this.getAsistencias();
  }

  getAsistencias(){
    this.asistenciaService.getAsistencias(this.id).subscribe((asistencias: any) => {       
      this.asistencias = asistencias;
    });
  }

}
