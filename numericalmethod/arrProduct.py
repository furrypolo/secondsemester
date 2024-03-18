import numpy as np

import matplotlib.pyplot as plt


##1
# plt.plot([1, 2, 3, 4, 5], [1, 2, 3, 4, 5])
# plt.show()


##2
# t = np.arange(0.0, 5.0, 0.2)
# plt.plot(t, t, 'r--', t, t**2, 'bs', t, t**3, 'g^')
# plt.show()

# #3
def f(t):
    return np.exp(-t) * np.cos(2 * np.pi * t)

t1 = np.arange(0.0, 5.0, 0.1)
t2 = np.arange(0.0, 5.0, 0.02)


plt.figure(dpi=300)
plt.subplot(211)
plt.plot(t1, f(t1), 'bo', t2, f(t2), 'k')
plt.subplot(212)
plt.plot(t2, np.cos(2 * np.pi * t2), 'r--')
plt.savefig('example_subplot.png')
plt.show()

# #4
# x = 100 + 15 * np.random.randn(10000)

# plt.hist(x, 50, density=True, facecolor='g', alpha=0.75)  # Mengganti normed menjadi density
# plt.title('Histogram of IQ')
# plt.xlabel('Smarts')
# plt.ylabel('Probability')
# plt.axis([40, 160, 0, 0.03])
# plt.grid(True)
# plt.show()

