import numpy as np

def generateMatrix(size):
    return np.random.randint(1,10, (size, size))

def generateOutput(size):
    return [np.random.randint(1,10) for i in range(size)]
'''
ukuranMatrix = int(input("Ukuran Matrix:"))
'''
'''
a = generateMatrix(ukuranMatrix)
print(a)
'''

a = np.array([
    [1, 2, 1],
    [1, 3, 2],
    [2, 1, 2]
], dtype=float)

b = np.array([6,9,12])
n=len(b)

print("Augmentasi Matriks: \n", np.column_stack((a,b)))

for k in range(n):
    for i in range(k+1, n):
        factor = a[i,k] / a[k,k]
        for j in range(k,n):
            a[i,j] -= factor * a[k,j]
        b[i] -= factor * b[k] 

x = np.zeros(n)
x[-1]=b[-1]/a[-1, -1]

for i in range(n-2, -1, -1):
    sum = b[i]
    for j in range(i+1, n):
        sum -= a[i,j] * x[j]
    x[i] = sum/a[i,i]

print("Gauss Naive: \n", np.column_stack((a,b)))

for i in range(len(x)):
    print("x%d = %.4f" % (i+1, x[i]))


'''
b = generateOutput(ukuranMatrix)
print(b)
'''
