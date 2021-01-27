import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Socio } from '../clase/socio';
import { SocioService } from './../servicios/socio.service';


@Component({
  selector: 'app-socio',
  templateUrl: './socio.component.html',
  styleUrls: ['./socio.component.scss'],
})
export class SocioComponent implements OnInit {

  socioId: any;
  socios: Socio[] = [];
  mostrar: boolean = false;
  ver: boolean = true;
  socioForm: FormGroup;



  constructor(
    private socioService: SocioService,
    private fb: FormBuilder, 
    private paramRoute: ActivatedRoute
    ) { }

  ngOnInit() {
    this.paramRoute.paramMap.subscribe( param => {
      this.socioId = param.get('id');      
    })   
    this.getSocio(this.socioId);
    this.initForm();
 
  }


  initForm(){
    this.socioForm = this.fb.group({
      direccion: [''],
      telefono: [''],
      nroEmergencia: [''],
      peso: [''],
      altura: [''],
      historiaClinica: ['']
    });
  }

  getSocio(id){
    this.socioService.getSocio(id).subscribe((socio: Socio[]) => {     
      this.socios = socio;
      this.socioForm.patchValue(this.socios);
    });
  }

  editar(){
    if(this.mostrar == false ){
      this.mostrar = true;
      this.ver = false;
      
    }else{
      this.mostrar = false;
      this.ver = true;

    }
  }

  submit(){
      this.socioService.updateSocio(this.socioId, this.socioForm.value).subscribe((socio )=>{
         let socioNew = socio;
      }); 
      location.reload();
  
  }

}
