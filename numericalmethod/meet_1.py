a=7
b=3.141592
c="Hello, World!"
d='The quick brown fox'

print (a)
print ("Nilai pi = ", b)
print (c)
print ("Some people says,", d)
#or
print ("Some people says," + d)

#printing with format
print("Nilai a = %d dan nilai pi = %.2f" %(a, b))
format=f"{a} + {b:.3f} = {a+b}" #another type
print(format)
#%d = integer %.2f = float with 2 numbers behind coma

print(c, d)

print(c, end=" ")
#preventing the line to enter

print(c)
print(c, end=" " + d)
print(" ")

#inputs
x = input() #string type -> can't use the value for arythmatics
print(type(x))

y = int(input()) #specifying into integer -> can use value for aythmatics
print(type(y))

#arythmatics

x = int(input("Masukkan integer x = "))
y = int(input("Masukkan integer y = "))

jumlah = x + y
print("%d + %d = %d" %(x,y,jumlah))

kurang = x - y
print("%d - %d = %d" %(x,y,kurang))

kali = x * y
print("%d * %d = %d" %(x,y,kali))

bagi = x / y
print("%d / %d = %d" %(x,y,bagi))

pangkat = x ** y
print("%d ^ %d = %d" %(x,y,pangkat))

#functions
import math
print(math.log(100)) #logaritma natural dari 100
print(math.log10(1000)) #log-10 dari 1000
print(math.sqrt(4250)) #akar2 dari 4250
print(math.cos(math.pi/4)) #cosinus dari pi/4
print(math.e) # e=2.718281828...

def luas_segi3(alas, tinggi): #making functions (def=define), luas_segi3 is the name of the function, alas tinggi is parameter
    luas=0.5*alas*tinggi #private variable so cant be called outside function
    return luas

alas = float(input("Masukkan alas: "))
tinggi = float(input("Masukkan tinggi: "))
luas = luas_segi3(alas, tinggi) #so its okay to use this same variable name cause this one is public the other one is private
print("Luas segitiga: %.3f" %(luas))
#or
print("Luas segitiga: %.3f" %(luas_segi3(alas, tinggi)))

def printer(): #another function like a void
    print("A paper")

printer()

# data type
# scalar: int, boolean, float, NoneType(example no return functions assigned to variable results to NoneType)
# nonscalar: string, list (like array), tuple, set(like list, but will remove duplicates), dict

#conversion
fnum = 3.141592
snum = 10
tnum = "12"
fonum = int(tnum)

print(fnum)
print(int(fnum))
print(snum)
print(float(snum))
fin = snum + fonum
print(fin)

'''
another comment
'''

#list (like array)
a_list = ["a", "b"]

print(type(a_list))
print(len(a_list))

a_list.append("c")
print(a_list)

a_list.insert(1, "123") #insert into 1st index, pushing others back
print(a_list)

print(a_list[2])

print(len(a_list))

#set
a_set = set()
print(type(a_set))

names = {"Alpha", "Beta"}
names.add("Charlie")
print(names)

names.add("Alpha")
print(names)
#dict
mahasiswa ={
    "nama": "Bob",
    "nim": "535230076"
}

print(mahasiswa)

mahasiswa["kelas"] = "TI C"
print(mahasiswa)