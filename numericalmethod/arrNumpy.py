import numpy as np

a = np.array([1,2,3])
print(a)

a = np.array([[1,2,3], [4,5,6]])
print(a)
print(a.shape)

b = a.reshape(3,2)
print(b)



#file2
z=np.zeros(5) #filling the arrays w zeros
print(z)

z=np.zeros((2,2))
print(z)

#or ones
z=np.ones(5)
print(z)

z=np.zeros((2,2))
print(z)

#full
y=np.full((2,2), 1.5)
print(y)

#arange
a = np.arange(5)
print(a)

a = np.arange(10, 20, 2)
print(a)

a = np.arange(10,20)
print(a)

