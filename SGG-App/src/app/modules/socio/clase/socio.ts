export class Socio{

    constructor(
        public id: number,
        public nombre: string,
        public apellido: string,
        public fechaNac: Date,
        public dni: number,
        public estado: string,
        public direccion: string,
        public telefono: number,
        public nroEmergencia: number,
        public peso: number,
        public altura: number,
        public historiaClinica: string
        

    ){}

}