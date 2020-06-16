/*
 *  Licensed to the Apache Software Foundation (ASF) under one
 *  or more contributor license agreements.  See the NOTICE file
 *  distributed with this work for additional information
 *  regarding copyright ownership.  The ASF licenses this file
 *  to you under the Apache License, Version 2.0 (the
 *  "License"); you may not use this file except in compliance
 *  with the License.  You may obtain a copy of the License at
 *
 *        http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing,
 *  software distributed under the License is distributed on an
 *  "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *  KIND, either express or implied.  See the License for the
 *  specific language governing permissions and limitations
 *  under the License.
 */

package domainapp.modules.simple.fixture;

import lombok.experimental.Accessors;

@Accessors(chain = true)
public class SimpleObjectBuilder /*extends BuilderScriptAbstract<Persona, SimpleObjectBuilder>*/ {

    /*@Getter @Setter
    private String nombre;
    @Getter @Setter
    private String apellido;
    @Getter @Setter
    private Integer dni;
    @Getter @Setter
    private Integer telefono;
    @Getter @Setter
    private String direccion;
    @Getter @Setter
    private LocalDate fechaNac;

    @Getter
    private Persona object;

    @Override
    protected void execute(final ExecutionContext ec) {

        checkParam("nombre", ec, String.class);

        object = wrap(personas).create(nombre, apellido, dni, telefono, direccion,fechaNac);
    }

    @javax.inject.Inject
    Personas personas;*/

}
