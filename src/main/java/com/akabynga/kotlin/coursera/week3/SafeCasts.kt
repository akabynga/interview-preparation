package com.akabynga.kotlin.coursera.week3


fun main() {

    val string: String = "Hello there"
//    var string: String;
    if (string is String) {
        println(string.uppercase())
    }

    println((string as? String)?.uppercase())
}