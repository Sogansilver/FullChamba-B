<?php
/**
 * Obtiene todas las metas de la base de datos
 */

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $json = file_get_contents ('php://input');
    $datos = json_decode ($json);
    $code=$datos->codigo;
    $tabla=$datos->rol;
    
    // Manejar petición POST

    if ($tabla =='Empleado') {
        require '../Classes/Empleado.php';
        $rpta = Empleado::dataUser($code);
    }
    if ($tabla =='Gerencia'){
        require '../Classes/Gerencia.php';
        $rpta = Gerencia::dataUser($code);
    }
    
    if ($rpta) {
        //print json_encode($rpta);
        print(json_encode(array(
            "idempleado" => $rpta["idempleado"],
            "nombre" => $rpta["nombre"],
            "cargo" => $rpta["cargo"],
            "correo" => $rpta["correo"]
            ))
        );
    } else {
        print(json_encode(array(
            "estado" => "ERROR",
            "mensaje" => "No se pudo validar el usuario"
            ))
        );
    }
}
?>