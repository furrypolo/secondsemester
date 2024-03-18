daftar_mhs =[
        ['Alpha', '535000001', 'TI A'],
        ['Beta', '535000002', 'TI B'],
        ['Charlie', '535000003', 'TI C'],
        ['Delta', '535000004', 'TI D'],
        ['Echo', '535000005', 'TI C'],
        ['Foxtrot', '535000006', 'TI B'],
        ['Golf', '535000007', 'TI A'],
        ['Hotel', '535000008', 'TI B'],
        ['India', '535000009', 'TI C'],
        ['Juliet', '535000010', 'TI D'],
];


def main():
    mhs_list_baru = [];
    
    for orang in daftar_mhs:
        mhs = {
            'nama': orang[0],
            'nim': orang[1],
            'kelas': orang[2]
        }
        mhs_list_baru.append(mhs)



    
    # Gunakan for loop untuk memasukkan
    # Data dari daftar_mhs
    # Ke dalam mhs_list_baru




    # Loop ini untuk print isi dari mhs_list_baru
    # Jangan diubah
    for line in mhs_list_baru:
        print(line)

    return mhs_list_baru


if __name__ == '__main__':
    main()
