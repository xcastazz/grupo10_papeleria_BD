# Retroalimentación — Laboratorio Lista Simple (Momento 2)

**Grupo:** Grupo10 · **Proyecto:** Papelería

## Nota

| Criterio | Peso | Nota (0-5) |
|---|---|---|
| Identificación de las relaciones uno-a-muchos | 20 % | 1.5 |
| `ListaSimple<T>` integrada al `Service` | 30 % | 2.0 |
| Menú en consola funcional | 15 % | 2.5 |
| Reemplazo del arreglo previo, sin código muerto | 20 % | 1.0 |
| Buenas prácticas (commits y nombres) | 15 % | 3.5 |
| **Nota del laboratorio** | | **2.00** |

La nota se calcula así: 20% relaciones + 30% integración al Service + 15% menú + 20% reemplazo del arreglo + 15% buenas prácticas.

## 1. Identificación de las relaciones uno-a-muchos (1.5)
**Lo que hicieron bien:**
- Usaron `ListaSimple<T>` en dos lugares reales del proyecto: la lista de proveedores y la lista de productos.

**Lo que pueden mejorar:**
- Esas dos listas son el "catálogo" general que guarda cada `Service`, no una relación entre dos entidades. La tarea pedía que una entidad tuviera muchas de otra, por ejemplo un `Proveedor` con muchos `Pedido`, o una `Venta` con muchos `ItemVenta`.
- Esas relaciones sí existen en su diagrama, pero no las convirtieron en listas.

## 2. `ListaSimple<T>` integrada al `Service` (2.0)
**Lo que hicieron bien:**
- `StockService` y `ProveedorService` usan `insertarFinal`, `buscarPorIndice` y `eliminar` de su lista.
- La vista (`MenuListaView`) solo habla con los `Service`, nunca con la lista.

**Lo que pueden mejorar:**
- `Proveedor` no tiene un atributo `ListaSimple<Pedido>`. El método `registrarPedido` crea el `Pedido` y lo pierde: nadie lo guarda.
- Además, en el constructor de `Proveedor` se crea un pedido "Recien creado" que tampoco se guarda en ningún lado.

## 3. Menú en consola (2.5)
**Lo que hicieron bien:**
- El menú permite registrar, buscar, listar y eliminar proveedores y productos, y también vender.

**Lo que pueden mejorar:**
- No hay opciones para agregar, buscar o eliminar `Pedido` de un proveedor, ni `ItemVenta` de una venta, que era lo que se quería probar.
- Al actualizar el teléfono de un proveedor se llama por error al método que cambia el nombre, así que el teléfono nunca cambia.
- Algunos mensajes dicen "Cliente" o "Producto" cuando hablan de proveedores.

## 4. Reemplazo del arreglo previo, sin código muerto (1.0)
**Lo que pueden mejorar:**
- `Venta` sigue guardando sus ítems en un `ArrayList<ItemVenta>`; debía pasar a `ListaSimple<ItemVenta>`.
- `Proveedor` tiene `import java.util.ArrayList` y `java.util.List` que no usa.
- La clase `Pila` y el menú de venta que no usa `Venta` quedan como piezas sueltas sin conexión con el resto.

## 5. Buenas prácticas (3.5)
**Lo que hicieron bien:**
- Trabajaron en una rama aparte y la integraron a `main` con merges; hubo varios commits repartidos en el tiempo con mensajes que explican el cambio.
- Los nombres de clases y métodos siguen en general las convenciones de Java.

**Lo que pueden mejorar:**
- Hay variables y parámetros que empiezan en mayúscula (`Nuevo`, `NombreProveedor`, `Cantidad`) y la lista de `ProveedorService` se llama `matrizProveedor`, aunque no es una matriz.
- No siguieron la estructura de carpetas acordada en clase: `Nodo`, `ListaSimple` y las demás estructuras están en `src/structures/` y debían estar en `src/model/structures/`.

## ¿El programa funciona?
Sí, compila y el menú corre sin errores al registrar, listar y buscar. Lo que falta es que las relaciones uno-a-muchos (pedidos y ítems de venta) estén realmente en listas y se puedan probar desde el menú.

## Para el próximo laboratorio
- Agreguen a `Proveedor` un atributo `ListaSimple<Pedido>` y guarden ahí cada pedido que se registre.
- Cambien el `ArrayList` de `Venta` por `ListaSimple<ItemVenta>` y ajusten el código que lo usa.
- Añadan al menú opciones para agregar, listar y eliminar pedidos e ítems de venta, pasando siempre por el `Service`.
- Corrijan la actualización del teléfono y quiten los imports y clases que no se usan.
- Muevan `structures` a `model/structures`.
