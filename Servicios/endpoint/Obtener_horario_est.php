<?php
/**
 * Obtiene todas las metas de la base de datos
 */

require '../Classes/Estudiante.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $json = file_get_contents ('php://input');
    $datos = json_decode ($json);;
    $codEst=$datos->codigo;

    // Manejar petición GET
    $rpta = Estudiante::getHorarioEst($codEst);

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


