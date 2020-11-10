import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class SocioService {

  
  constructor(private httpClient: HttpClient) { }


  httpOptions = {
    headers: new HttpHeaders({
      'Accept':  'application/json;profile=urn:org.apache.isis/v1',
      'Authorization': 'Basic aXNpcy1tb2R1bGUtc2VjdXJpdHktYWRtaW46cGFzcw==',
    })
  }

  private Url = 'http://localhost:8080/restful/services/socio.SimpleObjectMenu/actions/listAll/invoke';


  getSocios(){
     return this.httpClient.get(this.Url, this.httpOptions);
  }
  

  private urlMeta = 'http://localhost:8080/restful/objects/gimnasio.socios/';

  getMetas(idSocio: number){
    return this.httpClient.get(this.urlMeta + idSocio + '/collections/meta',  this.httpOptions); 
  }


}
