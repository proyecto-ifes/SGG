import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { MetasService } from '../servicios/metas.service';


@Component({
  selector: 'app-crear-meta',
  templateUrl: './crear-meta.component.html',
  styleUrls: ['./crear-meta.component.scss'],
})
export class CrearMetaComponent implements OnInit {

  metaForm: FormGroup;
  socioId = 1;

  constructor(private fb:FormBuilder, private metaService: MetasService, private router: Router) { }

  ngOnInit() {
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
    
      // location.reload();
    this.router.navigate(['/socio/metas']);
  }

}
