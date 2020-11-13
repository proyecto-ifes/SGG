import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class RutinasService {

  constructor(private httpClient: HttpClient) { }
  
  httpOptions = {
    headers: new HttpHeaders({
      'Accept':  'application/json;profile=urn:org.apache.isis/v1',
      'Authorization': 'Basic aXNpcy1tb2R1bGUtc2VjdXJpdHktYWRtaW46cGFzcw==',
    })
  }

  private Url = 'http://localhost:8080/restful/objects/gimnasio.socios/';

  private UrlEjercicios = 'http://localhost:8080/restful/objects/gimnasio.rutinas/';




  getRutinas(id: number){
     return this.httpClient.get(this.Url+id+'/collections/rutina', this.httpOptions);
  }

   getEjercicios(idRutina: number){
     return this.httpClient.get(this.UrlEjercicios+idRutina+'/collections/ejercicio', this.httpOptions);
  }
}
