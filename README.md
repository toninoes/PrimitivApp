# PrimitivApp
Mi primera App Android. Muy simple si, pero le tengo bastante cariño. Disponible para su instalación en: [Google Play](https://play.google.com/store/apps/details?id=es.uca.primitivapp).

Esta App genera combinaciones de números aleatorios para el juego de la primitiva pero con la particularidad que se centra en elegir combinaciones de números con las características históricamente más frecuentes. Descartando combinaciones con características poco frecuentes.

Para ello se ha consultado el apartado "Estadísticas del Juego" de la web de Loterías y Apuestas del Estado y hemos podido comprobar que las combinaciones que más se repiten cumplen que:

- Tienen tres números pares y por tanto tres impares.
- No hay ningún número consecutivo.
- El sumatorio de los seis números está entre 141 y 150.
- Dos de sus números tienen la misma terminación, los demás tienen terminaciones diferentes.
- Tienen tres números bajos (1-25) y tres números altos (26-49).
- Dos números en la misma decena, otros dos números en otra decena y el resto en decenas diferentes.

Ni que decir tiene que esto no garantiza nada, sólo garantizar que no aparecerán combinaciones de números cuyo patrón jamás o muy pocas veces ha salido.



