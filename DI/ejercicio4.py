"""
Un metodo para cada sala:
    def salaCentral()
    def salaNorte()
    def salaSur()
    def salaEste()
    def salaOeste()

Un método de muerte para que cambiar el mensaje de muerte sea más rápido
    def perder()

Un booleano que marcara si sigues jugando

Otro método para cambiar de sala
    def nuevaSala()

Una lista que contenga las salas que quedan sin vencer

Un metodo que imprima las salas que queden
    def imprimirsalas()

Una lista para los acertijos y otra con sus soluciones con un numero random que escoja el acertijo
Lo mismo para las preguntas de la sala oeste

Un metodo que describa cómo funciona el juego
"""


from random import randint
import time
def describirJuego():
    print("Te encuentras en la sala del medio de una mazmorra, rodeado de otras 4 salas. Una al norte, otra al sur, otra al oeste y otra al este. Para lograr salir de la mazmorra debes superar todas las salas con vida.")
jugar = True
salas = ["Norte","Sur","Este","Oeste"]
acertijos = ["Hay algo que, aunque te pertenezca, la gente siempre lo utiliza más que tú. ¿Qué es? (Respuesta = Nombre)",
            "Crezco a pesar de no estar vivo. No tengo pulmones, pero para vivir necesito el aire. El agua, aunque no tenga boca, me mata. ¿Qué soy? (Respuesta = Fuego)",
            "Estando roto es más útil que sin romperse. ¿Qué es? (Respuesta = Huevo)",
            "Aparato que te metes en la boca unas 3 veces al día. ¿Qué es? (Respuesta = Cepillo)",
            "Las personas siempre duermen menos en un mes del año. ¿Cuál es este mes? (Respuesta = Febrero)",
            "Estoy en todo pese a estar en nada. ¿Qué soy? (Respuesta = D)",
            "Te paras cuando está verde y continúas cuando está rojo. ¿Qué es? (Respuesta = Sandia)",
            "¿Qué monte era el más alto del mundo antes de descubrir el Everest? (Respuesta = Everest)",
            "La señora y el señor Sánchez tienen 6 hijos barones. Cada hijo baron tiene una hermana. ¿Cuántas personas hay en la familia Sánchez? (Respuesta = 9)",
            "Soy alto siendo joven y corto cuando soy viejo. Resplandezco con la vida y el viento es mi mayor enemigo. ¿Qué soy? (Respuesta = Vela)"]
respuestasAcertijos = ["Nombre","Fuego","Huevo","Cepillo","Febrero","D","Sandia","Everest","9","Vela"]

preguntas = ["¿Cuál es el río más largo de España? (Respuesta = Ebro)",
            "¿Cuál es el río más largo de la península ibérica? (Respuesta = Tajo)",
            "¿Cuál es el río más largo del mundo? (Respuesta = Amazonas)",
            "¿Cuál es la montaña más alta de España? (Respuesta = Teide)",
            "¿Cuál es la montaña más alta del mundo? (Respuesta = Everest)",
            "¿Cuál es el océano más grande? (Respuesta = Pacifico)",
            "¿Cuál es el país con más extensión? (Respuesta = Rusia)",
            "¿Cuál es el país más poblado? (Respuesta = India)"]
respuestasPreguntas = ["Ebro","Tajo","Amazonas","Teide","Everest","Pacifico","Rusia","India"]

def imprimirSalas():
    print("Salas restantes: ")
    for l in salas:
        print(l)
def reiniciarSalas():
    salas.clear()
    salas.append("Norte")
    salas.append("Sur")
    salas.append("Este")
    salas.append("Oeste")

def perder():
    return input("Quieres volver a intentarlo? S/N: ")

def salaMedio():
    print("Volviendo a la sala del medio...")
def nuevaSala():
    return input("Elija nueva sala:")
def salaNorte():
    perderBooleano = False
    while(perderBooleano == False):
        ataque = randint(0,100)
        print("Ataque: " + str(ataque))
        if(ataque > 90):
            print("Has muerto por lo que se reinicia el juego.")
            reiniciarSalas()
            return perder() # pregunto o no?
        respuesta = input("¿Quieres defenderte? S/N: ")
        if(respuesta == "S"):
            defensa = randint(0,100)
            print("Defensa: " + str(defensa))
            if(defensa < 60):
                perderBooleano = True
                print("La defensa ha fallado. Vas a ser atacado de nuevo.")
            else:
                print("Enhorabuena, has vencido al jefe.")
                salas.remove("Norte")
                return "N"
        else:
            return "N"
def salaSur():
    numAcertijo = randint(0,9)
    print(str(acertijos[numAcertijo]))
    respuesta = input("Respuesta: ")
    if(respuestasAcertijos[numAcertijo].lower() in respuesta.lower()):
        print("Enhorabuena, has acertado.")
        salas.remove("Sur")
        return "N"
    else:
        return perder()
def salaEste():
    numero = randint(1,100)
    print(numero)
    if(numero > 60):
        print("Enhorabuena, has conseguido abrir el cofre")
        salas.remove("Este")
        return "N"
    else:
        print("Descansando 20 segundos...")
        time.sleep(20)
        return perder()

def salaOeste():
    numPregunta = randint(0,7)
    print(str(preguntas[numPregunta]))
    respuesta = input("Respuesta: ")
    if(respuestasPreguntas[numPregunta].lower() in respuesta.lower()):
        print("Enhorabuena, has acertado.")
        salas.remove("Oeste")
        return "N"
    else:
        return perder()
while jugar == True:
    describirJuego()
    while(len(salas) > 0):
        imprimirSalas()
        opcion = input("¿A que sala quieres ir? ")
        if(opcion in salas):
            if(opcion == "Norte"):
                print("Aparece un monstruo y te ataca.")
                while True:
                    if(salaNorte().upper() == "N"):
                        salaMedio()
                        break
            if(opcion == "Sur"):
                print("Para superar esta sala debes acertar un acertijo.")
                while True:
                    if(salaSur().upper() == "N"):
                        salaMedio()
                        break
            if(opcion == "Este"):
                print("Para superar esta sala hay que conseguir abrir un cofre.")
                while True:
                    if(salaEste().upper() == "N"):
                        salaMedio()
                        break
            if(opcion == "Oeste"):
                print("Para superar esta sala debes responder bien a una pregunta.")
                while True:
                    if(salaOeste().upper() == "N"):
                        salaMedio()
                        break
        else:
            print("Esa sala no está disponible. Vuelva a elegir")
    reiniciar = input("Enhorabuena!! Has ganado! Quieres volver a jugar? S/N: ")
    if(reiniciar.upper() == "S"):
        reiniciarSalas()
    else:
        jugar = False
print("Juego finalizado.")

