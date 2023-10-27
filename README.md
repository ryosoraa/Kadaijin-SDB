<h1 align="center">Halo 👋, Saya Ryo</h1>
<h3 align="center">Seorang pengembang backend yang bersemangat dari Indonesia</h3>

# Selamat Datang di Kadaijin-SDB 👋

![Versi](https://img.shields.io/badge/versi-4.1--beta.4-biru.svg?cacheSeconds=2592000)
[![Twitter: Alexis11401746](https://img.shields.io/twitter/follow/Alexis11401746.svg?style=social)](https://twitter.com/dumps)

> Proyek ini merupakan tugas yang saya dapatkan selama magang di PT Indonesia Indicator dan merupakan perjalanan saya selama belajar bahasa pemrograman Java dan penggunaan framework Spring Boot

## Fitur

- Pemilihan teknologi atau library yang sesuai untuk web scraping.
- Penentuan struktur data yang akan disimpan.
- Pengembangan script untuk mengambil data dari halaman web.
- Pengolahan dan penyimpanan data yang diambil.
- Dokumentasi yang jelas mengenai cara menjalankan proyek dan menjelaskan kode.

## Versi

v1.0-beta.1 : launching pertama  
v1.2-beta.1 : update dto converter ke mapper  
v1.3-beta.1 : data yang diterima tidak langsung diterima oleh model tpi ke dto dulu  
v1.3-beta.1 : optimasi converter  
v1.4-beta.1 : optimasi RangeDTO dan AccountsDTO
v1.5-beta.1 : Rilis fitur Range  
v1.6-beta.2 : menambahkan keterangan total login  
v1.7-beta.2 : penghapusan bug total login terisi padahal pada bulan/waktu itu tidak login
v1.8-beta.2 : penghapusan table database account
v1.9-beta.2 : merubah table database kadaijin ke table accounts
v2.0-beta.2 : optimasi model entity baru
v2.1-beta.3 : perubahan jpa repository builder
v2.2-beta.3 : perbaikan convert model to dto
v2.3-beta.3 : optimasi
v2.4-beta.3 : penambahan data baru personal data
v2.5-beta.3 : update personal data model entity dan personal data DTO
v2.6-beta.3 : update endpoint login hanya membutuhkan body email dan password
v2.7-beta.3 : penambahan endpoint baru rangeLog
v2.8-beta.3 : penambahan fitur log range
v2.9-beta.3 : merubah cara kerja range
v3.0-beta.3 : menambah keluaran email dan log login secara bersamaan
v3.1-beta.4 : perubahan dari request body ke request param untuk rangeLog
v3.2-beta.4 : penambahan fitur between di range log
v3.3-beta.4 : menghapus log range controller
v3.4-beta.4 : perbaikan rangeLog between yang tidak bekerja dengan benar
v3.5-beta.4 : update log getOne dan accounts getOne bisa menerima string email
v3.6-beta.4 : update range log jika salah satu param between dihapus akan menampilkan semua log
v3.7-beta.4 : perbaikan di mana getOne account mengeluarkan log  
v3.8-beta.4 : penghapusan converter model to DTO dan merubah menjadi konstruktor
v3.9-beta.4 : perubah menjadi 1 controller 1 service
v3.0-beta.4 : optimasi
v4.1-beta.4 :

## Struktur

```
├───.mvn
│   └───wrapper
├───.vscode
├───src
│   ├───main
│   │   ├───java
│   │   │   └───com
│   │   │       └───kadaijin
│   │   │           └───kadaijin
│   │   │               ├───configuration
│   │   │               ├───controller
│   │   │               ├───json
│   │   │               ├───model
│   │   │               │   ├───converter
│   │   │               │   ├───DAO
│   │   │               │   └───DTO
│   │   │               ├───repository
│   │   │               └───service
│   │   └───resources
│   │       ├───static
│   │       │   └───database
│   │       └───templates
│   └───test
│       └───java
│           └───com
│               └───kadaijin
│                   └───kadaijin
└───target
    ├───classes
    │   ├───com
    │   │   └───kadaijin
    │   │       └───kadaijin
    │   │           ├───configuration
    │   │           ├───controller
    │   │           ├───json
    │   │           ├───model
    │   │           │   ├───converter
    │   │           │   ├───DAO
    │   │           │   └───DTO
    │   │           ├───repository
    │   │           └───service
    │   └───static
    │       └───database
    ├───generated-sources
    │   └───annotations
    ├───generated-test-sources
    │   └───test-annotations
    ├───maven-archiver
    ├───maven-status
    │   └───maven-compiler-plugin
    │       ├───compile
    │       │   └───default-compile
    │       └───testCompile
    │           └───default-testCompile
    ├───surefire-reports
    └───test-classes
        └───com
            └───kadaijin
                └───kadaijin
```

## Teknologi

Aplikasi ini dibangun menggunakan sejumlah proyek sumber terbuka untuk berfungsi dengan benar:

- [Java](<https://id.wikipedia.org/wiki/Java_(bahasa_pemrograman)>) - Bahasa pemrograman berorientasi objek yang dapat dijalankan di berbagai komputer termasuk telepon genggam.
- [Spring Boot](https://spring.io/projects/spring-boot) - Framework open source untuk membangun aplikasi Java yang berdiri sendiri.
- [JPA Repository](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/) - Abstraksi Spring Data yang memfasilitasi implementasi repository berdasarkan JPA.
- [Swagger](https://swagger.io/) - Kerangka kerja open source untuk merancang, membangun, mendokumentasikan, dan mengonsumsi RESTful Web Services.
- [MySQL](https://www.mysql.com/) - Sistem manajemen database open source yang populer.
- [Maven](https://maven.apache.org/) - Alat bantu build otomatis untuk proyek Java.

## Kebutuhan

- [Java](https://www.java.com/en/download/) v11+
- [Maven](https://maven.apache.org/) (sesuaikan versi dengan Java)

## Instalasi

Proyek ini memerlukan [Java](https://www.java.com/en/download/) LTS 11+ untuk dijalankan.

Instal semua dependency yang dibutuhkan pada proyek ini.

```sh
mvn install
```

## Penggunaan

```sh
mvn spring-boot:run
```

## Penulis

👤 **Rio Dwi Saputra**

- Twitter: [@ryosora12](https://twitter.com/ryosora12)
- Github: [@ryosoraa](https://github.com/ryosoraa)
- LinkedIn: [@rio-dwi-saputra-23560b287](https://www.linkedin.com/in/rio-dwi-saputra-23560b287/)

## Lisensi

MIT

## Terima Kasih

> Rio Dwi Saputra

- 🔭 Saat ini saya bekerja pada **Kadaijin-SDB**

- 👨‍💻 Semua proyek saya tersedia di [https://ryosoraa.github.io/](https://ryosoraa.github.io/)

- 📝 Saya secara teratur menulis artikel di [situs web](situs web)

- 💬 Tanya saya tentang **java, python, C#**

- 📫 Hubungi saya di **riodwi12174@gmail.com**

- 📄 Tahu tentang pengalaman saya [situs web](situs web)

- ⚡ Fakta menarik **Saya ingin menjadi pribadi yang lebih baik**

<h3 align="left">Hubungi saya:</h3>
<p align="left">
<a href="https://codepen.io/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/codepen.svg" alt="ryosoraa" height="30" width="40" /></a>
<a href="https://dev.to/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/devto.svg" alt="ryosoraa" height="30" width="40" /></a>
<a href="https://twitter.com/ryosora12" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/twitter.svg" alt="ryosora12" height="30" width="40" /></a>
<a href="https://linkedin.com/in/rio-dwi-23560b287" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="rio-dwi-23560b287" height="30" width="40" /></a>
<a href="https://stackoverflow.com/users/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/stack-overflow.svg" alt="ryosoraa" height="30" width="40" /></a>
<a href="https://codesandbox.com/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/codesandbox.svg" alt="ryosoraa" height="30" width="40" /></a>
<a href="https://kaggle.com/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/kaggle.svg" alt="ryosoraa" height="30" width="40" /></a>
<a href="https://fb.com/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/facebook.svg" alt="ryosoraa" height="30" width="40" /></a>
<a href="https://instagram.com/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/instagram.svg" alt="ryosoraa" height="30" width="40" /></a>
<a href="https://www.behance.net/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/behance.svg" alt="ryosoraa" height="30" width="40" /></a>  
<a href="https://hashnode.com/@ryosora" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/hashnode.svg" alt="@ryosora" height="30" width="40" /></a>
<a href="https://medium.com/@ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/medium.svg" alt="@ryosoraa" height="30" width="40" /></a>
<a href="https://www.youtube.com/c/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/youtube.svg" alt="ryosoraa" height="30" width="40" /></a>
<a href="https://www.codechef.com/users/ryosoraa" target="blank"><img align="center" src="https://cdn.jsdelivr.net/npm/simple-icons@3.1.0/icons/codechef.svg" alt="ryosoraa" height="30" width="40" /></a>
<a href="https://www.hackerrank.com/@ryosora" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/hackerrank.svg" alt="@ryosora" height="30" width="40" /></a>
<a href="https://codeforces.com/profile/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/codeforces.svg" alt="ryosoraa" height="30" width="40" /></a>
<a href="https://www.leetcode.com/ryosora" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/leet-code.svg" alt="ryosora" height="30" width="40" /></a>
<a href="https://www.hackerearth.com/@ryosora" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/hackerearth.svg" alt="@ryosora" height="30" width="40" /></a>
<a href="https://auth.geeksforgeeks.org/user/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/geeks-for-geeks.svg" alt="ryosoraa" height="30" width="40" /></a>
<a href="https://www.topcoder.com/members/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-
