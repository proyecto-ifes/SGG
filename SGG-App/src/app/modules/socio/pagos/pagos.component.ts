import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { PagosService } from '../servicios/pagos.service';

@Component({
  selector: 'app-pagos',
  templateUrl: './pagos.component.html',
  styleUrls: ['./pagos.component.scss'],
})
export class PagosComponent implements OnInit {

  socioId: any;
  idDetalle: number;
  pagos: any[] = [];
  mostrar: boolean = false;
  ver: boolean = true;

  constructor(
    private pagosService: PagosService, 
    private paramRoute: ActivatedRoute
    ) { }

  ngOnInit() {
    this.paramRoute.paramMap.subscribe( param => {
      this.socioId = param.get('id');      
    }) 
    this.getPagos(this.socioId);
  }

  getPagos(socioId){
    this.pagosService.getPagos(socioId).subscribe((pagos: any) => {       
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
