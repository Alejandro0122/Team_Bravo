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
| | | HU-01 (Alta de reserva) |
| | | HU-02 (Baja/Cancelación) |
| | | CR-01 / HU-03 (Límite de 1 reserva) |

---

## Prácticas técnicas
- **Evidencia RED (Prueba inicial que falla, momento o commit):**
  * **HU-01:** `c20eafa175c1d3dc720fc23a871788f9a3891df6` — *feat: HU01 implementación de reserva y pruebas JUnit*
  * **HU-02:** `8fd65d048d5642324bf855efae91c08baf09bd82` — *feat: HU02 cancela con pruebas*
  * **HU-03 (Cambio del cliente / RED_TDD):** `59ade281f30611a0c52f5222d06f21e2fe691e2b` — *test: HU03 prueba TDD RED limite de reserva activa por estudiante*

- **Evidencia GREEN (Prueba que pasa después, momento o commit):**
  * **HU-01:** `bb041681ebbd410c8da4e9c139f3ae452872c8b1` — *feat: HU01 GREEN_TDD_Cambio*
  * **HU-02:** `f722ef663495bf9b31328935f3e77c2971c87240` — *feat: HU02 PRUEBA VERDE*
  * **HU-03 (Cambio del cliente / GREEN_TDD):** Commit de ajuste de lógica en `BookingPolicy.java` con validación de `containsValue(studentId)`.

- **Refactorización o decisión de simplicidad:**
  * Se mantuvo el diseño simple y desacoplado utilizando la estructura base en `BookingPolicy.java` y `CancellationPolicy.java` para evitar conflictos de *merge* entre parejas.
  * La regla de límite de reserva (CR-01) se implementó de forma directa utilizando `ownerBySlot.containsValue(studentId)` para evitar iteraciones complejas o estructuras de datos innecesarias en memoria.

---

## Git / revisión / CI
- **PR HU-01:** [#1](https://github.com/Alejandro0122/Team_Bravo/pulls) | **Revisor distinto del autor:** Integrante de la Pareja 2 (Revisión cruzada realizada y aprobada)
- **PR HU-02:** [#2](https://github.com/Alejandro0122/Team_Bravo/pulls) | **Revisor distinto del autor:** Integrante de la Pareja 1 (Revisión cruzada realizada y aprobada)
- **Resultado Actions (éxito/fallo/no disponible):** Éxito (Marca verde) | **URL de ejecución:** https://github.com/Alejandro0122/Team_Bravo/actions

---

## Cambio del cliente
- **ID:** CR-01
- **Cliente:** Unidad académica de salas de estudio
- **Nueva historia:** HU-03 — Limitar a una reserva activa por estudiante.
- **Nueva regla:** Un mismo estudiante no podrá mantener más de una reserva activa en cualquiera de los bloques A, B o C. Si ya tiene una reserva activa, cualquier intento de reservar otro bloque debe devolver `false`. La restricción se aplica por estudiante, sin impedir que estudiantes distintos reserven bloques libres.
- **Criterios de aceptación:**
  1. Si E01 tiene reservado el bloque A, su intento de reservar B debe devolver `false` y no modificar ninguna reserva existente.
  2. Si E02 intenta reservar B y está libre, la operación debe devolver `true`, aunque E01 tenga reservado A.
  3. Si E01 cancela correctamente su reserva de A, podrá reservar B si está libre.
  4. No se debe sobrescribir una reserva ocupada ni permitir que un estudiante distinto cancele una reserva ajena.
  5. Pruebas HU-01 y HU-02 funcionando correctamente sin regresiones.
- **Impacto en pruebas/código:** Se agregaron pruebas JUnit específicas para validar la restricción por estudiante (fase RED) y se actualizó `BookingPolicy.java` para verificar reservas previas activas antes de registrar una nueva (fase GREEN).
- **Prioridad revisada:** Alta
- **Decisión del equipo y estado final:** Se aceptó el cambio, se aplicó TDD (fase RED seguida de GREEN) y se integró a la rama principal `main` tras verificar que la suite completa de pruebas pase exitosamente.

---

## Cierre
**Historias aceptadas, pendientes conocidos y siguiente mejora concreta:**
Todas las historias (HU-01, HU-02 y HU-03/CR-01) fueron integradas y probadas exitosamente en `main`. Como pendiente conocido no existen bloqueos funcionales en memoria; la siguiente mejora concreta sería incorporar persistencia en base de datos y un selector visual de horarios.

**Repositorio:** https://github.com/Alejandro0122/Team_Bravo/tree/main/Proyecto_Java_Maven_Generico