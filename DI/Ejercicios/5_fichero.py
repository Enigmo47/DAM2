import PyPDF2 
import string
import re
# creating a pdf file object 
pdfFileObj = open('5_ConstitucionCASTELLANO.pdf', 'rb')
# creating a pdf reader object 
pdfReader = PyPDF2.PdfFileReader(pdfFileObj)
#number of pages in pdf file 
numPaginas = int(pdfReader.numPages)

listaTexto = []

for i in range(numPaginas):
    # creating a page object
    pageObj = pdfReader.getPage(i) 
    # extracting text from page 
    listaTexto.append(pageObj.extractText())

stringTexto = ""
for pagina in listaTexto:
    stringTexto += pagina

#Cuenta las palabras del texto
result = len(re.findall(r'\w+', stringTexto))

#Cuenta palabras distintas en el texto
setPalabras = set(re.findall(r'\w+', stringTexto))
result2 = len(setPalabras)    

#Cuenta cuantas veces esta cada palabra
print("Hay " + str(result)  + " palabras")
print("Hay " + str(result2) + " palabras distintas")

#Cuenta cuantas veces esta cada letra del abecedario
abecedario = string.ascii_lowercase
dicts = {}

for letra in abecedario:
    contador = stringTexto.count(letra)
    #print(str(letra) + ": " + str(contador))
    dicts[letra] = contador
#diccionarioOrdenado = sorted(dicts)
print(diccionarioOrdenado)


