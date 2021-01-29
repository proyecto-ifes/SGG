import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})

export class SocioService {

  ip = 'http://localhost:8080';

  
  constructor(private httpClient: HttpClient) { }


  httpOptions = {
    headers: new HttpHeaders({
      'Accept':  'application/json;profile=urn:org.apache.isis/v1',
      'Authorization': 'Basic aXNpcy1tb2R1bGUtc2VjdXJpdHktYWRtaW46cGFzcw==',
    })
  }

  private Url = this.ip+'/restful/objects/gimnasio.socios/';

  private urlUpdate = this.ip+"/restful/objects/gimnasio.socios/";


  getSocio(id: number){
     return this.httpClient.get(this.Url+id, this.httpOptions);
  }

  updateSocio(id, socio){
    let datos = {
      "numeroDeTelefono:": {
        "value": socio.telefono
      },
      "direccion:": {
        "value": socio.direccion
      },
      "numeroDeEmergencia:": {
        "value": socio.nroEmergencia
      },
      "peso:": {
        "value": socio.peso
      },
      "altura:": {
        "value": socio.altura
      },
      "historiaClinica:": {
        "value": socio.historiaClinica
      }
    };
    return this.httpClient.post(this.urlUpdate+id+"/actions/update/invoke", JSON.stringify(datos), this.httpOptions);
  }
  


}
