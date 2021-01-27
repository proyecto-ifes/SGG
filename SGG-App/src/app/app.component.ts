import { Component, OnInit } from '@angular/core';

import { Platform } from '@ionic/angular';
import { SplashScreen } from '@ionic-native/splash-screen/ngx';
import { StatusBar } from '@ionic-native/status-bar/ngx';

@Component({
  selector: 'app-root',
  templateUrl: 'app.component.html',
  styleUrls: ['app.component.scss']
})
export class AppComponent implements OnInit {

  darkmode: boolean = false;
  id = window.sessionStorage["id"] ;
  public selectedIndex = 0;
  public appPages = [
    {
      title: 'Mis Datos',
      url: '/socio/socio/'+this.id,
      icon: 'person'
    },
    {
      title: 'Mis Rutinas',
      url: '/socio/rutinas/'+this.id,
      icon: 'clipboard'
    },
    {
      title: 'Mis Metas',
      url: '/socio/metas/'+this.id,
      icon: 'medal'
    },
    {
      title: 'Mis Asistencias',
      url: '/socio/asistencias/'+this.id,
      icon: 'calendar'
    },
    {
      title: 'Mis Pagos',
      url: '/socio/pagos/'+this.id,
      icon: 'cash'
    }
  ];

  constructor(
    private platform: Platform,
    private splashScreen: SplashScreen,
    private statusBar: StatusBar
  ) {
    this.initializeApp();
  }

  initializeApp() {
    this.platform.ready().then(() => {
      this.statusBar.styleDefault();
      this.splashScreen.hide();
    });

    this.checkDark();
  }

  ngOnInit() {
    
  }

  checkDark(){
    const prefersDark = window.matchMedia('(prefers-color-scheme: dark)');

    if(prefersDark.matches){
      document.body.classList.toggle( 'dark' );
    }
  }

  cambio(){

    this.darkmode = !this.darkmode;

    document.body.classList.toggle( 'dark' );

  }
}
