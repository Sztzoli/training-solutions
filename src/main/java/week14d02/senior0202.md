A következő feladatban online bevásárlással kapcsolatos staisztikákat kell megoldani.
Minden vásárlás a következőképpen épül fel. Vásárló egyedi azonosítója, a vásárlás egyedi azonosítója majd a rendelt termékek, melyek után zárójelben szerepel azok ára. Ezeket egy fájlban tároljuk. 
Adatok:
```
BK123-1211: bread(200),soda(120),carrot(320)
RA22-112: tomato(300),sugar(100),salt(100),choclate(200)
BK123-111: beer(300),chips(250),potato(300)
RA22-1145: peas(300),yoghurt(200),milk(200),chicken(1300),bread(200)
SM123-11: pork_belly(1200),ketchup(800),corn(250),alufoil(300)
GT23-011: bread(200),tomato(300),salt(100)
RA22-01112: salami(300),sour_cream(250)
SM123-120: dogfood(900),potato(300),tomato(200),chicken(1300),fish(3000),tuna(1200),pasta(200)
BK123-567: corn(200),jam(800),Nutella(1200),cereal(1200)
```
A fájlban egy vásárlóhoz több rendelés is tartozhat. Olvasd be és tárold el a memóriában az adatokat. Fontos, hogy a webáruház ismerje a vásárlóit a vásárlók pedig ismerjék összes vásárlásukat. A fájlban a vásárlások időrendi sorrendben szerepelnek egyénenként. Tehát mindig a legújabb vásárlás van legelöl a listában.
Oldd meg az alábbi feladatokat:
1. Készíts egy metódust, ami visszaadja vásárlási azonosító alapján az adott vásárlás összértékét.
2. Készíts egy metódust, ami egy vásárló alapján visszaadja, hogy az adott vásárló mennyit pénzt költött eddig összesen a webáruházban.
3. Készíts egy metódus, ami a vásárlónak ABC sorrendbe rendezi egy vásárláson belül a termékeket, vásárlás azonosító alapján. (Bónusz: megoldhatod úgy, hogy vagy név vagy ár alapján rendezze annak megfelelően, hogy hogyan hívjuk a metódust.) Fontos, hogy ne rendezzük át az eredeti listát egy másolatot rendezzünk és azt adjuk vissza.
4. Készíts egy metódust, ami visszaadja, adott termék neve alapján, hogy összesen hányat rendeletek belőle a fájl alapján.
5. Készíts statisztikát a rendelt termékekből. Tárold el a termékeket és azt, hogy összesen hány darabot rendeltek belőle. 

 

