#Georgia Sugisandhea - 535230080

print("1.")
num1=int(input("Masukkan bilangan pertama: "))
num2=int(input("Masukkan bilangan kedua: "))
print("Hasil penjumlahan: %.1f" %(num1+num2))
print("Hasil pengurangan: %.1f" %(num1-num2))
print("Hasil perkalian: %.1f" %(num1*num2))
print("Hasil pembagian: %.1f" %(num1/num2))

print("2.")
def luas(panjang, lebar):
    result= panjang*lebar
    return result

num1=int(input("Masukkan panjang persegi: "))
num2=int(input("Masukkan lebar persegi: "))
print("Luas persegi panjang: %.1f" %(luas(num1,num2)))

print("3.")
friend=["Alfian", "Kevin", "Brenda", "Lusy", "Eryca"]
print("Nama teman ketiga dan kelima adalah: ", friend[2], " & ", friend[4])

print("4.")
jeruk = {
    "name": "jeruk",
    "color": "orange"
}

pisang = {
    "name": "pisang",
    "color": "kuning"
}

apel = {
    "name": "apel",
    "color": "merah"
}

anggur = {
    "name": "anggur",
    "color": "ungu"
}

print("Warna buah", jeruk["name"], "adalah", jeruk["color"])
print("Warna buah", pisang["name"], "adalah", pisang["color"])
print("Warna buah", apel["name"], "adalah", apel["color"])
print("Warna buah", anggur["name"], "adalah", anggur["color"])




