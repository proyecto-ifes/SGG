import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
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
  mostrar: boolean = false;
  ver: boolean = true;
  socioForm: FormGroup;



  constructor(private socioService: SocioService, private fb: FormBuilder) { }

  ngOnInit() {
    this.getSocio();
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

  getSocio(){
    this.socioService.getSocio(this.socioId).subscribe((socio: Socio[]) => {     
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
    // this.router.navigate(['/cursos/curso-component'])

  }

}
