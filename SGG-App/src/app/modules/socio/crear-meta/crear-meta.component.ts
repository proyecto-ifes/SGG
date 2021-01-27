import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { MetasService } from '../servicios/metas.service';


@Component({
  selector: 'app-crear-meta',
  templateUrl: './crear-meta.component.html',
  styleUrls: ['./crear-meta.component.scss'],
})
export class CrearMetaComponent implements OnInit {


  metaForm: FormGroup;
  socioId: any;

  constructor(
    private fb:FormBuilder, 
    private metaService: MetasService, 
    private router: Router,  
    private paramRoute: ActivatedRoute
    ) { }

  ngOnInit() {
    this.paramRoute.paramMap.subscribe( param => {
      this.socioId = param.get('id');      
    }) 
    this.initForm();
  }


  initForm(){
    this.metaForm = this.fb.group({
      descripcion: ['']
    });
  }

  submit(){
  
      this.metaService.nuevaMeta(this.socioId, this.metaForm.value).subscribe((meta )=>{
         let metaNew = meta;
      }); 
    
      location.href= '/socio/metas/'+this.socioId;
  }

}
