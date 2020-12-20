<?php
/**
 * Obtiene todas las metas de la base de datos
 */

require '../Classes/Tarea.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $json = file_get_contents ('php://input');
    $datos = json_decode ($json);
    $idtarea=$datos->idtarea;

    // Manejar petición GET
    $rpta = Tarea::eliminarTarea($idtarea);

    if ($rpta) {
        $dic["estado"] = "ok";
        $dic["mensaje"] = "Funcion el delete";
        print json_encode($dic);
    } else {
        print json_encode(array(
            "estado" => "no ok",
            "mensaje" => "NO se ha podido hacer delete"
        ));
    }
}
?>