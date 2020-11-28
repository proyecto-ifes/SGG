import { Component, OnInit } from '@angular/core';
import { PagosService } from '../servicios/pagos.service';

@Component({
  selector: 'app-pagos',
  templateUrl: './pagos.component.html',
  styleUrls: ['./pagos.component.scss'],
})
export class PagosComponent implements OnInit {

  id = 1;
  idDetalle: number;
  pagos: any[] = [];
  mostrar: boolean = false;
  ver: boolean = true;

  constructor(private pagosService: PagosService) { }

  ngOnInit() {
    this.getPagos();
  }

  getPagos(){
    this.pagosService.getPagos(this.id).subscribe((pagos: any) => {       
      this.pagos = pagos;
    });
  }

  detalles(id: number){
    if(this.mostrar == false ){
      this.idDetalle = id;
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
