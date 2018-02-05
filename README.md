# BalineseDate Java Library
[![pipeline status](https://gitlab.com/peradnya/balinese-date-java-lib/badges/master/pipeline.svg)](https://gitlab.com/peradnya/balinese-date-java-lib/commits/master)
## Introduction
BalineseDate provides a library to build Balinese Saka Calendar in Java based application. 

**Disclaimer**: This library is in **Beta Phase**. Feedbacks, corrections, or bug reports are welcomed ... :)

## Features
BalineseDate provide a easy way to convert gregorian date into balinese date. 

BalineseDate support several features:
1. Sasih
    1. Penanggal / Pangelong
    2. Purnama / Tilem
    3. Mala Sasih / Nampih Sasih
    4. NgunaRatri
2. Saka Year
3. Pawukon
    1. Wuku
    2. Wewaran (Ekawara - Dasawara)
    3. Ingkel
    4. Jejapan
    5. Pawatekan (Alit + Madya)
    6. Lintang
    7. Pancasuda
    8. Pararasan
    9. Rakam

## How to Build
### Requirement
The recomended requirement to build this project is:
1. Oracle Java JDK 7 (minimum), JDK 8 (recomended)
2. Gradle 4.4.0 (minimum)
3. Git Client

for Gradle installation, you could follow this [Gradle installation instuction](https://gradle.org/install/).

### Building JAR File
JAR file of BalineseDate Library could be built by using following command:
```sh
[project root]$ gradle build
```
You could find the compiled JAR at:
```sh
[project root]/build/libs/balinese-date-java-lib-[version].jar
```

### Building Documentation (Javadoc)
Documentation of BalineseDate Library could be built by using following command:
```sh
[project root]$ gradle javadoc
```

You could find the documentation at:
```sh
[project root]/build/docs/javadoc/index.html
```

### Testing & Checking
Testing and Checking of BalineseDate Library could be done by using following command:
```sh
[project root]$ gradle check
```

You could find the test result at:
```sh
[project root]/build/reports/tests/test/index.html
```

## Using in Code
### Creating BalineseDate Object
```java
import peradnya.libs.balinesedate.*;
import java.util.GregorianCalendar;

// get current balinese date
BalineseDate now        = new BalineseDate();

// get balinese date at 1 January 2018
BalineseDate bDate1     = new BalineseDate(2018,0,1);

// get balinese date at 1 January 1969 using GregorianCalendar
GregorianCalendar date  = new GregorianCalendar(1969,0,1);
BalineseDate bDate2     = new BalineseDate(date);

```

### Using BalineseDate Method
```java
// get penanggal (1 - 15)
int penanggal                                   = bDate2.getPenanggal();

// get penanggal info (penanggal, pangelong, tilem, or purnama)
BalineseDateConst.PenanggalInfo penanggalInfo   = bDate2.getPenanggalInfo();

// etc... Lelah :)
```

## Related Project
There is another related project about Balinese Saka Calendar:
* Saka Calendar 2.0 by [Edy Santosa](https://github.com/edysantosa/sakacalendar).

## References
* babadbali.com (Yayasan Bali Galang) for [wewaran](http://www.babadbali.com/pewarigaan/perhitungan.htm) and [paringkelan](http://www.babadbali.com/pewarigaan/paringkelan.htm) algorithm.
* kalenderbali.org and kalenderbali.info for cross-checking and building sample test-cases.
* Pendit, Nyoman.(2001). *"Nyepi: kebangkitan, toleransi, dan kerukunan"*. Jakarta : Gramedia. Retrieved at [google book](https://books.google.co.id/books?id=4ND9KPn2o8AC).
* Prawira, I Putu Candra et.al.(2015).*"Pengembangan Aplikasi Kalender Saka Bali pada Sistem Operasi Machintos"*. E-Jurnal Merpati, Vol.3. Retrieved at [ojs.unud.ac.id](https://ojs.unud.ac.id/index.php/merpati/article/view/17799/11547).