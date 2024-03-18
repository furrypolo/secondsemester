#535230080_Georgia Sugisandhea_Kelas C
import numpy as np
import matplotlib.pyplot as plt

def euler(x):
    fin=1
    list_fin=[fin]
    result=0

    for loop in range(1, 21):
        temp=result
        fact=1
        if(loop==1):
            result=1
        else:
            for n in range(1,loop+1):
                fact*=loop
            result=((x**loop)/fact)
        
        fin=np.add(fin, result)
        list_fin.append(fin)

    return list_fin

def error(list):
    list_error=[]
    result=0

    for loop in range(2, 21):
        error=abs((list[loop]-list[loop-1])/(list[loop]))*100
        list_error.append(error)

    
    return list_error

list_fin=euler(1)
list_error=error(list_fin)

plt.subplot(211)
plt.plot(list_fin, marker="o")
plt.ylabel("Nilai Euler")
plt.grid()
plt.title("Grafik Nilai Euler dan Error")
plt.tight_layout()
plt.subplot(212)
plt.plot(list_error, marker="o")
plt.ylabel("Nilai Error")
plt.xlabel("Loop ke berapa")
plt.grid()
plt.tight_layout()
plt.show()

#loop 18 keatas tidak muncul karena dia perubahannya terlalu kecil ya kak jadi dia 0.0. 