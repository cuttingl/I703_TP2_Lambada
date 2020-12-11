# TP 2 Compilation : Génération d'arbres abstraits
## Cutting Laurent


## Exercice 1 : realisé
tester avec l'expression suivante :
```
let prixHt = 200;
let prixTtc =  prixHt * 119 / 100 .
```
et vous devriez obtenir qqch comme ceci :
```
(; ( let  prixHt 200 )( let  prixTtc (/ (* prixHt 119 )100 )))
```

## Exercice 2 : non realisé

---
# TP 3 Compilation : Génération de code assembleur depuis un arbre

## Exercice 1 : realisé

tester avec l'expression suivante :
```
let prixHt = 200;
let prixTtc =  prixHt * 119 / 100 .
```

et vous devriez obtenir dans un fichier le résultat suivant: \
[assembleur](arbre.ASM)
## Exercice 2 : non realisé
