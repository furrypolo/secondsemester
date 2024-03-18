#535230080_Georgia Sugisandhea_Kelas C
import numpy as np
import matplotlib.pyplot as plt



def sin(x):
    list_fin=[]
    result=0
    for n in range(11):
        fact=1
        for i in range(1, ((2*n+1)+1)):
            fact=(np.multiply(fact,i))
        temp=((((-1)**n)/fact)*(x**(2*n+1)))
        result=np.add(result,temp)
        list_fin.append(result)
    return list_fin



pi2 = sin(np.pi/2)
pi4 = sin(np.pi/4)
pi6 = sin(np.pi/6)

plt.subplot(311)
plt.plot(pi2, marker="o", color='b')
plt.ylabel("Nilai sin")
plt.xlabel("Loop ke berapa")
plt.grid()
plt.title("sin(π/2)")
plt.tight_layout()
plt.subplot(312)
plt.plot(pi4, marker="o", color='c')
plt.ylabel("Nilai sin")
plt.xlabel("Loop ke berapa")
plt.grid()
plt.title("sin(π/4)")
plt.tight_layout()
plt.subplot(313)
plt.plot(pi6, marker="o", color='k')
plt.ylabel("Nilai sin")
plt.xlabel("Loop ke berapa")
plt.grid()
plt.title("sin(π/6)")
plt.tight_layout()
plt.show()

        