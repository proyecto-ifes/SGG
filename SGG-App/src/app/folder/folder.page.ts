import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SocioService } from '../servicios/socio.service';

@Component({
  selector: 'app-folder',
  templateUrl: './folder.page.html',
  styleUrls: ['./folder.page.scss'],
})
export class FolderPage implements OnInit {
  
  public folder: string;
  socios: any[] = [];
  socioId : number = 2;
  metas: any[] = [];


  constructor(private activatedRoute: ActivatedRoute, private socioService: SocioService) { }

  ngOnInit() {
    // this.folder = this.activatedRoute.snapshot.paramMap.get('id');
    this.getSocios();
    this.getMetas();
  }


  getSocios(){
    this.socioService.getSocios().subscribe((socios: any) => {      
      this.socios = socios;
    });
  }

  getMetas(){
    this.socioService.getMetas(this.socioId).subscribe((metas: any) => {
        this.metas = metas;
    });
  }

}
