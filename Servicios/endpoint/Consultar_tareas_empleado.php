<?php
/**
 * Obtiene todas las metas de la base de datos
 */

require '../Classes/Tarea.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $json = file_get_contents ('php://input');
    $datos = json_decode ($json);

    $iduser=$datos->iduser;
    $listaTareas = Tarea::getTareaEmpleado($iduser);
    if ($listaTareas!=-1) {
        # code...
        $rpta = True;
    }
    else{
        $rpta=False;
    }
    if ($rpta) {
        $dic["estado"] = "ok";
        $dic["tareas"] = $listaTareas;
        print json_encode($dic);
    } else {
        print json_encode(array(
            "estado" => "no ok",
            "mensaje" => "Algo fallo"
        ));
    }
}
?>