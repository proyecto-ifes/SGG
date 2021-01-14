import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MetasService } from '../servicios/metas.service';

@Component({
  selector: 'app-crear-objetivo',
  templateUrl: './crear-objetivo.component.html',
  styleUrls: ['./crear-objetivo.component.scss'],
})
export class CrearObjetivoComponent implements OnInit {


  idMeta: any;
  objetivoForm: FormGroup;

  constructor(
    private fb: FormBuilder,
    private metaService: MetasService, 
    private paramRoute: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit() {

    this.paramRoute.paramMap.subscribe( param => {
        this.idMeta = param.get('id');      
    });

    this.initForm();

  }

  initForm(){
    this.objetivoForm = this.fb.group({
      descripcion: [''],
      fecha: ['']
    });
  }

  submit(){
  
    this.metaService.nuevaObjetivo(this.idMeta, this.objetivoForm.value).subscribe((objetivo )=>{
       let objetivoNew = objetivo;
    }); 
  
    // location.reload();
  this.router.navigate(['/socio/metas']);
}

}
