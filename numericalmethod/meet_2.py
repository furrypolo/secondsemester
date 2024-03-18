#ifElse

a = int(input("Input first number: "))
b = int(input("Input second number: "))

if a<b:
    z = b
else:
    z = a

print("The maximum is ", z)

#logicIf
a = int(input("Input first number: "))
b = int(input("Input second number: "))
c = int(input("Input third number: "))

if b>=a and b<=c or b<=a and b>=c:
    print("b is between a and c")

if not (b<a or b>c):
    print("b is still between a and c")

#If Elif Else
a = (input("Input operator: "))

if a == '+':
    op = 'plus'
elif a == '-':
    op = 'minus'
elif a == '*':
    op == 'multiply'
elif a =='/':
    op == 'division'
else:
    raise RuntimeError("Unknown Operator")

print(op)

#loop
for i in range(1,10): #10 isnt included
    print("2 pangkat %d adalah %d" %(i, 2**i))

# a = range(5) # a = [0,1,2,3,4]
# b = range(1,8) # b = [1,2,3,4,5,6,7]
# c = range(0, 14, 3) # c = [0, 3, 6, 9, 12]
# d = range(8, 1, -1) # d = [8, 7, 6, 5, 4, 3, 2]

a = "Hello World"
#print out the characters in a
for c in a:
    print(c)

b = ["Dave", "Mark", "Ann", "Phil"]
#print out members of a list
for name in b:
    print(name)

c = { 'a': 3, 'name': 'Dave', 'x': 7.5}
for key in c:
    print(key, c[key])