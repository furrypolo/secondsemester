import numpy as np
import pandas as pd
import random
import pandas.io.formats.excel
pandas.io.formats.excel.ExcelFormatter.header_style = None

while True:
    try:
        # Note: Python 2.x users should use raw_input, the equivalent of 3.x's input
        nim = int(input("Masukkan NIM anda: "))
    except ValueError:
        print("Bukan NIM anda, input ulang lagi!")
        continue
    else:
        #Kriptografi
        n = 25
        p = 5
        D = []
        for j in range(n):
            D.append(random.randint(1,50))
        #print(V)
        D = np.transpose(pd.DataFrame(D))
        D.set_index([['Pesan']*len(D)], inplace=True)

        caesar = [random.randint(0,25)]
        cae = pd.DataFrame(caesar)
        cae.set_index([['Caesar Key']*len(D)], inplace=True)

        listp = [x for x in range(3, 50) if all(x % y for y in range(2, x//2))]
        while(True):
            a = listp[random.randint(0,len(listp)-1)]
            if(a != 4 and a % 26 > 0): break
        b = random.randint(0,25)
        Affine = [[a,b]]
        Affine = pd.DataFrame(Affine, columns = ['a','b'])
        Affine.set_index([['Affine Keys']*len(Affine)], inplace=True)

        arrayA = [int(i) for i in str(nim)]
        arrayA = arrayA + [random.randint(1,p) for _ in range(p*p - len(arrayA))]
        matA = np.linalg.inv(np.array(arrayA).reshape(5,5)) 
        labelmat = [["Hill Cipher Key - [A]"]]

        #KNN
        n = 100 + (nim % 13)
        p = 4

        C = []
        for i in range(p):
            V = []
            for j in range(n):
                V.append(random.randint(3**i,3**(i+1)))
            C.append(V)

        F = np.add(np.add(np.add(C[0][:], np.array(C[1][:])*2),np.array(C[2][:])*3),np.array(C[3][:])*0.05)
        C = np.transpose(C)
        labels = []
        for i in range(p):
            labels.append("x"+str(i+1))

        dfpca = pd.DataFrame(C,columns=labels)
        maks = np.max(F)
        min = np.min(F)
        grup = []
        for i in range(n):
            if(F[i] >= min and F[i] <= np.quantile(F,.25)): grup.append('C')
            elif(F[i] > np.quantile(F,.25) and F[i] <= np.quantile(F,.5)): grup.append('B')
            else: grup.append('A')
        dfpca['Group'] = grup
        U = np.array(dfpca.iloc[random.randint(1,n-1),0:4])
        for _ in range(p-1): U[random.randint(0,p-2)] = random.randint(1,10)
        U[p-1] = round(U[0] + U[1] * 2 + U[2] * 3 + U[3] * 0.05)
        uji = pd.DataFrame(np.array(U).reshape(1,p),columns=labels)
        uji['Group'] = None

        #KMeans
        n = 15 + (nim % 13)
        p = 3

        B = []
        for i in range(p):
            V = []
            for j in range(n):
                V.append(random.randint(10*(i+1),(i+1)*2*10))
            B.append(V)
        B = np.transpose(B)

        #SVD
        n = 9+(nim % 11)
        p = 4
        A = []
        for i in range(p):
            V = []
            for j in range(n):
                V.append(random.randint(0,2))
            A.append(V)
        A = np.transpose(A)

        ew = pd.ExcelWriter(str(nim) + '.xlsx')
        pd.DataFrame(cae).to_excel(ew, sheet_name='Kriptografi', startrow = 0, header=False)
        pd.DataFrame(Affine).to_excel(ew, sheet_name='Kriptografi', startrow = 2)
        pd.DataFrame(labelmat).to_excel(ew, sheet_name='Kriptografi', startcol=0, startrow = 5, index=False, header=False)
        pd.DataFrame(matA).to_excel(ew, sheet_name='Kriptografi', startcol=0, startrow = 6,index=False, header=False)
        pd.DataFrame(D).to_excel(ew, sheet_name='Kriptografi', startrow = 12, header=False)
        pd.DataFrame(dfpca).to_excel(ew, sheet_name='KNN', index=False)
        pd.DataFrame(uji).to_excel(ew, sheet_name='KNN', startcol = 8, startrow = 0, index=False)
        pd.DataFrame(B).to_excel(ew, sheet_name='KMeans', index=False, header=False)
        pd.DataFrame(A).to_excel(ew, sheet_name='SVD', index=False, header=False)
        ew.close() 
        print("Data berhasil di-generate. Cek file '", str(nim), ".xlsx' di folder yang sama dengan file program ini")
        break


