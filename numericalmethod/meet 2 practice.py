# a = int(input("Masukkan bilangan yang diperiksa: "))

# def cek(a):
#     if a>0:
#         result = 'Positif'
#     elif a<0:
#         result = 'Negatif'
#     else:
#         result = 'Nol'
    
#     return result

# res = cek(a)
# print(res)

# uts = int(input("Masukkan nilai UTS: "))
# uas = int(input("Masukkan nilai UAS: "))

# def rep(uts, uas):
#     av = (uts+uas)/2
#     if(av>70):
#         return "Mahasiswa dinyatakan LULUS dengan nilai akhir: %d" %((uts+uas)/2)
#     else:
#         return "Mahasiswa dinyatakan TIDAK LULUS dengan nilai akhir: %d" %((uts+uas)/2)
    

# fin = rep(uts, uas)
# print(fin)
# x=1
# print("Bilangan ganjil dari 1 hingga 50")
# while(x<=50): #or use for i in range
#     y=x%2
#     if(y==1):
#         print(x, end=" ")
#     x+=1

word = input('Masukkan sebuah string')
vocal = ['a', 'A', 'i', 'I', 'u', 'U', 'e', 'E', 'o', 'O']
for i in word:
    if i in vocal:
    # if i.lower() == 'a' or i.lower() == 'i' or i.lower() == 'u' or i.lower() == 'e' or i.lower() == 'o':
        print(i)
    