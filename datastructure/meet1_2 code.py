def genap(a,b):
    if a<b:
        x=a%2
        if x == 0:
            n=a+1
            return str(a) + genap(n,b)
        else:
            n=a+1
            return genap(n,b)
    elif a==b:
        x=a%2
        if x == 0:
            return str(a)
        else:
            return (' ')




a = int(input("a = "))
b = int(input("b = "))
result = str(genap(a,b))
print(result)