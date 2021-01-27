import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { MetasService } from '../servicios/metas.service';

@Component({
  selector: 'app-metas',
  templateUrl: './metas.component.html',
  styleUrls: ['./metas.component.scss'],
})
export class MetasComponent implements OnInit {


  socioId: any;
  metas: any[] = [];
  objetivos: any[] = [];
  mostrar: boolean = false;
  ver: boolean = true;
  idmeta: number;

  constructor(
    private metasService: MetasService, 
    private router: Router, 
    private paramRoute: ActivatedRoute) { }

  ngOnInit() {
    this.paramRoute.paramMap.subscribe( param => {
      this.socioId = param.get('id');      
    }) 
    this.getMetas(this.socioId);

  }



  getMetas(socioId){
    this.metasService.getMetas(socioId).subscribe((metas: any) => { 
      this.metas = metas;
    });
  }

  getObjetivos(id: number){      
    this.metasService.getObjetivos(id).subscribe((objetivos: any) => {     
      this.objetivos = objetivos;
    });
    this.idmeta=id;
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


  nuevo(){
    this.router.navigate(['/socio/crearMeta/'+this.socioId]);
  }
  nuevoObjetivo(){
    this.router.navigate(['/socio/crearObjetivo/'+this.idmeta]);
  }

}
