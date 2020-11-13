import { Component, OnInit } from '@angular/core';
import { Socio } from '../clase/socio';
import { SocioService } from './../servicios/socio.service';


@Component({
  selector: 'app-socio',
  templateUrl: './socio.component.html',
  styleUrls: ['./socio.component.scss'],
})
export class SocioComponent implements OnInit {

  socioId = 1;
  socios: Socio[] = [];
  constructor(private socioService: SocioService) { }

  ngOnInit() {
    this.getSocio();
  }



  getSocio(){
    this.socioService.getSocio(this.socioId).subscribe((socio: Socio[]) => {     
      this.socios = socio;
    });
  }

}
