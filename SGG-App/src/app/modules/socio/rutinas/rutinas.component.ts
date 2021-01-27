import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { RutinasService } from '../servicios/rutinas.service';

@Component({
  selector: 'app-rutinas',
  templateUrl: './rutinas.component.html',
  styleUrls: ['./rutinas.component.scss'],
})
export class RutinasComponent implements OnInit {

  socioId: any;
  rutinas: any[] = [];
  ejercicios: any[] = [];
  mostrar: boolean = false;
  ver: boolean = true;

  constructor(
    private rutinasService: RutinasService, 
    private paramRoute: ActivatedRoute
    ) { }

  ngOnInit() {

    this.paramRoute.paramMap.subscribe( param => {
      this.socioId = param.get('id');      
    }) 
    this.getRutinas(this.socioId);
  }

  getRutinas(socioId){
    this.rutinasService.getRutinas(socioId).subscribe((rutinas: any) => {       
      this.rutinas = rutinas;
    });
  }

  getEjercicios(id: number){      
    this.rutinasService.getEjercicios(id).subscribe((ejercicios: any) => {     
      this.ejercicios = ejercicios;
    });

    if(this.mostrar == false ){
      this.mostrar = true;
      this.ver = false;
    }else{
      this.mostrar = false;
      this.ver = true;

    }
  }

  volver(){

    if(this.mostrar == true ){
      this.mostrar = false;
      this.ver = true;
    }else{
      this.mostrar = true;
      this.ver = false;

    }

  }

}
