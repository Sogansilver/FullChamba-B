<?php
/**
 * Obtiene todas las metas de la base de datos
 */

require '../Classes/Gerencia.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $json = file_get_contents ('php://input');
    //$datos = json_decode ($json);
    //$seccion=$datos->seccion;

    // Manejar petición GET
    $listaEmpleados = Gerencia::getEmpleados();

    if ($listaEmpleados!=-1) {
        # code...
        $rpta = True;
    }
    else{
        $rpta=False;
    }
    if ($rpta) {
        $dic["estado"] = "OK";
        $dic["empleados"] = $listaEmpleados;
        print json_encode($dic);
    } else {
        print json_encode(array(
            "estado" => "no ok",
            "mensaje" => "Algo fallo"
        ));
    }
}
?>