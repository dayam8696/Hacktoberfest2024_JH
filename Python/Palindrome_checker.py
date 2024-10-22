N=int(input('Enter the number'))
N1=N
N2=0
while N>0:
    r=N%10
    N2=N2*10+r
    N=N//10
if N2==N1:
    print ('True')
else:
    print ('False')