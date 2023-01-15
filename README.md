# Space-Invaders en JavaFX

## Description

Ce projet fournit une implantation de base du jeu *Space-Invaders* en *JavaFX*
Pour pouvoir développer votre propre implantation de ce projet, vous devez
en créer une **divergence** en cliquant sur le bouton `Fork` en haut à droite
de cette page.

Lorsque ce sera fait, vous pourrez inviter les membres de votre groupe en tant
que *Developer* pour vous permettre de travailler ensemble sur ce projet.

## Consignes

Vous pouvez retrouver ci-dessous les liens vers les sujets de TP vous guidant
dans le développement de votre projet.

- [Lancement du projet](https://gitlab.univ-artois.fr/enseignements-rwa/modules/but-2/q-dev-2/tp/-/tree/main/TP03)
- [Des patrons de conception dans le *Space-Invaders* (1)](https://gitlab.univ-artois.fr/enseignements-rwa/modules/but-2/q-dev-2/tp/-/tree/main/TP04)
- [Des patrons de conception dans le *Space-Invaders* (2)](https://gitlab.univ-artois.fr/enseignements-rwa/modules/but-2/q-dev-2/tp/-/tree/main/TP05)
- [Des patrons de conception dans le *Space-Invaders* (3)](https://gitlab.univ-artois.fr/enseignements-rwa/modules/but-2/q-dev-2/tp/-/tree/main/TP06)
- [Finalisation du projet *Space-Invaders*](https://gitlab.univ-artois.fr/enseignements-rwa/modules/but-2/q-dev-2/tp/-/tree/main/TP07)

## Aperçu

Le diagramme de classes ci-dessous vous donne un aperçu des fonctionnalités
disponibles dans ce projet.
N'hésitez pas à le mettre à jour dans la version dont vous disposez dans votre
propre projet, afin de permettre à votre enseignant de TP de vous faire des
retours sur vos choix de conception.
Il est en fait au format textuel (comme vous pouvez vous en rendre compte si
vous consulter le texte brut de ce document) et rendu automatiquement par
*GitLab*, ce qui devrez vous faciliter la tâche.

```plantuml
@startuml

!theme plain
top to bottom direction
skinparam linetype ortho

class AbstractMovable {
  # AbstractMovable(SpaceInvadersGame, double, double, Sprite): 
  + isConsumed(): boolean
  + getWidth(): int
  + setX(int): void
  + getX(): int
  + getHorizontalSpeed(): double
  + getXProperty(): DoubleProperty
  + getVerticalSpeed(): double
  + getGame(): SpaceInvadersGame
  + setSprite(Sprite): void
  + equals(Object): boolean
  + isConsumedProperty(): BooleanProperty
  + move(long): boolean
  + setHorizontalSpeed(double): void
  + hashCode(): int
  + getSprite(): Sprite
  + setY(int): void
  + consume(): void
  + getYProperty(): DoubleProperty
  + setVerticalSpeed(double): void
  + isCollidingWith(IMovable): boolean
  + self(): IMovable
  + getSpriteProperty(): ObjectProperty<Sprite>
  + getY(): int
  + getHeight(): int
  - updatePosition(double, double, long, int, int): double
}
class AbstractMovableDecorateur {
  # AbstractMovableDecorateur(IMovable): 
  + consume(): void
  + collidedWith(Tir): void
  + collidedWith(VaisseauJoueur): void
  + getWidth(): int
  + getYProperty(): DoubleProperty
  + getSprite(): Sprite
  + isConsumed(): boolean
  + getXProperty(): DoubleProperty
  + isConsumedProperty(): BooleanProperty
  + move(long): boolean
  + isCollidingWith(IMovable): boolean
  + setX(int): void
  + setY(int): void
  + collidedWith(IMovable): void
  + getHorizontalSpeed(): double
  + collidedWith(VaisseauAlien): void
  + getY(): int
  + setHorizontalSpeed(double): void
  + setVerticalSpeed(double): void
  + getVerticalSpeed(): double
  + getHeight(): int
  + getX(): int
}
class AlienTireIntelligent {
  + AlienTireIntelligent(SpaceInvadersGame): 
  + newStrategy(): IAlienAttaque
  + tir(): boolean
}
class AlienTirePasStrategy {
  + AlienTirePasStrategy(): 
  + tir(): boolean
  + newStrategy(): IAlienAttaque
}
class AlienTireStrategy {
  + AlienTireStrategy(): 
  + tir(): boolean
  + newStrategy(): IAlienAttaque
}
class BonusBomb {
  + BonusBomb(SpaceInvadersGame, double, double, Sprite): 
  + collidedWith(Tir): void
  + collidedWith(VaisseauAlien): void
  + explode(): void
  + collidedWith(BonusBomb): void
  + move(long): boolean
  + collidedWith(IMovable): void
  + collidedWith(TirAlien): void
  + collidedWith(Mur): void
  + collidedWith(VaisseauJoueur): void
}
class BonusPointVie {
  + BonusPointVie(SpaceInvadersGame, double, double, Sprite, double, int): 
  + collidedWith(Mur): void
  + collidedWith(BonusBomb): void
  + collidedWith(VaisseauJoueur): void
  + collidedWith(Tir): void
  + collidedWith(IMovable): void
  + collidedWith(VaisseauAlien): void
  + collidedWith(TirAlien): void
}
class BonusShield {
  + BonusShield(SpaceInvadersGame, double, double, Sprite): 
  + collidedWith(IMovable): void
  + collidedWith(Tir): void
  + collidedWith(Mur): void
  + collidedWith(VaisseauAlien): void
  + collidedWith(VaisseauJoueur): void
  + collidedWith(BonusBomb): void
  + collidedWith(TirAlien): void
}
class DeplacementAlienComposite {
  + DeplacementAlienComposite(SpaceInvadersGame): 
  + getDeplacement(): IDeplacements
}
class DeplacementDiagonale {
  + DeplacementDiagonale(): 
  + getVerticalSpeed(long): double
  + getHorizontalSpeed(long): double
}
class DeplacementNormal {
  + DeplacementNormal(): 
  + getVerticalSpeed(long): double
  + getHorizontalSpeed(long): double
}
class DeplacementVertical {
  + DeplacementVertical(): 
  + getHorizontalSpeed(long): double
  + getVerticalSpeed(long): double
}
class EnsembleAliens {
  + EnsembleAliens(SpaceInvadersGame): 
  + getHorizontalSpeed(): double
  + removeAlien(IMovable): void
  + setVerticalSpeed(double): void
  + getWidth(): int
  + getXProperty(): DoubleProperty
  + collidedWith(Tir): void
  + ajouteAlien(IMovable): void
  + collidedWith(VaisseauJoueur): void
  + getYProperty(): DoubleProperty
  + consume(): void
  + collidedWith(VaisseauAlien): void
  + isConsumed(): boolean
  + getVerticalSpeed(): double
  + setX(int): void
  + move(long): boolean
  + self(): IMovable
  + getSprite(): Sprite
  + collidedWith(BonusBomb): void
  + collidedWith(Mur): void
  + getX(): int
  + getHeight(): int
  + getSpriteProperty(): ObjectProperty<Sprite>
  + isCollidingWith(IMovable): boolean
  + setY(int): void
  + getY(): int
  + setHorizontalSpeed(double): void
  + collidedWith(IMovable): void
  + collidedWith(TirAlien): void
  + isConsumedProperty(): BooleanProperty
  + setSprite(Sprite): void
}
class EtatInvulnerable {
  + EtatInvulnerable(SpaceInvadersGame): 
  + nextStateAfterTime(): IEtatVaisseau
  + handle(): void
  + nextStateAfterShot(): IEtatVaisseau
}
class EtatVulnerable {
  + EtatVulnerable(SpaceInvadersGame): 
  + nextStateAfterTime(): IEtatVaisseau
  + handle(): void
  + nextStateAfterShot(): IEtatVaisseau
}
interface IAlienAttaque << interface >> {
  + tir(): boolean
  + newStrategy(): IAlienAttaque
}
interface IAlienDeplacementComposite << interface >> {
  + getDeplacement(): IDeplacements
}
interface IDeplacements << interface >> {
  + getHorizontalSpeed(long): double
  + getVerticalSpeed(long): double
}
interface IEtatVaisseau << interface >> {
  + nextStateAfterTime(): IEtatVaisseau
  + nextStateAfterShot(): IEtatVaisseau
  + handle(): void
}
interface IMovable << interface >> {
  + collidedWith(TirAlien): void
  + setSprite(Sprite): void
  + setY(int): void
  + getSpriteProperty(): ObjectProperty<Sprite>
  + consume(): void
  + getVerticalSpeed(): double
  + collidedWith(BonusShield): void
  + setHorizontalSpeed(double): void
  + getXProperty(): DoubleProperty
  + getWidth(): int
  + collidedWith(VaisseauJoueur): void
  + getHorizontalSpeed(): double
  + collidedWith(BonusBomb): void
  + getY(): int
  + move(long): boolean
  + getSprite(): Sprite
  + self(): IMovable
  + collidedWith(IMovable): void
  + collidedWith(Tir): void
  + setX(int): void
  + isConsumedProperty(): BooleanProperty
  + getX(): int
  + setVerticalSpeed(double): void
  + getHeight(): int
  + isConsumed(): boolean
  + collidedWith(VaisseauAlien): void
  + collidedWith(Mur): void
  + getYProperty(): DoubleProperty
  + isCollidingWith(IMovable): boolean
}
interface IMovableFactory << interface >> {
  + ensembleAlien(): EnsembleAliens
  + createShip(int, int): IMovable
  + createShot(int, int): IMovable
  + getBonus(): boolean
  + createBonus(int, int): IMovable
  + getNombreBomb(): int
  + createStrongShot(int, int): IMovable
  + setSpriteStore(ISpriteStore): void
  + createMur(int, int): IMovable
  + createAlien(int, int): IMovable
  + getNombreMur(): int
  + setGame(SpaceInvadersGame): void
  + createShotAlien(int, int): IMovable
  + createBomb(int, int): IMovable
}
interface ISpaceInvadersController << interface >> {
  + gameOver(String): void
  + prepare(): void
  + setGame(SpaceInvadersGame): void
  + setSpriteStore(ISpriteStore): void
  + bindLife(IntegerProperty): void
  + reset(): void
  + bindScore(IntegerProperty): void
  + addMovable(IMovable): void
}
interface ISpriteStore << interface >> {
  + getSprite(String): Sprite
}
interface IStateMur << interface >> {
  + getSpriteName(): String
  + getNextState(): IStateMur
}
interface ITirsGeneral << interface >> {
  + tir(): IAlienAttaque
}
class MovableFactory {
  + MovableFactory(): 
  + createStrongShot(int, int): IMovable
  + createShip(int, int): IMovable
  + getBonus(): boolean
  + getNombreMur(): int
  + getNombreBomb(): int
  + createShot(int, int): IMovable
  + createShotAlien(int, int): IMovable
  + createBonus(int, int): IMovable
  + createMur(int, int): IMovable
  + ensembleAlien(): EnsembleAliens
  + setGame(SpaceInvadersGame): void
  + setSpriteStore(ISpriteStore): void
  + createAlien(int, int): IMovable
  + createBomb(int, int): IMovable
}
class MovableFactory2 {
  + MovableFactory2(): 
  + getNombreMur(): int
  + createBonus(int, int): IMovable
  + createShot(int, int): IMovable
  + createShip(int, int): IMovable
  + createMur(int, int): IMovable
  + setSpriteStore(ISpriteStore): void
  + setGame(SpaceInvadersGame): void
  + getNombreBomb(): int
  + getBonus(): boolean
  + createBomb(int, int): IMovable
  + createShotAlien(int, int): IMovable
  + createStrongShot(int, int): IMovable
  + createAlien(int, int): IMovable
  + ensembleAlien(): EnsembleAliens
}
class MovableFactory3 {
  + MovableFactory3(): 
  + getBonus(): boolean
  + getNombreBomb(): int
  + ensembleAlien(): EnsembleAliens
  + createAlien(int, int): IMovable
  + createShip(int, int): IMovable
  + createShot(int, int): IMovable
  + createShotAlien(int, int): IMovable
  + createBomb(int, int): IMovable
  + getNombreMur(): int
  + createBonus(int, int): IMovable
  + setGame(SpaceInvadersGame): void
  + createStrongShot(int, int): IMovable
  + createMur(int, int): IMovable
  + setSpriteStore(ISpriteStore): void
}
class MovableFactory4 {
  + MovableFactory4(): 
  + getNombreBomb(): int
  + createShip(int, int): IMovable
  + getNombreMur(): int
  + setSpriteStore(ISpriteStore): void
  + setGame(SpaceInvadersGame): void
  + ensembleAlien(): EnsembleAliens
  + createShotAlien(int, int): IMovable
  + createBomb(int, int): IMovable
  + getBonus(): boolean
  + createStrongShot(int, int): IMovable
  + createMur(int, int): IMovable
  + createAlien(int, int): IMovable
  + createShot(int, int): IMovable
  + createBonus(int, int): IMovable
}
class Mur {
  + Mur(SpaceInvadersGame, double, double, Sprite): 
  + collidedWith(VaisseauJoueur): void
  + getState(): IStateMur
  + collidedWith(IMovable): void
  + setState(IStateMur): void
  - losesLife(): void
  + collidedWith(Mur): void
  + collidedWith(BonusBomb): void
  + collidedWith(Tir): void
  + collidedWith(TirAlien): void
  + collidedWith(VaisseauAlien): void
}
class MurStateBroken {
  + MurStateBroken(): 
  + getNextState(): IStateMur
  + getSpriteName(): String
}
class MurStateCracked {
  + MurStateCracked(): 
  + getSpriteName(): String
  + getNextState(): IStateMur
}
class MurStateEmpty {
  + MurStateEmpty(): 
  + getNextState(): IStateMur
  + getSpriteName(): String
}
class MurStateNormal {
  + MurStateNormal(): 
  + getNextState(): IStateMur
  + getSpriteName(): String
}
class SpaceInvaders {
  + SpaceInvaders(): 
  + main(String[]): void
  + start(Stage): void
}
class SpaceInvadersAnimation {
  + SpaceInvadersAnimation(SpaceInvadersGame, List<IMovable>): 
  + handle(long): void
  - checkCollisions(): void
  - dropBonus(long): void
  + start(): void
  - moveObjects(long): void
}
class SpaceInvadersController {
  + SpaceInvadersController(): 
  + addMovable(IMovable): void
  + setGame(SpaceInvadersGame): void
  + bindScore(IntegerProperty): void
  + setSpriteStore(ISpriteStore): void
  + prepare(): void
  - addKeyListeners(): void
  + gameOver(String): void
  + bindLife(IntegerProperty): void
  - createBackground(): void
  + setStage(Stage): void
  + reset(): void
}
class SpaceInvadersGame {
  + SpaceInvadersGame(int, int, ISpriteStore, IMovableFactory): 
  + stopMoving(): void
  + getLeftLimit(): int
  + getBottomLimit(): int
  + throwBomb(): void
  + setController(ISpaceInvadersController): void
  + setFactory(IMovableFactory): void
  + removeMovable(IMovable): void
  + getLife(): int
  + getTopLimit(): int
  - createMovables(): void
  + start(): void
  + moveRight(): void
  + alienIsDead(IMovable): void
  + alienReachedPlanet(): void
  - initStatistics(): void
  + fireShotAlien(IMovable): void
  + getRightLimit(): int
  + getMovableObjects(): List<IMovable>
  + prepare(): void
  + playerIsDead(): void
  + placeMur(): void
  + getShip(): IMovable
  + changeFactory(): void
  + getHeight(): int
  + reducePlayerLife(): void
  + addPlayerLife(int): void
  + moveLeft(): void
  + changeMurSprite(Mur): void
  - addMovable(IMovable): void
  - clearAllMovables(): void
  + getNbRemainingAliens(): int
  + getWidth(): int
  + fireShot(): void
  + dropBonus(): void
  + changeDeplacementAlien(VaisseauAlien): void
}
class Sprite {
  + Sprite(Image): 
  + draw(GraphicsContext, int, int): void
  + getWidth(): int
  + getImage(): Image
  + getHeight(): int
}
class SpriteStore {
  - SpriteStore(): 
  - loadImage(String): Image
  + getSprite(String): Sprite
  + getInstance(): SpriteStore
}
class Tir {
  + Tir(SpaceInvadersGame, double, double, Sprite): 
  + collidedWith(Mur): void
  + collidedWith(Tir): void
  + collidedWith(IMovable): void
  + collidedWith(TirAlien): void
  + collidedWith(BonusBomb): void
  + collidedWith(VaisseauJoueur): void
  + move(long): boolean
  + collidedWith(VaisseauAlien): void
}
class TirAlien {
  + TirAlien(SpaceInvadersGame, double, double, Sprite): 
  + collidedWith(VaisseauJoueur): void
  + collidedWith(TirAlien): void
  + move(long): boolean
  + collidedWith(Tir): void
  + collidedWith(IMovable): void
  + collidedWith(BonusBomb): void
  + collidedWith(VaisseauAlien): void
  + collidedWith(Mur): void
}
class TirAlienComposite {
  + TirAlienComposite(SpaceInvadersGame): 
  + newStrategy(): IAlienAttaque
  + tir(): boolean
}
class TirPuissantDecorateur {
  + TirPuissantDecorateur(IMovable): 
  + collidedWith(Mur): void
  + self(): IMovable
  + getSpriteProperty(): ObjectProperty<Sprite>
  + setSprite(Sprite): void
  + collidedWith(TirAlien): void
  + collidedWith(IMovable): void
  + collidedWith(BonusBomb): void
}
class TrucResistantDecorateur {
  + TrucResistantDecorateur(IMovable, boolean): 
  + collidedWith(Tir): void
  + collidedWith(TirAlien): void
  + collidedWith(BonusBomb): void
  + getSpriteProperty(): ObjectProperty<Sprite>
  + collidedWith(Mur): void
  + self(): IMovable
  + collidedWith(BonusShield): void
  + getVieProperty(): IntegerProperty
  + setSprite(Sprite): void
}
class VaisseauAlien {
  + VaisseauAlien(SpaceInvadersGame, double, double, Sprite, IDeplacements, IAlienAttaque): 
  + collidedWith(Mur): void
  + getDeplacement(): IDeplacements
  + move(long): boolean
  + collidedWith(Tir): void
  + setAlienAttack(IAlienAttaque): void
  + changeTirAlien(): void
  + collidedWith(BonusBomb): void
  + collidedWith(VaisseauAlien): void
  + collidedWith(TirAlien): void
  + setDeplacement(IDeplacements): void
  + collidedWith(IMovable): void
  + collidedWith(VaisseauJoueur): void
}
class VaisseauJoueur {
  + VaisseauJoueur(SpaceInvadersGame, double, double, Sprite): 
  + collidedWith(VaisseauJoueur): void
  + collidedWith(BonusBomb): void
  + move(long): boolean
  + collidedWith(IMovable): void
  + collidedWith(TirAlien): void
  + collidedWith(VaisseauAlien): void
  + collidedWith(BonusShield): void
  + collidedWith(Mur): void
  + collidedWith(Tir): void
  + getEtat(): IEtatVaisseau
}

AbstractMovable             -[#008200,dashed]-^  IMovable                   
AbstractMovableDecorateur   -[#008200,dashed]-^  IMovable                   
AlienTireIntelligent        -[#008200,dashed]-^  IAlienAttaque              
AlienTirePasStrategy        -[#008200,dashed]-^  IAlienAttaque              
AlienTireStrategy           -[#008200,dashed]-^  IAlienAttaque              
BonusBomb                   -[#000082,plain]-^  AbstractMovable            
BonusPointVie               -[#000082,plain]-^  AbstractMovable            
BonusShield                 -[#000082,plain]-^  AbstractMovable            
DeplacementAlienComposite   -[#008200,dashed]-^  IAlienDeplacementComposite 
DeplacementDiagonale        -[#008200,dashed]-^  IDeplacements              
DeplacementNormal           -[#008200,dashed]-^  IDeplacements              
DeplacementVertical         -[#008200,dashed]-^  IDeplacements              
EnsembleAliens              -[#008200,dashed]-^  IMovable                   
EtatInvulnerable            -[#008200,dashed]-^  IEtatVaisseau              
EtatVulnerable              -[#008200,dashed]-^  IEtatVaisseau              
MovableFactory              -[#008200,dashed]-^  IMovableFactory            
MovableFactory2             -[#008200,dashed]-^  IMovableFactory            
MovableFactory3             -[#008200,dashed]-^  IMovableFactory            
MovableFactory4             -[#008200,dashed]-^  IMovableFactory            
Mur                         -[#000082,plain]-^  AbstractMovable            
MurStateBroken              -[#008200,dashed]-^  IStateMur                  
MurStateCracked             -[#008200,dashed]-^  IStateMur                  
MurStateEmpty               -[#008200,dashed]-^  IStateMur                  
MurStateNormal              -[#008200,dashed]-^  IStateMur                  
SpaceInvadersController     -[#008200,dashed]-^  ISpaceInvadersController   
SpriteStore                 -[#008200,dashed]-^  ISpriteStore               
Tir                         -[#000082,plain]-^  AbstractMovable            
TirAlien                    -[#000082,plain]-^  AbstractMovable            
TirAlienComposite           -[#008200,dashed]-^  IAlienAttaque              
TirPuissantDecorateur       -[#000082,plain]-^  AbstractMovableDecorateur  
TrucResistantDecorateur     -[#000082,plain]-^  AbstractMovableDecorateur  
VaisseauAlien               -[#000082,plain]-^  AbstractMovable            
VaisseauJoueur              -[#000082,plain]-^  AbstractMovable            
@enduml
```

## Fonctionnement
- Appuyer sur la flèche du haut pour placer un mur au dessus du joueur (3 par manche)
- Appuyer sur la flèche du bas pour placer un bonus bombe au dessus du joueur. tirer sur celui-ci pour qu'il s'arrete et s'active (2 par manche)
