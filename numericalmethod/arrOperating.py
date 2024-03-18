import numpy as np

#Array indexing & slicing
#1 dimensi
a=np.arange(10)
print(a)
print(a[5]) #index starts at 0

#2 dimensi
b=np.array([[1,2,3], [4,5,6], [7,8,9]])
print("Isi array:")
print(a)
print("")

print("Kolom 2:")
print(b[:,1])
print("")

print("Baris 2:")
print(b[1,:])

print("Kolom 0 - 1")
print(b[:,0:2]) #from 0 column to the 1st column, 2 column isnt included
print("")

print("Kolom 1 sampai akhir: ")
print(b[:,1:])
print("")

#boolean indexing
a=np.array([[1,2], [3,4], [5,6]])
bool_idx = a>2

print(bool_idx)
print(a[bool_idx])
print(a[a>2])

#operating
x = np.array([[1,2], [3,4]], dtype=float)
y = np.array([[5,6], [7,8]], dtype=float)

print(x)
print(y)
print("Penjumlahan: ")
print(x+y)
print(np.add(x,y))

print("Pengurangan: ")
print(x-y)
print(np.subtract(x,y))

print("Perkalian: ")
print(x*y)
print(np.multiply(x,y)) #multiply like addition subtract layout
print(np.dot(x,y)) #actual matrix multiply

print("Pembagian: ")
print(x/y)
print(np.divide(x,y))

print("Akar: ")
print(np.sqrt(x,y))

#summation
sum = 0
for i in range(5):
    sum+= 3*i

print(sum)