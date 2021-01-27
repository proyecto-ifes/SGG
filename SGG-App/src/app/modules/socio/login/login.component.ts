import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AlertController, LoadingController, MenuController, ToastController } from '@ionic/angular';
import { LoginService } from '../servicios/login.service';
import { ToastService } from '../servicios/toast.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss'],
})
export class LoginComponent implements OnInit {

  loginForm: FormGroup;
  public loginInvalido: boolean =false;
  username: string = ''
  password: any;
  idSocio=1;



  constructor(private fb: FormBuilder,
    public menuCtrl: MenuController,
    public toastCtrl: ToastController,
    public alertCtrl: AlertController,
    public loadingCtrl: LoadingController,
    private loginService: LoginService,
    private toastService: ToastService
    
    ) { }

  ngOnInit() {
    this.initForm();
  }

  ionViewWillEnter() {
    this.menuCtrl.enable(false);
  }

  initForm(){
    this.loginForm = this.fb.group({
      username: [null, Validators.required],
      password: [null, Validators.required]
    });
  }


  submit(){
    if (this.loginForm.invalid){
      return;
    }
    this.username= this.loginForm.controls.username.value,
    this.password= this.loginForm.controls.password.value    
    this.loginService.realizaLogin(this.username, this.password, this.idSocio)
    .subscribe(
      (user: any) => {    

        this.loginService.getUserSocio(this.idSocio).subscribe((nuevoUser) => {
          
          if(nuevoUser[0].name == this.username) {
        
            // variable global.
            window.sessionStorage["id"] = this.idSocio; 
           
            location.href = '/socio/socio/'+this.idSocio;

            this.GuardaUsuarioEnCookie(this.username);
            this.toastService.presentToast('Bienvenido al sistema: '+this.username);
          
          }else{
            this.idSocio++
            this.submit();
          }

        })      
        
    },
    (error) => {
      console.log(error);    
    this.loginInvalido = true;
    this.toastService.presentToast('Usuario y/o contraseña incorrectos');
    this.loginForm.reset();
    })
  } 

  GuardaUsuarioEnCookie(usuarioRecibido: String){
    window.localStorage.usuario = usuarioRecibido;
  }

}
