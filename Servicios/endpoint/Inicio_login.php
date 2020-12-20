<?php
/**
 * Obtiene todas las metas de la base de datos
 */

if ($_SERVER['REQUEST_METHOD'] == 'POST') {

    $json = file_get_contents ('php://input');
    $datos = json_decode ($json);
    $code=$datos->codigo;
    $pass=$datos->password;
    
    // Manejar petición POST

    if (strtolower($code)[0] =='e') {
        require '../Classes/Empleado.php';
        $rpta = Empleado::validationUser($code,$pass);
    }
    if (strtolower($code)[0] =='g'){
        require '../Classes/Gerencia.php';
        $rpta = Gerencia::validationUser($code,$pass);
    }
    
    if ($rpta) {
        //print json_encode($rpta);
        print(json_encode(array(
            "estado" => "OK",
            "mensaje" => "INGRESO CONFIRMADO"
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