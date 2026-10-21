# Registro XP - Equipo ___
Repositorio: https://github.com/Alejandro0122/Team_Bravo.git
Integrantes y usuarios GitHub:
* Lenin Alexander Amangandi LLumiguano  — @Lenin27Amangandi
* Camila Daniela Caicedo Alcivar — @dxcam
* Marco Alejandro Marcillo Molina — @Alejandro0122
* Francisco Jesus Ulloa Caisaguano — @FUSHAR


## Cliente y objetivo de valor
**¿Qué necesidad de negocio resuelve este incremento? (máx. 2 líneas)**

Evitar conflictos al reservar una única sala de estudio con bloques A, B y C. Entregar registro y cancelación de reservas con
controles de disponibilidad y titularidad.

## Valores XP observables
**Registre dos decisiones reales del equipo que reflejen comunicación, simplicidad, retroalimentación, coraje o respeto.**

1. Dividir el trabajo en dos parejas según la capacidad para realizar las tareas de cada uno para un mejor rendimiento y comunicación del equipo, asignando HU-01 a Marco Marcillo y Francisco Ulloa, y HU-02 a Lenin Amangandi y Camila Caicedo.
2. Revisar el código y las pruebas de la otra pareja mediante los commits realizados en las ramas, corregir los problemas detectados y mantener una implementación simple que cumpla con los requisitos.

## Responsabilidades flexibles
* Pareja 1 (HU-01): Marco Marcillo / Francisco Ulloa | Pareja 2 (HU-02):
* Lenin Amangandi / Camila Caicedo
* Facilitación: ___ 
* Seguimiento: __
* Consulta al cliente: ___
Las responsabilidades pueden cambiar durante el examen.

## Historias, aceptación y estimaciones
| Historia | Prioridad | Estimación relativa | Criterios de aceptación | Tareas |
|---|---|---|---|---|
| HU-01: Registrar una reserva | Alta | 12 | Reservar un bloque válido (A, B o C) que esté libre devuelve true. Si el bloque está ocupado, devuelve false y conserva al titular original. Las entradas inválidas se rechazan sin modificar el estado. |  Escribir pruebas JUnit; implementar la reserva; validar bloque e identificador; ejecutar pruebas; crear rama feature/hu01; abrir PR.|
| HU-02: Cancelar una reserva | Baja | 10 | El titular puede cancelar su propia reserva y liberar el bloque; devuelve true. Si el bloque está libre o pertenece a otra persona, devuelve false sin cambiar el estado. Los datos inválidos se rechazan. | Escribir pruebas JUnit; implementar la cancelación; validar titularidad y bloque; ejecutar pruebas; crear rama feature/hu02; abrir PR. |

## Tablero mínimo
| Por hacer | En curso | Terminado |
|---|---|---|
| HU1 | | |

## Prácticas técnicas
* Evidencia RED (prueba inicial que falla, momento o commit)
  * HU-01: c20eafa175c1d3dc720fc23a871788f9a3891df6
  
    feat: HU01 implementación de reserva y pruebas JUnit
  * HU-02: 8fd65d048d5642324bf855efae91c08baf09bd82
  
     feat: HU02 cancela con pruebas
  * HU-01:
  * HU01 RED_TDD_Cambio:
  * 59ade281f30611a0c52f5222d06f21e2fe691e2b


* Evidencia GREEN (prueba que pasa después, momento o commit):

  * HU-01: bb041681ebbd410c8da4e9c139f3ae452872c8b1
  
    feat: HU01 GREEN_TDD_Cambio

  * HU-02: 
  f722ef663495bf9b31328935f3e77c2971c87240
  
    feat: HU02 PRUEBA VERDE


  
* Refactorización o decisión de simplicidad:

## Git / revisión / CI
PR HU-01: ... | Revisor distinto del autor: ...
PR HU-02: ... | Revisor distinto del autor: ...
Resultado Actions (éxito/fallo/no disponible): ... | URL de ejecución: ...

## Cambio del cliente (completar SOLO cuando se anuncie)
* ID: CR-01
* Cliente: Unidad académica de salas de estudio
* Nueva historia: HU-03 — Limitar a una reserva activa por estudiante.
* Nueva regla: Un mismo estudiante no puede mantener más de una reserva activa entre los bloques A, B y C. Si ya tiene una reserva activa, cualquier intento de reservar otro bloque debe devolver false. La restricción se aplica por estudiante, sin impedir que estudiantes distintos reserven bloques libres.
* Criterios de aceptación:
1. Si E01 tiene reservado el bloque A, su intento de reservar B debe devolver false y no modificar ninguna reserva existente.
2. Si E02 intenta reservar B y está libre, la operación debe devolver true, aunque E01 tenga reservado A.
3. Si E01 cancela correctamente su reserva de A, podrá reservar B si está libre.
4. No se debe sobrescribir una reserva ocupada ni permitir que un estudiante distinto cancele una reserva ajena.
5. Pruebas HU-01 y HU-02 funcionando.
* Impacto en pruebas/código: ... | 
* Prioridad revisada: Alta
* Decisión del equipo y estado final: Revisar el alcance del cambio y actualizará las tareas del tablero. Se intentará primero una prueba nueva que falle (RED), luego se modificará el código hasta que pase (GREEN) y se volverán a ejecutar las pruebas existentes. El estado final se actualizará según la implementación y las pruebas realmente completadas.

## Cierre
Historias aceptadas, pendientes conocidos y siguiente mejora concreta (máx. 3 líneas):
