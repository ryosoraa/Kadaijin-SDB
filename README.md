<h1 align="center" >Hello 👋, I'm Ryo</h1   >
<h3 align="center" >An independent backend developer</h3>

# Welcome To Kadaijin-SDB 🌟

![Versi](https://img.shields.io/badge/versi-4.1--beta.4-biru.svg?cacheSeconds=2592000)
[![Twitter: ryosora12](https://img.shields.io/twitter/follow/ryosora12.svg?style=social)](https://twitter.com/dumps)

> Proyek ini merupakan tugas yang saya dapatkan selama magang di PT Indonesia Indicator dan merupakan perjalanan saya selama belajar bahasa pemrograman Java dan penggunaan framework Spring Boot

## Feature

Proyek ini memiliki berbagai fitur yang sesuai dengan teknologi yang digunakan:

- **RESTful API**: Proyek ini menyediakan berbagai endpoint RESTful API yang memungkinkan pengguna untuk berinteraksi dengan aplikasi secara programatik. Anda dapat melakukan operasi CRUD (Create, Read, Update, Delete) pada sumber daya aplikasi melalui API ini.

- **Swagger Documentation**: Dokumentasi API yang dibangun dengan Swagger memungkinkan pengguna untuk dengan mudah menjelajahi dan memahami semua endpoint yang tersedia dalam proyek. Ini termasuk detail tentang penggunaan endpoint, parameter yang diperlukan, dan tanggapan yang diharapkan.

- **Maven Dependency Management**: Maven digunakan untuk mengelola dependensi proyek. Anda dapat dengan mudah menambahkan atau menghapus dependensi dari proyek Anda dengan menambahkan atau menghapus entri dependensi dalam berkas `pom.xml`. Maven juga mengotomatisasi proses pembangunan proyek, membuatnya lebih mudah untuk mengelola sumber daya dan kompilasi.

- **Spring Boot Application**: Proyek ini adalah aplikasi berbasis Spring Boot. Spring Boot memberikan konfigurasi otomatis yang kuat dan abstraksi yang memudahkan pengembangan aplikasi. Ini juga mendukung pembuatan aplikasi berkinerja tinggi dengan mudah.

- **Database Integration**: Proyek ini terintegrasi dengan MySQL sebagai basis data utama. Anda dapat mengelola data aplikasi, seperti pengguna, produk, atau entitas lainnya, melalui API yang terhubung ke basis data MySQL.

- **Security**: Anda dapat mengintegrasikan fitur keamanan dengan mudah menggunakan Spring Security, memungkinkan Anda untuk mengamankan akses ke endpoint API Anda.

  **Logging**: Proyek ini menggunakan sistem

## Version

<!-- ![Version](https://img.shields.io/badge/version-4.1--beta.4-blue.svg?cacheSeconds=2592000) -->

## Version History

![Version](https://img.shields.io/badge/version-1.0--beta.1-blue.svg?cacheSeconds=2592000)

**First Launching 💫** <brs>
**Release: 13 Oktober 2023**

> Pada tanggal ini, proyek saya resmi diluncurkan! Proyek ini dibangun dengan menggunakan teknologi-teknologi canggih, termasuk Spring Boot, Maven, dan Swagger. Di bawah ini adalah penjelasan singkat tentang masing-masing teknologi dan komponen yang digunakan dalam proyek ini:

> Spring Boot: Spring Boot adalah framework yang kuat untuk pengembangan aplikasi Java. Ini menyederhanakan pengembangan aplikasi dengan menyediakan banyak konvensi dan konfigurasi otomatis. Spring Boot memungkinkan pengembang untuk dengan cepat membangun aplikasi berkinerja tinggi tanpa harus menghabiskan banyak waktu dalam konfigurasi manual.

> Maven: Maven adalah alat manajemen proyek yang digunakan untuk mengelola dependensi, mengelola proses pembangunan, dan mengotomatisasi banyak tugas pengembangan. Ini memudahkan pengembang dalam mengelola proyek dan bergantung pada pustaka-pustaka eksternal yang diperlukan.

> Swagger: Swagger digunakan dalam proyek ini untuk menciptakan dokumentasi API yang otomatis. Ini membuat pengembang dan pengguna API dapat dengan mudah memahami dan menguji endpoints API yang ada.

> Selain itu, proyek ini menggunakan REST API untuk berkomunikasi antara berbagai komponen. REST (Representational State Transfer) adalah gaya arsitektur perangkat lunak yang digunakan untuk merancang jaringan aplikasi web yang bersifat stateless. Proyek ini juga mengandalkan MySQL sebagai basis data utama. MySQL adalah sistem manajemen basis data relasional (RDBMS) yang kuat, yang digunakan untuk menyimpan dan mengelola data aplikasi.

> Kombinasi dari teknologi-teknologi ini memungkinkan proyek ini untuk berjalan dengan baik dan efisien, memberikan solusi yang andal dan tangguh. Selamat datang di proyek saya, dan kami berharap proyek ini dapat memberikan manfaat bagi pengguna dan pengembang!

<br>

![Version](https://img.shields.io/badge/version-1.1--beta.1-blue.svg?cacheSeconds=2592000)<br>
**The received data is filtered through DTO before being stored in the model** 💫

> pada versi ini aku melakukan kesalahan karena Request yang dikirimkan oleh user tidak seharusnya langsung di terima oleh Model Enity tetapi harus melalui DTO terlebih dahulu, keuntungan menggunakan DTO adalah

> Menghindari "Overposting": Jika mengizinkan klien untuk mengirim data langsung ke model entitas, ini bisa membuka celah keamanan yang disebut "overposting". Overposting terjadi ketika klien dapat mengirimkan lebih banyak data daripada yang seharusnya, yang dapat menyebabkan masalah keamanan atau kegagalan validasi.

<br>

![Version](https://img.shields.io/badge/version-1.2--beta.1-blue.svg?cacheSeconds=2592000) <br>
**Optimization Converter** 💫

> Pada versi ini aku membuat Class baru yang di khusukan untuk Merubah data Model Enity menjadi DTO dan sebaliknya, serta Membuat converter List Model Entity menjadi List Model DTO, Dan berlaku juga untuk Page dan Optional

<br>

![Version](https://img.shields.io/badge/version-1.3--beta.1-blue.svg?cacheSeconds=2592000) <br>
**Update DTO Converter To ModelMapper** 💫
<br>

> Pada Versi ini aku merubah yang sebelumnya menggunakan DTO converter selama manual menjadi menggunakan ModelMapper dari Library **org.modelmapper.ModelMapper**, 💫
> Tapi model ini memiliki kekurangan karena antara DTO dan Model Entity field nya harus sama

<br>

![Version](https://img.shields.io/badge/version-1.4--beta.1-blue.svg?cacheSeconds=2592000) <br>
**Range Feature Release** 💫

> Di Versi ini aku mendapatkan arahan dari leader ku untuk menambahkan fiture dimana user bisa mengatur paging secara manual atau setiap page nya ingin memunculkan berapa banyak data, karena load dari database akan lambat jika harus me load semua data sekalihus

<br>

![Version](https://img.shields.io/badge/version-1.5--beta.1-blue.svg?cacheSeconds=2592000) <br>
**Optimization RangeDTO dan AccountsDTO** 💫

> DI versi sebelumnya penggunaan RangeDTO dan AccountDTO aku buat dengan Inherintence karena kedua Class memiliki kemiripan tetapi hasil return yang di hasikan tidak Rapi, Karena itu pada versi kali ini saya merubah menjadi 2 Class yang berbeda meski kedua model memiliki kemiripan

<br>

![Version](https://img.shields.io/badge/version-1.6--beta.2-blue.svg?cacheSeconds=2592000) <br>
**Add total login information** 💫

> Setelah melaporkan hasil project pada versi sebelumnya aku mendapatkan arahan lagi untuk menambahkan fiture untuk melihat user tertentu itu sudah login berapa kali, lalu pada update versi kali ini aku menambahkan field baru dimana untuk menyimpan total Login user

<br>

![Version](https://img.shields.io/badge/version-1.7--beta.2-blue.svg?cacheSeconds=2592000) <br>
**Bug Fix Total Logins Not Filled In At The Right Timet** 💫

> Pada versi ini, aku telah mengatasi masalah yang mengakibatkan total login terisi meskipun tidak ada aktivitas login yang sebenarnya pada bulan/waktu tertentu. Bug ini sekarang telah diperbaiki sehingga total login akan akurat merefleksikan aktivitas login yang sesungguhnya

<br>

![Version](https://img.shields.io/badge/version-1.8--beta.2-blue.svg?cacheSeconds=2592000) <br>
**Penghapusan Table Database Account** 💫

> Di versi kali ini saya aku menghapus table account di database karena dinilai tidak optimal dan tidak berguna, karena pada versi sebelumnya aku mempunyai 3 table yaitu table user untuk menyimpan data user yang sudah melakukan registrasi, lalu table account untuk menyimpan data user yang berhasil login, dan table logs untuk menyimpan waktu user login, tapi penggunaan table account terlalu tidak berguna karena bisa langsung menggunakan table user untuk menyimpan data total login dan karena user merupakan table utama

<br>

![Version](https://img.shields.io/badge/version-1.9--beta.2-blue.svg?cacheSeconds=2592000) <br>
**change the kadaijin database table to the accounts table** 💫

> Pada versi ini aku hanya melakukan perubahan kecil pada pengelolaan database nya, yaitu seperti merubah table user menjadi table accounts serta merubah beberapa nama column di dalamnya supaya bisa menjadi lebih mudah pengelolaan data nya

<br>

![Version](https://img.shields.io/badge/version-2.0--beta.2-blue.svg?cacheSeconds=2592000) <br>
**Optimization model entity baru** 💫

> Pada versi sebelumnya aku melakukan perubahan pada database yang dimana ini memberikan dampak pada model entity nya menjadi tidak sesuai, dan di versi kali ini aku melakukan perbaikan untuk menyesuaikan antara database dan model entity nya

<br>

![Version](https://img.shields.io/badge/version-2.1--beta.3-blue.svg?cacheSeconds=2592000) <br>
**jpa repository builder changes** 💫

> DI versi kali aku melakukan perbaikan pada Repository karena tidak dapat membuat query seperti yang aku harapkan, Dimana sebelumnya aku menggunakan fiture JPA builder untuk membuat query secara otomatis sekarang aku membuat Query manual di repository dengan menggunakan annotation **@Query** kelebihan pembuatan query manual adalah pengelolaan nya menjadi <br>lebih💫mudah

<br>

![Version](https://img.shields.io/badge/version-2.2--beta.3-blue.svg?cacheSeconds=2592000) <br>
**repair convert model to dto** 💫

> DI versi sebelumnya tepatnya pada versi **v1.3-beta.1** aku merubah converter menjadi menggunakan ModelMapper, tapi ternyata methode itu kurang effisien dikarenakan data dari <br>model💫entity langsung di rubah dan di return kembali ke user tanpa bisa merubah apapun, dan hal ini menyulitkan untuk me ngeset data yang tidak ada di dalam model Entity

> seperti pada versi ini aku sedang membuat fiture total login dan aku menambahkan field baru di dalam Accoutns DTO tetapi karena sebelumnya aku menggunakan model Mapper aku jadi tidak bisa mengisi field total login karena field itu tidak ada di dalam model entity accountsModel sehingga aku harus menjalankan 2 query untuk mengembalikan total login dan data yang dari model entity yang di ambil dari repository

<br>

![Version](https://img.shields.io/badge/version-2.3--beta.3-blue.svg?cacheSeconds=2592000) <br>
**Optimization** 💫

> Versi ini merupakan kelanjutan dari versi sebelumnya, pada versi ini aku merubah yang sebelumnya converter ku menggunakan model Mapper sekarang aku menggunakan construktor di dto nya, dimana construktor DTO ku menerima 2 paramater yaitu modelEntity dan juga list Modelentity lalu untuk mengeset totalLogin dan logs nya aku mengambil dari paramater List modelEnityt tersebut

<br>

![Version](https://img.shields.io/badge/version-2.4--beta.4-blue.svg?cacheSeconds=2592000) <br>
**adding new personal data** 💫

> Setelah melaporkan project versi sebelumnya aku mendapatkan arahan untuk berlatih join pada Sql dan juga Jpa, lalu untuk menambah menu latihan dan juga tantangan aku menambahkan data baru yaitu personal data pada table di sql dan aku membuat personal data model entity dan juga repositorynya

<br>

![Version](https://img.shields.io/badge/version-1.2--beta.4-blue.svg?cacheSeconds=2592000) <br>
**update personal data model entity dan personal data DTO** 💫

> pada versi ini aku hanya menambahkan contruktor untuk merubah Personal data DTO ke model entity dan juga sebaliknya, serta menambahkan sedikit configurasi pada model entity <br>yangutama di mana aku menambakkan field baru dan **@OneToMany** pada model entity utama supaya table saling terhubung menggunakan foreign key 💫

<br>

![Version](https://img.shields.io/badge/version-2.5--beta.4-blue.svg?cacheSeconds=2592000) <br>
**update endpoint login hanya membutuhkan body email dan password** 💫

> Pada versi ini aku merubah endpoint login menjadi menerima requestBody email dan password, kaena pada versi sebelumnya aku mempunyai 2 endpoint login, yang satu untuk menerima reuqest dari sisi frontend dan yang satunya utnuk alternative login, tetapi membuat 2 endpoint dengan fungsi yang sama kurang effisien dan pada akhirnya aku menghapus salah satu endpoint dan aku merubah menjadi hanya bisa menerima dalam bentuk json dan di terima oleh request body

<br>

![Version](https://img.shields.io/badge/version-2.6--beta.4-blue.svg?cacheSeconds=2592000) <br>
**Added new controller rangeLog** 💫

> setelah melakukan configurasi untuk log range akhirnya pada versi ini aku menambahkan controller untuk range log tersebut, dimana pada controller ini aku berencana menambahkan 3 endpoint dimana user bisa mengatur ingin mencari logs suatu user melalui rentang tahun, bulan, hari tertentu dan juga bisa custom pada tanggal berapa sampai berapa user tersebut sudah logib berapa kali

<br>

![Version](https://img.shields.io/badge/version-2.7--beta.4-blue.svg?cacheSeconds=2592000) <br>
**Added log range feature** 💫

> versi ini merupakan kelanjutan dari versi sebelumnya di mana aku berencana menambahkan log range dengan beberapa fiture dan fiture tersebut telah aku tambahkan pada versi kali ini

<br>

![Version](https://img.shields.io/badge/version-2.8--beta.4-blue.svg?cacheSeconds=2592000) <br>
**changed the way the range works** 💫

> setelah melaporkan project pada versi sebelumnya aku mendapatkan arahan lagi dari leaderku kenapa harus menjadi 3 endpoint kenapa tidak menjadi 1 saja di customs, dengan alasan ke effisienan karena semua endpoint tersebut bisa di handle oleh 1 endpoint customs saja

> dan pada versi kali ini aku sudah menggabung ke 3 endpoint tersebut menjadi 1 endpoint rangeLog dimana membutuhkan 3 paramater yaitu email, start, dan end

<br>

![Version](https://img.shields.io/badge/version-2.9--beta.5-blue.svg?cacheSeconds=2592000) <br>
**Fixed The Missing Login Logs** 💫

> Pada versi ini aku melakukan perbaikan di mana terdapat bug log dari login tidak mengeluarkan hasil apapun pada saat user mengakses melalui email, dan data yang di kembalikan ke user hanya data account dan personal data tanpa log

<br>

![Version](https://img.shields.io/badge/version-3.0--beta.5-blue.svg?cacheSeconds=2592000) <br>
**Changed From Request Body To Request Param** 💫

> Pada versi ini aku melakukan perubahan karena rangeDTO tidak mau menerima data Request body dari user dan data dari DTO tetap null, sehingga pada versi kali ini aku merubah yang sebelumnya method post aku rubah menjadi get dan hanya menerima reuqest melalui request param

<br>

![Version](https://img.shields.io/badge/version-3.1--beta.5-blue.svg?cacheSeconds=2592000) <br>
**rangeLog between bug that doesn't work correctly** 💫

> Pada versi ini terdapat bug yang sangat menjengkelkan dimana query between yang aku buat tidak mereturn hasil sesuai dengan yang aku minta dan pada versi ini aku belum menemukan cara memperbaikinya

<br>

![Version](https://img.shields.io/badge/version-3.2--beta.5-blue.svg?cacheSeconds=2592000) <br>
**Added Filter Between In Range Log** 💫

> Versi ini merupakan lanjutan dari versi sebelunya yang dimana terdapat bug fiture beetwwen yang aku buat di dalam repository tidak bekerja dan pada versi ini aku menambahkan fiture filter untuk mengambil semua data log dan aku filter untuk mengambil data mulai dari tanggal start dan sebelum tanggal end

<br>

![Version](https://img.shields.io/badge/version-3.3--beta.5-blue.svg?cacheSeconds=2592000) <br>
**Clearing Range Controller Logs** 💫

> Pada versi kali ini aku menghapus range controller dan menggabungkan nya ke log controller, karena dinilai kurang effisien dan terlalu banyak controller padahal fiture nya sama

<br>

![Version](https://img.shields.io/badge/version-3.4--beta.5-blue.svg?cacheSeconds=2592000) <br>
**Update Log GetOne And Accounts GetOne Can Receive Email Strings** 💫

> Pada versi ini aku menambahkan fiture dimana getOne pada controller log bisa menerima email atau id, jika memasukan email maka dia akan mencari di repository melalui query email dan jika id dia akan mencari dengan find by id

<br>

![Version](https://img.shields.io/badge/version-3.5--beta.5-blue.svg?cacheSeconds=2592000) <br>
**Fixed Accounts GetOne Outputting Logs** 💫

> Pada versi kali ini aku melakukan perbaikan dimana pada versi sebelumnya terdapat bug log ikut terpanggil padahal yang harus di kembalikan ke pada user hanyalah account dan personal data tanpa log

<br>

![Version](https://img.shields.io/badge/version-3.6--beta.5-blue.svg?cacheSeconds=2592000) <br>
**update range log if one of the between params is deleted will display all logs** 💫

> pada versi ini aku menambahkan fiture dimana jika salah satu param start atau end di endpoint log range maka data log akan di kembalikan ke user semua, sehingga bisa tahu user tersebut selama ini sudah login berapa kali

<br>

![Version](https://img.shields.io/badge/version-3.7--beta.5-blue.svg?cacheSeconds=2592000) <br>
**Deleting the model to DTO converter and changing it to a constructor** 💫

> pada versi ini aku melakukan penghapusan dan perubahan total terhadap penggunaan model Mapper untuk mengconvert DTO ke model entity dan sebaliknya , dan aku hanya menyisakan untuk merubah list DTO ke List Model Entity saja

<br>

![Version](https://img.shields.io/badge/version-3.8--beta.5-blue.svg?cacheSeconds=2592000) <br>
**change to 1 controller 1 service** 💫

> di versi ini aku memperbaiki package dimana yang sebelunya aku membagi service tergantung fungsinya sekarang aku mengelompokan service melalui controller yang dimana sekarang 1 controller akan memiliki 1 service

<br>

![Version](https://img.shields.io/badge/version-3.9--beta.5-blue.svg?cacheSeconds=2592000) <br>
**optimization** 💫

> pada versi kali ini aku melakukan pembersihan total dan perapihan package serta penghapusan method yang tidak di perlukan atau tidak di gunakan lagi, aku juga menambahkan sedikit descripsi di service untuk mempermudah pengelolaan

<br>

![Version](https://img.shields.io/badge/version-4.0--beta.5-blue.svg?cacheSeconds=2592000)

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

- [Java](<https://id.wikipedia.org/wiki/Java_(bahasa_pemrograman)   >) - Bahasa pemrograman berorientasi objek yang dapat dijalankan di berbagai komputer termasuk telepon genggam.
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

<h3 align="left"   >Hubungi saya:</h3 >
<p align="left">
<a href="https://codepen.io/ryosoraa" target="blank"   ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/codepen.svg" alt="ryosoraa" height="30" width="40" /></a>
<a href="https://dev.to/ryosoraa" target="blank"   ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/devto.svg" alt="ryosoraa" height="30" width="40" /  ></a  >
<a href="https://twitter.com/ryosora12" target="blank" ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/twitter.svg" alt="ryosora12" height="30" width="40" / ></a >
<a href="https://linkedin.com/in/rio-dwi-23560b287" target="blank" ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/linked-in-alt.svg" alt="rio-dwi-23560b287" height="30" width="40" /   ></a   >
<a href="https://stackoverflow.com/users/ryosoraa" target="blank"  ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/stack-overflow.svg" alt="ryosoraa" height="30" width="40" /></a>
<a href="https://codesandbox.com/ryosoraa" target="blank"  ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/codesandbox.svg" alt="ryosoraa" height="30" width="40" /   ></a   >
<a href="https://kaggle.com/ryosoraa" target="blank"   ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/kaggle.svg" alt="ryosoraa" height="30" width="40" / ></a >
<a href="https://fb.com/ryosoraa" target="blank"   ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/facebook.svg" alt="ryosoraa" height="30" width="40" /   ></a   >
<a href="https://instagram.com/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/instagram.svg" alt="ryosoraa" height="30" width="40" /   ></a   >
<a href="https://www.behance.net/ryosoraa" target="blank"  ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/behance.svg" alt="ryosoraa" height="30" width="40" /   ></a   >  
<a href="https://hashnode.com/@ryosora" target="blank" ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/hashnode.svg" alt="@ryosora" height="30" width="40" / ></a >
<a href="https://medium.com/@ryosoraa" target="blank"  ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/medium.svg" alt="@ryosoraa" height="30" width="40" /   ></a   >
<a href="https://www.youtube.com/c/ryosoraa" target="blank"><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/youtube.svg" alt="ryosoraa" height="30" width="40" / ></a >
<a href="https://www.codechef.com/users/ryosoraa" target="blank"   ><img align="center" src="https://cdn.jsdelivr.net/npm/simple-icons@3.1.0/icons/codechef.svg" alt="ryosoraa" height="30" width="40" /  ></a  >
<a href="https://www.hackerrank.com/@ryosora" target="blank"   ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/hackerrank.svg" alt="@ryosora" height="30" width="40" / ></a >
<a href="https://codeforces.com/profile/ryosoraa" target="blank"   ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/codeforces.svg" alt="ryosoraa" height="30" width="40" / ></a >
<a href="https://www.leetcode.com/ryosora" target="blank"  ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/leet-code.svg" alt="ryosora" height="30" width="40" /  ></a  >
<a href="https://www.hackerearth.com/@ryosora" target="blank"  ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/hackerearth.svg" alt="@ryosora" height="30" width="40" /   ></a   >
<a href="https://auth.geeksforgeeks.org/user/ryosoraa" target="blank"  ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-readme-generator/master/src/images/icons/Social/geeks-for-geeks.svg" alt="ryosoraa" height="30" width="40" /   ></a   >
<a href="https://www.topcoder.com/members/ryosoraa" target="blank" ><img align="center" src="https://raw.githubusercontent.com/rahuldkjain/github-profile-
