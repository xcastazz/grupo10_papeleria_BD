# Retroalimentación — Laboratorio 1: Codificación del diseño OO

**Grupo:** Grupo10 · **Proyecto:** Papelería
**Fecha límite:** 2026-09-08 23:59 · **Versión revisada:** commit `5e9a8a8`

## Nota

| Criterio | Peso | Nota (0-5) |
|---|---|---|
| El código sigue el diagrama UML | 60% | 3.0 |
| Pruebas: creación de objetos en el programa | 20% | 2.5 |
| Buenas prácticas de programación | 20% | 3.5 |
| **Nota del laboratorio** | | **3.00** |

La nota se calcula así: 60% diseño UML + 20% pruebas + 20% buenas prácticas.

## 1. El código sigue el diagrama UML (3.0)
**Lo que hicieron bien:**
- Las clases del dominio están en `src/model/domain/`, y la clase de prueba y `Main` están por fuera, como se acordó.
- Existen las ocho clases del diagrama con los nombres correctos.
- `Producto` es abstracta, implementa `Vendible`, protege sus atributos con `private` y valida que el precio y el stock tengan sentido.
- `calcularPrecioFinal()` está bien en los dos tipos de producto: 8% de recargo en `ProductoOficina` y 10% de descuento para primaria en `ProductoEscolar`.
- `Venta` guarda su lista de `ItemVenta`, y cada `ItemVenta` apunta a un `Producto`, como pide el diagrama.

**Lo que pueden mejorar:**
- `vender()` debía escribirse una sola vez en `Producto`, igual para todos. El método que cada tipo de producto resuelve a su manera es `calcularPrecioFinal()`. Ustedes lo hicieron al revés: dejaron `vender()` abstracto y lo escribieron dos veces, y ahí aparecieron errores:
  - En `ProductoOficina`, la condición del stock está invertida: rechaza las ventas que sí se pueden hacer y acepta las que dejan el stock en negativo.
  - En `ProductoEscolar`, vender exactamente todo el stock da error, cuando debería permitirse.
- A `Pedido` le faltan getters y setters, y no hay forma de asignarle su `Proveedor`.
- A `ItemVenta` le faltan getters para la cantidad y el producto. Además, su constructor imprime en consola; un constructor solo debería crear el objeto.

## 2. Pruebas: creación de objetos (2.5)
**Lo que hicieron bien:**
- `PruebaCreacionObjetos` existe y funciona cuando alguien escribe los datos: crea un producto escolar y uno de oficina, los agrega a una venta y muestra el resultado.

**Lo que pueden mejorar:**
- La prueba depende de `Scanner`. Cuando el programa se ejecuta sin que nadie escriba datos, se detiene con un error. Es mejor crear los objetos directamente en el código, por ejemplo `new ProductoOficina(...)`.
- Nunca se llama a `calcularPrecioFinal()`, que es el método que debía mostrar que los dos tipos de producto se comportan distinto.
- Hay un `sc.nextLine()` de más que se salta una línea de lo que escribe el usuario.

## 3. Buenas prácticas (3.5)
**Lo que hicieron bien:**
- Los commits tienen mensajes que explican qué se hizo.
- En general, los nombres siguen las costumbres de Java (clases con mayúscula inicial, métodos y variables en `camelCase`).

**Lo que pueden mejorar:**
- Todos los commits de esta entrega los hizo un solo integrante. Repartan el trabajo para que todos aporten código.
- Algunos nombres de variables no dicen qué guardan, como `p_vA`, `Qu`, `nn`, `ph` o `cP`.

## ¿El programa funciona?
Sí compila. Funciona si alguien escribe los datos a mano, pero se detiene con un error cuando se ejecuta sin que nadie escriba datos. Además, las ventas en `ProductoOficina` dan resultados equivocados.

## Para el próximo laboratorio
- Revisen en el diagrama qué método queda sin implementar en la clase abstracta y dejen `vender()` una sola vez en `Producto`.
- Prueben las condiciones (`>`, `<`, `>=`) con casos límite, como vender exactamente todo el stock.
- Escriban la prueba creando los objetos directamente en el código y llamen a `calcularPrecioFinal()` en cada tipo de producto.
- Completen getters, setters y validaciones en `Pedido` e `ItemVenta`.
- Repartan los commits entre todos los integrantes.

---

## Plan de mejora organizado (acción directa)

### Prioridad 1 — Corregir lógica y estructura UML
Objetivo: que el código respete el diseño y no falle en casos de stock.

- En `Producto`, dejar `vender()` implementado una sola vez (comportamiento común).
- En `ProductoOficina` y `ProductoEscolar`, mantener la especialización en `calcularPrecioFinal()`.
- Corregir validación de stock en `ProductoOficina` (hoy está invertida).
- Permitir en `ProductoEscolar` vender exactamente todo el stock (caso límite `== stock`).

### Prioridad 2 — Ajustar la prueba de creación de objetos
Objetivo: que la prueba ejecute sin entrada manual y demuestre polimorfismo.

- Quitar dependencia de `Scanner` en `PruebaCreacionObjetos`.
- Crear objetos directamente en código con constructores (`new Producto...`).
- Llamar explícitamente `calcularPrecioFinal()` para ambos tipos de producto.
- Eliminar el `nextLine()` sobrante.

### Prioridad 3 — Completar encapsulamiento faltante
Objetivo: cumplir UML y facilitar uso correcto de clases.

- `Pedido`: agregar getters/setters faltantes y forma de asignar su `Proveedor`.
- `ItemVenta`: agregar getters de cantidad y producto.
- Quitar impresiones en consola desde constructor de `ItemVenta`.

### Prioridad 4 — Mejora de calidad del código y trabajo en equipo
Objetivo: mejorar mantenibilidad y evidencia de colaboración.

- Renombrar variables poco descriptivas (`p_vA`, `Qu`, `nn`, `ph`, `cP`).
- Repartir commits entre integrantes (evitar autor único en la entrega).

## Checklist de cierre (antes de entregar)

1. `vender()` existe una sola vez en `Producto`.
2. Casos límite de stock probados (`<`, `==`, `>`).
3. Prueba corre sin `Scanner`.
4. `calcularPrecioFinal()` invocado en producto escolar y de oficina.
5. `Pedido` e `ItemVenta` con getters/setters requeridos.
6. Sin `System.out.println` en constructores.
7. Variables con nombres claros.
8. Commits distribuidos entre todos los integrantes.
