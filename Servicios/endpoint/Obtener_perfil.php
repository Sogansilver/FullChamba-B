<?php
/**
 * Obtiene todas las metas de la base de datos
 */



if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $json = file_get_contents ('php://input');
    $datos = json_decode ($json);
    $code=$datos->codigo;

    if (strtolower($code)[0] !='e') {
        require '../Classes/Gerencia.php';
        $rpta = Gerencia::getProfile($code);
    }else{
        require '../Classes/Empleado.php';
        $rpta = Empleado::getProfile($code);
    }

    if ($rpta) {
        /*
        $dic["estado"] = 1;
        $dic["detalle"] = $rpta;
        */
        print json_encode($rpta);
    } else {
        print json_encode(array(
            "estado" => 2,
            "mensaje" => "Error en obtener detalles"
        ));
    }
}
?>