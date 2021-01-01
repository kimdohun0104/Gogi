package com.deepthought.local

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}