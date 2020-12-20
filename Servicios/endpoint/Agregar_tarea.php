<?php
/**
 * Obtiene todas las metas de la base de datos
 */

require '../Classes/Tarea.php';

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $json = file_get_contents ('php://input');
    $datos = json_decode ($json);
    $idtarea=$datos->idtarea;
    $tit=$datos->titulo;
    $est=$datos->estado;
    $pri=$datos->prioridad;
    $des=$datos->descripcion;
    $idreq=$datos->idrequerimiento;
    $idemp=$datos->idempleado;

    // Manejar petición GET
    $rpta = Tarea::insertarTarea($idtarea,$tit,$est,$pri,$des,$idreq,$idemp);

    if ($rpta) {
        $dic["estado"] = "ok";
        $dic["mensaje"] = "Funcion el insert";
        print json_encode($dic);
    } else {
        print json_encode(array(
            "estado" => "no ok",
            "mensaje" => "NO se podido insertar"
        ));
    }
}
?>