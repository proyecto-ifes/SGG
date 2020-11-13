import { Component, OnInit } from '@angular/core';
import { RutinasService } from '../servicios/rutinas.service';

@Component({
  selector: 'app-rutinas',
  templateUrl: './rutinas.component.html',
  styleUrls: ['./rutinas.component.scss'],
})
export class RutinasComponent implements OnInit {

  id = 1;
  rutinas: any[] = [];
  ejercicios: any[] = [];
  mostrar: boolean = false;
  ver: boolean = true;

  constructor(private rutinasService: RutinasService) { }

  ngOnInit() {
    this.getRutinas();
  }

  getRutinas(){
    this.rutinasService.getRutinas(this.id).subscribe((rutinas: any) => {       
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
