import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class MetasService {

  constructor(private httpClient: HttpClient) { }
  
  httpOptions = {
    headers: new HttpHeaders({
      'Accept':  'application/json;profile=urn:org.apache.isis/v1',
      'Authorization': 'Basic aXNpcy1tb2R1bGUtc2VjdXJpdHktYWRtaW46cGFzcw==',
    })
  }

  private Url = 'http://localhost:8080/restful/objects/gimnasio.socios/';

  private UrlObjetivos = 'http://localhost:8080/restful/objects/gimnasio.metas/';

  getMetas(id: number){
     return this.httpClient.get(this.Url+id+'/collections/meta', this.httpOptions);
  }

   getObjetivos(idMeta: number){
     return this.httpClient.get(this.UrlObjetivos+idMeta+'/collections/objetivos', this.httpOptions);
  }
}
