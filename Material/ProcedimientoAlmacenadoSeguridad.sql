DELIMITER $$
create procedure sp_RegistrarEmpleado (
IN _nombre VARCHAR(50),
IN _apellido VARCHAR(50)
)
begin 
insert into empleado (Nombre, Apellido, FechaContrat,IdEstado) 
values (_nombre, _apellido, NOW(), 1);
END$$
DELIMITER ;


DELIMITER $$
CREATE procedure sp_AutenticarUsuario (
IN _usuario VARCHAR(20),
IN _password VARCHAR(20)
)
begin
	select IdUsuario, NomUsuario, CargoUsuario  from usuario 
	where NomUsuario = _usuario and PassUsuario = _password;
END$$
DELIMITER ;


DELIMITER $$
CREATE procedure sp_RolxUsuario (
IN _idusuario INT
)
begin
select r.IdRol , r.NomRol   from rol r inner join rolusuario ru on r.IdRol = ru.IdRol 
	where IdUsuario = _idusuario;
END$$
DELIMITER ;