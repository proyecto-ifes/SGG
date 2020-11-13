import { Component, OnInit } from '@angular/core';
import { MetasService } from '../servicios/metas.service';

@Component({
  selector: 'app-metas',
  templateUrl: './metas.component.html',
  styleUrls: ['./metas.component.scss'],
})
export class MetasComponent implements OnInit {

  id = 1;
  metas: any[] = [];
  objetivos: any[] = [];
  mostrar: boolean = false;
  ver: boolean = true;

  constructor(private metasService: MetasService) { }

  ngOnInit() {
    this.getMetas();
  }

  getMetas(){
    this.metasService.getMetas(this.id).subscribe((metas: any) => { 
      this.metas = metas;
    });
  }

  getObjetivos(id: number){      
    this.metasService.getObjetivos(id).subscribe((objetivos: any) => {     
      this.objetivos = objetivos;
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
