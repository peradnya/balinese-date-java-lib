# BalineseDate Java Library

[![build version](https://jitpack.io/v/com.gitlab.peradnya/balinese-date-java-lib.svg)](https://jitpack.io/#com.gitlab.peradnya/balinese-date-java-lib)
[![pipeline status](https://gitlab.com/peradnya/balinese-date-java-lib/badges/master/pipeline.svg)](https://gitlab.com/peradnya/balinese-date-java-lib/commits/master)
[![coverage report](https://gitlab.com/peradnya/balinese-date-java-lib/badges/master/coverage.svg)](https://gitlab.com/peradnya/balinese-date-java-lib/commits/master)

## Introduction

BalineseDate is an open source library to build Balinese Saka Calendar in Java based application.

**Note**: This library is in **Beta Phase**. Feedbacks, corrections, or bug reports are welcomed ... :)

## Features

BalineseDate provide a easy way to convert gregorian date into balinese date.

BalineseDate support several features:

1. Sasih
    1. Penanggal / Pangelong
    2. Purnama / Tilem
    3. Mala Masa / Nampih Sasih
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
4. Get the BalineseDate(s) from selected Date and Filter __(v0.2.0)__

## Import BalineseDate into Project

BalineseDate Java Library use [Jitpack](https://jitpack.io/#com.gitlab.peradnya/balinese-date-java-lib) to publish the binary.

### Gradle

Please add the repository of __Jitpack__ in the ```build.gradle``` of your project

```groovy
repositories {
    ...
    jcenter()
    maven { url 'https://jitpack.io' }
}
```

and then, add dependency to __BalineseDate Library__ in the ```build.gradle```

```groovy
dependencies {
    implementation 'com.gitlab.peradnya:balinese-date-java-lib:0.2.0'
}
```

### Maven

Please add the repository of __Jitpack__ in the ```pom.xml``` of your project

```xml
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

and then, add dependency to __BalineseDate Library__ in the ```pom.xml```

```xml
<dependency>
    <groupId>com.gitlab.peradnya</groupId>
    <artifactId>balinese-date-java-lib</artifactId>
    <version>0.2.0</version>
</dependency>
```

## Documentation

### Version 0.x

* [__0.2.0 (Latest)__](https://jitpack.io/com/gitlab/peradnya/balinese-date-java-lib/0.2.0/javadoc/)
* [0.1.0](https://jitpack.io/com/gitlab/peradnya/balinese-date-java-lib/0.1.0/javadoc/)

## How to Build

### Requirement

The recomended requirement to build this project is:

1. Latest Oracle Java JDK (Recomended >= 7.x)
2. Latest Gradle (Recomended >= 4.4.0)
3. Latest Git Client

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

Testing and checking of BalineseDate Library could be done by using following command:

```sh
[project root]$ gradle check
```

You could find the test results at:

```sh
# JUnit (Unit Test) Result
[project root]/build/reports/tests/test/index.html

# Jacoco (Coverage) Result
[project root]/build/reports/jacoco/test/html/index.html

# SpotBugs (Bug Analysis) Result
[project root]/build/reports/spotbugs/main.html
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

// get BalineseDate(s) Between 2017-01-01 and 2017-12-31 with Wuku Watugunung and Pancawara Kliwon

GregorianCalendar start     = new GregorianCalendar(2017,00,01);
GregorianCalendar finish    = new GregorianCalendar(2017,11,31);
BalineseDateUtil.Filter q   = new BalineseDateUtil.Filter();

q.wuku                      = Wuku.WATUGUNUNG;
q.pancawara                 = Pancawara.KLIWON;

BalineseDate[] result       = BalineseDateUtil.getBalineseDateByDate(q, start, finish);
```

## Related Project

There is another related project about Balinese Saka Calendar:

* Saka Calendar 2.0 by [Edy Santosa](https://github.com/edysantosa/sakacalendar).

## References

* Ardhana, I.B.S.(2005). *"Pokok-Pokok Wariga"*. Surabaya : Paramita.
* babadbali.com (Yayasan Bali Galang) for [wewaran](http://www.babadbali.com/pewarigaan/perhitungan.htm) and [paringkelan](http://www.babadbali.com/pewarigaan/paringkelan.htm) algorithm.
* kalenderbali.org and kalenderbali.info for cross-checking and building sample test-cases.
* Pendit, Nyoman.(2001). *"Nyepi: kebangkitan, toleransi, dan kerukunan"*. Jakarta : Gramedia. Retrieved at [google book](https://books.google.co.id/books?id=4ND9KPn2o8AC).
* Prawira, I Putu Candra et.al.(2015).*"Pengembangan Aplikasi Kalender Saka Bali pada Sistem Operasi Machintos"*. E-Jurnal Merpati, Vol.3. Retrieved at [ojs.unud.ac.id](https://ojs.unud.ac.id/index.php/merpati/article/view/17799/11547).