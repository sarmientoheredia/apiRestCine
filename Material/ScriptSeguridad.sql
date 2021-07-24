CREATE TABLE Usuario
(
 IdUsuario 		INT NOT NULL AUTO_INCREMENT,
 NomUsuario 	VARCHAR(50) NOT NULL,
 PassUsuario 	VARCHAR(50) NOT NULL,
 CargoUsuario	VARCHAR(50) NOT null,
 CONSTRAINT PK_USUARIO PRIMARY KEY (IdUsuario)
);


CREATE TABLE Rol
(
 IdRol	 		INT NOT NULL AUTO_INCREMENT,
 NomRol		 	VARCHAR(50) NOT null,
 CONSTRAINT PK_ROL PRIMARY KEY (IdRol)
);

CREATE TABLE RolUsuario
(
 IdUsuario	 	INT NOT NULL,
 IdRol	 		INT NOT null,
 CONSTRAINT PK_ROLUSUARIO PRIMARY KEY (IdUsuario, IdRol)
);

insert into Usuario (NomUsuario, PassUsuario,CargoUsuario) values ('lsalvatierra', 12345, 'JEFE');
insert into Usuario (NomUsuario, PassUsuario,CargoUsuario) values ('hvargas', 12345, 'SUPERVISOR');
insert into Usuario (NomUsuario, PassUsuario,CargoUsuario) values ('wlazo', 12345, 'EJECUTIVO DE VENTAS');
insert into Usuario (NomUsuario, PassUsuario,CargoUsuario) values ('ipizarro', 12345, 'EJECUTIVO DE COMPRAS');

insert into Rol (NomRol) values ('ROLE_ADMIN');
insert into Rol (NomRol) values ('ROLE_VENTAS');
insert into Rol (NomRol) values ('ROLE_COMPRAS');

insert into RolUsuario (IdUsuario, IdRol) values (1,1);
insert into RolUsuario (IdUsuario, IdRol) values (2,2);
insert into RolUsuario (IdUsuario, IdRol) values (2,3);
insert into RolUsuario (IdUsuario, IdRol) values (3,2);
insert into RolUsuario (IdUsuario, IdRol) values (4,3);




