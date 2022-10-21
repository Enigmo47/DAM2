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

#Cuenta cuantas veces esta cada letra
print("Hay " + str(result)  + " palabras")

#Cuenta cuantas veces esta cada letra del abecedario
abecedario = string.ascii_lowercase
for letra in abecedario:
    contador = stringTexto.count(letra)
    print(letra, " = ", contador)


"""
frecuenciaPalab = []
listaPalabras = stringTexto.split()
for palabra in listaPalabras:
    frecuenciaPalab.append(listaPalabras.count(palabra))
for i in range(len(stringTexto)):
    print("Palabra:\n" + str(listaPalabras) + "\n")
    print("Frecuencia:\n" + str(frecuenciaPalab[i]) + "\n")
"""
