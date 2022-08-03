Solución utilizando MVC + API
La consigna consiste en convertir un nùmero en nùmero romanos.

1 - Tenemos dos ArraysList de la misma longitud en que cada index de la lista de nùmeros coincide con su equivalente en el array de romanos
2 - Tomamos el nùmero a convertir y comparamos con el primero de la lista de nùmeros, si el nùmero que le pasamos es mayor o igual entonces conformamos nuestra salida con el romano y restamos el número equivalente al número que tratamos de convertir.
Por ejemplo:
263 --> No cumple para 1000,900,500,400. 
263 --> 100 cumple y agregaremos a la salida el equivalente romano 'C' y restamos por 100. 263-100
163 --> 100 cumple y repetimos. 163-100
63  --> 100 100,90,50,40 no cumplen.
63  --> 50 cumple y agregamos el equivalente romano a la salida 'L'. 63-50
13  --> 10 cumple y agregamos el equivalente romano a la salida 'X'. 13-10
3   --> 1 cumple y agregamos el equivalente a la salida 'I'. (3 veces)