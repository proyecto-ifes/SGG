import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginService {

  Auth64: string;
  ip = 'http://localhost:8080';

  constructor(private httpClient: HttpClient) { }


  realizaLogin(username:String, password:String, id){

        
    this.Auth64 = btoa(username+":"+password);
 
    const httpOptions = {
      headers: new HttpHeaders({
        'Accept':  'application/json;profile=urn:org.apache.isis/v1',
        'Authorization': 'Basic '+this.Auth64,
      })
    }

  
    const Url = this.ip+'/restful/objects/gimnasio.socios/';
    
  
    return this.httpClient.get(Url+id+'/collections/usuario', httpOptions);
    

  } 

  getUserSocio(id){
    const httpOptions2 = {
      headers: new HttpHeaders({
        'Accept':  'application/json;profile=urn:org.apache.isis/v1',
        'Authorization': 'Basic aXNpcy1tb2R1bGUtc2VjdXJpdHktYWRtaW46cGFzcw==',
      })
    }
    const Url2 = this.ip+'/restful/objects/gimnasio.socios/';

    return this.httpClient.get(Url2+id, httpOptions2);

  }
}
