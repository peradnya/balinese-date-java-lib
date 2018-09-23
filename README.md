# BalineseDate Java Library

[![build version](https://jitpack.io/v/com.gitlab.peradnya/balinese-date-java-lib.svg)](https://jitpack.io/#com.gitlab.peradnya/balinese-date-java-lib)
[![pipeline status](https://gitlab.com/peradnya/balinese-date-java-lib/badges/master/pipeline.svg)](https://gitlab.com/peradnya/balinese-date-java-lib/commits/master)
[![coverage report](https://gitlab.com/peradnya/balinese-date-java-lib/badges/master/coverage.svg)](https://gitlab.com/peradnya/balinese-date-java-lib/commits/master)

## Introduction

BalineseDate is an open source library to build Balinese Saka Calendar in Java based application.

> **Note**: This library is in **Beta Phase**, the API may change without notice.

## Features

BalineseDate is designed to be __immutable__ and __thread-safe__. BalineseDate have several features like:

* [Pawukon](http://www.babadbali.com/pewarigaan/kalender-pawukon.htm)
* [Pawewaran](http://www.babadbali.com/pewarigaan/pawewaran.htm)
  * [EkaWara](http://www.babadbali.com/pewarigaan/ekawara.htm)
  * [DwiWara](http://www.babadbali.com/pewarigaan/dwiwara.htm)
  * [TriWara](http://www.babadbali.com/pewarigaan/triwara.htm)
  * [CaturWara](http://www.babadbali.com/pewarigaan/caturwara.htm)
  * [PancaWara](http://www.babadbali.com/pewarigaan/pancawara.htm)
  * [SadWara](http://www.babadbali.com/pewarigaan/sadwara.htm)
  * [SaptaWara](http://www.babadbali.com/pewarigaan/saptawara.htm)
  * [AstaWara](http://www.babadbali.com/pewarigaan/astawara.htm)
  * [SangaWara](http://www.babadbali.com/pewarigaan/sangawara.htm)
  * [DasaWara](http://www.babadbali.com/pewarigaan/dasawara.htm)
* [Paringkelan](http://www.babadbali.com/pewarigaan/paringkelan.htm)
  * [Jejepan](http://www.babadbali.com/pewarigaan/jejepan.htm)
  * [Ingkel](http://www.babadbali.com/pewarigaan/ingkel.htm)
  * [Pawatekan Madya & Alit](http://www.babadbali.com/pewarigaan/watek.htm)
  * [Lintang](http://www.babadbali.com/pewarigaan/lintang.htm)
  * [PancaSuda](http://www.babadbali.com/pewarigaan/pancasuda.htm)
  * [Pararasan](http://www.babadbali.com/pewarigaan/paarasan.htm)
  * [Rakam](http://www.babadbali.com/pewarigaan/rakam.htm)
* Eka Jala Rsi __(v0.3.0)__
* Pratithi Samut Pada __(v0.3.0)__
* Dewasa __(v0.5.0)__
* Sasih
  * Pawukon/Penanggal and Nguna Ratri.
  * Pengalantaka Eka Sungsang Pon (before 2000) & Paing (2000 and after)
  * Malamasa (< 1993), Sasih Kesinambungan (1993 - 2002), Nampih Sasih (>= 2003)
* [Saka Year](http://www.babadbali.com/pewarigaan/kalender-saka.htm)

BalineseDate also have several utilities that can be use by developer like:

* Filter BalineseDate(s) from selected Date __(v0.2.0)__
* Filter BalineseDate(s) from selected BalineseDate List __(v0.4.0)__

## Import BalineseDate into Your Project

BalineseDate Java Library use [Jitpack](https://jitpack.io/#com.gitlab.peradnya/balinese-date-java-lib) to publish the binary. Choose one of these following method:

### Direct Download

* [balinese-date-java-lib-0.4.0.jar](https://jitpack.io/com/gitlab/peradnya/balinese-date-java-lib/0.4.0/balinese-date-java-lib-0.4.0.jar)
* [balinese-date-java-lib-0.4.0-javadoc.jar](https://jitpack.io/com/gitlab/peradnya/balinese-date-java-lib/0.4.0/balinese-date-java-lib-0.4.0-javadoc.jar)
* [balinese-date-java-lib-0.4.0-sources.jar](https://jitpack.io/com/gitlab/peradnya/balinese-date-java-lib/0.4.0/balinese-date-java-lib-0.4.0-sources.jar)

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
    implementation 'com.gitlab.peradnya:balinese-date-java-lib:0.4.0'
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
    <version>0.4.0</version>
</dependency>
```

## Documentation

* [0.4.0 (Latest)](https://jitpack.io/com/gitlab/peradnya/balinese-date-java-lib/0.4.0/javadoc/)

## How to Build

### Requirement

The recomended requirement to build this project are:

1. Latest Oracle Java JDK (Recomended >= 7.x)
2. Latest Gradle (Recomended >= 4.9.0)
3. Latest Git Client

for Gradle installation, you can follow the [Gradle installation instuction](https://gradle.org/install/).

### Building JAR File

JAR file of BalineseDate Library can be built by run the following command:

```sh
[project root]$ gradle build
```

You can find the compiled JAR at:

```sh
[project root]/build/libs/balinese-date-java-lib-[version].jar
```

### Building Documentation (Javadoc)

Documentation of BalineseDate Library can be built by run the following command:

```sh
[project root]$ gradle javadoc
```

You can find the documentation at:

```sh
[project root]/build/docs/javadoc/index.html
```

### Testing & Checking

Testing and checking of BalineseDate Library can be done by run the following command:

```sh
[project root]$ gradle check
```

You can find the test results at:

```sh
# JUnit (Unit Test) Result
[project root]/build/reports/tests/test/index.html

# Jacoco (Coverage) Result
[project root]/build/reports/jacoco/test/html/index.html
```

## Using in Code

### Creating BalineseDate Object

```java
import peradnya.libs.balinesedate.*;
import java.util.GregorianCalendar;

// get current balinese date

BalineseDate now        = new BalineseDate();

// get balinese date at 1 January 1969 using GregorianCalendar

GregorianCalendar date  = new GregorianCalendar(1969,0,1);
BalineseDate bDate1 = new BalineseDate(date);
```

### Using BalineseDate Method

```java
// get the sasih day (1 - 15)
// if number of element inside date = 1, then bDate1 is normal day
// if number of element inside date = 2, then bDate1 is ngunaratri day

List<Integer> date = bDate1.sasihDay();

// get sasih day info (penanggal, pangelong, tilem, or purnama)

SasihDayInfo sasihDayInfo   = bDate1.sasihDayInfo();

// get BalineseDate(s) Between 2017-01-01 and 2017-12-31 with Wuku Watugunung and Pancawara Kliwon

GregorianCalendar start     = new GregorianCalendar(2017,0,1);
GregorianCalendar finish    = new GregorianCalendar(2017,11,31);
BalineseDateUtil.Filter q   = new BalineseDateUtil.Filter();

q.wuku                      = Wuku.WATUGUNUNG;
q.pancaWara                 = PancaWara.KLIWON;

List<BalineseDate> result   = BalineseDateUtil.filterByDateRange(q, start, finish);
```

## Related Project

There is another related project about Balinese Saka Calendar:

* Saka Calendar 2.0 by [Edy Santosa](https://github.com/edysantosa/sakacalendar).

## References

* Ardhana, I.B.S. (2005). *"Pokok-Pokok Wariga"*. Surabaya : Paramita.
* babadbali.com (Yayasan Bali Galang) for [wewaran](http://www.babadbali.com/pewarigaan/perhitungan.htm) and [paringkelan](http://www.babadbali.com/pewarigaan/paringkelan.htm) algorithm.
* Pendit, Nyoman. (2001). *"Nyepi: kebangkitan, toleransi, dan kerukunan"*. Jakarta : Gramedia. Retrieved at [google book](https://books.google.co.id/books?id=4ND9KPn2o8AC).
* kalenderbali.org and kalenderbali.info for validation and building sample test-cases.