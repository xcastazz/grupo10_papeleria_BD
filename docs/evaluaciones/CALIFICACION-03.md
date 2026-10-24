# Retroalimentación — Laboratorio de Pilas y Colas

**Grupo:** Grupo10 · **Proyecto:** Papelería

## Nota

| Pilas | Puntos | Colas | Puntos |
|---|---|---|---|
| `Pila<T>` correcta | 6 / 30 | `Cola<T>` correcta | 28 / 30 |
| Casos límite | 0 / 10 | Casos límite | 7 / 10 |
| Integración en el `Service` | 12 / 30 | UML y entidad dueña | 14 / 15 |
| Menú en `view/` | 9 / 15 | Integración en el `Service` | 22 / 25 |
| Buenas prácticas | 6 / 15 | Menú en `view/` | 7 / 10 |
| | | Buenas prácticas | 4 / 10 |
| **Total Pilas** | **33 / 100** | **Total Colas** | **82 / 100** |

**Nota del laboratorio: 2.88**

La nota es el promedio de los dos totales (33 y 82) dividido entre 20.

## Pilas

**Lo que hicieron bien:**
- La pila vive en `VentasService`, como pide la Papelería, y la `View` no conoce la estructura.
- `listarOperaciones` usa una pila auxiliar y devuelve texto, y `rechazarVenta` restaura el stock sin volver a apilar.
- El menú usa `ConsoleUtils`, sin `Scanner` ni `try/catch`.

**Lo que pueden mejorar:**
- `push` está mal: el nodo nuevo se enlaza consigo mismo en vez de al tope anterior, así que se pierden los elementos de abajo, y el tamaño sube de dos en dos. Primero se enlaza al tope actual y después se mueve el tope.
- `pop` devuelve el nodo que queda debajo en lugar del dato retirado, y `peek` devuelve el nodo, no el dato.
- Con la pila vacía solo imprimen un mensaje y luego el programa falla con `NullPointerException`. Debe lanzar `IllegalStateException` con mensaje. `push(null)` debe lanzar `IllegalArgumentException`.
- Los métodos del `Service` no siguen el contrato: `consultarUltimaOperacion` devuelve `null` y `rechazarVenta` no devuelve la venta deshecha. Como `push` falla, listar tampoco conserva bien las ventas.
- `sinOperacionesPorDeshacer` mezcla "pila vacía" con "venta ya confirmada" e imprime mensajes. Esa pregunta debe ser solo si la pila está vacía.
- El menú no tiene una opción por cada operación (contar y listar van juntas) y las ventas se confirman por separado.

## Colas

**Lo que hicieron bien:**
- `Cola<T>` funciona: orden de llegada correcto, `frente` y `fin` quedan bien al vaciarla y se puede encolar de nuevo.
- `dequeue` y `front` lanzan `NoSuchElementException` con mensaje.
- `PedidosPendientes` sigue el diagrama: descripción validada, cola privada creada en el constructor, `getFila()` y sin `setFila`.
- `ProveedorService` tiene los cinco métodos más `listarEnEspera`, que rota la fila y la deja igual. El menú revisa si hay pedidos antes de atender.

**Lo que pueden mejorar:**
- `enqueue(null)` se acepta; debe lanzar `IllegalArgumentException`.
- `Cola` tiene `setFront` y `setBack` públicos, que dejan romper la fila desde afuera.
- La opción 5 del menú ("Cantidad en espera") muestra `true` o `false`; debe llamar a `contarEnEspera` y mostrar el número.
- `registrarLlegada` encola siempre el último pedido del proveedor, así que el mismo pedido puede quedar repetido en la fila. El listado solo muestra la categoría.

## Buenas prácticas

- No existen las ramas `feature/pila-en-el-proyecto` ni `feature/cola-en-el-proyecto`. Se trabajó en una sola rama larga (`clases_y_atributos`) fusionada con pull requests.
- Hay pocos commits y muy grandes. Los dos laboratorios quedaron en pocos commits con mensajes largos, no uno por parte.
- Nombres poco claros: la pila se llama `queueVentas` y la lista de proveedores `matrizProveedor`; hay métodos con mayúscula inicial (`MostrarItemVenta`).

## Estructura de carpetas

No siguieron la estructura acordada en clase: `Nodo`, `ListaSimple`, `Pila` y `Cola` están en `src/structures/` y deben ir en `src/model/structures/`.
