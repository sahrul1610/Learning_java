#include <stdio.h>
Lengkapilah prototipe program berikut untuk menentukan apakah suatu bilangan merupakan kelipatan 3 dan 4 atau tidak, Menggunakan Bahasa Pemograman Java.

Prototipe:
int main(){
    int bilangan;
    int cek;

    cek = 0;
    scanf("%d", &bilangan);

    if(/* silahkan isi kondisi*/){
        cek = 1;
    }

    printf("%d\n", cek);

    return 0;
}

Variabel cek menyimpan nilai kebenaran dari kondisi di atas. Variabel cek bernilai 1 jika bilangan yang dimasukkan merupakan kelipatan 3 dan 4. Jika tidak, variabel cek bernilai 0.
Spesifikasi Input

Satu baris berisi bilangan bulat X (0 < X < 100).

Spesifikasi Output

Satu baris berisi nilai variabel cek.

For example:

Input	Result
12
1
9
0
27
0
24
1
