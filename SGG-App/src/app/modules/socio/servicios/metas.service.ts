import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MetasService {
  ip = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) { }
  
  httpOptions = {
    headers: new HttpHeaders({
      'Accept':  'application/json;profile=urn:org.apache.isis/v1',
      'Authorization': 'Basic aXNpcy1tb2R1bGUtc2VjdXJpdHktYWRtaW46cGFzcw==',
    })
  }

  private Url = this.ip+'/restful/objects/gimnasio.socios/';

  private UrlObjetivos = this.ip+'/restful/objects/gimnasio.metas/';

  private addMeta = this.ip+'/restful/objects/gimnasio.socios/';

  private addObjetivo = this.ip+'/restful/objects/gimnasio.metas/';

  getMetas(id: number){
     return this.httpClient.get(this.Url+id+'/collections/meta', this.httpOptions);
  }

   getObjetivos(idMeta: number){
     return this.httpClient.get(this.UrlObjetivos+idMeta+'/collections/objetivos', this.httpOptions);
  }

  nuevaMeta(id, meta){
    let datos = {
      "descripcion:": {
        "value": meta.descripcion
      },
      "estado:": {
        "value": "Iniciado"
      }
    };
    return this.httpClient.post(this.addMeta+id+'/actions/addMeta/invoke', JSON.stringify(datos), this.httpOptions);
    
  }

  nuevaObjetivo(id, objetivo){
    let datos = {
      "descripcion:": {
        "value": objetivo.descripcion
      },
      "fecha:": {
        "value": objetivo.fecha
      }
    };
    return this.httpClient.post(this.addObjetivo+id+'/actions/addObjetivo/invoke', JSON.stringify(datos), this.httpOptions);
    
  }
}
