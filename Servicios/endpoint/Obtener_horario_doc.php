<?php
/**
 * Obtiene todas las metas de la base de datos
 */

require '../Classes/Docente.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $json = file_get_contents ('php://input');
    $datos = json_decode ($json);;
    $codDoc=$datos->codigo;

    // Manejar petición GET
    $rpta = Docente::getHorarioDoc($codDoc);

    if ($rpta) {

        $dic["estado"] = 1;
        $dic["horario"] = $rpta;

        print json_encode($dic);
    } else {
        print json_encode(array(
            "estado" => 2,
            "mensaje" => "NO se ha cargado el horario"
        ));
    }
}
?>


