Adott egy fájl melyben pizza rendeléseket tárolunk. A fájl blokkokra van osztva, egy blokk egy napot jelöl, és minden ilyen blokk egy dátummal kezdődik. Ezután egy rendelés adatai két sorban találhatók. Az első sor a futár azonosítója, a második sorban irányítószám, utcanév, házszám és a szállítás pontos ideje található.

```
2020.12.01
FUT_1
1113 Petőfi 12 12:30
FUT_2
1114 Kossuth 9 11:20
FUT_2
1211 Jókai 10 19:30
FUT_3
1191 Kossuth 9 18:12
FUT_1
1144 Tököly 11 16:33
2020.12.02
FUT_1
1123 Ady 12 12:30
....
```

A fájl beolvasása után oldjátok meg a következő feladatokat!
1. Melyik napon volt a legkevesebb rendelés?
2. Egy metódus várjon paraméterül egy dátumot, pontos időponttal és adjuk vissza a hozzá tartozó rendelést. Ha nincs ilyen akkor dobjunk kivételt. (Vagy Optional)
3. Készíts statisztikát a futárok szállításiból, futáronként add vissza, hogy mennyi rendelést teljesítettek. 
4. Melyik címre szállították a legtöbb pizzát? 

