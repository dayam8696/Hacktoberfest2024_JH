#Python v3.9.2
#AWS re/Start Project | Source Code by Joshua Kidder
#https://github.com/kiddjsh/analyzingInsulin


import re

#input file
fin = open("myPreproinsulin-seq.txt", "rt")
#output file with results
fout = open("myOutPreproinsulin-seq.txt", "wt",)
#for each line in the input file
for line in fin:
    #read replace spaces, capital letters, numbers and special characters, writting output to file
    fout.write(re.sub(r"[\s^A-Z0-9-/]",'',line))
    
#close file in and file out
fin.close()
fout.close()

#then
#open file in read mode
file = open("myOutPreproinsulin-seq.txt", "r")

number_of_lines = 0
number_of_characters = 0
#for each line in output file
for line in file:
    #count results of characters per line
    number_of_lines += 1
    number_of_characters += len(line)
  
#close output file
file.close()

#print results of count
print("lines:", number_of_lines, "characters:", number_of_characters)


#then
#open parsed file in read mode
file = open("myOutPreproinsulin-seq.txt", "r")

character = 0-24
character = 24-54
character = 54-89
character = 89-110

#for each line in output file
for character in file:
    #print character in parsed file  
    print (character)
    #create new file name and write results
    Isin = open("Isinsulin-seq-clean.txt", "wt")
    Isin.write(character[0:24])
    #print character per count restriction 
    print (character[0:24])
    #create new file name and write results
    bins = open("binsulin-seq-clean.txt", "wt")
    bins.write(character[24:54])
    #print character per count restriction
    print (character[24:54])
    #create new file name and write results
    cins = open("cinsulin-seq-clean.txt", "wt")
    cins.write(character[54:89])
    #print character per count restriction
    print (character[54:89])
    #create new file name and write results
    ains = open("ainsulin-seq-clean.txt", "wt")
    ains.write(character[89:110])
    print (character[89:110])
    
    #close output file
    Isin.close()
    bins.close()
    cins.close()
    ains.close()


#references and resources
#https://www.ncbi.nlm.nih.gov/protein/AAA59172.1
#https://pythonexamples.org/python-replace-string-in-file/
#https://pynative.com/python-regex-replace-re-sub/